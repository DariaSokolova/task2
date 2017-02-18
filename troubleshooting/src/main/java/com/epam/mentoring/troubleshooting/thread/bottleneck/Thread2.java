package com.epam.mentoring.troubleshooting.thread.bottleneck;

public class Thread2 extends Thread {
	private Object object;

	public Thread2(Object object) {
		this.object = object;
	}

	public void run() {
		System.out.println("Thread2: Waiting for object...");
		synchronized (object) {
			System.out.println("Thread2: Captured object...");

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread1: Released object...");
		}
	}
}
