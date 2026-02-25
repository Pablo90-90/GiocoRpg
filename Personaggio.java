import java.util.Random;
import java.util.Scanner;

public abstract class Personaggio {

    protected static final Random rand = new Random();
    protected static final Scanner input = new Scanner(System.in);
    private String nome;
    private int vita;
    private int attacco;
    private int difesa;
    private int armatura;
    private Sesso sesso;

    public Personaggio(String nome, Sesso sesso, int vita, int attacco, int difesa, int armatura) {
        this.nome = nome;
        this.sesso = sesso;
        this.vita = vita;
        this.attacco = attacco;
        this.difesa = difesa;
        this.armatura = armatura;
    }

    public void setNome(String nome) { this.nome = nome; }
    public void setSesso(Sesso sesso) { this.sesso = sesso; }
    public void setVita(int vita) { this.vita = Math.max(vita, 0); }
    public void setAttacco(int attacco) { this.attacco = attacco; }
    public void setDifesa(int difesa) { this.difesa = difesa; }
    public void setArmatura(int armatura) { this.armatura = armatura; }

    public String getNome() { return nome; }
    public Sesso getSesso() { return sesso; }
    public int getVita() { return vita; }
    public int getAttacco() { return attacco; }
    public int getDifesa() { return difesa; }
    public int getArmatura() { return armatura; }

    public boolean isVivo() { return vita > 0; }

    public abstract int attacca();

    public abstract void difendi(int danno);

    // --- nuovi metodi astratti ---
    public abstract int azioneTurno();
    public abstract void stampaInfo();
}
