package student;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import fromUser.Database;
import fromUser.User;
import fromUser.UserType;
import manager.SchoolType;
import teacher.Teacher;

public class Student extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date dateOfBirth;
    private List<Mark> marks;
    private Integer sumOfCredits;
    private List<Course> courses;
    private String gender;
    private Integer yearOfStudy;
    private SchoolType school;
    private Teacher advisor;
    private List<Schedule> schedules;
    private transient Scanner in;
    
    private void initScanner() {
        this.in = new Scanner(System.in);
    }

    public Student(String email, String password, UserType userType) {
		super(email, password, userType);
		// TODO Auto-generated constructor stub
	}
    

    public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public List<Mark> getMarks() {
		return marks;
	}


	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}


	public Integer getSumOfCredits() {
		return sumOfCredits;
	}


	public void setSumOfCredits(Integer sumOfCredits) {
		this.sumOfCredits = sumOfCredits;
	}


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Integer getYearOfStudy() {
		return yearOfStudy;
	}


	public void setYearOfStudy(Integer yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}


	public SchoolType getSchool() {
		return school;
	}


	public void setSchool(SchoolType school) {
		this.school = school;
	}


	public Teacher getAdvisor() {
		return advisor;
	}


	public void setAdvisor(Teacher advisor) {
		this.advisor = advisor;
	}


	public List<Schedule> getSchedules() {
		return schedules;
	}


	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}


	public Student(UserType userType, String iD, String firstName, String lastName, 
                   String email, String password, int phoneNumber, 
                   Date dateOfBirth, String gender, Integer yearOfStudy, SchoolType school) {
        super(userType, iD, firstName, lastName, email, password, phoneNumber);
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.yearOfStudy = yearOfStudy;
        this.school = school;
    }

    
    public void viewAndRegisterCoursesCLI() {
        System.out.println("Select your school type:");
        for (SchoolType type : SchoolType.values()) {
            System.out.println(type);
        }
        SchoolType selectedSchoolType = SchoolType.valueOf(in.nextLine().toUpperCase());

        System.out.println("Available courses for " + selectedSchoolType + ":");   //по выбранному типу факультета выходят предназначенные только этому факультету курсы
        List<Course> availableCourses = Database.getInstance().getAllcourses()
                                     .values().stream()
                                     .filter(course -> course.getSchool().equals(selectedSchoolType))
                                     .collect(Collectors.toList());

        availableCourses.forEach(course -> System.out.println(course.getCourseId() + ": " + course.getCourseName()));

        System.out.println("Enter the ID of the course to register:");
        int courseId = in.nextInt();
        Course selectedCourse = Database.getInstance().getCourseAtID(courseId); //с класса бд (нужно в бд добавить мэпы)

        if (selectedCourse != null) {
            registerForCourse(selectedCourse);
            System.out.println("Registered for course: " + selectedCourse.getCourseName());
        } else {
            System.out.println("Course not found.");
        }
    }

    public void registerForCourse(Course course) {
        courses.add(course);
    }

    public void viewCoursesCLI() {
        System.out.println("Courses you are enrolled in:");
        courses.forEach(course -> System.out.println(course.toString()));
    }

    public void viewTeacherInformation() {
        System.out.println("Select a course to view its teacher:");
        for (Course course : courses) {
            System.out.println(course.getCourseId() + ": " + course.getCourseName());
        }
        int courseId = in.nextInt();
        Course selectedCourse = courses.stream()
            .filter(course -> course.getCourseId() == courseId)
            .findFirst()
            .orElse(null);
        
        if (selectedCourse != null) {
            selectedCourse.getInstructors().forEach(teacher -> 
                System.out.println("Teacher for " + selectedCourse.getCourseName() + ": " + teacher.getFirstName()));
        } else {
            System.out.println("Course not found.");
        }
    }

    public void viewMarks() {
        System.out.println("Your marks:");
        marks.forEach(mark -> 
            System.out.println("Course: " + mark.getCourse().getCourseName() + ", Mark: " + mark.getMarkType()));
    }

    public void viewTranscript() {
        Transcript transcript = Database.getInstance().getTranscriptForStudent(this); 
        System.out.println(transcript.toString());
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
		System.out.println("--------Student's menu----------------");
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
						;
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

 
}
