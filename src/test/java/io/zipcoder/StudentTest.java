package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class StudentTest {

    @Test
    public void setFirstNameTest() {
        // Given
        Double[] testScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student("", "", testScores);
        String expected = "Julian";
        // When
        student.setFirstName(expected);
        String actual = student.getFirstName();
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setLastNameTest() {
        // Given
        Double[] testScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student("", "", testScores);
        String expected = "Rios";
        // When
        student.setLastName(expected);
        String actual = student.getLastName();
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFirstNameTest() {
        // Given
        Double[] testScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student("Julian", "", testScores);
        String expected = "Julian";
        // When
        student.setFirstName(expected);
        String actual = student.getFirstName();
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastNameTest() {
        // Given
        Double[] testScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student("", "Rios", testScores);
        String expected = "Rios";
        // When
        student.setLastName(expected);
        String actual = student.getLastName();
        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void examScoresSizeTest() {
        // Given
        Double[] testScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student("", "", testScores);
        String expected = "Exam Scores:\n" +
                " \tExam 1 -> 100\n" +
                " \tExam 2 -> 95\n" +
                " \tExam 3 -> 123\n" +
                " \tExam 4 -> 96";

        // When
        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addExamScoreTest() {
        // : Given
        String firstName = "Julian";
        String lastName = "Rios";
        Double[] examScores = { };
        Student student = new Student(firstName, lastName, examScores);
        String expected = "Exam Scores:\n \tExam 1 -> 100";

        // When
        student.addExamScore(100.0);

        String output = student.getExamScores();

        // Then
        Assert.assertEquals(output,expected);
    }

    @Test
    public void setExamScore() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0 };
        Student student = new Student(firstName, lastName, examScores);
        String expected = "Exam Scores:\n \tExam 1 -> 150";

        // When
        student.setExamScore(0, 150.0);
        String output = student.getExamScores();
        System.out.println(output);
        System.out.println(expected);


        // Then
       Assert.assertEquals(expected, output);
    }

    @Test
    public void getAverageExamScoreTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        Double output = student.getAverageExamScore();
        Double expected = 125.0;

        // Then
        Assert.assertEquals(expected, output);
    }

    @Test
    public void toStringTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);
        String expected = "Student Name: Leon Hunter\n" +
                " > Average Score: 125.0\n" +
                " > Exam Scores:\n" +
                " \tExam 1 -> 100\n" +
                " \tExam 2 -> 150\n" +
                " \tExam 3 -> 250\n" +
                " \tExam 4 -> 0";

        // When
        String output = student.toString();

        // Then
        Assert.assertEquals(expected, output);
    }

}