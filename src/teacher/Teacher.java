package teacher;

import java.io.IOError;
import java.io.IOException;
import java.util.*;

import fromEmployee.Employee;
import fromUser.*;
import manager.SchoolType;
import student.*;

public class Teacher extends Employee {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1014100442159559502L;

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L; old

	Scanner in = new Scanner(System.in);
/// It needs for admin ( NUrikkkkk
	public Teacher(String email, String password, UserType userType) {
		super();
	}
	
	public Teacher(String name) {
		super(name);
	}
	
	
	private List<Course> courses;
    
	private SchoolType section;
    
    private List<Teacher> interns;    

    public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public SchoolType getSection() {
		return section;
	}

	public void setSection(SchoolType section) {
		this.section = section;
	}

	public List<Teacher> getInterns() {
		return interns;
	}

	public void setInterns(List<Teacher> interns) {
		this.interns = interns;
	}

	public void viewStudentInfo() {
		System.out.println("Choose student: ");
		for(Student s: Database.getAllstudents()) {
			System.out.println(s.getID() + "  " + s.getFirstName() + " " + s.getLastName());
		}
		String schoice = in.nextLine();
		Student currentStudent = Database.getStudentbyID(schoice);
        System.out.println(currentStudent.toString());
    }

    public void putMark(Student student) {
    	System.out.println("How many points: ");
		Integer point = in.nextInt();
		System.out.println("For what: ");
		String comment = in.nextLine();
        student.getMarks().putpoint(point, comment);
    }

    public void viewCourse(Course c) {
        System.out.println(c.toString());
    }

    public void sendComplaints() {
    	System.out.println("Type complaint:");
		String complaint = in.nextLine();
		System.out.println("Choose Urgencylevel: 1) LOW  2) MED  3) HIGH");
		UrgencyLevel urlevel = null;
		try {
            urlevel = UrgencyLevel.fromString(in.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    	Message m = new Message(complaint, this, MessageType.Complaint, urlevel);
        Database.addMessage(m);
    }

    public void sendOrder() {
    	System.out.println("Type order: ");
		String order = in.nextLine();
    	super.sendOrder(order);
    }

    
    
    
    
    
    private void save() throws IOException{
    	Database.write();
    }
    
    private void exit() {
    	System.out.println("Session ended.");
    	try {
    		save();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    
    public void run() throws IOException{
    	try {
    		System.out.println("Welcome!");
    		menu: while(true) {
    			System.out.println("What do you want to do?\n 1) Put marks  2) View Course  3) ViewStudentInfo  4) Send complaint  5) Send order  6) Exit");
    			int choice = in.nextInt();
    			if(choice==1) {
    				putmark: while(true) {
    					System.out.println("Choose course: ");
    					for(Course c: courses) {
    						System.out.println(c.getCourseId() + ". " + c.getCourseName());
    					}
    					choice = in.nextInt();
    					Course currentCourse = Database.getCourseAtID(choice);
    					student: while(true) {
    						System.out.println("Choose student: ");
	    					for(Student s: Database.getStudents()) {
	    						if(s.getCourses().contains(currentCourse)) {
		    						System.out.println(s.getID() + ". " + s.getFirstName() + " " + s.getLastName());
	    						}
	    					}
	    					String schoice = in.nextLine();
	    					Student currentStudent = Database.getStudentbyID(schoice);
	    					mark: while(true) {
		    					this.putMark(currentStudent);
    							System.out.println("\n1) Put more mark  2) Change student  3) Change course  4) Return back  5) Exit");
		    					choice = in.nextInt();
		    					if(choice==1) continue mark;
		    					if(choice==2) continue student;
		    					if(choice==3) continue putmark;
		    					if(choice==4) continue menu;
		    					if(choice==5) {exit(); break menu;}
		    					break;
     				        }
	    				}
    				}
    			}
    			else if(choice==2) { 
    				course: while(true) {
    					Course.viewCourseInfo(courses);
    					System.out.println("\n1) Choose another course  2) Return back  3) Exit");
    					choice = in.nextInt();
    					if(choice==1) continue course;
    					if(choice==2) continue menu;
    					if(choice==3) {exit(); break menu;}
    					break;
    				}
    			}
    			else if(choice==3) {
    				student: while(true) {
    					this.viewStudentInfo();
    					System.out.println("\n1) Choose another student  2) Return back  3) Exit");
    					choice = in.nextInt();
    					if(choice==1) continue student;
    					if(choice==2) continue menu;
    					if(choice==3) {exit(); break menu;}
    					break;
    				}
    			}
    			else if(choice==4) {
    				complaint: while(true) {
    					this.sendComplaints();
    					System.out.println("\nDone\n1) Send another complaint  2) Return back  3) Exit");
    					choice = in.nextInt();
    					if(choice==1) continue complaint;
    					if(choice==2) continue menu;
    					if(choice==3) {exit(); break menu;}
    					break;
    				}
    			}
    			else if(choice==5) {
    				order: while(true) {
    					this.sendOrder();
    					System.out.println("\nDone\n1) Send another order  2) Return back  3) Exit");
    					choice = in.nextInt();
    					if(choice==1) continue order;
    					if(choice==2) continue menu;
    					if(choice==3) {exit(); break menu;}
    					break;
    				}
    			}
    			else if(choice==6) {
    				exit();
    				break menu;
    			}	
    		}
    	} catch(Exception e) {
    		System.out.println("Something went wrong...\n Saving session...");
    		e.printStackTrace();
    		save();
    	}
    }

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMenu() {
		// TODO Auto-generated method stub
		
	}
}  
