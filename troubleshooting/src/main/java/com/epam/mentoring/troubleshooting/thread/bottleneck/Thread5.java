package com.epam.mentoring.troubleshooting.thread.bottleneck;

public class Thread5 extends Thread {

	private Object object;
	
	public Thread5(Object object) {
		this.object = object;
	}
	
	public void run() {
		System.out.println("Thread5: Waiting for object...");
		synchronized (object) {
			System.out.println("Thread5: Captured object...");

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread5: Released object...");
		}
	}
}
