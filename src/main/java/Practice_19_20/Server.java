package Practice_19_20;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
	public void execApp() throws IOException {
		DatagramSocket socket = new DatagramSocket(1337);
		byte[] buffer = new byte[2048];
		Date date = new Date();
		File fileClear=new File("src/main/java/Practice_19_20/history.txt");
		fileClear.delete();
		FileWriter fileWriter = new FileWriter("src/main/java/Practice_19_20/history.txt", true);
		try {
			fileWriter.write("**********\n" + "Server launched. Date is " + date.toString() + "\n**********\n");
		} catch (IOException e) {
			System.out.println("Something wrong I can feel it");
		} finally {
			fileWriter.close();
		}
		DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
		while (true) {
			socket.receive(packet);
			date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			String message = new String(buffer, 0, packet.getLength());
			System.out.println(format.format(date) + " | " + message);
			fileWriter = new FileWriter("src/main/java/Practice_19_20/history.txt", true);
			try {
				fileWriter.write(format.format(date) + " | " + message + "\n");
			} catch (IOException e) {
				System.out.println("Something wrong I can feel it");
			} finally {
				fileWriter.close();
			}
		}

	}
}
