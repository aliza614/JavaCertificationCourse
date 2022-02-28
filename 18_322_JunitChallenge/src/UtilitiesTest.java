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
        fail("this is a dummy test");
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
        fail("this is a dummy test");
    }

    @Test
    void nullIfOddLength() {
        fail("this is a dummy test");
    }
}