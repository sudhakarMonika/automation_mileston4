package com.milestone.four.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.milestone.four.utility.Screenshot;

public class MyTestListener implements ITestListener {
	@Override
	public void onStart(ITestContext context) {
		System.out.println("[TEST START]" + context.getName());
	}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("[TEST FINISH]" + context.getName());
		System.out.println("Passed: "+context.getPassedTests().size());
		System.out.println("Failed: "+context.getFailedTests().size());
		System.out.println("Skipped: "+context.getSkippedTests().size());
	}
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("[METHOD START]" + result.getMethod().getMethodName());
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("[FAIL] " + result.getMethod().getMethodName());
		Screenshot.capture();
	}
	
}

