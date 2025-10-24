package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {

            String reportFolder = System.getProperty("user.dir") + "/extent-report";
            File folder = new File(reportFolder);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String path = reportFolder + "/ExtentReport.html";
            System.out.println("ExtentReport will be created at: " + path);
            
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
            htmlReporter.config().setDocumentTitle("API Automation Report");
            htmlReporter.config().setReportName("Rest Assured API Testing");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        return getInstance().createTest(testName);
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
            System.out.println("Extent report flushed successfully!");
        }
    }
}
