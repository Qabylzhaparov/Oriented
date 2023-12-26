package research;

import java.io.IOException;

import fromUser.Database;

import java.io.EOFException;
import teacher.Teacher;

public class Tester {

	public static void main(String[] args) throws EOFException{
		Teacher t = new Teacher("Vito");
		t.setID("21");
		Researcher r = new Researcher(t);
		r.setName("Piter");
		r.setSurname("Parker");
		ResearchDatabase.addResearcher(r);
		ResearchJournal j = new ResearchJournal("Forbes", "IT");
		j.addEditor(r);
		ResearchDatabase.addResearchJournal(j);
		try {
			r.run();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
//		ResearchDatabase.getResearchers();
		
	}

}