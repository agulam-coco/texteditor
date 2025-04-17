# CSC 207: Text Editor

**Author**  
Jason Chigabatia  
📧 chigabat@grinnell.edu

---

## 📋 Overview

This project is a terminal-based text editor developed in Java using the Lanterna library. It includes core text editing features with support for two buffer implementations: `SimpleStringBuffer` and `GapBuffer`. The project demonstrates key data structure concepts and event-driven programming principles.

---

## ✅ Changes Made

- Fixed bugs in `moveLeft` and `moveRight` methods.
- Resolved buffer expansion logic errors.
- Updated `insert` and `delete` behavior to adhere to style guidelines.
- Enhanced test coverage and added file I/O capabilities.

---

## 🔍 Analysis: `SimpleStringBuffer` `insert` Method

Each `insert` operation involves **three critical string copying operations**, each linear in time relative to string length `n`:

- Substring extraction  
- Concatenation before insertion  
- Concatenation after insertion  

### Runtime Complexity:
- Each of the three operations is **O(n)**
- Therefore, the overall runtime: **3n**

> **Conclusion:** `insert` is **O(n)**

---

## 📖 Resources Used

### 🤝 Collaboration

- Collaborated with **Drilon**, who helped identify a bug in the `expand` function.

### 🧠 Citations

1. W3Schools. *Java String substring() Method*. [Link](https://www.w3schools.com/java/ref_string_substring.asp)  
2. Stack Overflow. *What's the actual use of fail in JUnit test case?* [Link](https://stackoverflow.com/questions/3869954/whats-the-actual-use-of-fail-in-junit-test-case)  
3. Baeldung. *Introduction to jqwik: Property-based Testing in Java*. [Link](https://www.baeldung.com/java/jqwik-property-based-testing)  
4. Grinnell College. *Text Editor Lab*. Osera. [Link](https://osera.cs.grinnell.edu/ttap/data-structures-labs/text-editor.html)  
5. Stack Overflow. *How do I use `fail()` in a JUnit Test case?* [Link](https://stackoverflow.com/a/11001759)  
6. Mabe02. *Lanterna API Docs 2.1: Screen Interface*. [Link](https://mabe02.github.io/lanterna/apidocs/2.1/com/googlecode/lanterna/screen/Screen.html)  
7. Mabe02. *TerminalPosition Class*. [Link](https://mabe02.github.io/lanterna/apidocs/2.1/com/googlecode/lanterna/terminal/TerminalPosition.html)  
8. Mabe02. *Screen.putString Method (Standard)*. [Link](https://mabe02.github.io/lanterna/apidocs/2.1/com/googlecode/lanterna/screen/Screen.html#putString(int,%20int,%20java.lang.String,%20com.googlecode.lanterna.terminal.Terminal.Color,%20com.googlecode.lanterna.terminal.Terminal.Color,%20java.util.Set))  
9. Mabe02. *Screen.putString Method (With Styles)*. [Link](https://mabe02.github.io/lanterna/apidocs/2.1/com/googlecode/lanterna/screen/Screen.html#putString(int,%20int,%20java.lang.String,%20com.googlecode.lanterna.terminal.Terminal.Color,%20com.googlecode.lanterna.terminal.Terminal.Color,%20com.googlecode.lanterna.screen.ScreenCharacterStyle...))  
10. Mabe02. *KeyStroke Class - Lanterna API Docs 3.0*. [Link](https://mabe02.github.io/lanterna/apidocs/3.0/com/googlecode/lanterna/input/KeyStroke.html)

### 🔧 Tools and Technologies

- **Java Programming Language** – [Oracle Java](https://www.oracle.com/java/)  
- **NetBeans IDE** – [Apache NetBeans](https://netbeans.apache.org/)  
- **ChatGPT** – Used to help structure this README. [Link](https://www.openai.com/chatgpt)

---

## 📝 Git Commit Log
## Changelog
commit 20669bbd6e60abe07b0796dad1e2f2b0229c397d (HEAD -> main)
Author: Jason Chigabatia <aguchija@gmail.com>
Date:   Sun Feb 23 23:38:00 2025 -0600

    Fixed length method call in string buffer

commit 4293b56991b876a7c14aee7a7953f5f2659dabf1 (origin/main, origin/HEAD)
Author: Jason Chigabatia <aguchija@gmail.com>
Date:   Sun Feb 23 23:32:01 2025 -0600

    Fixed bug in move left and move right in string buffer

commit 5303a3a9dbeed8532a3b2a4a8ec4a7d755465a1d
Author: Jason Chigabatia <aguchija@gmail.com>
Date:   Sun Feb 23 23:27:36 2025 -0600

    Fixed bug in string buffer

commit 7c04cdc5b2aee562220eb3411d08ade75e2fc088
Author: Jason Chigabatia <aguchija@gmail.com>
Date:   Sun Feb 23 23:20:57 2025 -0600

    Attempting to swap check in insert
pnueli texteditor$ 
pnueli texteditor$ git log > log.txt
pnueli texteditor$ cat log.txt 
commit 20669bbd6e60abe07b0796dad1e2f2b0229c397d
Author: Jason Chigabatia <aguchija@gmail.com>
Date:   Sun Feb 23 23:38:00 2025 -0600

    Fixed length method call in string buffer

commit 4293b56991b876a7c14aee7a7953f5f2659dabf1
Author: Jason Chigabatia <aguchija@gmail.com>
Date:   Sun Feb 23 23:32:01 2025 -0600

    Fixed bug in move left and move right in string buffer

commit 5303a3a9dbeed8532a3b2a4a8ec4a7d755465a1d
Author: Jason Chigabatia <aguchija@gmail.com>
Date:   Sun Feb 23 23:27:36 2025 -0600

    Fixed bug in string buffer

commit 7c04cdc5b2aee562220eb3411d08ade75e2fc088
Author: Jason Chigabatia <aguchija@gmail.com>
Date:   Sun Feb 23 23:20:57 2025 -0600

    Attempting to swap check in insert

commit ef44be11d7b717571919d1e2de0b2ed56a553666
Author: Jason Chigabatia <aguchija@gmail.com>
Date:   Sun Feb 23 23:17:21 2025 -0600

    Changed expand number after gap calculation

commit 0629575a5a1232a59c97b1b3c616eeff622a4834
Author: Jason Chigabatia <aguchija@gmail.com>
Date:   Sun Feb 23 23:08:53 2025 -0600

    Increased buffer initial size

commit 14cb62122803f746640f959654f9d038d9001fee
Merge: df17f48 e2cd0f4
Author: Jason Chigabatia <aguchija@gmail.com>
Date:   Sun Feb 23 23:01:48 2025 -0600

    Merge branch 'main' of github.com:agulam-coco/texteditor
    merge to include new string tests

commit df17f4802b39dcb00b66e2dfee0f4d29f4364f62
Author: Jason Chigabatia <aguchija@gmail.com>
Date:   Sun Feb 23 22:59:45 2025 -0600

    Modified string tests

commit e2cd0f4bfa588db7a111bce837b5c7974d5c5d84
Author: agulam-coco <aguchija@gmail.com>
Date:   Sun Feb 23 20:51:19 2025 -0600

    added information to README

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
