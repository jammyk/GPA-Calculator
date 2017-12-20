package model;

/**
 * ENUMERATION for GPA,
 * According to the UBC Arts equivalency
 */
public enum GPA {

    NINETY(4.33, 90),
    EIGHTYNINE(4.30, 89), EIGHTYEIGHT(4.2, 88), EIGHTYSEVEN(4.1, 87), EIGHTYSIX(4, 86), EIGHTYFIVE(3.95, 85),
    EIGHTYFOUR(3.9, 84), EIGHTYTHREE(3.85, 83), EIGHTYTWO(3.8, 82), EIGHTYONE(3.75, 81), EIGHTY(3.7, 80),
    SEVENTYNINE(3.6, 79), SEVENTYEIGHT(3.5, 78), SEVENTYSEVEN(3.4, 77), SEVENTYSIX(3.3, 76), SEVENTYFIVE(3.2, 75),
    SEVENTYFOUR(3.1, 74), SEVENTYTHREE(3, 73), SEVENTYTWO(2.95, 72), SEVENTYONE(2.9, 71), SEVENTY(2.8, 70),
    SIXTYNINE(2.7, 69), SIXTYEIGHT(2.65, 68), SIXTYSEVEN(2.6, 67), SIXTYSIX(2.55, 66), SIXTYFIVE(2.5, 65),
    SIXTYFOUR(2.4, 64), SIXTYTHREE(2.3, 63), SIXTYTWO(2.2, 62), SIXTYONE(2.1, 61), SIXTY(2, 60),
    FIFTYNINE(1.9, 59), FIFTYEIGHT(1.8, 58), FIFTYSEVEN(1.7, 57), FIFTYSIX(1.6, 56), FIFTYFIVE(1.5, 55),
    FIFTYFOUR(1.4, 54), FIFTYTHREE(1.3, 53), FIFTYTWO(1.2, 52), FIFTYONE(1.1, 51), FIFTY(1, 50);

    private double gpa;
    private int per;

    /**
     * CONSTRUCTOR
     * @param gpa
     * @param percentage
     */
    private GPA(double gpa, int percentage) {
        this.gpa = gpa;
        this.per = percentage;
    }

    public int getPercentageValue() {
        return this.per;
    }


    /**
     * returns the GPA for the given enumeration
     * @return
     */
    public double returnGPA() {
        return this.gpa;
    }
}
