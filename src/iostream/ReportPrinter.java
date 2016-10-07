package iostream;

/**
 * Created by Semen on 07-Oct-16.
 */
public class ReportPrinter {

    private String report;

    public ReportPrinter() {
        report = "\tTEST RESULT\t\n";
    }


    public String getReport() {
        return report;
    }

    public void addLine(String line) {
        report += (line + '\n');
    }

    public void printReport() {
        System.out.println(report);
    }
}
