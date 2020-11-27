package Practice_23_24;

import java.io.IOException;

public class Worker {
	public static void main(String[] args) {
		System r=new System();
		try {
			r.execApp();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
