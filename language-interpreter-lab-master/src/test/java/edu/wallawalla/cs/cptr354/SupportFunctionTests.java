package edu.wallawalla.cs.cptr354.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SupportFunctionTests extends AbstractTests{
	@Test
	public void testDebug() throws Exception {
		String inputString = "a := 1; DEBUG;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("{a=1.0}" + System.lineSeparator(), result);
	}

	@Test
	public void testDebugMultipleVariables() throws Exception {
		String inputString = "a := 1; b := 2; DEBUG;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("{a=1.0, b=2.0}" + System.lineSeparator(), result);
	}

	@Test
	public void testPrint() throws Exception {
		String inputString = "Put_Line 1;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("1.0" + System.lineSeparator(), result);
	}

	@Test
	public void testPrintMultiple() throws Exception {
		String inputString = "Put_Line 1; Put_Line 2;" + System.lineSeparator();
		String result = runInterpreter(inputString);
		assertEquals("1.0" + System.lineSeparator() + "2.0" + System.lineSeparator(), result);
	}
}
