package Model;

public class player {
    public String name;
    public Hero hero;
    public Coordinate coordinates;
    public int level;
    public int xp;

    public void createPlayer(String name, String herotype){
        Hero store = new Hero(herotype);
        this.name = name;
        this.level = 0;
        this.xp = 500;
        this.hero = store;
    }
    public void destroyEnemy(enemy){
        if (the artifact in enemy .equals("Weapon")){
            this.hero.attack += 4;
            this.xp += 500;
        }
        else if(the artifact in enemy .equals("Armor")){
            this.hero.defence += 3;
            this xp += 500;
        }
        else if(the artifact in enemy .equals("Helm")){
            this.hero.HP += 5;
            this.xp += 500;
        }
    }
}
