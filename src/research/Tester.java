package research;

import java.io.IOException;
import java.util.Date;

import fromUser.Database;

import java.io.EOFException;
import teacher.Teacher;

public class Tester {

	public static void main(String[] args) throws EOFException, ClassNotFoundException{
		Teacher t = new Teacher("Vito");
		t.setID("21");
		Researcher r = new Researcher(t);
		r.setName("Piter");
		r.setSurname("Parker");
		Database.getInstance();
		ResearchDatabase.INSTANCE.researchers.add(r);
	
		try {
			
//			ResearchProject pr = new ResearchProject("f", null, "IT", null, new Date());
//			ResearchDatabase.INSTANCE.projects.add(pr);
			
			
			
			r.run();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
            Database.write();
        }
		
//		ResearchDatabase.getResearchers();
		
	}

}
