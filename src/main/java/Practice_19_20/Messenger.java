package Practice_19_20;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Messenger {
	public static void main(String[] args) throws SocketException {
		Server server = new Server();
		Client client = new Client();
		Thread thread1=new Thread(()->client.execApp());
		Thread thread2=new Thread(()-> {
			try {
				server.execApp();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}



	}
}
