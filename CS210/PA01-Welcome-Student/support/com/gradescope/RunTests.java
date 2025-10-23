//
// Copyright (c) 2025 Tim Richards. All rights reserved.
//
package com.gradescope;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import com.gradescope.jh61b.grader.GradedTestListenerJSON;

import hello.HelloTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    HelloTest.class,
})

public class RunTests {
  public static void main(String[] args) {
    JUnitCore runner = new JUnitCore();
    runner.addListener(new GradedTestListenerJSON());

    Result r = runner.run(RunTests.class);
  }
}