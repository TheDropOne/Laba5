package entity;

import Exceptions.TestNotPassedException;
import iostream.ReportPrinter;
import tests.ComplexTest;
import tests.SimpleTest;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Semen on 07-Oct-16.
 */
public class Tester {
    public static void makeSimpleTest(List<SimpleTest> testList, String regex) throws TestNotPassedException {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        ReportPrinter reportPrinter = new ReportPrinter();
        boolean isMatches;
        for (SimpleTest test : testList) {
            matcher = pattern.matcher(test.getExpression());
            isMatches = matcher.matches();
            reportPrinter.addLine(test.getExpression() + "\t\t" + isMatches);
            if (isMatches != test.isCorrect()) {
                throw new TestNotPassedException("\t SimpleTest " + test + " not passed!");
            }
        }
        reportPrinter.printReport();
    }

    /*
    public static void makeComplexTest(List<ComplexTest> testList, String regex) throws TestNotPassedException {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        ReportPrinter reportPrinter = new ReportPrinter();
        boolean isMatches;
        for (ComplexTest test : testList) {
            matcher = pattern.matcher(test.getExpression());
            isMatches = matcher.matches();
            reportPrinter.addLine(test.getExpression() + "\t\t" + isMatches);
            if (isMatches != test.isCorrect()) {
                throw new TestNotPassedException("\t SimpleTest " + test + " not passed!");
            }
        }
        reportPrinter.printReport();
    }
    */

}
