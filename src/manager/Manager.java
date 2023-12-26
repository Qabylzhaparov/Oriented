package manager;

import java.io.IOException;
import java.util.*;
import fromEmployee.Employee;

import student.Student;
import teacher.Teacher;
import student.Course;

import fromUser.Database;
import fromUser.Message;
import fromUser.MessageType;
import fromUser.UserType;

public class Manager extends Employee{


    private transient Scanner in;
    
    private void initScanner() {
        this.in = new Scanner(System.in);
    }

    public Manager(String email, String password, UserType userType) {
		super(email, password, userType);
		// TODO Auto-generated constructor stub
	}


	public Manager(UserType userType, String ID, String firstName, String lastName, String email, String password,
			int phoneNumber) {
		super(userType, ID, firstName, lastName, email, password, phoneNumber);
		// TODO Auto-generated constructor stub
	}


	public Manager() {
 
    }
    

    public void viewStudents() {
//        students.sort(Comparator.comparing(Student::getYearOfStudy)
//                                 .thenComparing(Student::getSchool));
//        students.forEach(System.out::println);
    }

    public void viewTeachers() {
//        teachers.sort(Comparator.comparing(Teacher::getSection));
//        teachers.forEach(System.out::println);
    }

    public void viewRequests() {
//        for (Message msg : Database.getMessages()) {
//            if (msg.getCategory() == MessageType.REQUEST && !msg.isSigned()) {
//                System.out.println("Request to be sent to Dean: " + msg);
//            }
//        }
    }
    private void addNews() {
        try {
            System.out.println("Choose category: \n1) Research \n2) Study");
            int catChoice = in.nextInt();
            in.nextLine(); 
//            Category category = Category.get(catChoice - 1);

            System.out.println("Enter headline:");
            String headline = in.nextLine();

            System.out.println("Enter topic:");
            String topic = in.nextLine();

            
//            News newsItem = new News(headline, topic, category);
//
//            
//            Database.getInstance().getNews().add(newsItem);

//            Database.write();

            System.out.println("News added successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred while adding news: " + e.getMessage());
        }
    }

    private void removeNews() {
        try {
            System.out.println("Enter the ID of the news to remove:");
            int id = in.nextInt();
//            Database.getInstance().getNews().removeIf(newsItem -> newsItem.getId() == id);
            Database.write();
            System.out.println("News removed successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred while removing news: " + e.getMessage());
        }
    }


	private void save() throws IOException {
		Database.write();
	}
	private void exit() {
		System.out.println("Bye bye");
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
    public void displayMenu() {
		System.out.println("--------Manage's menu----------------");
		System.out.println("====================================");
		System.out.println("*	1) View Students             *");
		System.out.println("*	2) View Teachers             *");
		System.out.println("*	3) View and Manage Requests  *");
		System.out.println("*	4) Add News                  *");
		System.out.println("*	5) Remove News               *");
		System.out.println("*	6) Exit                      *");
		System.out.println("====================================");
    }
    public void run() throws IOException {
		try {
			initScanner();
			menu : while(true){
				displayMenu();
				int choice = in.nextInt();
				if(choice==1){
					viewStudents: while(true){
						viewStudents();
						Database.write();
						System.out.println("\n 1) Add new user \\n 2) Return back \\n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue viewStudents;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if(choice==2){
					viewTeachers: while(true){
						viewTeachers();
						Database.write();
						System.out.println("\n 1) Remove user \\n 2) Return back \\n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue viewTeachers;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if(choice==3){
					viewRequests: while(true){
						viewRequests();
						Database.write();
						System.out.println("\n 1) Update user \\n 2) Return back \\n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue viewRequests;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if(choice==4){
					addNews: while(true){
						addNews();
						Database.write();
						System.out.println("\n 1) Show a users list \\n 2) Return back \\n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue addNews;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if(choice==5){
					removeNews: while(true){
						removeNews();
						Database.write();
						System.out.println("\n 1) Show a users list \\n 2) Return back \\n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue removeNews;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
			
				else if (choice==6){
						exit();
						break menu;
					}
				}
			} catch (Exception e) {
				System.out.println("Something bad happened... \n Saving resources...");
				e.printStackTrace();
				save();
			}
		finally {
			if(in != null) in.close();
	        // Close the Scanner
	      
	    }
	}
				


	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sendOrder() {
		// TODO Auto-generated method stub
		
	}






}
