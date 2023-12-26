package manager;

import java.util.*;

import fromEmployee.Employee;
import fromUser.UserType;
import research.ResearchPaper;
import student.*;
import teacher.Teacher;

    public class Manager extends Employee {

        /// emp cons
        
        /// cons with just name

        
    	
    	
    	
    	
    	
    	
        /**
		 * 
		 */
		private static final long serialVersionUID = 5823056758898745893L;
		public Manager(fromUser.UserType UserType, String ID, String FirstName, String LastName, String Email,
				String Password, int PhoneNumber, double salary, Date hireDate) {
			super(UserType, ID, FirstName, LastName, Email, Password, PhoneNumber, salary, hireDate);
			// TODO Auto-generated constructor stub
		}
/// it needs for Admin class (Nurikkkk
		public Manager(String email, String password, UserType userType) {
			// TODO Auto-generated constructor stub
		}

		private List<Course> courses = new ArrayList<>();                          ///
        private List<Teacher> teachers = new ArrayList<>();                        ///
        private List<Student> students = new ArrayList<>();                        /// VSE DOLZHNO HRANITCA V DB
        private List<Request> requests = new ArrayList<>();                        ///

        // Constructor, getters, setters, and other methods specific to Manager

        
        
//    	
        
        Login Manager
        ManageNews
        1.
        2.
        3.
        4.
        1. Add news  
        2. Remove news
        enter: id : 3
       
        RemoveNews(3) {
        	
        }
        
        1. Add news
        Choose category: 1
        1.Res
        2.Study
        3.Social
        Category cat = Category.get(sc.getInt());
        
        Enter headline: ladjaldka;dk;akd
        String hl = sc.nextline();
        
        Enter topic: akd;akdka;dka;ldk
        String tp = sc.nextLIne()
        
        News news1 = new News(hd, tp, cat);
        DB.addNews()
        
        


        public void infoStudent(Student student) {
            // Implementation to display information about a student
            System.out.println("Student Information: " + student);
        }

        public void infoTeacher(Teacher teacher) {
            // Implementation to display information about a teacher
            System.out.println("Teacher Information: " + teacher);
        }


        // Method to announce a research paper
        public void announceResearchPaper(ResearchPaper paper) {       
        	News n = new News("RP announced", paper.getAnnotation(), Category.RESEARCHER)
        	DB.addNews(n);
        }
    

    
	    public void viewRequests() {                           /// prosto DB.getRequests() (Receiver = Manager)
	    	DB.getRequests() (Receiver = Manager)
	    }
	    

	    
	    public void run() {
	    	
	    }
		@Override
		public void sendMessage() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void sendOrder() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void displayMenu() {
			// TODO Auto-generated method stub
			
		}

    
}