public class Guerriero extends Eroe {

    private int bonusAlto = 1;

    public Guerriero(String nome, Sesso sesso) {
        super(nome, sesso,
                120,   // vita base
                15,    // attacco base
                10,    // difesa base
                5      // armatura base
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
    public void stampaInfo() {

    }
}
