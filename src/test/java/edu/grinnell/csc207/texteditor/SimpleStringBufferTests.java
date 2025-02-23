package edu.grinnell.csc207.texteditor;

//import edu.grinnell.csc207.texteditor.SimpleStringBuffer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

public class SimpleStringBufferTests {

    /**
     * TODO: fill me in with unit and property tests!
     */
    @Test
    public void emptyBufferTests() {

        SimpleStringBuffer temp = new SimpleStringBuffer();
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
}
