package ca.ubc.cpsc210.colour;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ColourTest {
    Colour white;
    Colour grey;
    Colour blue;
    Colour yellow;
    Colour teal;

    @BeforeEach
    void runBefore() {
        white = new Colour(0, 0, 0);
        grey = new Colour(128,128,128);
        blue = new Colour(0, 0, 255);
        yellow = new Colour(255, 255, 0);
        teal = new Colour(0,128,128);
    }

    @Test
    void testIsGreyScale() {
        assertTrue(white.isGreyScale());
        assertTrue(grey.isGreyScale());
        assertFalse(blue.isGreyScale());
        assertFalse(yellow.isGreyScale());
        assertFalse(teal.isGreyScale());
    }

    @Test
    void testToHex() {
        assertEquals("0", white.toHex());
        assertEquals("808080", grey.toHex());
        assertEquals("ff", blue.toHex());
        assertEquals("ffff00", yellow.toHex());
        assertEquals("8080", teal.toHex());
    }
}