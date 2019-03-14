package io.zipcoder;

import java.util.*;

import org.apache.commons.lang3.StringUtils;


public class Classroom {
    private Student[] students;
    private int size;

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom() {
        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return this.students;
    }

    public Double getAverageExamScore() {
        Double classAverage = 0.0;
        for (Student student : students) {
            classAverage += student.getAverageExamScore();
        }
        return classAverage / students.length;
    }

    public void addStudent(Student student) {
        for(int i = 0; i < students.length; i++) {
            if(students[i] == null) {
                students[i] = student;
            }
        }

//        if (size == students.length) {
//
//            Student[] newStudent = Arrays.copyOf(students, students.length + 1);
//            newStudent[students.length] = student;
//            students = newStudent;
//        } else {
//            students[size] = student;
//        }
//        size++;
    }

    public void removeStudent(String firstName, String lastName) {

//        for(int i =0; i < students.length; i++) {
//            if(students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName)) {
//                students[i] = null;
//            }
//        }
//        Arrays.sort(students,Comparator.nullsLast(Comparator.naturalOrder()));
//        return students;
        Student[] removedStudent = Arrays.copyOf(students, students.length);
        int index = 0;
        for (int i = 0; i < students.length; i++) {
            if(students[i] != null) {
                if (!students[i].getFirstName().equals(firstName) && !students[i].getLastName().equals(lastName)) {
                    removedStudent[index] = students[i];
                    index++;
                }
            }
        }
        students = removedStudent;
    }

////    public Student[] getStudentsByScore() {
////        ScoreComparator comparator = new ScoreComparator();
////        Arrays.sort(students, comparator);
////        return students;
////    }
//
//    public HashMap<Student, String> getGradeBook() {
//        Student[] sorted = getStudentsByScore();
//        HashMap<Student, String> grades = new HashMap<>();
//
//        for(int i = 0; i < sorted.length; i++) {
//            String letterGrade;
//            Double percentile = (double)(i+1)/sorted.length;
//
//            if(percentile > 0.9) {
//                letterGrade = "A";
//            } else if(percentile > .71) {
//                letterGrade = "B";
//            } else if(percentile > 0.5) {
//                letterGrade = "C";
//            } else if(percentile > 0.11) {
//                letterGrade = "D";
//            } else {
//                letterGrade = "F";
//            }
//            grades.put(sorted[i], letterGrade);
//        }
//        return grades;
//    }
//
//
    public Student[] getStudentsByScore() {
        Arrays.sort(students);
        return students;
    }

    public Map<Student,Character> getGradeBook(){
        Arrays.sort(students);
        Map<Student, Character> gradedStudents = new HashMap<>();

        int startingIndex = 0;
        int aNumber = (int) Math.ceil(students.length * .1);
        setStudentGrade(gradedStudents, aNumber, startingIndex, 'A');
        startingIndex = aNumber;

        int bNumber = (int) Math.ceil(students.length * .19);
        setStudentGrade(gradedStudents, bNumber, startingIndex, 'B');
        startingIndex += bNumber;

        int cNumber = (int) Math.ceil(students.length * .20);
        setStudentGrade(gradedStudents, cNumber, startingIndex, 'C');
        startingIndex += cNumber;

        int dNumber = (int) Math.ceil(students.length * .38);
        setStudentGrade(gradedStudents, dNumber, startingIndex, 'D');
        startingIndex += dNumber;

        int fNumber = students.length - startingIndex;
        setStudentGrade(gradedStudents, fNumber, startingIndex, 'F');

        return gradedStudents;
    }

    private void setStudentGrade(Map<Student, Character> gradedStudents, int numberOfStudent, int startingIndex, char grade) {
        //starting index= 0, add the number of students that was taken to get the the stop index
        int stopIndex = startingIndex + numberOfStudent;
        for (int i = startingIndex; i < stopIndex; i++) {
            Student student = students[i];
            //Adding the student and their grades into the map
            gradedStudents.put(student, grade);
        }
    }

    

}
