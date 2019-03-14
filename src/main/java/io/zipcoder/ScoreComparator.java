package io.zipcoder;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Student> {

    public int compare(Student student1, Student student2) {
        int sort = Double.compare(student2.getAverageExamScore(), student1.getAverageExamScore());
        if(sort == 0) {
           return student2.compareTo(student1);
        }
        return sort;
    }
}
