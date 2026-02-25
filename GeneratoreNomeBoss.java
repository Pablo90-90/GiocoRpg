import java.util.Random;

public class GeneratoreNomeBoss {

        private static final String[] NOMI = {
                "Gwyn", "Drakor", "Malakar", "Zeroth", "Valthor", "Oblivion"
        };

        private static final Random rand = new Random();

        public static String nomeBossCasuale() {
                return NOMI[rand.nextInt(NOMI.length)];
        }
}
