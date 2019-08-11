// filename: Base/ExtentReportUtil.java

package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ExtentReportUtil extends BaseUtil {
  String fileName = reportLocation + "extentreport.html";

  // create ExtentReport object
  public void ExtentReport() {
    extent = new ExtentReports();
    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
    htmlReporter.config().setTheme(Theme.DARK);
    htmlReporter.config().setDocumentTitle("Cucumber Basics Test Results!");
    htmlReporter.config().setEncoding("utf-8");
    htmlReporter.config().setReportName("Test Report");

    extent.attachReporter(htmlReporter);

  }

  public void ExtentReportScreenshot() throws IOException {
    var screenshot = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
    Files.copy(screenshot.toPath(), new File(reportLocation + "screenshot.png").toPath());
    // scenarioDef.fail();
  }

  public void FlushReport() {
    extent.flush();
  }

}
