//package src;

import Controller.ConsoleMode;

public class Main {

    public static void main(String[] args) {
        // write your code here
        if(args.length == 1){
            if(args.equals("GUI"))
            {
                //Start Gui
            }
            else if (args[0].equals("Console"))
                ConsoleMode.startingSwingy();
            else
                System.out.println("Choose a PLATFORM between GUI AND CONSOLE");
        }
    }
}