package edu.grinnell.csc207.texteditor;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.screen.Screen;
import java.io.IOException;

/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {

    /**
     * The main entry point for the TextEditor application.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java TextEditor <filename>");
            System.exit(1);
        }

        // TODO: fill me in with a text editor TUI!
        String path = args[0];
        System.out.format("Loading %s...\n", path);

        GapBuffer buffer = new GapBuffer();
        Screen screen = new DefaultTerminalFactory().createScreen();

        //start
        screen.startScreen();

        OUTER:
        while (true) {
            KeyStroke userInput = screen.readInput();
            KeyType userKeyType = userInput.getKeyType();
            switch (userKeyType) {
                case Character:
                    //add character
                    char insertCharacter = userInput.getCharacter();
                    buffer.insert(insertCharacter);
                    break;
                case ArrowLeft:
                    buffer.moveLeft();
                    //perform arrow left
                    break;
                case ArrowRight:
                    buffer.moveRight();
                    //perform arrow right
                    break;
                case Backspace:
                    buffer.delete();
                    //perform backspace
                    break;
                case Escape:
                    break OUTER;
                default:
                    break;
            }
            drawBuffer(buffer, screen);
        }
        //cleanup
        screen.stopScreen();

    }

    public static void drawBuffer(GapBuffer buf, Screen screen) throws IOException {
        screen.clear();
        for(int index = 0; index < buf.getSize();index++){
            //set character in terminal
            int row = index % screen.getTerminalSize().getColumns();
            int col = index / screen.getTerminalSize().getColumns();
            screen.setCharacter(row, col, new TextCharacter(buf.getChar(index)));
           
        }

        //set cursor
        int cursorX = buf.getCursorPosition() % screen.getTerminalSize().getColumns();
        int cursorY = buf.getCursorPosition() / screen.getTerminalSize().getColumns();
        screen.setCursorPosition(new TerminalPosition(cursorX, cursorY));

        screen.refresh();
    }
}
