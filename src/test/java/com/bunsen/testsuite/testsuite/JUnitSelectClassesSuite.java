/**
 * JUnit provides an easy way to create automated tests, including the ability to create
 * test suites. We can use test suites to organize our tests into logical groups, run a
 * set of tests in a specific order, or run a subset of tests based on specific criteria.
 */

package com.bunsen.testsuite.testsuite;

import com.bunsen.testsuite.test.ProductUnitTest;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ProductUnitTest.class})
//@ExcludeTags("negative")
//@SelectPackages({"com.bunsen.testsuite.test"})
//@IncludePackages("com.bunsen.testsuite.test.positive")
//@ExcludePackages("com.bunsen.testsuite.test.negative")
//@IncludeClassNamePatterns("com.bunsen.testsuite.test.Class.*UnitTest")
//@ExcludeClassNamePatterns("com.bunsen.testsuite.test.ClassTwoUnitTest")
//@IncludeTags("positive")
//@SelectMethod(type = ClassOneUnitTest.class, name = "whenFalse_thenFalse")
//@SelectMethod("com.bunsen.testsuite.test.subpackage.ClassTwoUnitTest#whenFalse_thenFalse")
public class JUnitSelectClassesSuite {

}