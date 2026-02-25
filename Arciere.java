public class Arciere extends Eroe {

    private int resistenza = 3;

    public Arciere(String nome, Sesso sesso) {
        super(nome, sesso,
                90,    // vita base
                13,    // attacco base
                7,     // difesa base
                3      // armatura base
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
