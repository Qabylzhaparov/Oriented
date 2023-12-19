package student;

import java.util.*;

import fromUser.Language;
import teacher.Teacher;

public class Schedule {

    private Integer academicYear;

    private String term;

    private List<Course> courses;
    
    private List<Lesson> lessons ;
    

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

    public void updateLesson(Lesson oldLesson, Lesson newLesson) {
        lessons.set(lessons.indexOf(oldLesson), newLesson);
                
    }
    
    
    
    
    
    
    
    
    public void printSchedule() {
        // Получаем уникальные дни недели из уроков
        List<WeekDay> uniqueDaysOfWeek = getUniqueDaysOfWeek();

        // Выводим заголовок с днями недели
        System.out.print(String.format("%-20s", ""));
        for (WeekDay day : uniqueDaysOfWeek) {
            System.out.print(String.format("%-20s", day));
        }
        System.out.println();

        // Выводим расписание по временам
        List<String> uniqueTimes = getUniqueTimes();
        for (String time : uniqueTimes) {
            System.out.print(String.format("%-20s", time));

            for (WeekDay day : uniqueDaysOfWeek) {
                Lesson lesson = findLessonByTimeAndDay(time, day);
                if (lessons.   contains(time) != null) {
                    System.out.print(String.format("%-20s", lesson.toString()));
                } else {
                    System.out.print(String.format("%-20s", ""));
                }
            }

            System.out.println();
        }
    }
    
    // Вспомогательный метод для получения уникальных времен из уроков
    private List<String> getUniqueTimes() {
        // Реализуйте логику получения уникальных времен из уроков
        // Верните, например, List<String> с временами
        return List.of("10:00", "11:00", "12:00", "13:00", "14:00", "15:00");
    }
    // Вспомогательный метод для получения уникальных дней недели из уроков
    private List<WeekDay> getUniqueDaysOfWeek() {
        // Реализуйте логику получения уникальных дней недели из уроков
        // Верните, например, List<WeekDay> с днями недели
        return List.of(WeekDay.MON, WeekDay.TUE, WeekDay.WED, WeekDay.THU, WeekDay.FRI);
    }

    // Вспомогательный метод для поиска урока по времени и дню недели
    private Lesson findLessonByTimeAndDay(String time, WeekDay day) {
        if(lessons.)
        return null;
    }
    
    
    
    public static void main(String[] args) {
        // Создаем объект Schedule
        Schedule schedule = new Schedule();

        // Устанавливаем значения
        schedule.setAcademicYear(2023);
        schedule.setTerm("Spring");

        // Создаем список курсов
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Math"));
        courses.add(new Course("History"));
        schedule.setCourses(courses);

        // Создаем список уроков
        List<Lesson> lessons = new ArrayList<>();
        Teacher mathTeacher = new Teacher("John");
        Teacher historyTeacher = new Teacher("Jane");

        lessons.add(new Lesson(courses.get(0), mathTeacher, "Room 101", "10:00", WeekDay.MON));
        lessons.add(new Lesson(courses.get(1), historyTeacher, "Room 102", "11:00", WeekDay.TUE));

        // Добавьте еще уроков по необходимости

        schedule.setLessons(lessons);

        // Вызываем метод printSchedule для вывода расписания
        schedule.printSchedule();
    }
    
}
