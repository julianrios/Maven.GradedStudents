package io.zipcoder;

public class Classroom {
    private Student[] students;
//    private int maxStudents;

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
        this.students[students.length-1] = student;
    }

    public void removeStudent(String firstName, String lastName) {
        this.students[expected]
    }
}
