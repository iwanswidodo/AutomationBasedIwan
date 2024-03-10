package StepDef.Integrations.Assertion;

import StepDef.Integrations.Logger.Log;
import StepDef.FE.WebBaseMethod;
import org.openqa.selenium.*;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertFalse;

/**
 * All the validation methods and method to take screenshot
 * are defined in this class.
 */
public class Assertions {
    public static boolean testCaseStatus = true;


    /**
     * method to verify the actual value with expected value
     *
     * @param actual   actual text displayed
     * @param expected expected text to be displayed
     * @param message  message should be displayed on failure of assertion
     */
    public static boolean verifyEquals(Object actual, Object expected, String message, boolean screenshootOnPassed, boolean screenshotOnFailure,
                                       boolean exitOnFailure, WebElement element) {
        try {
            Assert.assertEquals(actual, expected);
            Log.info("PASSED");
            if (screenshootOnPassed) {
                WebBaseMethod.screenshotElement(element);
            }

        } catch (AssertionError e) {
            Log.info("FAIL - " + message + " Actual: " + actual.toString() + " Expected: " + expected.toString());
            if (screenshotOnFailure) {
                WebBaseMethod.screenshotElement(element);
            }
            if (exitOnFailure) {
                Log.info("Exiting this function as exitOnFail flag is set to True. Will move to next test.");
                throw e;
            }
            return false;
        }
        return true;
    }

    // Assert Equals
    public static void verifyWebElementText(WebElement actual, String expected) {
        try {
            Assert.assertEquals(actual.getText(), expected);
            Log.info("PASSED");
        } catch (AssertionError e) {
            Log.info("FAILED");
        }
    }

    public static void verifyWebElementIsDisplayed(WebElement e) {
        Assert.assertTrue(e.isDisplayed(), "Element is not displayed.");
        Log.infoGreen("suitable with Expected");
    }

    public static void verifyWebElementIsClickable(WebElement element) {
        Assert.assertTrue(element.isEnabled(), "Element is not clickable.");
    }

    // Assert FALSE
    public static void verifyWebElementIsNotDisplayed(WebElement element) {
        Assert.assertFalse(element.isDisplayed(), "Element is unexpectedly displayed.");
    }

    public static void verifyWebElementIsNotClickable(WebElement element) {
        Assert.assertFalse(element.isEnabled(), "Element is unexpectedly clickable.");
    }


    /**
     * method to verify if the condition is true
     *
     * @param condition           statement to verify
     * @param message             message should be displayed on failure of assertion
     * @param screenshotOnFailure true if screenshot has to be taken in case of failure
     * @param exitOnFailure       true if execution to be stopped in case of failure
     * @return true if assertion passes, false if fails
     */
    public static boolean verifyTrue(boolean condition,
                                     String message,
                                     boolean screenshotOnFailure,
                                     boolean screenshootOnPassed,
                                     boolean exitOnFailure,
                                     WebElement element) {

        try {
            Assert.assertTrue(condition, message);
            Log.info("PASS - " + message);
            if (screenshootOnPassed) {
                WebBaseMethod.screenshotElement(element);
            }
        } catch (AssertionError e) {
            testCaseStatus = false;
            Log.info("FAIL - " + message + " Actual: FALSE Expected: TRUE.");
            if (screenshotOnFailure) {
                WebBaseMethod.screenshotElement(element);
            } else {
                Log.info("FAIL - " + message);
            }
            if (exitOnFailure) {
                Log.info("Exiting this function as exitOnFail flag is set to True.");
                throw e;
            }
        }
        return testCaseStatus;
    }



    public static void assertEquals(Object Actual, Object Expected) {
        Assert.assertEquals(Actual, Expected);
        Log.info("================ Assert equals ================");
        Log.info("Actual : " + Actual);
        Log.info("Expected : " + Expected);
        Log.info("Result: PASS");
        Log.info("===============================================");
    }

    public static void assertTrue(Boolean conditionTrue) {
        Assert.assertTrue(conditionTrue);
        Log.info("================ Assert true ================");
        Log.info("Condition True: " + conditionTrue);
        Log.info("Result: PASS");
        Log.info("===============================================");
    }




}


