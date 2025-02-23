package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

public class GapBufferTests {

    /**
     * TODO: fill me in with unit and property tests!
     */
    @Test
    public void emptyBufferTests() {

        GapBuffer temp = new GapBuffer();
        assertEquals(0, temp.getSize(), "Size is not 0");

        //delete test empty
        temp.delete();
        assertEquals(0, temp.getSize(), "Size is not 0");

        //move cursor
        assertEquals(0, temp.getCursorPosition(), "Current Position is not 0");
        temp.moveRight();
        assertEquals(0, temp.getCursorPosition(), "After Move Right, Position is not 0");

        temp.moveLeft();
        assertEquals(0, temp.getCursorPosition(), "After Move Left, Position is not 0");

    }

    @Test
    public void insertTest() {
        GapBuffer temp = new GapBuffer();
        temp.insert('h');
        temp.insert('e');
        temp.insert('l');
        temp.insert('l');
        temp.insert('o');
        temp.insert(' ');
        temp.insert('w');
        temp.insert('o');
        temp.insert('r');
        temp.insert('l');
        temp.insert('d');

        assertEquals("hello world", temp.toString(), "Insertion failed");
    }

    @Test
    public void deleteTest() {
        GapBuffer temp = new GapBuffer();
        temp.insert('h');
        temp.insert('e');
        temp.insert('l');
        temp.insert('l');
        temp.insert('o');
        temp.insert(' ');
        temp.insert('w');
        temp.insert('o');
        temp.insert('r');
        temp.insert('l');
        temp.insert('d');

        //delete 4 characters
        for (int i = 0; i < 4; i++) {
            temp.delete();
        }

        assertEquals("hello w", temp.toString(), "Deletion failed");
    }

    @Test
    public void deleteTestEdge() {
        GapBuffer temp = new GapBuffer();
        temp.insert('h');
        temp.insert('e');
        temp.insert('l');
        temp.insert('l');
        temp.insert('o');

        //delete 4 characters
        for (int i = 0; i < 8; i++) {
            temp.delete();
        }

        assertEquals(0, temp.getCursorPosition(), "Delete edge case failed");
    }

    @Test
    public void cursorPostionTest() {
        GapBuffer temp = new GapBuffer();
        temp.insert('h');
        temp.insert('e');
        temp.insert('l');
        temp.insert('l');
        temp.insert('o');
        temp.insert(' ');
        temp.insert('w');
        temp.insert('o');
        temp.insert('r');
        temp.insert('l');
        temp.insert('d');

        assertEquals(10, temp.getCursorPosition(), "Get Cursor Failed");

    }

    @Test
    public void moveLeftTest() {
        GapBuffer temp = new GapBuffer();
        temp.insert('h');
        temp.insert('e');
        temp.insert('l');
        temp.insert('l');
        temp.insert('o');
        temp.insert(' ');
        temp.insert('w');
        temp.insert('o');
        temp.insert('r');
        temp.insert('l');
        temp.insert('d');

        //save current position
        int currentPosition = temp.getCursorPosition();

        //move left four characters
        for (int i = 0; i < 4; i++) {
            temp.moveLeft();
        }

        assertEquals(currentPosition - 4, temp.getCursorPosition(), "Move left failed");
    }

    @Test
    public void moveLeftTestEdge() {
        GapBuffer temp = new GapBuffer();
        temp.insert('h');
        temp.insert('e');
        temp.insert('l');
        temp.insert('l');
        temp.insert('o');
        temp.insert(' ');
        temp.insert('w');
        temp.insert('o');
        temp.insert('r');
        temp.insert('l');
        temp.insert('d');

        //move left 10 times characters
        for (int i = 0; i < 10; i++) {
            temp.moveLeft();
        }

        assertEquals(0, temp.getCursorPosition(), "Move left failed");
    }

    @Test
    public void moveRightTest() {
        GapBuffer temp = new GapBuffer();
        temp.insert('h');
        temp.insert('e');
        temp.insert('l');
        temp.insert('l');
        temp.insert('o');
        temp.insert(' ');
        temp.insert('w');
        temp.insert('o');
        temp.insert('r');
        temp.insert('l');
        temp.insert('d');

        //save current position
        int currentPosition = temp.getCursorPosition();

        //move left four characters
        for (int i = 0; i < 4; i++) {
            temp.moveLeft();
        }
        //move right four characters
        for (int i = 0; i < 4; i++) {
            temp.moveRight();
        }

        assertEquals(currentPosition, temp.getCursorPosition(), "Move right failed");
    }

    @Test
    public void moveRightTestEdge() {
        GapBuffer temp = new GapBuffer();
        temp.insert('h');
        temp.insert('e');
        temp.insert('l');
        temp.insert('l');
        temp.insert('o');
        temp.insert(' ');
        temp.insert('w');
        temp.insert('o');
        temp.insert('r');
        temp.insert('l');
        temp.insert('d');

        //save current position
        int currentPosition = temp.getCursorPosition();

        //move left four characters
        for (int i = 0; i < 4; i++) {
            temp.moveLeft();
        }
        //move right 10 characters
        for (int i = 0; i < 10; i++) {
            temp.moveRight();
        }

        assertEquals(currentPosition, temp.getCursorPosition(), "Move right failed");
    }

    @Test
    public void testGetChar() {
        GapBuffer temp = new GapBuffer();
        temp.insert('h');
        temp.insert('e');
        temp.insert('l');
        temp.insert('l');
        temp.insert('o');
        temp.insert(' ');
        temp.insert('w');
        temp.insert('o');
        temp.insert('r');
        temp.insert('l');
        temp.insert('d');

        assertEquals(' ', temp.getChar(5), "Get Char Failed");

    }

    @Test
    public void testGetCharEdge() {
        GapBuffer temp = new GapBuffer();
        temp.insert('h');
        temp.insert('e');
        temp.insert('l');
        temp.insert('l');
        temp.insert('o');
        temp.insert(' ');
        temp.insert('w');
        temp.insert('o');
        temp.insert('r');
        temp.insert('l');
        temp.insert('d');

        try {
            temp.getChar(11);
            fail("Did not throw Index out of Bounds Error");

        } catch (IndexOutOfBoundsException e) {
            //program did exactly what was expected
            assertTrue(true);
        }
    }

    @Property
    boolean sizePropertyTest(@ForAll @IntRange(min = 1, max = 1000) int sz) {
        GapBuffer temp = new GapBuffer();

        for (int i = 0; i < sz; i++) {
            temp.insert('a');
        }
        return temp.getSize() == sz;
    }
}
