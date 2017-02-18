package com.epam.mentoring.troubleshooting.thread.deadlock;

public class Cyberman extends Thread {
	
	private Object tardis;
	private Object river;

	public Cyberman(Object tardis, Object river) {
		this.tardis = tardis;
		this.river = river;
	}
	
	public void run() {
		synchronized (tardis) {
			System.out.println("Cyberman: Captured Tardis...");

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Cyberman: Waiting for River...");

			synchronized (river) {
				System.out.println("Cyberman: Captured Tardis & River...");
			}
		}
	}
}
