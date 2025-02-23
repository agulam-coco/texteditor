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

    //Credit: https://stackoverflow.com/a/13386147
    public void delete() {
        if (sz != 0) {
            stringBuffer = stringBuffer.substring(0, sz) + stringBuffer.substring(sz + 1);

            sz--;
        }
        //throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public int getCursorPosition() {
        return sz;
        //throw new UnsupportedOperationException("Unimplemented method 'getCursorPosition'");
    }

    public void moveLeft() {
        if (sz != 0) {
            sz--;
        }
        //throw new UnsupportedOperationException("Unimplemented method 'moveLeft'");
    }

    public void moveRight() {
        if (this.getSize() > 0 && sz != stringBuffer.length() + 1) {
            sz++;
        }
        //throw new UnsupportedOperationException("Unimplemented method 'moveRight'");
    }

    public int getSize() {
        return stringBuffer.length();
        //  throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }

    public char getChar(int i) throws IndexOutOfBoundsException {
        return stringBuffer.charAt(i);
        //throw new UnsupportedOperationException("Unimplemented method 'getChar'");
    }

    @Override
    public String toString() {
        return stringBuffer;
        //throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }
}

