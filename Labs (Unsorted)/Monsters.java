public class Monsters {

    private int hitPoints;
    private int attack;
    private int luck;
    private int defense;

    public Monsters(int hitPoints, int strength, int defense, int luck) {

        this.hitPoints = hitPoints;
        this.attack = strength;
        this.luck = luck;
        this.defense = defense;

    }

    public static void battle(Monsters pokemon1, Monsters pokemon2) {
        System.out.println("Ash encounters a Squirtle");
        System.out.println("Squirtle Stats: " + "HP: " + pokemon2.hitPoints + " Attack: " + pokemon2.attack
                + " Defense: " + pokemon2.defense);
        try {
            Thread.sleep(1000);

        }

        catch (InterruptedException ex) {

        }
        System.out.println("Go Charmander!");
        try {
            Thread.sleep(3000);

        }

        catch (InterruptedException ex) {

        }

        if (pokemon1.luck > pokemon2.luck) {
            do {
                if (pokemon1.hitPoints >= 1) {
                    pokemon2.hitPoints = pokemon2.hitPoints - (pokemon1.attack / (pokemon2.defense / 10));

                    System.out.println(
                            "Charmander does " + (pokemon1.attack / (pokemon2.defense / 10)) + " damage to Squirtle");
                    System.out.println("Squirtle has " + pokemon2.hitPoints + " HP left.");

                    try {
                        Thread.sleep(1000);

                    }

                    catch (InterruptedException ex) {

                    }
                    pokemon1.hitPoints = pokemon1.hitPoints - (pokemon2.attack / (pokemon1.defense / 10));

                    System.out.println(
                            "Squirtle does " + (pokemon2.attack / (pokemon1.defense / 10)) + " damage to Charmander");
                    System.out.println("Charmander has " + pokemon1.hitPoints + " HP left.");
                    try {
                        Thread.sleep(1000);

                    }

                    catch (InterruptedException ex) {

                    }
                    if (pokemon1.hitPoints < 1) {
                        System.out.println("Charmander has lost the fight");
                        break;
                    } else if (pokemon2.hitPoints < 1) {
                        System.out.println("Squirtle has lost the fight");
                        break;
                    } else {
                        continue;
                    }
                }
            } while (pokemon1.hitPoints >= 1 || pokemon2.hitPoints >= 1);
        }

    }

    public static void main(String[] args) {
        Monsters Charmander = new Monsters(109, 10, 10, 60);
        Monsters Squirtle = new Monsters(109, 10, 10, 50);
        Monsters.battle(Charmander, Squirtle);

    }
}
