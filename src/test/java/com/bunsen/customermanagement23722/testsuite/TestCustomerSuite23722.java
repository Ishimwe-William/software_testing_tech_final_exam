/**
 * JUnit provides an easy way to create automated tests, including the ability to create
 * test suites. We can use test suites to organize our tests into logical groups, run a
 * set of tests in a specific order, or run a subset of tests based on specific criteria.
 */

package com.bunsen.customermanagement23722.testsuite;

import com.bunsen.customermanagement23722.test.TestCreateUpdateDeleteCustomer23722;
import com.bunsen.customermanagement23722.test.TestReadCustomer23722;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({TestCreateUpdateDeleteCustomer23722.class, TestReadCustomer23722.class})
public class TestCustomerSuite23722 {

}