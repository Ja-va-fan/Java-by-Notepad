




# Regular Expressions

This Java-by-Notepad exercise will take a look at regular expressions and what 
can be achieved with those.

A regular expression, regexp, is a serie of characters that define a search 
pattern.
Some exclusive characters has special meaning giving you the opportunity to 
find one or more strings based on what is known.

More on this later on...

##### Additional reading

If you want to dig deep here are some reference and tutorial pages that I have 
used:

* http://www.vogella.com/tutorials/JavaRegularExpressions/article.html
* https://docs.oracle.com/javase/tutorial/essential/regex/index.html
* http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html




## Where can regular expressions be used in Java

There are special classes that takes the magic of regular expressions to the
maximum level and these are Pattern and Matcher. 
But this is not the only place where regexp can be used.
The most commonly used is probably the replaceAll(String, String) and 
split(String) methods that String has.

If we have the string:

	String phrase = "If the mountain will not come to Muhammad, then Muhammad must go to the mountain.";

We can do:

	System.out.println( phrase.replaceAll("mountain", "icecream truck") );

_Please observe that we not really have used regular expressions just yet. 
Also note that since Java String is immutable the original String phrase has 
not be altered._

So if we add another row like this:

	System.out.println( phrase.replaceAll("Muhammad", "Mikael") );

_The mountain is now back and only Muhammad has been changed to Mikael._

If we need to do two replaceAll calls to the same String you could use method
chaining, like this:

	System.out.println( phrase.replaceAll("mountain", "icecream truck").replaceAll("Muhammad", "Mikael") );

The output would be:

	If the icecream truck will not come to Mikael, then Mikael must go to the icecream truck.



### Using the regexp special character . (dot)

In regular expressions the dot (.) has the meaning of any character.