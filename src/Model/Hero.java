package Model;

public class Hero {
    public int attack;
    public int defence;
    public String typeOfHero;
    public int HP;

    public Hero(String hero) {
        switch (hero) {
            case "Wizard": {
                this.attack = 6;
                this.defence = 5;
                this.typeOfHero = hero;
            }
            break;
            case "Berserker": {
                this.attack = 9;
                this.defence = 7;
                this.typeOfHero = hero;
            }
            break;
            case "Archer": {
                this.attack = 4;
                this.defence = 6;
                this.typeOfHero = hero;
            }
            break;
            default:
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