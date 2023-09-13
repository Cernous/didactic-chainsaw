package Tutorial1;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class utility_Test {
    static Utility Uti;
    
    @BeforeAll
    public static void setUp() throws Exception{
        Uti = new Utility();
    }

    @Test
    void testAddInt() {
        assertEquals(7, Utility.addIntNumbers(3, 4));
    }

    @Test
    void testAddFloat() {
        assertEquals(9, Uti.addfloatNumbers(2.5, 4.5));
    }
}
