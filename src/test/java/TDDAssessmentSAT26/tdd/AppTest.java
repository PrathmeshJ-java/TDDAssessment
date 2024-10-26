package TDDAssessmentSAT26.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
	
	App app;
	
	@BeforeEach
    public void init() {
        app = new App();
    }
	
    @Test
    void testEmptyString() {
        assertEquals(0, app.Add(""));
    }
    
    @Test
    void testStringOne() {
        assertEquals(1, app.Add("1"));
    }
    
    @Test
    void testTwoDigitNumbers() {
        assertEquals(6, app.Add("1,5"));
    }
    
    @Test
    void testTwoDigitNewLine() {
        assertEquals(6, app.Add("1\n5"));
    }
    
    @Test
    void testTwoDigitwithdifferentdiliminators() {
        assertEquals(3, app.Add("//;\\n1;2"));
    }
    
    @Test
    void testTwoDigitwithNegativeNumbers() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            app.Add("1\n-5");
        });
        assertEquals("Negative numbers not allowed: -5", thrown.getMessage());
    }
}
