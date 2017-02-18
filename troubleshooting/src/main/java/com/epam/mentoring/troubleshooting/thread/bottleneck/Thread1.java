package com.epam.mentoring.troubleshooting.thread.bottleneck;

public class Thread1 extends Thread {
	private Object object;

	public Thread1(Object object) {
		this.object = object;
	}

	public void run() {
		System.out.println("Thread1: Waiting for object...");
		synchronized (object) {
			System.out.println("Thread1: Captured object...");
			try {
				for (;;)
					Thread.sleep(500000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread1: Released object...");
		}
	}
}
