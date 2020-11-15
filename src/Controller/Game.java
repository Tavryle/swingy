package Controller;

import Model.Map;
import Model.Player;
import Model.SaveTheGame;
import Model.Villain;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    public Villain[] createVillains(){
        int number = Map.size / 2;
        Villain[] vill = new Villain[number];
        for(int i = 0; i < vill.length; i++){
            vill[i] = new Villain();
        }
        return vill;
    }

    public void makeCoordinates(Villain[] villain, Player player){
        int y;
        int x;

        for(int i = 0; i < villain.length; i++){
            x = (int) (Math.random() * Map.size);
            villain[i].x = x;
        }
        for(int i = 0; i < villain.length; i++){
            y = (int) (Math.random() * Map.size);
            villain[i].y = y;

            if((villain[i].x == player.coordinate.x) && (villain[i].y == player.coordinate.y)){
                while(villain[i].x == player.coordinate.x){
                    villain[i].x = (int) (Math.random() * Map.size);
                }
            }
        }
    }
    //game movement

    private void north(Player player){
        player.coordinate.y += 1;
    }
    private void south(Player player){
        player.coordinate.y -= 1;
    }
    private void east(Player player){
        player.coordinate.x += 1;
    }
    private void west(Player player){
        player.coordinate.x -= 1;
    }

    public static void movement(Player player){
        Game store = new Game();
        Game object = new Game();
        Villain villList[] = store.createVillains();
        store.makeCoordinates(villList ,player);

        System.out.println("Mover Your Character " + "\n");
        System.out.println("1. Up " + "2. Down " + "3. Left " + "4. Right " + "\n");
        System.out.println("Player's Location " + player.coordinate.x + player.coordinate.y);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String input = bufferedReader.readLine();
            switch (input){
                case "1":{
                    object.north(player);
                }
                break;
                case "2":{
                    object.south(player);
                }
                break;
                case "3":{
                    object.east(player);
                }
                break;
                case "4":{
                    object.west(player);
                }
                break;
                case "info":{
                    info.show(player);
                }
                break;
                case "exit":{
                    System.exit();
                }
                break;
                default:
                    System.out.println("use a valid movement command");
            }
            if(player.coordinate.x >= Map.size || player.coordinate.y >= Map.size){
                player.level += 1000;
                Map.newMap(player);
                villList = store.createVillains();
                store.makeCoordinates(villList, player);
                SaveTheGame.SaveFile(player);
            }
            else if(player.coordinate.x > 0 || player.coordinate.y > 0){
                player.level += 1000;
                Map.newMap(player);
                villList = store.createVillains();
                store.makeCoordinates(villList, player);
                SaveTheGame.SaveFile(player);
            }
            for (int i = 0; i < villList.length; i++){
                if((villList[i].x == player.coordinate.x) && (villList[i].y == player.coordinate.y) &&
                        (villList[i].power > 0)){
                    object.functionOfTheGame(player, villList[i]);
                }
            }
            if (LevelUp.levelUp(player) == true){
                Map.newMap(player);
                villList = store.createVillains();
                store.makeCoordinates(villList, player);
                SaveTheGame.SaveFile(player);
            }
        }catch (IOException e){
            System.out.println("couldn't move the Character");
            e.printStackTrace();
        }
    }

    public void functionOfTheGame(Player player, Villain villain){
        ConsoleMode.clearScreen();
        System.out.println("You found a Villain: " + "\n" + "1. Battle" +"\n" + "2. Avoid" + "\n" + "View Stats before " +
                "the battle");
        System.out.println("Villain class " + villain.name);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try{
            boolean battle = true;
            while (battle){
                String input2 = bufferedReader.readLine();
                switch (input2){
                    case "1":{
                        System.out.println("\n");
                        if (Sim.battle(player, villain) == true){
                            SaveTheGame.SaveFile(player);
                            battle = false;
                        }
                        else{
                            System.out.println("your character got destroyed ");
                            System.exit();
                        }
                    }
                    break;
                    case "2":{
                        if (Sim.avoid(player, villain) == true){
                            SaveTheGame.SaveFile(player);
                            battle = false;
                        }
                    }
                    break;
                    case "info":{
                        info.show(player);
                        info.showVillain(villain);
                        System.out.println("1. Battle" + "\n" + "2. Avoid");
                    }
                    break;
                    case "exit":{
                        System.exit(1);
                    }
                    break;
                    default:
                        System.out.println("could decide to battle or not");
                }
            }
        } catch (IOException e) {
            System.out.println("error with the game");
            e.printStackTrace();
        }
    }
}
