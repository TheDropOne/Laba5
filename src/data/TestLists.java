package data;

import tests.ComplexTest;
import tests.SimpleTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static iostream.MyFileReader.*;

/**
 * Created by Semen on 07-Oct-16.
 */
public class TestLists {

    public static List<ComplexTest> tests_first_task;
    public static List<SimpleTest> tests_second_task;
    public static List<SimpleTest> tests_third_task;
    public static List<SimpleTest> tests_fourth_task;
    public static List<SimpleTest> tests_fifth_task;
    public static List<SimpleTest> tests_sixth_task;
    public static List<SimpleTest> tests_seventh_task;
    public static List<ComplexTest> tests_eighth_task;
    public static List<SimpleTest> tests_ninth_task;

    public static void uploadTests(){
        try {
            tests_second_task = readSimpleTestFromFile(new File("test2.txt"));
            tests_third_task = readSimpleTestFromFile(new File("test3.txt"));
            tests_fourth_task = readSimpleTestFromFile(new File("test4.txt"));
            tests_fifth_task = readSimpleTestFromFile(new File("test5.txt"));
            tests_sixth_task = readSimpleTestFromFile(new File("test6.txt"));
            tests_seventh_task = readSimpleTestFromFile(new File("test7.txt"));
            tests_ninth_task = readSimpleTestFromFile(new File("test9.txt"));

            tests_first_task = readComplexTestFromFile(new File("test1.txt"));
            tests_eighth_task = readComplexTestFromFile(new File("test8.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
