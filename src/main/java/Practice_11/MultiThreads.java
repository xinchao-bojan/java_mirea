package Practice_11;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreads {

	private AtomicInteger totalSum = new AtomicInteger();
	static ReentrantLock lock = new ReentrantLock();
	private long wrongSum=0;
	ArrayList<Thread> threads = new ArrayList<>();
	long startTime;
	long endTime;

	private void monoThread()
	{
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			wrongWork(i);
		}
		endTime = System.currentTimeMillis();
		System.out.println("One thread:");
		System.out.println("total time| " + (endTime - startTime));
		System.out.println("total sum| " + wrongSum + "\n");
	}


	private void wrongMultiThreads() throws InterruptedException {
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			final int localI = i;
			Thread thread = new Thread(() -> wrongWork(localI));
			thread.start();
			threads.add(thread);
		}

		for (Thread t : threads) {
			t.join();
		}
		endTime = System.currentTimeMillis();
		System.out.println("Multiple threads, but wrong:");
		System.out.println("total time: " + (endTime - startTime));
		System.out.println("total sum: " + wrongSum + "\n");
		threads.clear();
	}

	private void trueMultiThreads() throws InterruptedException {
		totalSum.set(0);
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			final int localI = i;
			Thread thread = new Thread(() -> trueWork(localI));
			thread.start();
			threads.add(thread);
		}

		for (Thread t : threads) {
			t.join();
		}
		endTime = System.currentTimeMillis();
		System.out.println("Multiple threads, but truely:");
		System.out.println("total time: " + (endTime - startTime));
		System.out.println("total sum: " + totalSum + "\n");
	}

	public void exec() throws InterruptedException {
		monoThread();
		wrongMultiThreads();
		trueMultiThreads();
	}

	private void trueWork(int i)
	{
		long startTime = System.currentTimeMillis();
		long result;
		result = doHardWorkTruely(i * 1337, 100_000_000);
		long endTime = System.currentTimeMillis();
		System.out.println(i + ": " + result + " | " + (endTime - startTime));
	}


	private  void wrongWork(int i) {
		long startTime = System.currentTimeMillis();
		long result;
		result = doHardWork(i * 1000, 100_000_000);
		long endTime = System.currentTimeMillis();
		System.out.println(i + ": " + result + " | " + (endTime - startTime));
	}

	private  long doHardWork(int start, int count) {
		long a = 0;
		for (int i = 0; i < count; i++) {
			a += (start + i) * (start + i) * Math.sqrt(start + i);
			wrongSum++;
		}
		return a;
	}

	private long doHardWorkTruely(int start, int count) {
		long a = 0;
		for (int i = 0; i < count; i++) {
			a += (start + i) * (start + i) * Math.sqrt(start + i);
			totalSum.getAndIncrement();
		}
		return a;
	}

}
