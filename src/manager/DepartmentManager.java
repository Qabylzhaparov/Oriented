package manager;
    
import java.util.*;

import student.Course;
import teacher.Teacher;


public class DepartmentManager extends Manager{
		private Set<Teacher> facultyMembers;               /// DB DepMembers map<Department, Set<Teacher>>
        private DepartmentType departmentType;
	
        /// emp cons
        
        /// cons with just name
        
        
        public DepartmentManager(fromUser.UserType UserType, String ID, String FirstName, String LastName, String Email,
			String Password, int PhoneNumber, double salary, Date hireDate) {
		super(UserType, ID, FirstName, LastName, Email, Password, PhoneNumber, salary, hireDate);
		    this.facultyMembers = new HashSet<>();
		// TODO Auto-generated constructor stub
	}


        public Set<Teacher> getFacultyMembers() {
            return this.facultyMembers;
        }

        public void setFacultyMembers(Set<Teacher> facultyMembers) {
            this.facultyMembers = facultyMembers;
        }
    
        
        public DepartmentType getDepartmentType() {
            return this.departmentType;
        }
          
        public void setDepartmentType(DepartmentType departmentType) {
            this.departmentType = departmentType;
        }
        
        
    }