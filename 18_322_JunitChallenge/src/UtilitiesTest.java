
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {
    private Utilities util=new Utilities();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void everyNthChar() {
//        fail("this is a dummy test");
        Utilities util=new Utilities();
        char[] result={'e','l'};
        char[] input={'h','e','l','l','o'};
        assertArrayEquals(result,util.everyNthChar(input,2));
    }

    @Test
    void removePairs() {
//        fail("this is a dummy test");
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF",util.removePairs("ABCCABDEEF"));
        assertNull(util.removePairs(null),"not unull result");
        assertEquals("A",util.removePairs("A"));
        assertEquals("",util.removePairs(""));
    }

    @Test
    void converter() {
//        fail("this is a dummy test");
        Exception exception=assertThrows(ArithmeticException.class,()-> {
            assertEquals(300,util.converter(10,0),0);
        });
        assertEquals(300,util.converter(10,5),0);
        assertTrue(exception.getClass().equals(ArithmeticException.class));


    }

    @Test
    void nullIfOddLength() {
//        fail("this is a dummy test");
        Utilities util=new Utilities();
        assertNull(util.nullIfOddLength("odd"));
        assertNotNull(util.nullIfOddLength("even"));
    }
}