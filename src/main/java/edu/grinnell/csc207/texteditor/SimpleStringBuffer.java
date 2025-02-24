package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {

    private String stringBuffer;
    private int sz = 0;

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
        if (sz == 0) {
            stringBuffer = String.format("%c", ch);
        } else {
            String left_portion = stringBuffer.substring(0, sz);
            String right_portion = stringBuffer.substring(sz, stringBuffer.length());
            stringBuffer = left_portion + ch + right_portion;
        }
        sz++;
        //throw new UnsupportedOperationException("Unimplemented method 'delete'");
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
        //throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    /**
     * This function returns the current position of the cursor
     *
     * @return
     */
    public int getCursorPosition() {
        return sz;
        //throw new UnsupportedOperationException("Unimplemented method 'getCursorPosition'");
    }

    /**
     * This function moves the cursor left by causing
     */
    public void moveLeft() {
        if (sz != 0) {
            sz--;
        }
        //throw new UnsupportedOperationException("Unimplemented method 'moveLeft'");
    }

    /**
     * THis function moves the cursor right
     */
    public void moveRight() {
        if (this.getSize() > 0 && sz != stringBuffer.length() + 1) {
            sz++;
        }
        //throw new UnsupportedOperationException("Unimplemented method 'moveRight'");
    }

    /**
     * This function returns the size of the current function
     *
     * @return
     */
    public int getSize() {
        return stringBuffer.length();
        //  throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }

    /**
     * This function returns a particular index of a function i
     *
     * @param i
     * @return
     */
    public char getChar(int i) throws IndexOutOfBoundsException {
        return stringBuffer.charAt(i);
        //throw new UnsupportedOperationException("Unimplemented method 'getChar'");
    }

    /**
     * This function returns a string version of buffer
     *
     * @return
     */
    @Override
    public String toString() {
        return stringBuffer;
        //throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }
}
