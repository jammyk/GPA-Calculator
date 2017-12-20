package model;

import java.util.ArrayList;
import java.util.List;

/**
 *      REPRESENTS A TERM
 */
public class Term {
    /*   the list of courses taken during this term  */
    private List<Course> courses;
    /* the name of the term taken */
    private String term;

    /**
     * CONSTRUCTOR
     * @param term
     */
    public Term(String term) {
        this.term = term;
        this.courses = new ArrayList<>();
    }

    /**
     * add course
     * @param course
     */
    public void addCourse(Course course) {
        if (!courses.contains(course))
            courses.add(course);
    }

    /**
     *
     * @param isWeighted
     * @return  the GPA of term
     */
    public double calculateGPA(boolean isWeighted) {
        double totalGPA = getGPA(isWeighted);           // call to helper
        if (isWeighted) {
            return totalGPA / getTotalCredit();         // weighted
        } else {
            return totalGPA / courses.size();           // not weighted
        }
    }

    /**
     * HELPER method for calculateGPA(b: boolean)
     * @param   isWeighted true if weighted, false otherwise
     * @return  the total GPA earned this term
     */
    private double getGPA(boolean isWeighted) {
        double totalGPA = 0;
        for (Course c : courses) {
            totalGPA += c.calculateGPA(isWeighted);
        }
        return totalGPA;
    }


    /**
     * HELPER METHOD for calculateGPA(b: boolean)
     * @return  total credit taken this term
     */
    private int getTotalCredit() {
        int totalCredits = 0;
        for (Course c : courses) {
            totalCredits += c.getCreditNumber();
        }
        return totalCredits;
    }

    public String getTermName() {
        return this.term;
    }

    public int getAverage() {
        return -1;
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != getClass()) return false;
        Term o = (Term) other;
        return o.getTermName().equals(this.getTermName());
    }

    @Override
    public int hashCode() {
        int result = 17;
        return result * this.term.hashCode() + 33;
    }

    @Override
    public String toString() {
        double gpa = calculateGPA(true);
        double roundedGPA = (double) Math.round(gpa * 100) / 100;                                                   // Math.round(double) rounded to the nearest integer
                                                                                                                    //      since I want up to two digits, first multiply by 100
                                                                                                                    //      ie. 4.3328538 to 433.28538 then it rounds to 433
                                                                                                                    //      divide by 100, which becomes 4.33
        return String.format("You have received a weighted GPA of: %s in the term of %s", roundedGPA, term);        // %s is for string formating, it formats anything to a string type
    }
}
