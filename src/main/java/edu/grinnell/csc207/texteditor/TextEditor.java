package edu.grinnell.csc207.texteditor;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.screen.Screen;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

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
            printUsage();
            System.exit(1);
        }

        // TODO: fill me in with a text editor TUI!
        Path path = Paths.get(args[0]);
        System.out.format("Loading %s...\n", path.getFileName());

        //DECLARE VARIABLES
        GapBuffer buffer = new GapBuffer();
        Screen screen = new DefaultTerminalFactory().createScreen();
        screen.startScreen();

        if (Files.exists(path) && Files.isRegularFile(path)) {
            String fileContents = Files.readString(path);
            insertInitial(buffer, fileContents);
            drawBuffer(buffer, screen);
        }
//  System.out.print("This is not a valid file name!");
//            printUsage();
//            System.exit(2);
//        
        OUTER:             //start
        while (true) {
            KeyStroke userInput = screen.readInput();
            KeyType userKeyType = userInput.getKeyType();
            switch (userKeyType) {
                case Character -> {
                    //add character
                    char insertCharacter = userInput.getCharacter();
                    buffer.insert(insertCharacter);
                }
                case ArrowLeft ->
                    buffer.moveLeft();
                //perform arrow left
                case ArrowRight ->
                    buffer.moveRight();
                //perform arrow right
                case Backspace ->
                    buffer.delete();
                //perform backspace
                case Escape -> {
                    break OUTER;
                }
                default -> {
                }
            }
            drawBuffer(buffer, screen);
        }
        //cleanup
        screen.stopScreen();

        Files.writeString(path, buffer.toString());

    }

    private static void printUsage() {
        System.err.println("Usage: java TextEditor <filename>");
    }

    public static void drawBuffer(GapBuffer buf, Screen screen) throws IOException {
        screen.clear();
        for (int index = 0; index < buf.getSize(); index++) {
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

    public static void insertInitial(GapBuffer buf, String initialContent) {
        if (initialContent.length() == 0) {
            return;
        }
        for (int i = 0; i < initialContent.length(); i++) {
            buf.insert(initialContent.charAt(i));
        }
    }
}
