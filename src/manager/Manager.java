package manager;

import java.util.*;

import fromEmployee.Employee;
import student.*;
import teacher.Teacher;

    public class Manager extends Employee {

        /// emp cons
        
        /// cons with just name
        
    	
        public Manager(fromUser.UserType UserType, String ID, String FirstName, String LastName, String Email,
				String Password, int PhoneNumber, double salary, Date hireDate) {
			super(UserType, ID, FirstName, LastName, Email, Password, PhoneNumber, salary, hireDate);
			// TODO Auto-generated constructor stub
		}

		private List<Course> courses = new ArrayList<>();                          ///
        private List<Teacher> teachers = new ArrayList<>();                        ///
        private List<Student> students = new ArrayList<>();                        /// VSE DOLZHNO HRANITCA V DB
        private List<Request> requests = new ArrayList<>();                        ///
        private Map<Course, Teacher> courseAssignments = new HashMap<>();          ///

        // Constructor, getters, setters, and other methods specific to Manager

        // Method to manage news
        public void manageNews(String news) {
            // Implementation to manage and publish news
            System.out.println("News managed: " + news);
        }

        // Method to prioritize news by its category
        public void prioritizeNews(String category) {
            // Implementation to prioritize news based on category
            System.out.println("News prioritized for category: " + category);
        }

        // Method to get information about a student
        public void infoStudent(Student student) {
            // Implementation to display information about a student
            System.out.println("Student Information: " + student);
        }

        // Method to get information about a teacher
        public void infoTeacher(Teacher teacher) {
            // Implementation to display information about a teacher
            System.out.println("Teacher Information: " + teacher);
        }

        // Method to create reports
        public void createReports() {                                   /// uberi
            // Implementation to create and generate reports
            System.out.println("Reports created successfully.");
        }

        // Method to announce a research paper
        public void announceResearchPaper(String researchPaper) {       /// uberi
            // Implementation to announce a research paper
            System.out.println("Research Paper Announced: " + researchPaper);
        }
    

    
	    public void viewRequests() {                           /// prosto DB.getRequests() (Receiver = Manager)
	        for (Request request : requests) {
	            if (request.signedByDean) {
	                // что напишем сюда? 
	            } else {
	                // и здесь 
	            }
	        }
	    }
	    
	    public void assignCourseToTeacher(Course course, Teacher teacher) {
	        courseAssignments.put(course, teacher);
	    }
	    
	    public void createStatisticalReports() {                         /// uberi
	        
	    }

    
}