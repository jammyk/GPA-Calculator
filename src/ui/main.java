package ui;

import model.Course;
import model.Term;
import model.TermManager;

public class main {

    public static void main(String[] args) {
        loadCourses();
        System.out.println(TermManager.getInstance());
        System.out.println(TermManager.getInstance().getCumulativeGPA(false));
        System.out.println(TermManager.getInstance().getCumulativeGPA(true));
        System.out.println(TermManager.getInstance().getCumulativeAverage(true));

    }
























    private static void loadCourses() {
        Term firstYearTermOne = new Term("Y1T1");
        Course cpsc110 = new Course("CPSC110", 4, 90, firstYearTermOne);
        Course chem111 = new Course("CHEM111", 4, 90, firstYearTermOne);
        Course engl110 = new Course("ENGL110", 3, 90, firstYearTermOne);
        Course eosc112 = new Course("EOSC112", 3, 100, firstYearTermOne);
        firstYearTermOne.addCourse(cpsc110);
        firstYearTermOne.addCourse(chem111);
        firstYearTermOne.addCourse(engl110);
        firstYearTermOne.addCourse(eosc112);

        Term firstYearTermTwo = new Term("Y1T2");
        Course cpsc121 = new Course("CPSC121", 4, 87, firstYearTermTwo);
        Course math101 = new Course("MATH101", 3, 95, firstYearTermTwo);
        Course ling100 = new Course("LING100", 3, 87, firstYearTermTwo);
        Course engl100 = new Course("ENGL100", 3, 76, firstYearTermTwo);
        firstYearTermTwo.addCourse(cpsc121);
        firstYearTermTwo.addCourse(math101);
        firstYearTermTwo.addCourse(ling100);
        firstYearTermTwo.addCourse(engl100);

        Term firstYearSummerTermOne = new Term("Y1S1");
        Course engl224 = new Course("ENGL224", 3, 80, firstYearSummerTermOne);
        firstYearSummerTermOne.addCourse(engl224);

        Term secondYearTermOne = new Term("Y2T1");
        Course cpsc210 = new Course("CPSC210", 4, 95, secondYearTermOne);
        Course phil120 = new Course("PHIL120", 3, 85, secondYearTermOne);
        Course stat200 = new Course("STAT200", 3, 89, secondYearTermOne);
        Course comm465 = new Course("COMM465", 3,87,  secondYearTermOne);
        Course chin131 = new Course("CHIN131", 3, 92, secondYearTermOne);
        secondYearTermOne.addCourse(cpsc210);
        secondYearTermOne.addCourse(phil120);
        secondYearTermOne.addCourse(stat200);
        secondYearTermOne.addCourse(comm465);
        secondYearTermOne.addCourse(chin131);

        TermManager.getInstance().addTerm(firstYearSummerTermOne);
        TermManager.getInstance().addTerm(firstYearTermOne);
        TermManager.getInstance().addTerm(firstYearTermTwo);
        TermManager.getInstance().addTerm(secondYearTermOne);
    }
}
