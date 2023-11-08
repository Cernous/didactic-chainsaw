package Assignment2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

public class QueryTest {

    private static WarehouseDB wDb;

    @BeforeAll
    public static void setUp()
    {
        wDb = new WarehouseDB();
        wDb.initial();
    }

    @Test
    public void testQueryQty() throws Exception
    {
        String cmp = "IN0003\n" + //
                "IN0000\n" + //
                "IN0001\n";
        assertEquals(cmp, wDb.query("qty", 3));
    }

    @Test
    public void testQueryReorderLvl() throws Exception
    {
        String cmp ="IN0000\n" + //
                "IN0001\n";
        assertEquals(cmp, wDb.query("reorderlvl", 2));
    }
    
}
