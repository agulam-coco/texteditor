package edu.grinnell.csc207.texteditor;

import java.util.Arrays;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {

    final int INITIAL_BUFFER_SIZE = 2;
    char[] buffer = new char[INITIAL_BUFFER_SIZE];

    private int gapStartingIndex;
    private int afterCursorIndex;

    public GapBuffer() {
        gapStartingIndex = 0;
        afterCursorIndex = buffer.length;
    }

    /**
     * This function expands a Gap Buffer aby doubling its internal size
     */
    private void expand() {

        //new array of double size 
        char[] newArray = new char[buffer.length * 2];

        //copy portion before gap
        System.arraycopy(buffer, 0, newArray, 0, gapStartingIndex);

        int numberAfterGap = buffer.length - afterCursorIndex;

        int newAfterCursorIndex = newArray.length - numberAfterGap;

        //copy portion after gap 
        if (numberAfterGap > 0) {
            System.arraycopy(buffer, afterCursorIndex, newArray, newAfterCursorIndex - 1, numberAfterGap);
        }

        //assign new array
        buffer = newArray;

        //move after cursor to new 
        afterCursorIndex = newAfterCursorIndex;
        
    }

    /**
     * This function inserts the character ch into the current gap buffer
     * @param ch 
     */
    public void insert(char ch) {

        buffer[gapStartingIndex] = ch;
        gapStartingIndex++;

        if (gapStartingIndex == afterCursorIndex) {
            //expand
            expand();
        }
        //throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    /**
     * THis function removes the element behind the current gap by pointing the gap to it
     */
    public void delete() {
        //decrement gap starting index unless it is at the start of array
        if (gapStartingIndex != 0) {
            gapStartingIndex--;
        }
        //throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    /**
     * This function returns the current position of the cursor
     * @return 
     */
    public int getCursorPosition() {
        return gapStartingIndex;
    }

    /**
     * This function moves the cursor left by causing 
     */
    public void moveLeft() {
        //if gapStaringIndex > 0
        //move gap starting index back one.
        //move after cursor index back one 
        //take whatever is at gapStartingIndex position and move it to afterCursor position

        if (gapStartingIndex > 0) {
            gapStartingIndex--;
            afterCursorIndex--;
            buffer[afterCursorIndex] = buffer[gapStartingIndex];
        }
    }

    /**
     * THis function moves the cursor right
     */
    public void moveRight() {
        //if aftercursor < buffer length
        //copy value in after cursor to gapStartingBuffer.
        //increment gapStartingIndex
        //increment afterCursorIndex
        if (afterCursorIndex < buffer.length) {
            buffer[gapStartingIndex] = buffer[afterCursorIndex];
            gapStartingIndex++;
            afterCursorIndex++;
        }
    }
    
    /**
     * This function returns the size of the current function
     * @return 
     */
    public int getSize() {
        //buffer length - length of gap +1 <-- for shift by index
        
        if(gapStartingIndex == 0 && afterCursorIndex == buffer.length){
            return 0;
        }
        return (buffer.length - (afterCursorIndex - gapStartingIndex ));
    }

    /** This function returns a particular index of a function i
     * @param i
     * @return 
     */
    public char getChar(int i) {
        //in the part after gap
        if (i >= gapStartingIndex) {
            return buffer[afterCursorIndex + (i - gapStartingIndex)];
        } //in the part before gap
        else {
            return buffer[i];
        }
        //throw new UnsupportedOperationException("Unimplemented method 'getChar'");
    }

    /**
     * This function returns a string version of buffer
     * @return 
     */
    //credit: https://stackoverflow.com/a/4822280
    public String toString() {
        //add first part before gap to part after gap
        String firstHalf;
        String secondHalf;

        if (gapStartingIndex == 0) {
            firstHalf = "";
        } else {
            firstHalf = String.valueOf(Arrays.copyOfRange(buffer, 0, gapStartingIndex));
        }

        if (afterCursorIndex == buffer.length) {
            secondHalf = "";
        } else {
            secondHalf = String.valueOf(Arrays.copyOfRange(buffer, afterCursorIndex, buffer.length));
        }

        return firstHalf + secondHalf;
    }
}
