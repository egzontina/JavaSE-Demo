package javaTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Algorithme.StringAnagramCheck;

public class StringAnagramTest {

	@Test
	public void testIsAnagram() {
		assertTrue(StringAnagramCheck.isAnagram("word", "wrdo"));
		assertTrue(StringAnagramCheck.isAnagram("mary", "army"));
		assertTrue(StringAnagramCheck.isAnagram("stop", "tops"));
		assertTrue(StringAnagramCheck.isAnagram("boat", "btoa"));
		assertFalse(StringAnagramCheck.isAnagram("pure", "in"));
		assertFalse(StringAnagramCheck.isAnagram("fill", "fil"));
		assertFalse(StringAnagramCheck.isAnagram("b", "bbb"));
		assertFalse(StringAnagramCheck.isAnagram("ccc", "ccccccc"));
		assertTrue(StringAnagramCheck.isAnagram("a", "a"));
		assertFalse(StringAnagramCheck.isAnagram("sleep", "slep"));
	}

	@Test
	public void testIAnagram() {
		assertTrue(StringAnagramCheck.iAnagram("word", "wrdo"));
		assertTrue(StringAnagramCheck.iAnagram("boat", "btoa"));
		assertFalse(StringAnagramCheck.iAnagram("pure", "in"));
		assertFalse(StringAnagramCheck.iAnagram("fill", "fil"));
		assertTrue(StringAnagramCheck.iAnagram("a", "a"));
		assertFalse(StringAnagramCheck.iAnagram("b", "bbb"));
		assertFalse(StringAnagramCheck.iAnagram("ccc", "ccccccc"));
		assertFalse(StringAnagramCheck.iAnagram("sleep", "slep"));
	}

	@Test
	public void testcheckAnagram() {
		assertTrue(StringAnagramCheck.checkAnagram("word", "wrdo"));
		assertFalse(StringAnagramCheck.checkAnagram("b", "bbb"));
		assertFalse(StringAnagramCheck.checkAnagram("ccc", "ccccccc"));
		assertTrue(StringAnagramCheck.checkAnagram("a", "a"));
		assertFalse(StringAnagramCheck.checkAnagram("sleep", "slep"));
		assertTrue(StringAnagramCheck.checkAnagram("boat", "btoa"));
		assertFalse(StringAnagramCheck.checkAnagram("pure", "in"));
		assertFalse(StringAnagramCheck.checkAnagram("fill", "fil"));
	}

}
