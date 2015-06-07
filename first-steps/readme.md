





# First Steps

This first steps tutorial is what is commonly known as a "Hello World!" application.
Mastering this doesn't mean you rock at Java. :)




## Step One - Verifying Java Version

Before going any further you must have JDK, Java Development Kit.
The JRE, Java Runtime Environment, version will not suffice.

##### Verify

Open a terminal (console) and type:

	javac -version   [Enter]

If you get the response `javac 1.7.0_80` or something near-by you are home free.

If you get the response `javac: command not found` you need to install the Java JDK.




## Step Two - Write the Hello World App

The Hello World App is a simple public class file with a main method.
The main method is special in Java since it is the starting point when the app is started from a terminal with the java command.

__If you feel that you master this write that program now without reading any further.__

##### First Stone You Might Trip On

In Java the public class and the file should have the same name except that the file must also end in `.java`.
This means that if we aim to create a `public class Hello` it must be written in a file named `Hello.java`



### Write the App

This time we are writing a very simple app without any hierarchy, more about those in other tutorials.
Therefore the contents of the Hello.java file is as simple as this:

	public class Hello {
		public static void main(String[] args) {
			System.out.println("Hello World!");
		}
	}



### Compile the App

Now we need the java compiler, javac, to transform our class file `Hello.java` into a class file `Hello.class`.
The resulting `Hello.class` file contains what is called byte-code and that can be run on any JVM, Java Virtual Machine, on any operating system without recompilation. The JVM is instantiated simply with the command `java`.

##### Compile

	javac Hello.java

_This command will, hopefully, end without any comment what so ever. If it does it most probably will tell you where you made the error._

__This is what an error message could look like__

	Hello.java:3: error: ';' expected
			System.out.println("Hello World!")
			                                  ^
	1 error

__I left out the semicolon at the end of the row and that is clearly marked.__



### Run the App

The result of the compilation is a `Hello.class` file in the same directory as the `Hello.java` file.
You can see it with a simple ls:

	$ ls
	Hello.class  Hello.java

Running is very simple:

	java Hello

_Please note that java does not require nor does it accept the `.class` extension when the program is to be run._



### The Solution is in the solution folder

If you want to run the test without writing anything, the Hello.java file is available in the solution folder.

In that folder there are also some other files that simplifies compiling, running and the making of a runnable jar:

* alias.source - This file, if sourced, creates these aliases:
	- compile - compiles the files in the classes file
	- run - compiles and runs the mainClass
	- makejar - builds a runnable jar
* classes - Contains the list of files to be compiled.


#### Sourcing the alias.source file

In linux, sourcing a file means that it is run in the current context.
This is the only way add environment variables to the current process.

##### Source like this

	source alias.source

##### or like this

	. alias.source
