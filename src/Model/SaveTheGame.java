package Model;

import java.io.FileWriter;
import java.io.IOException;

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
}
