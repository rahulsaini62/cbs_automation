package org.cbs.runner;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")

@SelectClasspathResource("org/cbs")
public class RunCucumberTest {
}