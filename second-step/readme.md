




# Second Steps into Java by Notepad

This time we are going to structure our files a bit more than before.
Not to invent something new we are going to use the Maven default structure:

	src
	├── main
	|   └── java
	|		  └── packages
	|				└── java source files

This will result in a very deep folder structure but we will benefit from this in the long run.

We are also going to use more than one java files to get a hang on how to manage that.




## Make the Main.java file in package com.domain.main

Create the folder structure com/domain/main from the src/main/java folder.

	mkdir -p src/main/java/com/domain/main

_The -p switch make sure any non existing folders are created as well._

Enter this in the file src/main/java/com/domain/main/Main.java

```java
	package com.domain.main;

	import com.domain.message.Message;

	public class Main {
		public static void main(String... args) {
			if (args.length > 0) {
				System.out.println(new Message(String.join(" ", args)).getMessage());
			} else {
				System.out.println(new Message(null).getMessage());
			}
		}
	}
```

_This class imports the class Message which is in another package thus cannot be imported by the current package auto import rule._




## Make the Message.java file in the com.domain.package package

Create the folder structure com/domain/message from the folder src/main/java

	mkdir -p src/main/java/com/domain/message

Enter this in the file src/main/java/com/domain/message/Message.java

	package com.domain.message;

```java
	public class Message {
		String message = "It is really working!";
		public Message(String message) {
			if (message != null) {
				this.message = message;
			}
		}
		public String getMessage() {
			return message;
		}
	}
```

_We do not need to import anything to this class.
The java.lang package is automatically imported to any class and that contains the needed String class._




## Compile the classes with javac

We now have a new complexity, not only do we have two classes we also have a src directory and packages.
To compile this we need to use the `-sourcepath src/main/java` switch argument to specify the source directory.
We also use the `-d target/classes` to structure the path where the class-files will be created.

	javac -d target/classes -sourcepath /src/main/java src/main/java/com/domain/main/Main.java

> note: target/classes folder must exist.

_By entering `-sourcepath src/main/java` the compiler automatically compiles the Message.java file since it is needed by Main.java._




## Run the compiled classes

We now have compiled the classes needed and can run those.
However the java virtual machine has to know where to find all classes that is part of the application.

Therefore we need to use the `-cp target/classes` switch to point out where the classes reside.

	java -cp target/classes com/domain/main/Main




## Build a runnable jar

One really neat feature with a jar is that it can be made runnable.
This means that the jar contains all that is needed to run the application and can be started as easy as this:

	java -jar theNameOfThe.jar

To make such a jar we need to tell the jar packaging utility which class should be used when the jar is started.
This can be done in two ways: either you can make a manifest file and state the Main-Class in that or by using the e switch from the command line.
We are going to use the latter version.

	jar cfe Main.jar com/domain/main/Main -C target/classes com

_The cfe switches means c=create, f=jar filename, e=entrypoint class. The -C switch points out a path that the jar utility will cd into prior to add the files._

The result of the above is a jar file called `Main.jar` which contains all files below the target/classes/com directory.
The jar utility also add the META-INF directory that contains the MANIFEST.MF file.




## The alias.source file makes compiling and running easier

By sourcing the file alias.source we can use the commands compile, run and makejar to easily package, compile and run the application.

	source alias.source

This command reads in the settings in alias.source.



### Run with the run command

By issuing the `run` command the java files are compiled and then run.

	run

Compile without running with this command

	compile

Make a runnable jar this easy:

	makejar

The jar can then be run by:

	java -jar Main.jar
