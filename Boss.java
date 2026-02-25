import java.util.Random;

public class Boss extends Nemico {

    private final int moltiplicatoreExtra;
    private static final Random rand = new Random();
    private int exp_boss=150;

    public static Boss creaBossCasuale() {
        Random rand = new Random();

        return new Boss(
                GeneratoreNomeBoss.nomeBossCasuale(), // 👈 QUI
                rand.nextInt(51) + 120,
                rand.nextInt(11) + 20,
                rand.nextInt(6) + 8,
                rand.nextInt(5) + 3,
                Sesso.MASCHIO,
                TipoDanno.FISICO,
                rand.nextInt(6) + 5,
                TipoNemico.BOSS,
                rand.nextInt(3) + 2,
                150
        );
    }

    public Boss() {
        super("BossBase",          // nome
                150,                // vita
                25,                 // attacco
                10,                 // difesa
                5,                  // armatura
                Sesso.MASCHIO,      // sesso
                TipoDanno.FISICO,
        5,                  // atkSemplice
                TipoNemico.BOSS,
                150
        );
        this.moltiplicatoreExtra = 2;
    }

    public Boss(String nome, int vita, int attacco, int difesa,
                int armatura, Sesso sesso, TipoDanno tipo,
                int atkSemplice, TipoNemico tipoNemico, int moltiplicatoreExtra , int expDrop) {
        super(nome, vita, attacco, difesa, armatura, sesso, tipo, atkSemplice, tipoNemico , expDrop);
        this.moltiplicatoreExtra = moltiplicatoreExtra;
        this.exp_boss = moltiplicatoreExtra;
    }

    @Override
    public int attacca() {
        int danno = getAttacco() + rand.nextInt(6) + 1; // sempre almeno 1
        System.out.println(getNome() + " attacca con " + danno);
        return danno;
    }


    @Override
    public void difendi(int danno) {
        int riduzione = (getDifesa() + getArmatura()) / 2;
        int dannoSubito = Math.max(danno - riduzione, 1);
        setVita(getVita() - dannoSubito);
        System.out.println(getNome() + " subisce " + dannoSubito + " danni. Vita rimasta: " + getVita());
    }

    @Override
    public void stampaInfo() {
        System.out.println("---- BOSS ----");
        System.out.println("Nome: " + getNome());
        System.out.println("Vita: " + getVita());
        System.out.println("Attacco base: " + getAttacco());
        System.out.println("Difesa: " + getDifesa());
        System.out.println("Armatura: " + getArmatura());
        System.out.println("Sesso: " + getSesso());
        System.out.println("Tipo: " + getTipoNemico());
        System.out.println("Atk semplice: " + getAtkSemplice());
        System.out.println("Moltiplicatore extra: " + moltiplicatoreExtra);
    }

    public int getExp_boss() {
        return exp_boss;
    }

    public void setExp_boss(int exp_boss) {
        this.exp_boss = exp_boss;
    }
}
