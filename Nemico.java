import java.util.Random;

public class Nemico extends Personaggio {

    private int atkSemplice;
    private TipoNemico tipoNemico;
    private static final Random rand = new Random();
    private int vitaMax;
    private int expDrop;


    public Nemico(String s, int vita, int attacco, int difesa, int armatura, Sesso sesso, TipoDanno tipo, int vitaMax, int atkSemplice, TipoNemico tipoNemico, int expDrop) {
        super("NemicoBase", Sesso.MASCHIO, 50, 5, 3, 1);
        this.expDrop = expDrop;
        this.atkSemplice = 1;
        this.tipoNemico = TipoNemico.BASE;
        this.vitaMax = getVita();
    }

    public Nemico(String nome, int vita, int attacco, int difesa,
                  int armatura, Sesso sesso, TipoDanno tipo,
                  int atkSemplice, TipoNemico tipoNemico, int expDrop) {
        super(nome, sesso, vita, attacco, difesa, armatura);
        this.atkSemplice = Math.max(atkSemplice, 1);
        this.tipoNemico = tipoNemico;
        this.vitaMax = vita;
        this.expDrop = expDrop;
    }

    public int getAtkSemplice() { return atkSemplice; }
    public void setAtkSemplice(int atkSemplice) { this.atkSemplice = Math.max(atkSemplice, 1); }
    public TipoNemico getTipoNemico() { return tipoNemico; }
    public void setTipoNemico(TipoNemico tipoNemico) { this.tipoNemico = tipoNemico; }
    public int getVitaMax() { return vitaMax; }

    @Override
    public int attacca() {
        int moltiplicatore = rand.nextInt(5) + 1; // 1–5
        int danno = atkSemplice * moltiplicatore;
        System.out.println(getNome() + " attacca con danno: " + danno);
        return  danno;
    }

    @Override
    public void difendi(int danno) {
        int dannoSubito = Math.max(danno - (getDifesa() + getArmatura()), 0);
        setVita(getVita() - dannoSubito);
        System.out.println(getNome() + " difende, danno subito: " + dannoSubito + ", vita: " + getVita());
    }

    @Override
    public int azioneTurno() {
        if (getVita() > vitaMax * 0.2) {
            attacca();
        } else {
            System.out.println(getNome() + " si difende!");
            difendi(0); // difesa attiva senza danno esterno
        }
        return 0;
    }

    @Override
    public void stampaInfo() {
        System.out.println("---- Nemico ----");
        System.out.println("Nome: " + getNome());
        System.out.println("Vita: " + getVita());
        System.out.println("Vita max: " + vitaMax);
        System.out.println("Attacco base: " + getAttacco());
        System.out.println("Difesa: " + getDifesa());
        System.out.println("Armatura: " + getArmatura());
        System.out.println("Sesso: " + getSesso());
        System.out.println("Tipo: " + tipoNemico);
        System.out.println("Atk semplice: " + atkSemplice);
    }

    public int getExpDrop() {
        return expDrop;
    }

    public void setExpDrop(int expDrop) {
        this.expDrop = expDrop;
    }
}
