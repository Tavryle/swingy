package Model;

import Controller.Game;

import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class SaveTheGame {
    public static void SaveFile(Player player){
        try{
            FileWriter saveToFile = new FileWriter("swingy.txt");
            saveToFile.write("Player Information: " + "\n");
            saveToFile.write("Player Name: " + player.name + "\n" + "Hero class: " + player.getHero() + "\n");
            saveToFile.write("Level: " + player.level + "\n" + "Xp: " + player.xp + "\n");
            saveToFile.write("Attack: " + player.hero.attack + "\n");
            saveToFile.write("Defence: " + player.hero.defence + "\n");
            saveToFile.close();

        } catch (IOException e) {
            System.out.println("Failed to save game");
        }
    }
    public static void SaveToTheFile(Player player){
        SaveFile(player);
    }
    public static void loadPreviousPlayer(String name){
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            @NotNull(message = "Player Name is needed")
            String line = bufferedReader.readLine();
            if (line == null){
                System.out.println("couldn't load player");
            }
            else{
                ArrayList<String> store = new ArrayList<String>();
                if (line.contains(name)){
                    while (line != null) {
                        int i = line.indexOf("; ");
                        store.add(line.substring(i + 2));
                        line = bufferedReader.readLine();
                    }
                        Iterator<String> cycle = store.iterator();
                        String store2 = cycle.next();
                        Player player = new Player();
                        player.createPlayer(store2, cycle.next());
                        store2 = cycle.next();
                        player.level = Integer.parseInt(store2);

                        store2 = cycle.next();
                        player.xp = Integer.parseInt(store2);

                        store2 = cycle.next();
                        player.hero.attack = Integer.parseInt(store2);

                        store2 = cycle.next();
                        player.hero.defence = Integer.parseInt(store2);
                        Map.newMap(player);
                        Game.movement(player);
                    }
                else
                    System.out.println("couldn't find a user");
                }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("couldnt load");
        }
    }
}
