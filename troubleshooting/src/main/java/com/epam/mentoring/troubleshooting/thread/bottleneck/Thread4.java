package com.epam.mentoring.troubleshooting.thread.bottleneck;

public class Thread4 extends Thread {
	private Object object;
	
	public Thread4(Object object) {
		this.object = object;
	}
	
	public void run() {
		System.out.println("Thread4: Waiting for object...");
		synchronized (object) {
			System.out.println("Thread4: Captured object...");

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread4: Released object...");
		}
	}
}
