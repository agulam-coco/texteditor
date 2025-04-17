package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {

    private String stringBuffer;
    private int sz = 0;

    /**
     * Constructor for String Buffer
    */
    public SimpleStringBuffer() {
        stringBuffer = "";
        sz = 0;
    }

    /**
     * This function inserts the character ch into the current gap buffer
     *
     * @param ch
     */
    public void insert(char ch) {
         String leftPortion = stringBuffer.substring(0, sz);
        String rightPortion = stringBuffer.substring(sz);
        stringBuffer = leftPortion + ch + rightPortion;
        sz++;
    }

    /**
     * THis function removes the element at the cursor by adding the string
     * before and after it
     */
    //Credit: https://stackoverflow.com/a/13386147
    public void delete() {
        if (sz != 0) {
            stringBuffer = stringBuffer.substring(0, sz - 1) + stringBuffer.substring(sz);
            sz--;
        }
    }

    /**
     * This function returns the current position of the cursor
     * @return the position of the cursor
     */
    public int getCursorPosition() {
        return sz;
    }

    /**
     * This function moves the cursor left by causing
     */
    public void moveLeft() {
        if (sz > 0) {
            sz--;
        }
    }

    /**
     * THis function moves the cursor right
     */
    public void moveRight() {
        if (sz < stringBuffer.length()) {
            sz++;
        }
    }

    /**
     * This function returns the size of the current buffer
     * @return the size of the buffer
     */
    public int getSize() {
        return stringBuffer.length();
    }


    /** This function returns a particular index of a function i
     * @param i the index to get from buffer
     * @return the current character to get from buffer
     */
    public char getChar(int i) throws IndexOutOfBoundsException {
        return stringBuffer.charAt(i);
    }

    
     /**
     * This function returns a string version of buffer
     * @return the string representation of the buffer
     */
    @Override
    public String toString() {
        return stringBuffer;
    }
}
