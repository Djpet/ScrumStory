package fr.scrumstory;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

public abstract class AbstractTest {

	@Rule
	public ExpectedException assertException = ExpectedException.none();
	
}
