package model;

public class Course {

    private String name;
    private int creditNumber;
    private int gradeReceived;
    private Term term;

    /**
     * CONSTRUCTOR
     * @param name              the name of this course with course number
     * @param credit            number of credits of course
     * @param gradeReceived     percentage earned for course
     * @param term              the term in which this course belongs to
     */
    public Course(String name, int credit, int gradeReceived, Term term) {
        this.name = name;
        this.creditNumber = credit;
        this.gradeReceived = gradeReceived;
        this.term = term;
        term.addCourse(this);
    }

    /**
     * calculate the single GPA according to the grade received and credits
     * @param isWeighted    true if weighted GPA, false if want single GPA
     * @return
     */
    public double calculateGPA(boolean isWeighted) {
        if (isWeighted) {
            return getGPAEquivalency(gradeReceived) * creditNumber;                 // since "weighted" doesn't count for single values, this only applies when calculating for term
        } else {
            return getGPAEquivalency(gradeReceived);                                // just return the GPA since we are looking for single GPA
        }
    }

    /**
     *
     * @return number of credits
     */
    public int getCreditNumber() {
        return this.creditNumber;
    }

    /**
     *
     * @param isWeighted    true if weighted, false otherwise
     * @return percentage received
     */
    public int getGradeReceived(boolean isWeighted) {
        if (isWeighted) return gradeReceived * creditNumber;
        return gradeReceived;
    }

    /**
     *
     * @return  String
     */
    @Override
    public String toString() {
        return "COURSE INFORMATION ---- \n" +
                  "TERM         :     "+term.getTermName()+
                "\nCOURSE       :     "+name+
                "\nCREDITS      :     "+creditNumber+
                "\nPERCENTAGE   :     "+gradeReceived+
                "\nGPA          :     "+calculateGPA(false)+
                "\n";
    }


    /**
     * helper method
     * returns the GPA equivalency of the grade given
     * @param gradeReceived
     * @return
     */
    private double getGPAEquivalency(int gradeReceived) {
        if (gradeReceived > 90) {                                                           // ENUM has only 90, nothing above
            return 4.33;
        }

        if (gradeReceived < 50) {                                                          // ^ same for below 50
            return 1;
        }

        for (GPA gpa : GPA.values()) {                                                    // iterator through the values of the GPA.... can optimize by somehow changing into a hashmap
            if (gpa.getPercentageValue() == gradeReceived)
                return gpa.returnGPA();
        }
        return 0;
    }
}
