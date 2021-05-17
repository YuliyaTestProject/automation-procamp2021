package jUnitSettings;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import util.Config;

import java.io.IOException;

public class TestRunner {

    private static Config config;

    public static void main(String[] args) throws IOException {

        config = Config.getInstance();
        config.setConfig(args);

        if (args != null && args.length > 1)
        {
            // use Test Class or Test Suite name as parameter to run from command line
            // for example: java -jar automation-procamp2021-1.0-SNAPSHOT.jar config.yaml uiTests.UiLoginPageTests
            JUnitCore.main(args[1]);
        } else
        {
            Result result = JUnitCore.runClasses(TestSuiteSettings.class);
            for (Failure failure : result.getFailures()){
                System.out.println(failure.toString());
            }
            System.out.println(result.wasSuccessful());
        }

    }
}