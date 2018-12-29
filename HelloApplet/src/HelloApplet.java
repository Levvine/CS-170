package arcade;

import acm.program.*;

public class HelloApplet extends ConsoleProgram {

    public void run() {
        println("What is your name? ");
        String name = readLine();
        println("Hello " + name + "!  It is good to meet you!");
    }
}