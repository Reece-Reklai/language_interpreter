package edu.wallawalla.cs.cptr354.visitor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ListTests extends AbstractTests {

    @Test
	public void testList() throws Exception {
		String input = "a : array := (2,3,4); Put_Line(a);" + System.lineSeparator();
		String result = runInterpreter(input);
		assertEquals("[2.0, 3.0, 4.0]" +System.lineSeparator(), result);
	}

    @Test
	public void testLength() throws Exception {
		String input = "a : array := (2,3,4); Put_Line(a.length);" + System.lineSeparator();
		String result = runInterpreter(input);
		assertEquals("3.0" +System.lineSeparator(), result);
	}

    @Test
	public void testAccessor() throws Exception {
		String input = "a : array := (2,3,4); Put_Line(a(1));" + System.lineSeparator();
		String result = runInterpreter(input);
		assertEquals("3.0" +System.lineSeparator(), result);
	}
    @Test
	public void testAccessorAssign() throws Exception {
		String input = "a : array := (2,3,4); a(1) := 0; Put_Line(a);" + System.lineSeparator();
		String result = runInterpreter(input);
		assertEquals("[2.0, 0.0, 4.0]" +System.lineSeparator(), result);
	}

    @Test
	public void testAccessorAssign2() throws Exception {
		String input = "b := 1; a : array := (2,3,4); a(b) := 0; Put_Line(a);" + System.lineSeparator();
		String result = runInterpreter(input);
		assertEquals("[2.0, 0.0, 4.0]" +System.lineSeparator(), result);
	}

}
