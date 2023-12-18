package manager;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SchoolManager extends Manager{
	private SchoolName school;
    private List<Request> listOfRequestsSchool;
    private List<StaffMember> staffMembers;
    
    public SchoolManager(fromUser.UserType UserType, String ID, String FirstName, String LastName, String Email,
			String Password, int PhoneNumber, double salary, Date hireDate,SchoolName school) {
		super(UserType, ID, FirstName, LastName, Email, Password, PhoneNumber, salary, hireDate);
		// TODO Auto-generated constructor stub
        this.school = school;
        this.listOfRequestsSchool = new ArrayList<>();
        this.staffMembers = new ArrayList<>();		
	}

   
    public void manageEvents() {
    	System.out.println("Events managed for " + school);
    }

    public void addStaffMembers(StaffMember staffMember) {
        staffMembers.add(staffMember);
        System.out.println("Staff member added: " + staffMember.getName());
    }

    
    public void removeStaffMembers(StaffMember staffMember) {
        staffMembers.remove(staffMember);
        System.out.println("Staff member removed: " + staffMember.getName());
    }

    
    public void viewStaffMembers() {
        for (StaffMember staffMember : staffMembers) {
            System.out.println(staffMember);
        }
    }

    
    public void approveCourseAddition(Request request) {
        
        listOfRequestsSchool.remove(request);
        System.out.println("Course addition approved for " + request.getCourse().getName());
    }

    
    public void sendSchoolReports() {
        
        System.out.println("School reports sent for " + school);
    }

  
}