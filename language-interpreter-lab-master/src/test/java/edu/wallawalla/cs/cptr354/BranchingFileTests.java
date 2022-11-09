package edu.wallawalla.cs.cptr354.visitor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BranchingFileTests extends AbstractTests {

    @Test
	public void testIfTTrue() throws Exception {
		String input = "a := 5; if 1 then a := 10; end if; Put_Line a;" + System.lineSeparator();
		String result = runInterpreter(input);
		assertEquals("10.0" +System.lineSeparator(), result);
	}
    @Test
	public void testIfFalse() throws Exception {
		String input = "a := 5; if 0 then a := 10; end if; Put_Line a;"  + System.lineSeparator();
		String result = runInterpreter(input);
		assertEquals("5.0" +System.lineSeparator(), result);
	}

    @Test
	public void testIfElsif() throws Exception {
		String input = "a := 5; if 0 then a := 10; a := 20; elsif 1 then a := 15; end if; Put_Line a;"  + System.lineSeparator();
		String result = runInterpreter(input);
		assertEquals("15.0" +System.lineSeparator(), result);
	}

    @Test
	public void testIfElse() throws Exception {
		String input = "a := 5; if 0 then a := 10; elsif 0 then a := 15; else a := 0; end if; Put_Line a;"  + System.lineSeparator();
		String result = runInterpreter(input);
		assertEquals("0.0" +System.lineSeparator(), result);
	}

    @Test
	public void testBoolean() throws Exception {
		String input = "a := 2; if 2 = a then a := 10; end if; Put_Line a;" + System.lineSeparator();
		String result = runInterpreter(input);
		assertEquals("10.0" +System.lineSeparator(), result);
	}

    @Test
	public void testBooleanFalse() throws Exception {
		String input = "a := 2; if a /= 2 then a := 10; end if; Put_Line a;" + System.lineSeparator();
		String result = runInterpreter(input);
		assertEquals("2.0" +System.lineSeparator(), result);
	}

    @Test
	public void testWhileLoop() throws Exception {
		String input = "c := 0; while c < 10 loop c := c + 1; end loop; Put_Line c;" + System.lineSeparator();
		String result = runInterpreter(input);
		assertEquals("10.0" +System.lineSeparator(), result);
	}
    @Test
	public void testWhileLoop2() throws Exception {
		String input = "c := 100; while c >= 10 loop c := c / 2; c := c + 2; end loop; Put_Line c;" + System.lineSeparator();
		String result = runInterpreter(input);
		assertEquals("7.0" +System.lineSeparator(), result);
	}

    @Test
	public void testBooleanDec() throws Exception {
		String input = "c := 2 < 4; Put_Line c;" + System.lineSeparator();
		String result = runInterpreter(input);
		assertEquals("1.0" +System.lineSeparator(), result);	}

}
