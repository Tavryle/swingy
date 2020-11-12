package Model;

public class Hero {
    public int attack;
    public int defence;
    public String typeOfHero;
    public int HP;

    public Hero(String hero) {
        if (hero.equals("Wizard")) {
            this.attack = 6;
            this.defence = 5;
            this.typeOfHero = hero;
        } else if (hero.equals("Archer")) {
            this.attack = 4;
            this.defence = 6;
            this.typeOfHero = hero;
        } else if (hero.equals("Berserker")) {
            this.attack = 9;
            this.defence = 7;
            this.typeOfHero = hero;
        } else {
            System.out.println("The character you picked doesn't exist");
        }
    }

    public void artifact(String artifact) {
        if (artifact.equals("Weapon")) {
            this.attack = attack + 4;
        }
        if (artifact.equals("Armor")) {
            this.defence = defence + 3;
        }
        if (artifact.equals("Helm")) {
            this.HP = HP + 5;
        }
    }
}