package student;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import fromUser.Language;
import teacher.Teacher;

public class Schedule {

    private Integer academicYear;

    private String term;

    private List<Course> courses;
    
    private List<Lesson> lessons ;
    
    private Set<WeekDay> weekdays;
    
    

	public Integer getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(Integer academicYear) {
		this.academicYear = academicYear;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
	
    public Set<WeekDay> getWeekdays() {
		return weekdays;
	}

	public void setWeekdays(Set<WeekDay> weekdays) {
		this.weekdays = weekdays;
	}

	public void updateLesson(Lesson oldLesson, Lesson newLesson) {
        lessons.set(lessons.indexOf(oldLesson), newLesson);
                
    }
    
    
	
    
    public void printSchedule() {
        List<WeekDay> weekdays = lessons.stream().map(n->n.getDay()).collect(Collectors.toSet()).
                                         stream().sorted(Comparator.comparingInt(WeekDay::ordinal)).
                                         collect(Collectors.toList());
    	weekdays.stream()
                .sorted().forEach(day -> {
					            System.out.println(" ".repeat(24) + day);
					            lessons.stream()
					                    .filter(lesson -> lesson.getDay().equals(day))
					                    .sorted(Comparator.comparing(Lesson::getTime))
					                    .forEach(System.out::println);
        });
    }
    

    
//    public static void main(String[] args) {
//        Schedule schedule = new Schedule();
//
//        schedule.setAcademicYear(2023);
//        schedule.setTerm("Spring");
//
//        List<Course> courses = new ArrayList<>();
//        courses.add(new Course("Discrete Math"));
//        courses.add(new Course("History"));
//        courses.add(new Course("Physics"));
//        courses.add(new Course("Computer Science"));
//        schedule.setCourses(courses);
//
//        List<Lesson> lessons = new ArrayList<>();
//        Teacher mathTeacher = new Teacher("J. Antony");
//        Teacher historyTeacher = new Teacher("K. West");
//        Teacher physicsTeacher = new Teacher("S. Johnson");
//        Teacher computerScienceTeacher = new Teacher("M. Smith");
//
//        lessons.add(new Lesson(courses.get(0), LessonType.P, mathTeacher, "101", "10:00", WeekDay.MON));
//        lessons.add(new Lesson(courses.get(1), LessonType.L, historyTeacher, "102", "11:00", WeekDay.TUE));
//        lessons.add(new Lesson(courses.get(2), LessonType.P, physicsTeacher, "103", "14:00", WeekDay.WED));
//        lessons.add(new Lesson(courses.get(3), LessonType.L, computerScienceTeacher, "104", "15:00", WeekDay.THU));
//        lessons.add(new Lesson(courses.get(0), LessonType.L, mathTeacher, "105", "13:00", WeekDay.MON));
//        lessons.add(new Lesson(courses.get(1), LessonType.P, historyTeacher, "106", "16:00", WeekDay.TUE));
//        lessons.add(new Lesson(courses.get(2), LessonType.L, physicsTeacher, "107", "12:00", WeekDay.WED));
//        lessons.add(new Lesson(courses.get(3), LessonType.P, computerScienceTeacher, "108", "17:00", WeekDay.THU));
//        lessons.add(new Lesson(courses.get(0), LessonType.P, mathTeacher, "109", "11:00", WeekDay.FRI));
//        lessons.add(new Lesson(courses.get(1), LessonType.L, historyTeacher, "110", "14:00", WeekDay.FRI));
//
//        schedule.setLessons(lessons);
//
//        schedule.printSchedule();
//    }
//    
}
