package iostream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Semen on 07-Oct-16.
 */
public class ReportPrinter {

    private List<String> report = new ArrayList<>();

    public ReportPrinter() {
        report.add("\t\t\tTEST RESULT");
    }

    public List<String> getReport() {
        return report;
    }

    public void addLine(String line) {
        report.add(line);
    }

    public void printReport() {
        report.forEach(System.out::println);
    }
}
