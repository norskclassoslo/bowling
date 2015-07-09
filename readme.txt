** How to exectue the program
Build the program using maven and then run
java -classpath /path/to/kata-1.0-SNAPSHOT.jar com.saif.App

Alternatively, run the jar file provided in the dist directory.
java -jar dist/kata-1.0-SNAPSHOT.jar

** input and output

Input should be a string cosisting of these characters; digit, /, -, and X.
A valid string will be something like this pattern (([1-9-][1-9/-])|X)+

The program expects a series of valid rolls of a Ten-Pin Bowling. 
For example, XXXXXXXXXXXX. A valid subsequence of a complete game will show partial result.

The output will be as follows
Score is <number>

** Example
java -jar kata-1.0-SNAPSHOT.jar 
Enter sequence of rolls (for example, X2/3-):X2/3-
Score is 36

