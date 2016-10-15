import Exceptions.TestNotPassedException;
import data.TestLists;
import entity.Tester;

import java.util.regex.Pattern;

/**
 * Created by Semen on 07-Oct-16.
 */
public class Runner {

    private static final String FIRST_REGEX = "\\*[^\\*]+\\*"; //All Tests Passed!
    private static final String SECOND_REGEX = "([01]?\\d|2[0-3]):[0-5]\\d"; // All Tests Passed!
    private static final String THIRD_REGEX = "[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}" +
            "|\\{[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}\\}"; // All Tests Passed!
    private static final String FOURTH_REGEX = "((([01]?\\d{2}|2[0-4]\\d|25[0-5])\\.?){3}([01]?\\d{2}|2[0-4]\\d|25[0-5]))" +
            "|((([01]?\\d{2}|2[0-4]\\d|25[0-5])\\.?){3}([01]?\\d{2}|2[0-4]\\d|25[0-5]))" +
            "|((0?(\\d{1,3}|x[a-fA-F0-9]{2})\\.){3}0?(\\d{1,3}|x[a-fA-F0-9]{1,2}))"; // All Tests Passed!
    private static final String FIFTH_REGEX = "^((https?://)?(w{3}\\.)?)?([a-zA_Z][a-zA-Z\\+\\-]{0,61}[a-zA_Z]\\.)+([a-z]{2,4})" +
            "(:\\d{2,4}|((/[^\\s\\.]+)+)\\.[a-z]{2,4}((\\?((\\w+=\\S+\\&)+)?(\\w+=\\S+))|#\\w+)?)?"; // All Tests Passed!
    private static final String SIXTH_REGEX = "((0[1-9]|[12]\\d|3[01])/(0[13578]|1[02])|(0[1-9]|[12]\\d|30)/(0[469]|11)|(0[1-9]|[12][0-8])/02)/(1[6-9]\\d{2}|[2-9]\\d{3})" +
            "|(29/02/(1[6-9](([2468][048])|(0[48])|(1[26]))|([2468][048]([02468][048])|([13579][26])))"; // All Tests Passed!
    private static final String SEVENTH_REGEX = "#[a-fA-F0-9]{6}"; // All Tests Passed!
    private static final String EIGHTH_REGEX = "(([\\w']+\\s)|(\".+\")|(\\S+(--)|(--)\\S+)|([\\w]+'?[\\w]+-\\w+'?\\w+))"; // All Tests Passed
    private static final String NINTH_REGEX = "(\\:([a-zA_Z][a-zA-Z\\+\\-]{0,61}[a-zA_Z]\\.)+([a-z]{2,4})\\s+)?" + //hostname (optional)
            "[^\\s\\*\"/\\?\\<>\\:\\\\]+" +     //nickname (Required)
            "\\s+PRIVMSG\\s+" +         //PRIVMSG command (Required)
            "\\#\\p{Lower}{2,}\\s+" +   //channel (Required)
            "\\:.{1,450}";               // message (Required)


    public static void main(String[] args) {
        try {
            TestLists.uploadTests();

            Tester.makeComplexTest(TestLists.tests_first_task, FIRST_REGEX, 1);     // 10

            Tester.makeSimpleTest(TestLists.tests_second_task, SECOND_REGEX);       // 24
            Tester.makeSimpleTest(TestLists.tests_third_task, THIRD_REGEX);         // 105
            Tester.makeSimpleTest(TestLists.tests_fourth_task, FOURTH_REGEX);       // 203
            Tester.makeSimpleTest(TestLists.tests_fifth_task, FIFTH_REGEX);         // 150
            Tester.makeSimpleTest(TestLists.tests_sixth_task, SIXTH_REGEX);         // 62
            Tester.makeSimpleTest(TestLists.tests_seventh_task, SEVENTH_REGEX);     // 15

            Tester.makeComplexTest(TestLists.tests_eighth_task, EIGHTH_REGEX, 8);   // 61
            Tester.makeSimpleTest(TestLists.tests_ninth_task, NINTH_REGEX);         // 119

                                    //0.2703757542
        } catch (TestNotPassedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
