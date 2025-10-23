//
// Copyright (c) 2025 Tim Richards. All rights reserved.
//
//
// Copyright (c) 2025 Tim Richards. All rights reserved.
//
package hello;

import static org.junit.Assert.*;

import org.junit.Test;


public class HelloTest {
	@Test
	public void testHelloString() {
		assertEquals("helloString returns incorrect value", "Hello, CICS 210 Data Structures World!", Hello.helloString());
	}
}