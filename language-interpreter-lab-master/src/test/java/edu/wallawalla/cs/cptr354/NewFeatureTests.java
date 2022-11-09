package edu.wallawalla.cs.cptr354.visitor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NewFeatureTests extends AbstractTests {

    @Test
	public void testComment() throws Exception {
		String input = "a := 5; -- This is a comment\n if 1 then a := 10; end if; Put_Line a;" + System.lineSeparator();
		String result = runInterpreter(input);
		assertEquals("10.0" +System.lineSeparator(), result);
	}
    @Test
	public void testComment2() throws Exception {
		String input = "-- This is a comment\n a := 5; if 1 then a := 10; end if; Put_Line a;" + System.lineSeparator();
		String result = runInterpreter(input);
		assertEquals("10.0" +System.lineSeparator(), result);
	}

}
