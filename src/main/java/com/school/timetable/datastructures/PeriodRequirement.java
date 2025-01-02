package com.school.timetable.datastructures;

/*
 * Supporting Class for SubjectPeriodTracker.java
 */
public class PeriodRequirement {
	private int remainingPeriodsPerDay;
	private int remainingPeriodsPerWeek;

	public PeriodRequirement(int remainingPeriodsPerDay, 
			int remainingPeriodsPerWeek) {
		this.remainingPeriodsPerDay = 
				remainingPeriodsPerDay;
		this.remainingPeriodsPerWeek = 
				remainingPeriodsPerWeek;
	}

	public void reduceRemainingPeriodsPerDay() {
		if (remainingPeriodsPerDay > 0) remainingPeriodsPerDay--;
	}

	public void reduceRemainingPeriodsPerWeek() {
		if (remainingPeriodsPerWeek > 0) remainingPeriodsPerWeek--;
	}

	// Getters
	public int getRemainingPeriodsPerDay() {
		return remainingPeriodsPerDay;
	}

	public int getRemainingPeriodsPerWeek() {
		return remainingPeriodsPerWeek;
	}

	@Override
	public String toString() {
		return "PeriodRequirement(remainingPeriodsPerDay=" + remainingPeriodsPerDay +
				", remainingPeriodsPerWeek=" + remainingPeriodsPerWeek + ")";
	}

	/**
	 * @param remainingPeriodsPerDay the remainingPeriodsPerDay to set
	 */
	public void setRemainingPeriodsPerDay(int remainingPeriodsPerDay) {
		this.remainingPeriodsPerDay = remainingPeriodsPerDay;
	}

	/**
	 * @param remainingPeriodsPerWeek the remainingPeriodsPerWeek to set
	 */
	public void setRemainingPeriodsPerWeek(int remainingPeriodsPerWeek) {
		this.remainingPeriodsPerWeek = remainingPeriodsPerWeek;
	}

}
