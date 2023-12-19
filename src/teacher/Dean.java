package teacher;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import fromUser.Database;
import fromUser.Message;
import fromUser.MessageType;
import fromUser.UrgencyLevel;
import manager.SchoolType;


public class Dean extends Teacher implements Heads {
	Scanner in = new Scanner(System.in);
	private SchoolType deanOfSchool;
	
	public Dean() {
    	super();
    }
	
	public Dean(String name) {
		super(name);
	}

    public Dean(String name, SchoolType deanOfSchool) {
        super(name);
    	this.deanOfSchool = deanOfSchool;
    }
    
    
    public SchoolType getDeanOfSchool() {
        return this.deanOfSchool;
    }
    
    public void setDeanOfSchool(SchoolType deanOfSchool) {
        this.deanOfSchool = deanOfSchool;
    }

    // Operations 
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
				System.out.println("What do you want to do?\n1) View complaints  2) Sign to request  3) Exit");
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
