package edu.wallawalla.cs.cptr354.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ArthmeticTests extends AbstractTests {

	@Test
	public void testAddition() throws Exception {
		String inputString = "Put_Line -5 + 6;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("1.0" + System.lineSeparator(), result);
	}

	@Test
	public void testAdditionVariable() throws Exception {
		String inputString = "a := 5 + 6; Put_Line a;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("11.0" + System.lineSeparator(), result);
	}

    @Test
	public void testSubtraction() throws Exception {
		String inputString = "Put_Line 5 - 6;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("-1.0" + System.lineSeparator(), result);
	}

    @Test
	public void testSubtractionVar() throws Exception {
		String inputString = "a := 5; Put_Line a - 6;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("-1.0" + System.lineSeparator(), result);
	}

}
