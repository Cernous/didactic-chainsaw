package Workshop2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntArrayBasedListTest {
	
	static IntArrayBasedList iList; 

	@BeforeAll
	public static void setUp() throws Exception {
		iList = new IntArrayBasedList();
	}

	@Test
	void testInsert() {
		if(iList.find(0))
			assertEquals(false, iList.insert(0, 100)); 
		else
			assertEquals(true,iList.insert(0, 100));
	}
	
	@Test
	void testFind() {
		iList.insert(0, 100);
		assertEquals(true, iList.find(0) );
		assertEquals(false, iList.find(1));
	}
	
	@Test
	void testRemove() {
		// This part was wrong v since the definition specifies to return false!
		// prev: assertEquals(expected:true, iList.remove(pos:0))
		assertEquals(false, iList.remove(0));
	}

}
