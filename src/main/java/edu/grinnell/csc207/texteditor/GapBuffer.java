package edu.grinnell.csc207.texteditor;

import java.util.Arrays;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {

    final int INITIAL_BUFFER_SIZE = 20;
    char[] buffer = new char[INITIAL_BUFFER_SIZE];

    private int gapStartingIndex;
    private int afterCursorIndex;

    public GapBuffer() {
        gapStartingIndex = 0;
        afterCursorIndex = buffer.length;
    }
    
    
    private void expand(){
        
        //new array of double size 
        char[] newArray = new char[buffer.length * 2];
        
        //copy portion before gap
        System.arraycopy( buffer, 0, newArray, 0, gapStartingIndex );
        
        int numberAfterGap = buffer.length - afterCursorIndex;
        
        //copy portion after gap 
        System.arraycopy( buffer, afterCursorIndex, newArray, newArray.length-numberAfterGap, numberAfterGap);
        
        //assign new array
        buffer = newArray;   
    }

    public void insert(char ch) {

        buffer[gapStartingIndex] = ch;
        gapStartingIndex++;

        if (gapStartingIndex == afterCursorIndex) {
            //expand
        }
        //throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public void delete() {
        //decerement gap starting index unless it is at the start of array
        if (gapStartingIndex != 0) {
            gapStartingIndex--;
        }
        //throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public int getCursorPosition() {
        return gapStartingIndex;
    }

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

    public int getSize() {
        //buffer length - length of gap +1 <-- for shift by index
        return (buffer.length - (afterCursorIndex - gapStartingIndex) + 1);
    }

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

    //credit: https://stackoverflow.com/a/4822280
    public String toString() {
        //add first part before gap to part after gap
        String firstHalf;
        String secondHalf;

        if (gapStartingIndex == 0) {
            firstHalf = "";
        } else {
            firstHalf = new String(Arrays.copyOfRange(buffer, 0, gapStartingIndex));
        }

        if (gapStartingIndex == buffer.length) {
            secondHalf = "";
        } else {
            secondHalf = new String(Arrays.copyOfRange(buffer, afterCursorIndex, buffer.length));
        }

        return firstHalf + secondHalf;
    }
}
