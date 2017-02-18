package com.epam.mentoring.troubleshooting.thread.bottleneck;

public class Thread3 extends Thread {

	private Object object;

	public Thread3(Object object) {
		this.object = object;
	}

	public void run() {
		System.out.println("Thread3: Waiting for object...");
		synchronized (object) {
			System.out.println("Thread3: Captured object...");

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread3: Released object...");
		}
	}
}
