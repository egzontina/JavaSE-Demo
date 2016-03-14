package javaTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Demo.ListString;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
 
/**

 */
public class ListStringUnitTest {
	private List<String> aTestList;
	 
    @Before
    public void setUp() {
        aTestList = new ArrayList<String>();
        aTestList.add("one");
        aTestList.add("two");
        aTestList.add("three");
    }
 
    @After
    public void tearDown() {
        aTestList = null;
    }
 
    @Test
    public void shouldConcatenateASimpleString() {
        assertEquals("one,two,three", ListString.concatenate(aTestList));
    }
 
    @Test
    public void shouldRevertAList() {
        List<String> result = ListString.reverseList(aTestList);
        assertEquals("three", result.get(0));
        assertEquals("two", result.get(1));
        assertEquals("one", result.get(2));
    }
 
    @Test
    public void shouldUppercaseContent() {
        List<String> result = ListString.toUppercase(aTestList);
        assertEquals("ONE", result.get(0));
        assertEquals("TWO", result.get(1));
        assertEquals("THREE", result.get(2));
    }
    
    @Test
    public void shouldJoinTwoList() {
    	List<String> listA = new ArrayList<String>();
		listA.add("A");		
		List<String> listB = new ArrayList<String>();
		listB.add("B");
		
		List<String> listFinal  = ListString.joinTwoList(listA, listB);
		assertEquals("A", listFinal.get(0));
		assertEquals("B", listFinal.get(1));
    }
 
    @Test
    public void shouldTestAll() {
        List<String> list = new ArrayList<String>();
        list.add("un");
        list.add("deux");
        list.add("trois");
        list.add("quatre");
 
        assertEquals("un,deux,trois,quatre", ListString.concatenate(list));
 
        assertEquals("quatre,trois,deux,un", ListString.concatenate(ListString.reverseList(list)));
 
    }
}