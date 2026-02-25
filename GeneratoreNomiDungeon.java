import java.util.Random;

public class GeneratoreNomiDungeon {

    private static final String[] prefissi = {
            "Dark", "Shadow", "Crimson", "Frost", "Dragon", "Ancient", "Cursed", "Mystic"
    };

    private static final String[] suffissi = {
            "Cave", "Fortress", "Sanctum", "Crypt", "Keep", "Labyrinth", "Tower", "Dungeon"
    };

    private static final Random rand = new Random();

    // Genera un nome casuale combinando prefisso e suffisso
    public static String nomeDungeonCasuale() {
        String prefisso = prefissi[rand.nextInt(prefissi.length)];
        String suffisso = suffissi[rand.nextInt(suffissi.length)];
        return prefisso + " " + suffisso;
    }
}