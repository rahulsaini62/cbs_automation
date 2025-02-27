package org.cbs.base;

import io.cucumber.java.*;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.cbs.actions.LoginActions;
import org.cbs.actions.SharedActions;
import org.cbs.api.restful.response.EmailSender;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.cbs.actions.SharedActions;
import org.cbs.actions.drivers.DriverActions;
import org.cbs.actions.drivers.WindowActions;
import org.cbs.enums.PlatformType;
import org.cbs.manager.ParallelSession;

import javax.mail.MessagingException;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static java.text.MessageFormat.format;
import static org.cbs.manager.ParallelSession.createSession;
import static org.cbs.manager.ParallelSession.getCurrentPersona;
import static org.cbs.utils.PropertiesUtil.getApplicationProps;


@Slf4j
public class BaseTests {


    @BeforeAll
    public static void beforeAll() {

    }

    @Before
    public void beforeScenario() {
        final String platformType = getApplicationProps("platformType");
        final String driverKey = getApplicationProps("driverKey");
//        if (!getCurrentPersona().isEmpty()) {
//            ParallelSession.getSession().getDriver().quit();
//            ParallelSession.clearSession();
//        }
        createSession(format("CBSTests-{0}", platformType),
                PlatformType.valueOf(platformType), driverKey);
        ParallelSession.getSession().getDriver().manage().deleteAllCookies();
    }

    @After(order = 1)
    public void afterScenario(final Scenario scenario) {
        if (scenario.isFailed()) {
            WindowActions.onWindow()
                    .takeScreenshot();
            final byte[] screenshot = ((TakesScreenshot) ParallelSession.getSession()
                    .getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "transaction-failed");
            Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
        }
        DriverActions.withDriver()
                .saveLogs();
        ParallelSession.clearSession();
    }

    @AfterAll
    public static void afterAll() {
        File folderToZip = new File("target/allure-results");
        String zipFileName = "report.zip";

        // Send the email with attachment
        try {
            zipFolder(folderToZip, zipFileName);
            System.out.println("Folder has been successfully zipped into: " + zipFileName);

            EmailSender.sendEmail(
                    "rahul.saini1@appinventiv.com",
                    "CBS Test Result: ",
                    "Test result details are attached.",
                    zipFileName
            );
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void zipFolder(File folder, String zipFileName) throws IOException {
        // Create a file output stream to write to the zip file
        try (FileOutputStream fileOut = new FileOutputStream(zipFileName);
             ZipOutputStream zipOut = new ZipOutputStream(fileOut)) {

            // Recursively zip all files and subfolders
            zipFile(folder, folder.getName(), zipOut);
        }
    }


    // Helper method to zip files and subfolders
    private static void zipFile(File fileToZip, String parentFolderName, ZipOutputStream zipOut) throws IOException {
        // If it's a folder, we need to recurse into the subfolder
        if (fileToZip.isDirectory()) {
            for (File file : fileToZip.listFiles()) {
                zipFile(file, parentFolderName + File.separator + file.getName(), zipOut);
            }
        } else {
            // If it's a file, zip it
            try (FileInputStream fis = new FileInputStream(fileToZip)) {
                // Create a ZipEntry (this is the actual file inside the zip)
                ZipEntry zipEntry = new ZipEntry(parentFolderName + File.separator + fileToZip.getName());
                zipOut.putNextEntry(zipEntry);

                // Write the file content to the zip
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    zipOut.write(buffer, 0, length);
                }

                // Close this entry
                zipOut.closeEntry();
            }
        }
    }
}
