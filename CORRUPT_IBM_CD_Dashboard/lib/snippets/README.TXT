These are the Rational Team Concert plain java client example snippets. They show you 
how to call the java client libraries from a regular java program.

WHAT IS JAZZ AND TEAM CONCERT

See http://jazz.net for all the information relating to Rational Team Concert and Jazz based products.
The Rational Team Concert SDK can be found at https://jazz.net/wiki/bin/view/Main/RtcSdk20.

SETUP

If you have these snippets it's because you've downloaded the client libraries. To run the
snippets you'll also need a Jazz server that is running and on which you have administrative
permissions. See jazz.net for instructions on installing the simple all-in-one Jazz server.

Once the server is running you'll have to add a test user that the snippets will use:

1. Create a new user with a user id of 'test' and password 'test' (the password defaults 
to 'test' so you should not need to explicity set it).
2. Assign the JazzAdmin permission to the new user and grant him the developer license. 

HOW TO COMPILE THE SNIPPETS

Jazz requires a 1.6 compatible Java installation. Once that is available, simply run javac as follows:

$ cd <location of the unzipped client library examples> 
$ javac -extdirs . snippets/*.java

HOW TO RUN THE SNIPPETS

Start the Jazz server and don't forget to add the test user as mentioned above. The examples assume 
that the default URL for the server is being used which is https://localhost:9443/jazz. Since there 
are several jar files which are part of the client library, the simplest mechanism to add them to
the external libraries classpath. 

$ java -Djava.ext.dirs=<location of your VMs ext dir>:snippets:. snippets.Snippet1

or an example is

$ java -Djava.ext.dirs=/home/jm/6.0sr10/jre/lib/ext:snippets:. snippets.Snippet1

Note: On Linux the java.ext.dirs separator is ':' and on Windows it's ';'.

GETTING THE SOURCE

The source for the Rational Team Concert client libraries can be downloaded from the jazz.net
downloads page. You'll find the source for Rational Team Concert at the end of the 
"All Downloads" section of https://jazz.net/downloads/rational-team-concert/.
