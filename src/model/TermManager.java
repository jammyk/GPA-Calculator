package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TermManager {

    /* global single instance of class */
    private static TermManager instance;
    /* list of terms this manager knows about */
    private List<Term> terms;

    /**
     * private CONSTRUCTOR
     */
    private TermManager() { terms = new ArrayList<>();}

    /**
     * lazy constructor
     * @return instance of class
     */
    public static TermManager getInstance() {
        if (instance == null)
            instance = new TermManager();
        return instance;
    }


    /**
     * add term to TermManager
     * @param t Term to be added
     */
    public void addTerm(Term t) {
        if (!terms.contains(t))
            terms.add(t);
    }

    /**
     * clear current list of terms
     */
    public void clearTerms() {
        terms = new ArrayList<>();
    }

    /**
     * calculate the cumulative GPA
     * @param isWeighted true if GPA is weighted, false otherwise
     * @return cumulative GPA
     */
    public double getCumulativeGPA(boolean isWeighted) {
        double cumulativeGPA = 0;
        for (Term t: terms) {
            cumulativeGPA += t.calculateGPA(isWeighted);
        }
        cumulativeGPA = cumulativeGPA / terms.size();
        return (double) Math.round(cumulativeGPA * 100) / 100;
    }

    public double getCumulativeAverage(boolean isWeighted) {
        double cumulativeAverage = 0;
        for (Term t : terms) {
            cumulativeAverage += t.calculateAverage(isWeighted);
        }
        cumulativeAverage = cumulativeAverage / terms.size();
        return (double) Math.round(cumulativeAverage * 100) / 100;
    }

    /**
     *
     * @return list of terms
     */
    public List<Term> getTerms() {
        return Collections.unmodifiableList(terms);
    }

    @Override
    public String toString() {
        return "You have received a weighted cumulative GPA of: " + getCumulativeGPA(true);
    }
}
