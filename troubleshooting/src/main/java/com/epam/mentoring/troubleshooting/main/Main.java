package com.epam.mentoring.troubleshooting.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.epam.mentoring.troubleshooting.thread.bottleneck.Thread1;
import com.epam.mentoring.troubleshooting.thread.bottleneck.Thread2;
import com.epam.mentoring.troubleshooting.thread.bottleneck.Thread3;
import com.epam.mentoring.troubleshooting.thread.bottleneck.Thread4;
import com.epam.mentoring.troubleshooting.thread.bottleneck.Thread5;
import com.epam.mentoring.troubleshooting.thread.deadlock.Cyberman;
import com.epam.mentoring.troubleshooting.thread.deadlock.Dalek;
import com.epam.mentoring.troubleshooting.thread.deadlock.GreatIntelligence;
import com.epam.mentoring.troubleshooting.thread.deadlock.Master;

public class Main {

	private static final int SIMPLE_DEADLOCK = 1;
	private static final int BOTTLENECK = 2;
	private static final int MEMORY_LEAK = 3;
	private static final int FIXED_MEMORY_LEAK = 4;

	public static void main(String[] args) {
		if (args.length > 0) {
			int option = Integer.valueOf(args[0]);
			switch (option) {
			case SIMPLE_DEADLOCK:
				simpleDeadlock();
				break;
			case BOTTLENECK:
				bottleneck();
				break;
			case MEMORY_LEAK:
			case FIXED_MEMORY_LEAK:
				if (args.length < 2) {
					System.err.println("File name isn't specified");
					break;
				}
				String filename = args[1];
				memoryLeak(filename, option);
				break;
			default:
				System.err.println("Unknown command");
			}
		}
	}

	private static void simpleDeadlock() {
		Object theDoctor = new Object();
		Object tardis = new Object();
		Object river = new Object();
		Object rory = new Object();

		Dalek t1 = new Dalek(theDoctor, tardis);
		Cyberman t2 = new Cyberman(tardis, river);
		Master t3 = new Master(river, rory);
		GreatIntelligence t4 = new GreatIntelligence(theDoctor, rory);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	private static void bottleneck() {
		Object object = new Object();

		Thread1 t1 = new Thread1(object);
		Thread2 t2 = new Thread2(object);
		Thread3 t3 = new Thread3(object);
		Thread4 t4 = new Thread4(object);
		Thread5 t5 = new Thread5(object);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

	private static void memoryLeak(String filename, int option) {
		List<String> list = new ArrayList<String>();

		BufferedReader br = null;
		FileReader fr = null;

		try {
			Thread.sleep(10000);
			System.out.println("Start");

			try {
				fr = new FileReader(filename);
				br = new BufferedReader(fr);

				String currentLine;

				while ((currentLine = br.readLine()) != null) {
					String subString;
					if (option == FIXED_MEMORY_LEAK) {
						subString = new String(currentLine.substring(0, 3));
					} else {
						subString = currentLine.substring(0, 3);
					}
					list.add(subString);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)
						br.close();
					if (fr != null)
						fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			System.out.println("End");
			Thread.sleep(10000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
