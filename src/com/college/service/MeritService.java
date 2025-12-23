package com.college.service;

public class MeritService {
	public boolean isEligible(double marks, double cutoff) {
	    return marks >= cutoff;
	}

}
