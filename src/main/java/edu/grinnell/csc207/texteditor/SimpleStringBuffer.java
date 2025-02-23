package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {
    
    private String string_buffer;
    private int sz = 0;
    
    public SimpleStringBuffer(){
        string_buffer = "";
        sz = 0;
    }
    
    public void insert(char ch) {
        String left_portion = string_buffer.substring(sz);
        String right_portion = string_buffer.substring(sz, string_buffer.length());
        string_buffer = left_portion + ch + right_portion;
        
        sz++;
        //throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    //Credit: https://stackoverflow.com/a/13386147
    public void delete() {
        if ( sz != 0) {
            string_buffer = string_buffer.substring(0, sz) + string_buffer.substring(sz + 1);

            sz--;
        }
        //throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public int getCursorPosition() {
        return sz;
        //throw new UnsupportedOperationException("Unimplemented method 'getCursorPosition'");
    }

    public void moveLeft() {
        if (sz != 0){
            sz--;
        }
        //throw new UnsupportedOperationException("Unimplemented method 'moveLeft'");
    }

    public void moveRight() {
         if (sz != string_buffer.length()+1){
            sz++;
        }
        //throw new UnsupportedOperationException("Unimplemented method 'moveRight'");
    }

    public int getSize() {
        return string_buffer.length();
      //  throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }

    public char getChar(int i) throws IndexOutOfBoundsException{
        return string_buffer.charAt(i);
        //throw new UnsupportedOperationException("Unimplemented method 'getChar'");
    }

    @Override
    public String toString() {
        return string_buffer;
        //throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }
}
