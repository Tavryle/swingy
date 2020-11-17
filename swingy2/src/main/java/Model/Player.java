package Model;

import java.util.ArrayList;

public class Player {
    public String name;
    public Hero hero;
    public Coordinate coordinate;
    public int level;
    public int xp;
    public ArrayList<String> artifact = new ArrayList<String>();

    public void createPlayer(String name, String heroType){
        Hero store = new Hero(heroType);
        this.name = name;
        this.level = 0;
        this.xp = 500;
        this.hero = store;
    }
    public void destroyEnemy(Villain villain){
        if (villain.artifact.equals("Weapon")){
            this.hero.attack += 4;
            this.xp += 500;
        }
        else if(villain.artifact.equals("Armor")){
            this.hero.defence += 3;
            this.xp += 500;
        }
        else if(villain.artifact.equals("Helm")){
            this.hero.HP += 5;
            this.xp += 500;
        }
        this.artifact.add(villain.artifact);
        this.xp += villain.power;
        villain.power = 0;
        villain.name = "None";
    }
    public String getHero(){
        return this.hero.typeOfHero;
    }
    public void getLocation(){
        System.out.println("Y : " + this.coordinate.y);
        System.out.println("X : " + this.coordinate.x);
    }
}
