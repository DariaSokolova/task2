package com.epam.mentoring.troubleshooting.thread.deadlock;

public class GreatIntelligence extends Thread {
	private Object theDoctor;
	private Object rory;

	public GreatIntelligence(Object theDoctor, Object rory) {
		this.theDoctor = theDoctor;
		this.rory = rory;
	}
	
	public void run() {
		synchronized (rory) {
			System.out.println("Great Intelligence: Captured Rory...");

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Great Intelligence: Waiting for Doctor...");

			synchronized (theDoctor) {
				System.out.println("Great Intelligence: Captured Rory & Doctor...");
			}
		}
	}

}
