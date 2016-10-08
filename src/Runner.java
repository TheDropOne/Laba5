import Exceptions.TestNotPassedException;
import entity.Tester;
import data.TestLists;

import java.util.regex.Pattern;

/**
 * Created by Semen on 07-Oct-16.
 */
public class Runner {

    private static final String FIRST_REGEX = "\\*[^\\*]+\\*"; //All Tests Passed!
    private static final String SECOND_REGEX = "([01]?\\d|2[0-3]):[0-5]\\d"; // All Tests Passed!
    private static final String THIRD_REGEX = "[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}"; // works without brackets
    private static final String FOURTH_REGEX = "(([01]?\\d{2}|2[0-4]\\d|25[0-5])\\.?){3}([01]?\\d{2}|2[0-4]\\d|25[0-5])"; // Works only for DEC
    private static final String FIFTH_REGEX = "";
    private static final String SIXTH_REGEX = "(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/(1[6-9]\\d{2}|[2-9]\\d{3})"; // All Tests Passed!
    private static final String SEVENTH_REGEX = "#[a-fA-F0-9]{6}"; // All Tests Passed!
    private static final String EIGHTH_REGEX = "";
    private static final String NINTH_REGEX = "";


    public static void main(String[] args) {
        try {
            TestLists.uploadTests();
            //Pattern p1 = Pattern.compile("\\*[^\\*]+\\*");
            Pattern p3 = Pattern.compile("(([a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12})|\\{\\2\\})");
            //Pattern p3 = Pattern.compile("([a-fA-F0-9]){8}-\\1");
            //Pattern p4 = Pattern.compile("(([01]?\\d{2}|2[0-4]\\d|25[0-5])\\.?){3}([01]?\\d{2}|2[0-4]\\d|25[0-5])");
            //Pattern p6 = Pattern.compile("(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/(1[6-9]\\d{2}|[2-9]\\d{3})");
            //Pattern p7 = Pattern.compile("#[a-fA-F0-9]{6}");
            Tester.makeComplexTest(TestLists.tests_first_task,FIRST_REGEX,1);
            System.exit(0);

            Tester.makeSimpleTest(TestLists.tests_second_task, SECOND_REGEX);
            Tester.makeSimpleTest(TestLists.tests_third_task, THIRD_REGEX);
            Tester.makeSimpleTest(TestLists.tests_fourth_task, FOURTH_REGEX);
            Tester.makeSimpleTest(TestLists.tests_fifth_task, FIFTH_REGEX);
            Tester.makeSimpleTest(TestLists.tests_sixth_task, SIXTH_REGEX);
            Tester.makeSimpleTest(TestLists.tests_seventh_task, SEVENTH_REGEX);

            /*
            Tester.makeComplexTest(TestLists.tests_first_task, FIRST_REGEX);
            Tester.makeComplexTest(TestLists.tests_eighth_task, EIGHTH_REGEX);
            Tester.makeComplexTest(TestLists.tests_ninth_task, NINTH_REGEX);
            */
        } catch (TestNotPassedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
