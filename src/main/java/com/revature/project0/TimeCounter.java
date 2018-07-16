package com.revature.project0;


public class TimeCounter implements Runnable {
	long startTime;
	long endTime;
	long time;
	
	public void setStartTime(long start) {
		startTime = start;
	}
	
	public void setEndTime(long end) {
		endTime = end;
	}
	
	public synchronized void run() {
		System.out.println("Start Time: " + startTime);
		startTime = System.currentTimeMillis();
		while(!Game.isEndOfGame()) {
			
		}
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("End Time: " + endTime);
		System.out.println("Total play Time: " + time);
		
	}
}
