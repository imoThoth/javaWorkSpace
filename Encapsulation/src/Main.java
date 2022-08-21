public class Main {

    public static void main(String[] args) {

        Player player = new Player();
        player.name = "Tim"; //changing player.name to player.firstName would break the code
        player.health = 20; //local variable name changed in main class will have to be changed in player class
        player.weapon = "Sword";

        int damage = 10;
        // player is able to cheat
        player.loseHealth(damage);
        System.out.println("Remaining health " + player.healthRemaining());

        damage++;
        player.loseHealth(damage);
        System.out.println("Remaning health " + player.healthRemaining());
    }
}
