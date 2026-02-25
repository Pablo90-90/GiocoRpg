public class Paladino extends Eroe {

    private int potereSanto = 3;

    public Paladino(String nome, Sesso sesso) {
        super(nome, sesso,
                100,   // vita base
                12,    // attacco base
                12,    // difesa base
                6      // armatura base
        );
    }

    @Override
    public int attacca() {
        int danno = getAttacco() + rand.nextInt(6) + 1; // sempre almeno 1
        System.out.println(getNome() + " attacca con " + danno);
        return danno;
    }


    @Override
    public void difendi(int danno) {
        int dannoSubito = Math.max(danno - (getDifesa() + getArmatura()), 1); // sempre almeno 1
        setVita(getVita() - dannoSubito);
        System.out.println(getNome() + " subisce " + dannoSubito + " danni. Vita rimasta: " + getVita());
    }


    @Override
    public void stampaInfo() {}

}
