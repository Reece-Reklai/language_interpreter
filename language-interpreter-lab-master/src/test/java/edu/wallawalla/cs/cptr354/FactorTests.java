package edu.wallawalla.cs.cptr354.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FactorTests extends AbstractTests {

	@Test
	public void testMultiplication() throws Exception {
		String inputString = "Put_Line -5 * 6;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("-30.0" + System.lineSeparator(), result);
	}

	@Test
	public void testDivision() throws Exception {
		String inputString = "a := 4 / 2; Put_Line a;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("2.0" + System.lineSeparator(), result);
	}

    @Test
	public void testParenthesis() throws Exception {
		String inputString = "Put_Line (5 + 5) * 2;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("20.0" + System.lineSeparator(), result);
	}

    @Test
	public void testSQRT() throws Exception {
		String inputString = "Put_Line sqrt(4);" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("2.0" + System.lineSeparator(), result);
	}

}