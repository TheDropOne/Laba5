import Exceptions.TestNotPassedException;
import entity.Tester;
import data.TestLists;

/**
 * Created by Semen on 07-Oct-16.
 */
public class Runner {

    public static final String FIRST_REGEX = "";
    public static final String SECOND_REGEX = "";
    public static final String THIRD_REGEX = "";
    public static final String FOURTH_REGEX = "";
    public static final String FIFTH_REGEX = "";
    public static final String SIXTH_REGEX = "";
    public static final String SEVENTH_REGEX = "";
    public static final String EIGHTH_REGEX = "";
    public static final String NINTH_REGEX = "";

    public static void main(String[] args) {
        try {
            TestLists.uploadTests();

            Tester.makeSimpleTest(TestLists.tests_first_task, FIRST_REGEX);
            Tester.makeSimpleTest(TestLists.tests_second_task, SECOND_REGEX);
            Tester.makeSimpleTest(TestLists.tests_third_task, THIRD_REGEX);
            Tester.makeSimpleTest(TestLists.tests_fourth_task, FOURTH_REGEX);
            Tester.makeSimpleTest(TestLists.tests_fifth_task, FIFTH_REGEX);
            Tester.makeSimpleTest(TestLists.tests_sixth_task, SIXTH_REGEX);
            Tester.makeSimpleTest(TestLists.tests_seventh_task, SEVENTH_REGEX);
            Tester.makeSimpleTest(TestLists.tests_eighth_task, EIGHTH_REGEX);
            Tester.makeSimpleTest(TestLists.tests_ninth_task, NINTH_REGEX);
        } catch (TestNotPassedException e) {
            System.out.println(e.getMessage());
        }
    }
}
