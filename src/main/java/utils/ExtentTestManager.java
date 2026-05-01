package utils;

import com.aventstack.extentreports.ExtentTest;
import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    private static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized void setTest(ExtentTest test) {
        extentTestMap.put((int) Thread.currentThread().getId(), test);
    }

    public static synchronized void removeTest() {
        extentTestMap.remove((int) Thread.currentThread().getId());
    }
}