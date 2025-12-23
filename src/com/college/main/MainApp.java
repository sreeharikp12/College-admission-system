
	package com.college.main;

	import java.util.Scanner;

	import com.college.dao.ApplicationDAO;
	import com.college.dao.StudentDAO;
	import com.college.service.MeritService;

	public class MainApp {

	    public static void main(String[] args) throws Exception {

	        Scanner sc = new Scanner(System.in);

	        StudentDAO studentDAO = new StudentDAO();
	        ApplicationDAO appDAO = new ApplicationDAO();
	        MeritService meritService = new MeritService();

	        while (true) {

	            System.out.println("\n====== COLLEGE ADMISSION SYSTEM ======");
	            System.out.println("1. Register Student");
	            System.out.println("2. Apply for Course");
	            System.out.println("3. View Applications");
	            System.out.println("4. Approve Admissions");
	            System.out.println("5. Generate Admission List");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = sc.nextInt();

	            switch (choice) {

	            case 1:
	                System.out.print("Enter Name: ");
	                String name = sc.next();

	                System.out.print("Enter Email: ");
	                String email = sc.next();

	                System.out.print("Enter Marks: ");
	                double marks = sc.nextDouble();

	                studentDAO.registerStudent(name, email, marks);
	                System.out.println("✅ Student Registered Successfully");
	                break;

	            case 2:
	                System.out.print("Enter Student ID: ");
	                int studentId = sc.nextInt();

	                System.out.print("Enter Course ID: ");
	                int courseId = sc.nextInt();

	                appDAO.applyForCourse(studentId, courseId);
	                System.out.println("✅ Course Applied Successfully");
	                break;

	            case 3:
	                appDAO.viewApplications();
	                break;

	            case 4:
	                System.out.print("Enter Student Marks: ");
	                double studentMarks = sc.nextDouble();

	                System.out.print("Enter Course Cutoff: ");
	                double cutoff = sc.nextDouble();

	                System.out.print("Enter Student ID: ");
	                int sId = sc.nextInt();

	                System.out.print("Enter Course ID: ");
	                int cId = sc.nextInt();

	                String status;
	                if (meritService.isEligible(studentMarks, cutoff)) {
	                    status = "APPROVED";
	                } else {
	                    status = "REJECTED";
	                }

	                appDAO.updateApplicationStatus(sId, cId, status);
	                System.out.println("✅ Application " + status);
	                break;

	            case 5:
	                appDAO.generateAdmissionList();
	                break;

	            case 6:
	                System.out.println("Exiting System...");
	                sc.close();
	                System.exit(0);

	            default:
	                System.out.println("❌ Invalid Choice");
	            }
	        }
	    }
	}


