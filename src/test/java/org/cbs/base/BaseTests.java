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

import java.io.ByteArrayInputStream;

import static java.text.MessageFormat.format;
import static org.cbs.manager.ParallelSession.createSession;
import static org.cbs.manager.ParallelSession.getCurrentPersona;
import static org.cbs.utils.PropertiesUtil.getApplicationProps;


@Slf4j
public class BaseTests {

    @Before
    public void beforeScenario() {
        final String platformType = getApplicationProps("platformType");
        final String driverKey = getApplicationProps("driverKey");
        if (!getCurrentPersona().isEmpty()) {
            ParallelSession.getSession().getDriver().quit();
            System.out.println("*****************");
            System.out.println("*****************");
            System.out.println("*****************");
            System.out.println("*****************");
            System.out.println("*****************");
        }
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

//            EmailSender.sendEmail("rahul.saini1@appinventiv.com",
//                    "Test Failed: " + scenario.getName(),
//                    "Test failed. Details: " + scenario.getName());
        }
        DriverActions.withDriver()
                .saveLogs();
        ParallelSession.clearSession();

    }


//    @BeforeAll
//    public static void beforeAll() {
////        LoginActions loginActions = new LoginActions();
//
////        loginActions.navigateToAppUrl ("cbs.app.url");
////        loginActions.loginWithGivenCred ("cbs.username", "cbs.password");
//    }
//
//    @Before
//    public void beforeScenario() {
//
//        System.out.println("Before Scenario started");
//        final String platformType = getApplicationProps("platformType");
//        final String driverKey = getApplicationProps("driverKey");
//        createSession(format("CBSTests-{0}", platformType),
//                PlatformType.valueOf(platformType), driverKey);
//    }
//
//    @After
//    public void afterScenario(final Scenario scenario) {
//        if (scenario.isFailed()) {
//            WindowActions.onWindow()
//                    .takeScreenshot();
//            final byte[] screenshot = ((TakesScreenshot) ParallelSession.getSession()
//                    .getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", "transaction-failed");
//            Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
//        }
//    }
//
//    @AfterAll
//    public static void afterAll() {
//        if (!ParallelSession.getSession()
//                .getPlatformType()
//                .equals(PlatformType.valueOf("API")))
//            DriverActions.withDriver()
//                    .saveLogs();
//        ParallelSession.clearSession();
//    }
}
