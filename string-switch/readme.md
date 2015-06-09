




# Switch statement using strings

This Java-by-Notepad exercise will take a look at the string switch statement
functionality that was introduced in Dolphin.

The features inclusion into the Java language was requested around 16 years
before it happened with the release of Java 7. The reason for the late 
inclusion was never really given.

Thw functionality works by using string constants in case declarations that 
are expanded at compile time following a pattern and in the end uses JVM 
instructions that was already in place. More about this can be read here:
https://blogs.oracle.com/darcy/entry/project_coin_string_switch_anatomy

More about the compilation of switch statements can be read here: 
http://docs.oracle.com/javase/specs/jvms/se7/html/jvms-3.html#jvms-3.10

# The Exercise

Write a program that can take any number of string arguments representing the 
ten digits in its text form and print out its number form.

e.g. the input "one" should print the output 1, the input "two" should print 2
and so on. The any number of arguments statement dictates that the input "one two"
should give the output 1 and 2. 

Make the ready program a runnable jar using the command line and execute it from 
ẗhe command line with arguments of your chosing.