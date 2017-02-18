package com.epam.mentoring.troubleshooting.thread.deadlock;

public class Master extends Thread {
	private Object river;
	private Object rory;
	
	public Master(Object river, Object rory) {
		this.river = river;
		this.rory = rory;
	}
	
	public void run() {
		synchronized (river) {
			System.out.println("Master: Captured River...");

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Master: Waiting for Rory...");

			synchronized (rory) {
				System.out.println("Master: Captured River & Rory...");
			}
		}
	}

}
