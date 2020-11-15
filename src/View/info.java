package View;
import Model.Player;
import Model.Villain;

import java.util.Iterator;

public class info {
    public static void show(Player player){
        System.out.println("Player Info: " + player.name);
        System.out.println("Type of hero: " + player.getHero());
        System.out.println("Level: " + player.level + " " + " XP: " + player.xp);
        System.out.println("Attack: " + player.hero.attack);
        System.out.println("Defence: " + player.hero.defence);

        if (player.artifact.isEmpty() == false){
            Iterator <String> artifactss = player.artifact.iterator();
            System.out.println("Artifact: " );
            while (artifactss.hasNext())
                System.out.println(artifactss.next());
        }
        System.out.println("\n");
    }

    public static void showVillain(Villain villain){
        if(villain.name.equals("None") == false){
            System.out.println("Villain type: " + villain.getName());
            System.out.println("villain attack: " + villain.power);
            System.out.println("villain artifact: " + villain.artifact + "\n");
        }
    }
}
