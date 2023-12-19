package teacher;

import java.io.IOException;
import java.util.Vector;

import fromUser.Database;
import fromUser.Message;
import fromUser.MessageType;
import fromUser.UrgencyLevel;

public class Rector extends Teacher implements Heads {
    
	private static Rector rector;
	
	private Rector() {
		
	}

    //                          Operations                                  
    public static Rector getInstance() {
    	return rector;
    }
    
    public void addStrageticGoal() {
    	System.out.println("Enter strategic goal: ");
    	String goal = in.nextLine();
    	Database.addStrategicGoal(goal);
    }
    
    public void removeStrategicGoal() {
    	System.out.println("Enter removing strategic goal: ");
    	String goal = in.nextLine();
    	Database.removeStrategicGoal(goal);
    }


    public void viewComplaints() {
        Database.getComplaints().stream().forEach(System.out::println);
    }

    @Override
    public void signToRequest() {
        System.out.println("Choose complaint id: ");
        int id = in.nextInt();
        Message m = new Message("Your complaint with id - " + id + " is signed by dean " + getLastName(), 
        		              this, Database.getReceiverId(id), MessageType.Message, UrgencyLevel.MED);
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
	
	public void run() throws IOException {
		try {
			System.out.println("Welcome!");
			menu : while(true){
				System.out.println("What do you want to do?\n1) ViewComplaints  2) Sign to request  3) Add strategic goal  4) Remove strategic goal  5) Exit");
				int choice = in.nextInt();
				view: if(choice==1){
					while(true) {
						this.viewComplaints();
						System.out.println("\n1) Sign to request  2) Exit");
						choice = in.nextInt();
						if(choice==1) {choice=2; break view;}
						if(choice==2) {exit(); break menu;}
						
					}
				}
				if(choice==2) {
					request: while(true) {
						this.signToRequest();
						System.out.println("\n1) Sign to another request  2) Exit");
						choice=in.nextInt();
						if(choice==1) continue request;
						if(choice==2) {exit(); break menu;}
					}
				}
				if(choice==3) {
					add: while(true) {
						this.addStrageticGoal();
						System.out.println("\n1) Add another goal  2) Return back  3) Exit");
						choice=in.nextInt();
						if(choice==1) continue add;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
					}
				}
				if(choice==4) {
					remove: while(true) {
						this.removeStrategicGoal();
						System.out.println("\n1) Remove another goal  2) Return back  3) Exit");
						choice=in.nextInt();
						if(choice==1) continue remove;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
					}
				}
				if(choice==5) {
					exit();
					break menu;
				}
			}
		}
		catch(Exception e) {
			System.out.println("Something went wrong...\nSaving session...");
			e.printStackTrace();
			save();
		}
	}

    
}