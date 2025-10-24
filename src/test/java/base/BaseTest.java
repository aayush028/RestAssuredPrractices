package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.ExtentManager;

public class BaseTest {

    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeClass
    public void setup() {
        extent = ExtentManager.getInstance();
        test = ExtentManager.createTest(this.getClass().getSimpleName());
    }

    @AfterClass
    public void tearDown() {
        ExtentManager.flushReport();
    }
}
