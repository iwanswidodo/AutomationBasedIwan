package StepDef.Integrations.Listener;

import StepDef.Integrations.Logger.Log;
import StepDef.Integrations.AllureReport.AllureAttachments;
import StepDef.Integrations.Utils.ScreenRecord;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;
import org.testng.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class CustomListener implements ITestListener, ISuiteListener, IInvokedMethodListener, IExecutionListener, TestLifecycleListener {

    public static List<ITestNGMethod> passedTests = new ArrayList<>();
    public static List<ITestNGMethod> failedTests = new ArrayList<>();
    public static List<ITestNGMethod> skippedTests = new ArrayList<>();
    private static long startTime;
    private static long endTime;


    /*This belongs to ISuiteListener and will execute before the Suite Starts*/
    @Override
    public void onStart(ISuite arg0) {
        Reporter.log("Execution of the Suite '" + arg0.getName() + "' Started!", false);
    }


    /*This belongs to ISuiteListener and will execute after the Suite Ends*/
    @Override
    public void onFinish(ISuite arg0) {
        Reporter.log("Execution of the Suite '" + arg0.getName() + "' Completed!", false);
    }


    /*This belongs to ITestListener, It will execute at the time of Test Execution */
    @Override
    public void onStart(ITestContext arg0) {
//        testRailAPI.clientInit();
        Reporter.log("About to begin executing Test " + arg0.getName(), false);
    }


    /*This belongs to ITestListener, It will execute at the End of Test*/
    @Override
    public void onFinish(ITestContext arg0) {
        Reporter.log("Completed executing test " + arg0.getName(), false);
    }




    /*This belongs to ITestListener, It will Execute only when the Test is PASSED*/
    @Override
    public void onTestSuccess(ITestResult result) {
        passedTests.add(result.getMethod());
        Log.infoGreen("SUCCESSFULLY EXECUTED TEST: " + result.getTestClass().getName() + "." + result.getMethod().getMethodName());
    }


    /*This belongs to ITestListener, It will Execute only when the Test is FAILED*/
    @Override
    public void onTestFailure(ITestResult result) {
        failedTests.add(result.getMethod());
        Log.infoRed("FAILED TEST: " + result.getTestClass().getName() + "." + result.getMethod().getMethodName());
    }


    /*This belongs to ITestListener, It and will execute before the Main Test Starts (@Test)*/
    @Override
    public void onTestStart(ITestResult result) {
        try {
            Log.infoBlue("STARTED TESTING: " + result.getTestClass().getName() + "." + result.getMethod().getMethodName());
            if(AllureAttachments.recordOnPassed | AllureAttachments.recordOnFailure) {
                 ScreenRecord.startRecording(returnMethodName(result.getMethod()));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /*This belongs to ITestListener, It will execute only if any of the Main Test(@Test) Gets Skipped*/
    @Override
    public void onTestSkipped(ITestResult result) {
        skippedTests.add(result.getMethod());
        Log.infoYellow("SKIPPED TEST: " + result.getTestClass().getName() + "." + result.getMethod().getMethodName() + "\n");

    }

    @Override
    public void beforeTestStop(TestResult result) {
        if(AllureAttachments.recordOnPassed | AllureAttachments.recordOnFailure) {
            try {
                switch (result.getStatus()) {
                    case PASSED -> {
                        if (AllureAttachments.deviceName.contains("android") || AllureAttachments.deviceName.contains("ios"))
                         ScreenRecord.stopRecording(AllureAttachments.recordOnPassed, true, true);
                    }
                    default -> {
                        if (AllureAttachments.deviceName.contains("android") || AllureAttachments.deviceName.contains("ios"))
                         ScreenRecord.stopRecording(AllureAttachments.recordOnFailure, true, true);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }



    /*This belongs to IInvokedMethodListener, It will execute before every method Including @Before @After @Test*/
    public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
        String textMsg = "About to begin executing following method : " + returnMethodName(arg0.getTestMethod());
        Reporter.log(textMsg, false);
    }


    /*This belongs to IInvokedMethodListener and will execute after every method Including @Before @After @Test*/
    public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
        String textMsg = "Completed executing following method : " + returnMethodName(arg0.getTestMethod());
        Reporter.log(textMsg, false);
    }


    /*This will return method names to the calling function*/
    private String returnMethodName(ITestNGMethod method) {
        return method.getRealClass().getSimpleName() + "." + method.getMethodName();
    }


    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onExecutionStart() {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void onExecutionFinish() {

        endTime = System.currentTimeMillis();



    }



    private static String getExecutionTime(long millisecond) {
        long min = Duration.ofMillis(millisecond).toMinutes();
        long sec = Duration.ofMillis(millisecond).toSeconds()-(min*60);
        return min + " minute(s) " + sec + " seconds";
    }

    public static String getFailedTestsList() {
        StringBuilder builder = new StringBuilder();
        if (failedTests.size() > 0) {
            for (ITestNGMethod test : failedTests) {
                builder.append("\\n\\u2022 " + test.getMethodName());
            }
        } else {
            builder.append("\\n\\u2022 None");
        }
        return builder.toString();
    }

}
