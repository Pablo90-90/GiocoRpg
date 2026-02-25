public abstract class Eroe extends Personaggio {

    private int livello = 1;
    private int esperienza = 0;
    private int oro = 0;
    private int n_pozioni = 0;

    public Eroe(String nome, Sesso sesso, int vita, int attacco, int difesa, int armatura) {
        super(nome, sesso, vita, attacco, difesa, armatura);
    }

    public int getLivello() { return livello; }
    public int getEsperienza() { return esperienza; }
    public int getOro() { return oro; }
    public int getN_pozioni() { return n_pozioni; }

    public void guadagnaEsperienza(int exp) {
        esperienza += exp;
        while (esperienza >= 100) {
            esperienza -= 100;
            livello++;
            System.out.println(getNome() + " è salito al livello " + livello + "!");
            aumentaStatistiche();
        }
    }

    private void aumentaStatistiche() {
        setVita(getVita() + 10);
        setAttacco(getAttacco() + 2);
        setDifesa(getDifesa() + 2);
        setArmatura(getArmatura() + 1);
    }

    public void usaPozione() {
        if (n_pozioni > 0) {
            setVita(getVita() + 20);
            n_pozioni--;
            System.out.println(getNome() + " usa una pozione! Vita attuale: " + getVita());
        } else {
            System.out.println(getNome() + " non ha pozioni disponibili!");
        }
    }

    public void aumentaPozione(int num) { n_pozioni += num; }
    public void guadagnaOro(int oro) { this.oro += oro; }
    public void spendiOro(int oro) { this.oro -= oro; }

    @Override
    public abstract int attacca();

    @Override
    public abstract void difendi(int danno);

    @Override
    public int azioneTurno() {
        System.out.println(getNome() + " scegli azione: 1-Attacca 2-Difendi 3-Pozione 0-Passa");
        int scelta = input.nextInt();

        switch (scelta) {
            case 1 -> System.out.println(getNome() + " attacca!");  // Combattimento gestirà il bersaglio
            case 2 -> System.out.println(getNome() + " si prepara a difendere!");
            case 3 -> usaPozione();
            default -> System.out.println(getNome() + " passa il turno.");
        }
        return scelta;
    }
}
