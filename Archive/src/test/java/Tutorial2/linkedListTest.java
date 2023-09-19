package Tutorial2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class linkedListTest {
    private static iList<Integer> L1;
    /**
     * This method is automatically called once before each test case method,
     * so that all the variables are cleanly initialized for each test.
     */
    @BeforeAll
    public static void setUp(){
        L1 = new linkedList<Integer>(); 
        for(int i = 0; i < 5; i =  (i +1)){
            L1.add(i);
        }
    }

    @Test
    public void getSize(){
        assertEquals(5, L1.size());
    }

    @Test
    public void removeValue() {
        assertEquals(0, (int)L1.remove(0));
    }

    @Test
    public void clearAll() {
        assertEquals(true, L1.clear());
    }

}
