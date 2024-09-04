****************
* Warmup
* CS221
* 8/30/2024
* Daylen Mathews
**************** 

OVERVIEW:

 This is a program that allows users to check if a given square matrix is a Magic Square or allow them to generate a new one. 


INCLUDED FILES:
* MagicSquare.java - source file
 * MagicSquareDriver.java - source file
 * README - this file


COMPILING AND RUNNING:

 From the directory containing all source files, compile the program with the command:
 
 $ javac MagicsquareDriver.java
  
  To run the program
 
 $ java MagicSquareDriver <-check | -create> <filename> < | int(has to be odd)> 
 
 Console output will give the results after the program finishes.


PROGRAM DESIGN AND IMPORTANT CONCEPTS:
There are two main classes for the program design. The first class is the MagicSquare class. This class encapsulates the logic required to manage and verify the squares. In this class, it implements logic to read a matrix from a file, then it runs and checks if it is a Magic Square, and generates a new Magic Square. An important method that the MagicSquare uses is how it verifies the properties, checking if all required numbers are being used and if all rows, columns, and diagonals are the same. The MagicSquare also uses a 2D ineteger array to represent the matrix. 

The second class is the MagicSquareDriver class. This class serves as the main driver for creating and validating the magic squares. It serves as the main entry point for the program. This driver class contains the main method. The driver reads the command-line arguments that specify whether the program should check an existing matrix from existing files or create a new one. It also helps to validate input and to ensure proper usage and proper outputs. 

Both of these classes work together to complete the program. The MagicSquareDriver class handles all of the input and output of the program while the MagicSquare performs the core logic of the code and the program. This design helps ensure to keep each responsibility seperated and clean. A part of this that could be improved is the error messaging which could be updated as it does not run quite right. 


TESTING:
There was already a tester provided for this assignment. The tester provided was MagicSquarestest.java. There were tests ran on the constructors to ensure the program can initialize properly and handle all of the exceptions. There were also test ran on the Magic Square to ensure the program correctly indetifies the valid and invalid squares. The program can handle a bad input. A bug I may have found is when creating a 4x4 magic square and the constructor takes the file name and size, there is an IndexOutOfBoundsException which needs to be fixed to make sure that the program is running properly. 


DISCUSSION:
 This was definitely a tough project for me. There were a few issues I encountered during programming development. Some parts where I struggled were when it came to having to debug some of my complex array issues. I have not had too much previous experience handling arrays and the correct sizing and erros when it came to using them. I used the TA room and tutoring sessions to help me fix these bugs. Another problem I had was ensuring the file writing as well as the reading. A moment when something clicked was when I was not getting the right output, but realized I had not put the tester program into my code. 
 
 
EXTRA CREDIT:

 There were no extra credit opporutunities for this project. 


----------------------------------------------------------------------------