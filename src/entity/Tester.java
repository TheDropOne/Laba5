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
                reportPrinter.addLine(test.getExpression() + "\t\t" + "test faled!");
                reportPrinter.printReport();
                /*try {
                    new Thread().wait(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                throw new TestNotPassedException("\t SimpleTest " + test + " not passed!");
            }
        }
        reportPrinter.addLine("All tests passed!");
        reportPrinter.printReport();
    }


    public static void makeComplexTest(List<ComplexTest> testList, String regex, int testNumber) throws TestNotPassedException {
        if (testNumber != 1 && testNumber != 8 && testNumber != 9) return;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        ReportPrinter reportPrinter = new ReportPrinter();
        boolean isMatches;
        for (ComplexTest test : testList) {
            switch (testNumber) {
                case 1:
                    String tempString = "";
                    matcher = pattern.matcher(test.getExpression());
                    if (matcher.matches()) {
                        tempString = matcher.group();
                        tempString = tempString.substring(1, tempString.length() - 1);
                    }
                    tempString = getStringFirstTask(tempString);
                    isMatches = tempString.equals(test.getCorrectExpression());
                    if (isMatches) {
                        reportPrinter.addLine(test.getExpression() + "\t\t" + "Test passed successfully");
                    } else {
                        reportPrinter.addLine(test.getExpression() + "\t\t" + "Test failed!");
                        reportPrinter.printReport();
                        throw new TestNotPassedException("\t SimpleTest " + test + " not passed!");
                    }
                    break;
                case 8:
                    if (true) {
                        throw new TestNotPassedException("\t SimpleTest " + test + " not passed!");
                    }
                    break;
                case 9:
                    if (true) {
                        throw new TestNotPassedException("\t SimpleTest " + test + " not passed!");
                    }
                    break;
            }

        }
        reportPrinter.addLine("All tests passed!");
        reportPrinter.printReport();
    }


    private static String getStringFirstTask(String result) {
        return (!result.isEmpty()) ? "<em>" + result + "<\\em>" : "wrong";
    }

    private static String getStringEighthTask(String result) {
        return "<em>" + result + "<\\em>";
    }

    private static String getStringNinthTask(String result) {
        return result;
    }

}
