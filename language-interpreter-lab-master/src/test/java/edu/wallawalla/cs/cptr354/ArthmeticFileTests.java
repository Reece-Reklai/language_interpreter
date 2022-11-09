package edu.wallawalla.cs.cptr354.visitor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArthmeticFileTests extends AbstractTests {

	@Test
	public void testAddition() throws Exception {
		String input = readFileToString("BasicArthmetic.txt");
		String expected = readFileToString("BasicArthmeticResult.txt");
		String result = runInterpreter(input);
		assertEquals(expected, result);
	}

    @Test
	public void testQuadratic() throws Exception {
		String input = readFileToString("quadratic.adb");
		String expected = readFileToString("quadraticResults.txt");
		String result = runInterpreter(input);
		assertEquals(expected, result);
	}

    @Test
	public void testSort() throws Exception {
		String input = readFileToString("sort.adb");
		String expected = readFileToString("sortResults.txt");
		String result = runInterpreter(input);
		assertEquals(expected, result);
	}

}
