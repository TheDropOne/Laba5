package entity;

import Exceptions.TestNotPassedException;
import iostream.ReportPrinter;
import tests.ComplexTest;
import tests.SimpleTest;

import java.util.ArrayList;
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
            if (isMatches != test.isCorrect()) {
                reportPrinter.addLine(test.getExpression() + "\t\t" + "test failed!");
                reportPrinter.printReport();
                throw new TestNotPassedException("\t SimpleTest " + test + " not passed!");
            }
            reportPrinter.addLine(test.getExpression() + "\t\t" + isMatches + "\t\t" + "Test passed successfully");
        }
        reportPrinter.addLine("\t\tAll tests passed!\n");
        reportPrinter.printReport();
    }


    public static void makeComplexTest(List<ComplexTest> testList, String regex, int testNumber) throws TestNotPassedException {
        if (testNumber != 1 && testNumber != 8) return;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        String tempString = "";
        ReportPrinter reportPrinter = new ReportPrinter();
        boolean isMatches;
        for (ComplexTest test : testList) {
            switch (testNumber) {
                case 1:
                    tempString = "";
                    matcher = pattern.matcher(test.getExpression());
                    if (matcher.matches()) {
                        tempString = matcher.group();
                        tempString = tempString.substring(1, tempString.length() - 1);
                    }
                    tempString = firstTaskGetString(tempString);
                    isMatches = tempString.equals(test.getCorrectExpression());
                    if (isMatches) {
                        reportPrinter.addLine(test.getExpression() + "\t\t" + tempString + "\t\t" + "Test passed successfully");
                    } else {
                        reportPrinter.addLine(test.getExpression() + "\t\t" + "Test failed!");
                        reportPrinter.printReport();
                        throw new TestNotPassedException("\t ComplexTest " + test + " not passed!\t" + tempString + "/" + test.getCorrectExpression());
                    }
                    break;
                case 8:
                    List<String> list = new ArrayList<>();
                    tempString = eightTaskDeleteGarbage(test.getExpression());
                    matcher = pattern.matcher(tempString);
                    while (matcher.find()) {
                        list.add(matcher.group());
                    }
                    tempString = "";
                    for (String s : list) {
                        tempString += eightTastDeleteFinalGarbage(s) + ',';
                    }
                    tempString = tempString.substring(0, tempString.length() - 1) + ".";
                    isMatches = tempString.equals(test.getCorrectExpression());
                    if (isMatches) {
                        reportPrinter.addLine(test.getExpression() + "\t\t" + tempString + "\t\t" + "Test passed successfully");
                    } else {
                        reportPrinter.addLine(test.getExpression() + "\t\t" + "Test failed!\t" + tempString + "/" + test.getCorrectExpression());
                        reportPrinter.printReport();
                        throw new TestNotPassedException("\t ComplexTest " + test + " not passed!\t" + tempString + "/" + test.getCorrectExpression());
                    }
                    break;
            }
        }
        reportPrinter.addLine("\t\tAll tests passed!\n");
        reportPrinter.printReport();
    }


    private static String firstTaskGetString(String result) {
        return (!result.isEmpty()) ? "<em>" + result + "<\\em>" : "wrong";
    }

    private static String eightTaskDeleteGarbage(String s) {
        String tempString = "";
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (Character.isLetterOrDigit(a) || a == '\"' || a == '\'' || a == ' ' || a == '-') {
                tempString += a;
            }
        }
        return tempString;
    }

    private static String eightTastDeleteFinalGarbage(String s) {
        if (s.contains("\"")) {
            return s.replaceAll("\"", "");
        }
        if (s.contains("--")) {
            return s.replaceAll("--", "");
        }
        return s.replaceAll(" ", "");
    }
}
