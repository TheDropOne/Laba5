package data;

import tests.SimpleTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static iostream.MyFileReader.*;

/**
 * Created by Semen on 07-Oct-16.
 */
public class TestLists {

    public static List<SimpleTest> tests_first_task;
    public static List<SimpleTest> tests_second_task;
    public static List<SimpleTest> tests_third_task;
    public static List<SimpleTest> tests_fourth_task;
    public static List<SimpleTest> tests_fifth_task;
    public static List<SimpleTest> tests_sixth_task;
    public static List<SimpleTest> tests_seventh_task;
    public static List<SimpleTest> tests_eighth_task;
    public static List<SimpleTest> tests_ninth_task;

    public static void uploadTests(){
        try {
            tests_first_task = readSimpleTestFromFile(new File("test1"));
            tests_second_task = readSimpleTestFromFile(new File("test2"));
            tests_third_task = readSimpleTestFromFile(new File("test3"));
            tests_fourth_task = readSimpleTestFromFile(new File("test4"));
            tests_fifth_task = readSimpleTestFromFile(new File("test5"));
            tests_sixth_task = readSimpleTestFromFile(new File("test6"));
            tests_seventh_task = readSimpleTestFromFile(new File("test7"));
            tests_eighth_task = readSimpleTestFromFile(new File("test8"));
            tests_ninth_task = readSimpleTestFromFile(new File("test9"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
