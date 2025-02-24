# CSC 207: Text Editor

**Author**:  
Jason Chigabatia  
chigabat@grinnell.edu

## Resources Used

### Web Citations:

1. W3Schools. (n.d.). *Java String substring() Method*. W3Schools. Retrieved February 23, 2025, from [https://www.w3schools.com/java/ref_string_substring.asp](https://www.w3schools.com/java/ref_string_substring.asp)

2. Stack Overflow. (2010). *What's the actual use of fail in JUnit test case?*. Stack Overflow. Retrieved February 23, 2025, from [https://stackoverflow.com/questions/3869954/whats-the-actual-use-of-fail-in-junit-test-case](https://stackoverflow.com/questions/3869954/whats-the-actual-use-of-fail-in-junit-test-case)

3. Baeldung. (2020, November 30). *Introduction to jqwik: Property-based Testing in Java*. Baeldung. Retrieved February 23, 2025, from [https://www.baeldung.com/java/jqwik-property-based-testing](https://www.baeldung.com/java/jqwik-property-based-testing)

4. Grinnell College. (n.d.). *Text Editor Lab*. Osera, Grinnell College. Retrieved February 23, 2025, from [https://osera.cs.grinnell.edu/ttap/data-structures-labs/text-editor.html](https://osera.cs.grinnell.edu/ttap/data-structures-labs/text-editor.html)

5. Stack Overflow. (2012). *How do I use `fail()` in a JUnit Test case?*. Stack Overflow. Retrieved February 23, 2025, from [https://stackoverflow.com/a/11001759](https://stackoverflow.com/a/11001759)

6. Mabe02. (n.d.). *Screen Interface - Lanterna API Docs 2.1*. Mabe02. Retrieved February 23, 2025, from [https://mabe02.github.io/lanterna/apidocs/2.1/com/googlecode/lanterna/screen/Screen.html](https://mabe02.github.io/lanterna/apidocs/2.1/com/googlecode/lanterna/screen/Screen.html)

7. Mabe02. (n.d.). *TerminalPosition Class - Lanterna API Docs 2.1*. Mabe02. Retrieved February 23, 2025, from [https://mabe02.github.io/lanterna/apidocs/2.1/com/googlecode/lanterna/terminal/TerminalPosition.html](https://mabe02.github.io/lanterna/apidocs/2.1/com/googlecode/lanterna/terminal/TerminalPosition.html)

8. Mabe02. (n.d.). *Screen.putString Method - Lanterna API Docs 2.1*. Mabe02. Retrieved February 23, 2025, from [https://mabe02.github.io/lanterna/apidocs/2.1/com/googlecode/lanterna/screen/Screen.html#putString(int,%20int,%20java.lang.String,%20com.googlecode.lanterna.terminal.Terminal.Color,%20com.googlecode.lanterna.terminal.Terminal.Color,%20java.util.Set)](https://mabe02.github.io/lanterna/apidocs/2.1/com/googlecode/lanterna/screen/Screen.html#putString(int,%20int,%20java.lang.String,%20com.googlecode.lanterna.terminal.Terminal.Color,%20com.googlecode.lanterna.terminal.Terminal.Color,%20java.util.Set)

9. Mabe02. (n.d.). *Screen.putString Method - Lanterna API Docs 2.1 (with Styles)*. Mabe02. Retrieved February 23, 2025, from [https://mabe02.github.io/lanterna/apidocs/2.1/com/googlecode/lanterna/screen/Screen.html#putString(int,%20int,%20java.lang.String,%20com.googlecode.lanterna.terminal.Terminal.Color,%20com.googlecode.lanterna.terminal.Terminal.Color,%20com.googlecode.lanterna.screen.ScreenCharacterStyle...)](https://mabe02.github.io/lanterna/apidocs/2.1/com/googlecode/lanterna/screen/Screen.html#putString(int,%20int,%20java.lang.String,%20com.googlecode.lanterna.terminal.Terminal.Color,%20com.googlecode.lanterna.terminal.Terminal.Color,%20com.googlecode.lanterna.screen.ScreenCharacterStyle...)

10. Mabe02. (n.d.). *Screen.putString Method - Lanterna API Docs 2.1 (with Styles)*. Mabe02. Retrieved February 23, 2025, from [https://mabe02.github.io/lanterna/apidocs/2.1/com/googlecode/lanterna/screen/Screen.html#putString(int,%20int,%20java.lang.String,%20com.googlecode.lanterna.terminal.Terminal.Color,%20com.googlecode.lanterna.terminal.Terminal.Color,%20com.googlecode.lanterna.screen.ScreenCharacterStyle...)](https://mabe02.github.io/lanterna/apidocs/2.1/com/googlecode/lanterna/screen/Screen.html#putString(int,%20int,%20java.lang.String,%20com.googlecode.lanterna.terminal.Terminal.Color,%20com.googlecode.lanterna.terminal.Terminal.Color,%20com.googlecode.lanterna.screen.ScreenCharacterStyle...)

11. Mabe02. (n.d.). *KeyStroke Class - Lanterna API Docs 3.0*. Mabe02. Retrieved February 23, 2025, from [https://mabe02.github.io/lanterna/apidocs/3.0/com/googlecode/lanterna/input/KeyStroke.html](https://mabe02.github.io/lanterna/apidocs/3.0/com/googlecode/lanterna/input/KeyStroke.html)

### Java Programming Language:  
Oracle. (n.d.). *The Java™ Programming Language*. Oracle. Retrieved February 23, 2025, from [https://www.oracle.com/java/](https://www.oracle.com/java/)

### NetBeans IDE:  
Apache Software Foundation. (n.d.). *NetBeans IDE*. Apache Software Foundation. Retrieved February 23, 2025, from [https://netbeans.apache.org/](https://netbeans.apache.org/)

### ChatGPT Citation:  
OpenAI. (2025). *ChatGPT*. Used to format README file. OpenAI. Retrieved February 23, 2025, from [https://www.openai.com/chatgpt](https://www.openai.com/chatgpt)

## Analysis of SimpleStringBuffer

### `insert` method

- The relevant input to the insert method is `n` where `n` is the size of the string that is implicitly copied within any of the string manipulation methods. 
- Because each substring and concatenation is a copy, they would each be treated as their own critical operation. THERE ARE 3 OF THESE CRITICAL OPERATIONS.

If we assume that every copy operation is a linear function with a function in the order of `n`, then the mathematical model of the runtime is `3n`.

**insert is O(n)**

## Changelog
commit 6edd42844d5647f9fb74b0f75cd3e329fa733d45
Author: Jason Chigabatia <aguchija@gmail.com>
Date:   Sun Feb 23 20:38:41 2025 -0600

    Fixed string buffer delete bug. FInal push

commit 8d73f2b9f8e7f67d264c6576170ecf3a6a00e800
Author: Jason Chigabatia <aguchija@gmail.com>
Date:   Sun Feb 23 19:58:26 2025 -0600

    Implemented file savign and read and write ability

commit 04903063e1b0e36ce5c6c68593c892836c964a79
Author: Chigabatia <chigabat@pnueli.cs.grinnell.edu>
Date:   Sun Feb 23 19:07:08 2025 -0600

    Fixed bug in input of the text editor.

commit 5262cd0c1368b324cb7480f04a9b3b0facce5ff6
Author: agulam-coco <aguchija@gmail.com>
Date:   Sun Feb 23 18:23:20 2025 -0600

    Implemented terminal

commit 7627161f0fccdd4f4e3649fd82cb7e68c019997d
Author: agulam-coco <aguchija@gmail.com>
Date:   Sun Feb 23 16:34:55 2025 -0600

    GapBuffer passed all test

commit ce09e39daf6675dfc312f7fc48774e778ad82ffe
Author: agulam-coco <aguchija@gmail.com>
Date:   Sun Feb 23 14:02:46 2025 -0600

    Fixed expasion bug for gap buffer

commit a78be058411e3ee05738a816bb9287a88fde3a18
Author: agulam-coco <aguchija@gmail.com>
Date:   Sun Feb 23 11:52:31 2025 -0600

    Simple String buffer tests complete

commit 1896eb37c031a855eaeb4448927290773f25a5c9
Author: agulam-coco <aguchija@gmail.com>
Date:   Sat Feb 22 22:26:59 2025 -0600

    Wrote test for emptybuffer test in simplestringbuffer and fixed move right method

commit 3ef4f49e12e8373ad29b4b6abbcb220c5512bfee
Author: agulam-coco <aguchija@gmail.com>
Date:   Sat Feb 22 21:42:34 2025 -0600

    implemented simplestringbuffers and gapbuffers

commit 32a90495f40bd92ce905d4d78fbdab4dbaa6d5f9
Author: Peter-Michael Osera <osera@cs.grinnell.edu>
Date:   Thu Feb 13 12:40:05 2025 -0600

    Project files

commit 02dc92144ecc088bcefb4a9798df0934efe300c1
Author: Peter-Michael Osera <osera@cs.grinnell.edu>
Date:   Thu Feb 13 12:39:53 2025 -0600

    initial commit