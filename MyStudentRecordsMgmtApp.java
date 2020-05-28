package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

public class MyStudentRecordsMgmtApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Student[]students = {new Student("110001", "Dave", LocalDate.of(1951,11,18)),
    		  new Student("110002", "Anna", LocalDate.of(1990,12,07)),
    		  new Student("10003", "Erica",  LocalDate.of(1974,01,31)),
    		  new Student("110004", "Carlos", LocalDate.of(2009,8,22)),
    		  new Student("110005", "Bob",  LocalDate.of(1990,02,05))
                 };
      
      //Assending order by name of students.
      
     // List<Student>stList1 = Arrays.asList();
      System.out.println("1. Students list with there alphabetical order. \n");
      Comparator<Student>nameComp = (Student st1, Student st2)->st1.getName().compareTo(st2.getName());
     // List<Student>stList2 = Collections.sort(stList1); //(students, nameComp);
      Arrays.sort(students, nameComp);
      List<Student>stList1 = Arrays.asList(students);
      MyStudentRecordsMgmtApp.printListOfStudents(stList1);
     
      //Descending order by dateofAdmission.
       System.out.println("  2. Platinium students list\n");
      List<Student> platinum = getListOfPlatinumAlumniStudents(students);
      platinum.sort(Comparator.comparing(Student::getDateOfAdmission).reversed());
      System.out.println(platinum);
}
 public static void printListOfStudents(List<Student>list) {
	 for(Student st : list) {
		 System.out.println(st);
	 }
	
 }
 public static List<Student> getListOfPlatinumAlumniStudents(Student[] arr){
	 List<Student>students = new ArrayList<>();
	 for(Student st : arr) {
		 if(LocalDate.now().getYear() - st.getDateOfAdmission().getYear() > 30) {
			 students.add(st);
		 }
		
	 }
	 return students;
 }
 
}