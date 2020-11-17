package Controller;

import Model.Map;
import Model.Player;
import Model.SaveTheGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.validation.constraints.NotNull;

public class ConsoleMode {
    public static void startingSwingy(){
        clearScreen();

        System.out.println("\n" + " Welcome to the Game Swingy" + "\n\n" + "1. Create New Character " + "\n" +
                "2. Load Character");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            boolean cycle = true;
            while (cycle) {
                String input = bufferedReader.readLine();
                if (input.equals("1")) {
                    while (true) {
                        System.out.println(" What's your name? " + "\n");
                        input = null;

                        input = bufferedReader.readLine();
                        if (input.isEmpty() == false) {
                            if (input.equals("exit") == true) {
                                bufferedReader.close();
                                System.exit(0);
                            }
                            break;
                        }
                    }
                    String nameOfPlayer = input;
                    Player playerObject = new Player();
                    input = null;
                    while (true) {
                        System.out.println("Choose your hero class : " + "\n" + "1. Warlock " + "\n" + "2. Archer"
                                + "\n" + "3. Berserker");
                        input = bufferedReader.readLine();
                        if (input.isEmpty() == false) {
                            if (input.equals("1") || input.equals("2") || input.equals("3")) {
                                break;
                            } else if (input.equals("exit")) {
                                bufferedReader.close();
                                System.exit(0);
                            } else {
                                System.out.println("invalid input");
                            }
                        }
                    }
                    if (input.equals("1")) {
                        playerObject.createPlayer(nameOfPlayer, "Warlock");
                    } else if (input.equals("2")) {
                        playerObject.createPlayer(nameOfPlayer, "Archer");
                    }
                    else if(input.equals("3")){
                        playerObject.createPlayer(nameOfPlayer, "Beserker");
                    }
                    Map.newMap(playerObject);
                    SaveTheGame.SaveToTheFile(playerObject);
                    //while takes in a boolean
                    Game.movement(playerObject);
                    cycle = false;
                }
                else if(input.equals("2")){
                    while(true){
                        System.out.println("What's your name? " + "\n");
                        input = null;
                        input = bufferedReader.readLine();
                        if(input.isEmpty() == false){
                            if (input.equals("exit")){
                                bufferedReader.close();
                                System.exit(0);
                            }
                            break;
                        }
                    }
                    SaveTheGame.loadPreviousPlayer(input);
                    cycle = false;
                }
                else if(input.equals("exit")){
                    cycle = false;
                    System.exit(0);
                }
                else{
                    System.out.println("invalid input");
                }
            }
    } catch (IOException e) {
            System.out.println("input error");
        }
    }
    protected static void clearScreen(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}