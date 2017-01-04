package com.scala.qa.contentmanager.Base;

import com.relevantcodes.extentreports.ExtentReports;

/**
 * Created by kpatel on 12/22/2016.
 */
public class ExtentManager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(String filePath) {
        if (extent == null) {
            extent = new ExtentReports(filePath, true);

            extent
                    .addSystemInfo("Host Name", "Muni")
                    .addSystemInfo("Environment", "QA");
        }

        return extent;
    }
}
