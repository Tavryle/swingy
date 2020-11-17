package Controller;

import Model.Player;
import Model.Villain;

public class Sim {

    public static boolean battle(Player player, Villain villain) {
        if (player.hero.attack >= 6) {
            player.hero.attack -= 6;
            player.destroyEnemy(villain);
        } else if (player.hero.defence >= 6) {
            player.hero.defence -= 6;
            player.destroyEnemy(villain);
        } else if (player.hero.HP > 0) {
            player.hero.HP -= 1;
            player.destroyEnemy(villain);
        } else {
            int store = (int) (Math.random() * 2);
            if (store == 1)
                player.destroyEnemy(villain);
            else
                return false;
        }
        System.out.println("You won the battle but not the war");
        return true;
    }

    public static boolean avoid(Player player, Villain villain){
        if(player.hero.HP > 0){
            player.hero.HP--;
        }
        else{
            int store = (int) (Math.random() * 2);
            if (store == 0){
                System.out.println("Could not avoid the battle");
                if (Sim.battle(player, villain) == false){
                    return false;
                }
            }
        }
        System.out.println("you avoided the battle !");
        return true;
    }
}
