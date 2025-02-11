package org.cbs.base;

import io.cucumber.java.*;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.cbs.actions.SharedActions;
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
import static org.cbs.utils.PropertiesUtil.getApplicationProps;

@Slf4j
public class BaseTests {

    @Before
    public void beforeScenario() {
        final String platformType = getApplicationProps("platformType");
        final String driverKey = getApplicationProps("driverKey");
        createSession(format("CBSTests-{0}", platformType),
                PlatformType.valueOf(platformType), driverKey);
    }

    @After (order = 2)
    public void logOut() {
        for(int i=0;i<3;i++){
            try {
                SharedActions.logoutWithApi();
                break;
            }catch (Exception e){
                log.info(e.getMessage());
            }
        }

    }

    @After (order = 1)
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
}
