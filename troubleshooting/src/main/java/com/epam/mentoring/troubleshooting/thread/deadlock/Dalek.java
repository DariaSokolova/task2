package com.epam.mentoring.troubleshooting.thread.deadlock;

public class Dalek extends Thread {
	private Object theDoctor;
	private Object tardis;

	public Dalek(Object theDoctor, Object tardis) {
		this.theDoctor = theDoctor;
		this.tardis = tardis;
	}

	public void run() {
		synchronized (theDoctor) {
			System.out.println("Dalek: Captured Doctor...");

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Dalek: Waiting for Tardis...");

			synchronized (tardis) {
				System.out.println("Dalek: Captured Doctor & Tardis...");
			}
		}
	}
}
