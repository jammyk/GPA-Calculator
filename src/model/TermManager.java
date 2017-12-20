package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TermManager {

    private static TermManager instance;
    private List<Term> terms;

    private TermManager() { terms = new ArrayList<>();}

    /**
     * lazy constructor
     * @return
     */
    public static TermManager getInstance() {
        if (instance == null)
            instance = new TermManager();
        return instance;
    }

    public void addTerm(Term t) {
        if (!terms.contains(t))
            terms.add(t);
    }

    public void clearTerms() {
        terms = new ArrayList<>();
    }

    public double calculateGPA(boolean isWeighted) {
        double cumulativeGPA = 0;
        for (Term t: terms) {
            cumulativeGPA += t.calculateGPA(isWeighted);
        }
        cumulativeGPA = cumulativeGPA / terms.size();
        return (double) Math.round(cumulativeGPA * 100) / 100;
    }

    public List<Term> getTerms() {
        return Collections.unmodifiableList(terms);
    }

    @Override
    public String toString() {
        return "You have received a weighted cumulative GPA of: " + calculateGPA(true);
    }
}
