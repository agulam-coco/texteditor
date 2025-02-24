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

        //main program loop
        while (true) {
            KeyStroke userInput = screen.readInput();
            KeyType userKeyType = userInput.getKeyType();
            if (userKeyType.equals(KeyType.Character)) {
                //add character
                char insertCharacter = userInput.getCharacter();
                buffer.insert(insertCharacter);
            } else if (userKeyType.equals(KeyType.ArrowLeft)) {
                buffer.moveLeft();
                //perform arrow left
            } else if (userKeyType.equals(KeyType.ArrowRight)) {
                buffer.moveRight();
                //perform arrow right
            } else if (userKeyType.equals(KeyType.Backspace)) {
                buffer.delete();
                //perform backspace
            } else if (userKeyType.equals(KeyType.Escape)) {
                break;
            }
            drawBuffer(buffer, screen);
        }
        //cleanup
        screen.stopScreen();

    }

    public static void drawBuffer(GapBuffer buf, Screen screen) throws IOException {

        for (int index = 0; index < buf.getSize(); index++) {

            //set character in termainal
            int row = index / screen.getTerminalSize().getRows();
            int col = index % screen.getTerminalSize().getColumns();
            screen.setCharacter(row, col, new TextCharacter(buf.getChar(index)));

        }

        //set cursor
        int cursorX = buf.getCursorPosition() / screen.getTerminalSize().getRows();
        int cursorY = buf.getCursorPosition() % screen.getTerminalSize().getColumns();
        screen.setCursorPosition(new TerminalPosition(cursorX, cursorY));

        screen.refresh();
    }
}
