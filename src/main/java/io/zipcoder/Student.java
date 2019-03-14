package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>();
        this.examScores.addAll(Arrays.asList(testScores));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExamScores() {
        StringBuilder str = new StringBuilder();
        str.append("Exam Scores:\n");

        int counter = 1;

        for (Double score : examScores) {
            printExamScores(str, counter, score);
            counter++;
        }
        return str.toString();
    }

    public Integer getNumberOfExamsTaken() {
        return this.examScores.size();
    }

    private void printExamScores(StringBuilder str, int counter, Double score) {
        str.append(" \t");
        str.append("Exam ");
        str.append(counter);
        str.append(" -> ");
        str.append(score.intValue());
        if(counter < examScores.size()) {
            str.append("\n");
        }
    }

    public void addExamScore(double score) {
        this.examScores.add(score);
    }

    public void setExamScore(int index, double scoreValue) {
        this.examScores.set(index, scoreValue);
    }

    public Double getAverageExamScore() {
        Double average = 0.0;
        for (Double score : this.examScores) {
            average += score;
        }
        return average / getNumberOfExamsTaken();
    }

    @Override
    public String toString() {
        return "Student Name: " + firstName + " " + lastName + "\n > Average Score: " + getAverageExamScore() + "\n" + " > "
                + getExamScores();
    }

    @Override
    public int compareTo(Student otherStudent) {
        return otherStudent.getAverageExamScore().compareTo(this.getAverageExamScore());
    }


}
