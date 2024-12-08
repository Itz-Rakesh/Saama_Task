package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//@CucumberOptions (
//        features = "src/test/java/features" ,
//        glue = {"utility","stepDefinition"},
//        //plugin = {"pretty","html:target/cucumber-html-report","json:cucumber.json"}
//        //plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"}
//        plugin = {
//                "pretty",
//                "html:reports/cucumber-html-report", // Change location if needed
//                "json:target/cucumber.json"
//        }
//)

//@RunWith(Cucumber.class)
//@CucumberOptions (
//        features = "src/test/java/features",
//        glue = "stepDefinition",
//        plugin = {
//                "json:target/cucumber.json",            // Output format for Cucumber results
//                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Allure integration plugin
//        }
//)

//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/java/features",  // Path to your feature files
//        glue = "stepDefinition",  // Path to step definitions
//        plugin = {
//                "json:target/cucumber.json",  // Generate JSON report for Cucumber
//                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"  // Integrate Allure plugin
//        }
//)
//
//public class TestRunner {
//}

//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/java/features", // Path to your feature files
//        glue = "stepDefinition", // Path to step definitions
//        plugin = {
//                "json:target/cucumber.json", // Cucumber JSON report
//                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Allure integration plugin
//        }
//)
//public class TestRunner {
//}

//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/java/features", // Path to your feature files
//        glue = "stepDefinition", // Path to step definitions
//        plugin = {
//                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // ExtentReports adapter
//        }
//)

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features", // Path to your feature files
        glue = "stepDefinition",             // Path to step definitions
        plugin = {
                "json:target/cucumber.json",                     // Generate JSON report for Cucumber
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Allure integration plugin
        }
)
public class TestRunner {
}

