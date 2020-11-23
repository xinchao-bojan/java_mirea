package Practice_19_20;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
	public void execApp() {

		Scanner in=new Scanner(System.in);
		System.out.println("Introduce yourself : ");
		String name=in.nextLine();
		System.out.println("Start typing something");
		String message=in.nextLine();
		while (true)
		{
			try {
				sendMessage(name+" : "+message, "255.255.255.255", 1337);
			} catch (IOException e) {
				e.printStackTrace();
			}
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
