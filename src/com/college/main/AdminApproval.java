
	package com.college.main;

	import java.util.Scanner;

	import com.college.dao.ApplicationDAO;
	import com.college.service.MeritService;

	public class AdminApproval {

	    public static void main(String[] args) throws Exception {

	        Scanner sc = new Scanner(System.in);
	        MeritService meritService = new MeritService();
	        ApplicationDAO appDAO = new ApplicationDAO();

	        System.out.print("Enter Student Marks: ");
	        double marks = sc.nextDouble();

	        System.out.print("Enter Course Cutoff: ");
	        double cutoff = sc.nextDouble();

	        System.out.print("Enter Student ID: ");
	        int studentId = sc.nextInt();

	        System.out.print("Enter Course ID: ");
	        int courseId = sc.nextInt();

	        String status;

	        // ✅ ADMIN APPROVAL LOGIC (YOU ASKED THIS)
	        if (meritService.isEligible(marks, cutoff)) {
	            status = "APPROVED";
	        } else {
	            status = "REJECTED";
	        }

	        appDAO.updateApplicationStatus(studentId, courseId, status);

	        System.out.println("Application Status Updated: " + status);
	    }
	}


