import java.util.ArrayList;
import java.util.Random;

public class DungeonFinale extends Dungeon{

    private ArrayList<Nemico> nemici;
    private final String nome="Rovine di Lordran";
    private final Boss boss=new Boss("Gwyn",400,60,60,40,Sesso.MASCHIO,TipoDanno.FISICO,10,TipoNemico.CAVALIERE,3 , 500);

    public DungeonFinale(){}

    public DungeonFinale(String nome, Boss boss, int ricompensa) {
        super(nome, boss, ricompensa);
        this.nemici = new ArrayList<>();
    }

    @Override
    public void avviaDungeon() {
        Random rand = new Random();
        System.out.println("Benvenuto nel dungeon: " + nome);

        // Genera 10 nemici casuali
        for (int i = 1; i <= 20; i++) {
            int vita = rand.nextInt(21) + 30;        // 30-50
            int attacco = rand.nextInt(6) + 5;       // 5-10
            int difesa = rand.nextInt(4) + 1;        // 1-4
            int armatura = rand.nextInt(3);
            int vitaMax = vita+10;// 0-2
            Sesso sesso = Sesso.values()[rand.nextInt(Sesso.values().length)];
            TipoDanno tipo = TipoDanno.values()[rand.nextInt(TipoDanno.values().length)];
            int atkSemplice = rand.nextInt(6) + 1;   // 1-6
            TipoNemico tipoNemico = TipoNemico.values()[rand.nextInt(TipoNemico.values().length)];
            int expDrop = rand.nextInt(20) + 1;

            Nemico n = new Nemico("Nemico " + i, vita, attacco, difesa, armatura, sesso, tipo, vitaMax , atkSemplice, tipoNemico , expDrop);
            nemici.add(n);
        }

        // Aggiungi il boss
        nemici.add(boss);

        System.out.println("Il dungeon contiene " + (nemici.size() - 1) + " nemici e 1 boss finale.");
        System.out.println("Preparati al combattimento!");
        setRicompensa(10000);
    }

    @Override
    public ArrayList<Nemico> getNemici() {
        return nemici;
    }

    public boolean DungeonCleared() {
        return nemici.isEmpty();
    }
}