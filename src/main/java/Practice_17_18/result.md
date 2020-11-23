####Client.java
```java
package Practice_19_20;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {

		Scanner in=new Scanner(System.in);
		System.out.println("Introduce yourself : ");
		String name=in.nextLine();
		System.out.println("Start typing something");
		String message=in.nextLine();
		while (true)
		{
			sendMessage(name+" : "+message, "255.255.255.255", 1337);
			message=in.nextLine();
		}

	}

	public static void sendMessage(String message, String address, int port) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		byte[] data = message.getBytes();
		DatagramPacket packet = new DatagramPacket(data, 0, data.length, InetAddress.getByName(address), port);
		socket.send(packet);

	}
}
```
####Server.java
```java
package Practice_19_20;

import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(1337);
		byte[] buffer = new byte[2048];
		Date date = new Date();
		FileWriter fileWriter = new FileWriter("src/Practice_19_20/history.txt", true);
		try {
			fileWriter.write("**********\n" + "Server launched. Date is " + date.toString() + "\n**********\n");
		} catch (IOException e) {
			System.out.println("Something wrong I can feel it");
		} finally {
			fileWriter.close();
		}
		DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
		System.out.println("Welcome to chat based on 1337");
			while (true) {
				socket.receive(packet);
				date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
				String message = new String(buffer, 0, packet.getLength());
				System.out.println(format.format(date) + " | " + message);
				fileWriter = new FileWriter("src/Practice_19_20/history.txt", true);
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
```
