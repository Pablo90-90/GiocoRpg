import java.util.ArrayList;
import java.util.Random;

public class Dungeon {

    private String nome;
    private ArrayList<Nemico> nemici;
    private Boss boss;
    private int ricompensa;

    public Dungeon() {}

    public Dungeon(String nome, Boss boss, int ricompensa) {
        this.nome = nome;
        this.boss = boss;
        this.ricompensa = ricompensa;
        this.nemici = new ArrayList<>();
        avviaDungeon();
    }

    public void avviaDungeon() {
        Random rand = new Random();
        GeneratoreNomiDungeon gen = new GeneratoreNomiDungeon();

        nemici = new ArrayList<>();

        System.out.println("Benvenuto nel dungeon: " + gen.nomeDungeonCasuale());

        // Nemici normali
        for (int i = 1; i <= 2; i++) {
            int vita = rand.nextInt(21) + 30;
            int attacco = rand.nextInt(6) + 5;
            int difesa = rand.nextInt(4) + 1;
            int armatura = rand.nextInt(3);

            Sesso sesso = Sesso.values()[rand.nextInt(Sesso.values().length)];
            TipoDanno tipo = TipoDanno.values()[rand.nextInt(TipoDanno.values().length)];
            int atkSemplice = rand.nextInt(6) + 1;

            Nemico n = new Nemico(
                    "Nemico " + i,
                    vita,
                    attacco,
                    difesa,
                    armatura,
                    sesso,
                    tipo,
                    atkSemplice,
                    TipoNemico.BASE,
                    120
            );
            nemici.add(n);
        }

        // Boss finale → crea PRIMA di usarlo
        boss = Boss.creaBossCasuale();
        nemici.add(boss);

        System.out.println("Il dungeon contiene " + (nemici.size() - 1) + " nemici e 1 boss finale.");
        System.out.println("Preparati al combattimento!");

        // Ricompensa casuale
        ricompensa = rand.nextInt(30) + 5;
    }

    public void prossimoCombattimento(Party party) {
        Combattimento c = new Combattimento(party, nemici, ricompensa);
        c.avviaCombattimento();
    }

    public ArrayList<Nemico> getNemici() {
        return nemici;
    }

    public int getRicompensa() {
        return ricompensa;
    }

    public void setRicompensa(int ricompensa) {
        this.ricompensa = ricompensa;
    }
}
