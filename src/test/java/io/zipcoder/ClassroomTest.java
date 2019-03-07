package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ClassroomTest {

    @Test
    public void getStudentsTest() {
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };
        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student[] expected = {s1,s2};
        Classroom classroom = new Classroom(expected);

        // When
        Student[] actual = classroom.getStudents();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoreTest() {
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };
        Double expectedAverage = 125.0;

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        Double output = classroom.getAverageExamScore();

        // Then
        Assert.assertEquals(expectedAverage, output);
    }

    @Test
    public void addStudentTest() {
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student expected = new Student("Leon", "Hunter", examScores);

        // When
        Student[] expectedArr = {expected};
        classroom.addStudent(expected);
        Student[] actualArr = classroom.getStudents();

        // Then
        Assert.assertEquals(expectedArr, actualArr);
    }

    @Test
    public void removeStudentTest() {
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student expected = new Student("Leon", "Hunter", examScores);

        // When
        Student[] expectedArr = new Student[expected];
        classroom.removeStudent("Leon", "Hunter");

        // Then
        Assert.assertEquals(expectedArr, actualArr);
    }
}
