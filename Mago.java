public class Mago extends Eroe {

    private int lvlMana = 3;
    private int attaccoMagico = 1;
    private int difesaMagica = 1;

    public Mago(String nome, Sesso sesso) {
        super(nome, sesso,
                80,    // vita base
                10,    // attacco base
                5,     // difesa base
                2      // armatura base
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
