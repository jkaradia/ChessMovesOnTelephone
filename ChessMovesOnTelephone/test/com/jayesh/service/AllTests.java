package com.jayesh.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ KingTelephoneTest.class, PawnTelephoneTest.class,
		QueenTelephoneTest.class })
public class AllTests {

}
