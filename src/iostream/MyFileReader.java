package iostream;

import tests.ComplexTest;
import tests.SimpleTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Semen on 07-Oct-16.
 */
public class MyFileReader {
    public static List<SimpleTest> readSimpleTestFromFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<SimpleTest> testList = new ArrayList<>();

        String tempString;
        while ((tempString = br.readLine()) != null) {
            testList.add(splitSimpleTestFromLine(tempString));
        }
        br.close();
        return testList;
    }

    public static List<ComplexTest> readComplexTestFromFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<ComplexTest> testList = new ArrayList<>();

        String tempString;
        while ((tempString = br.readLine()) != null) {
            testList.add(splitComplexTestFromLine(tempString));
        }
        br.close();
        return testList;
    }

    private static SimpleTest splitSimpleTestFromLine(String line) {
        String[] stringArr = line.split("##");
        return new SimpleTest(stringArr[0], Boolean.parseBoolean(stringArr[1]));
    }

    private static ComplexTest splitComplexTestFromLine(String line) {
        String[] stringArr = line.split("//");
        return new ComplexTest(stringArr[0], stringArr[1]);
    }

}
