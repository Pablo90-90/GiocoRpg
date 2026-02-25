import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Combattimento {

    private Party party;
    private ArrayList<Nemico> nemici;
    private int ricompensa;
    private Scanner input = new Scanner(System.in);
    private Random rand = new Random();
    private int expTotale = 0;

    public Combattimento(Party party, ArrayList<Nemico> nemici, int ricompensa) {
        this.party = party;
        this.nemici = nemici;
        this.ricompensa = ricompensa;
    }

    public Combattimento(Party party, ArrayList<Nemico> nemici) {

    }

    // --- Avvia combattimento completo ---
    public boolean avviaCombattimento() {
        System.out.println("⛔ Inizia il combattimento! ⛔");

        // Stampa iniziale stato
        stampaStato();

        while (!nemici.isEmpty() && !partyMorto()) {

            // --- Turno degli Eroi ---
            System.out.println("\n💪 Turno degli eroi");
            for (Eroe e : party.getPartyArray()) {
                if (e != null && e.isVivo()) {
                    System.out.println("\nTurno di " + e.getNome());

                    // Mostra nemici vivi
                    mostraNemici();

                    System.out.println("Scegli azione: 1-Attacca 2-Difendi 3-Pozione 0-Passa");
                    int scelta = input.nextInt();

                    switch (scelta) {
                        case 1 -> {
                            // Attacca: scegli nemico vivo
                            Nemico bersaglio = scegliNemicoVivo();
                            if (bersaglio != null) {
                                int danno = e.attacca();   // calcola danno
                                bersaglio.difendi(danno);  // applica danno
                            }
                        }
                        case 2 -> System.out.println(e.getNome() + " si prepara a difendere!");
                        case 3 -> e.usaPozione();
                        default -> System.out.println(e.getNome() + " passa il turno.");
                    }
                }
            }

            // --- Turno dei Nemici ---
            turnoNemici();

            // --- Rimuovi morti ---
            rimuoviNemiciMorti();
            rimuoviEroiMorti();

            // --- Stampa stato aggiornato ---
            stampaStato();
        }

        // --- Risultato finale ---
        if (nemici.isEmpty()) {
            System.out.println("🏆 Il tuo party ha vinto il combattimento!");
            ricompensaOro();


        } else {
            System.out.println("💀 Tutti gli eroi sono morti. Game Over!");
        }
        return false;
    }

    private void turnoNemici() {
        System.out.println("\n👹 Turno dei nemici");

        int nemiciCheAttaccano = 0;

        for (Nemico n : nemici) {

            if (!n.isVivo()) continue;

            if (nemiciCheAttaccano >= 4) break; // ⛔ solo i primi 4

            Eroe bersaglio = scegliEroeVivo();
            if (bersaglio != null) {
                int danno = n.attacca();
                System.out.println(n.getNome() + " attacca " + bersaglio.getNome()
                        + " per " + danno + " danni!");
                bersaglio.difendi(danno);
            }

            nemiciCheAttaccano++;
        }
    }

    // --- Sceglie un nemico vivo dall'elenco ---
    private Nemico scegliNemicoVivo() {
        ArrayList<Nemico> vivi = new ArrayList<>();
        for (Nemico n : nemici) {
            if (n.isVivo()) vivi.add(n);
        }
        if (vivi.isEmpty()) return null;

        System.out.println("Seleziona un nemico da attaccare:");
        for (int i = 0; i < vivi.size(); i++) {
            System.out.println(i + ") " + vivi.get(i).getNome() + " HP: " + vivi.get(i).getVita());
        }
        int scelta = input.nextInt();
        if (scelta < 0 || scelta >= vivi.size()) scelta = 0; // default primo nemico
        return vivi.get(scelta);
    }

    // --- Sceglie un eroe vivo casuale ---
    private Eroe scegliEroeVivo() {
        ArrayList<Eroe> vivi = new ArrayList<>();
        for (Eroe e : party.getPartyArray()) {
            if (e != null && e.isVivo()) vivi.add(e);
        }
        if (vivi.isEmpty()) return null;
        return vivi.get(rand.nextInt(vivi.size()));
    }

    // --- Mostra nemici vivi ---
    private void mostraNemici() {
        System.out.println("Nemici vivi:");
        for (int i = 0; i < nemici.size(); i++) {
            Nemico n = nemici.get(i);
            if (n.isVivo()) System.out.println(i + ") " + n.getNome() + " HP: " + n.getVita());
        }
    }

    // --- Controlla se tutti gli eroi sono morti ---
    private boolean partyMorto() {
        for (Eroe e : party.getPartyArray()) {
            if (e != null && e.isVivo()) return false;
        }
        return true;
    }

    private void rimuoviNemiciMorti() {
        for (int i = 0; i < nemici.size(); i++) {
            Nemico n = nemici.get(i);
            if (!n.isVivo()) {
                System.out.println(n.getNome() + " è stato sconfitto!");
                expTotale += n.getExpDrop(); // 👈 SOMMA EXP
                nemici.remove(i);
                i--;
            }
        }
    }


    // --- Rimuove eroi morti dal party ---
    private void rimuoviEroiMorti() {
        for (int i = 0; i < party.getPartyArray().length; i++) {
            Eroe e = party.getPartyArray()[i];
            if (e != null && !e.isVivo()) {
                System.out.println(e.getNome() + " è caduto!");
                party.getPartyArray()[i] = null;
            }
        }
    }

    // --- Distribuisce oro ---
    private void ricompensaOro() {
        System.out.println("Il party guadagna " + ricompensa + " oro!");
        party.guadagnaOro(ricompensa);
    }

    // --- Stampa stato eroi e nemici ---
    private void stampaStato() {
        System.out.println("\n--- Stato attuale ---");
        System.out.println("Eroi:");
        for (Eroe e : party.getPartyArray()) {
            if (e != null) System.out.println(e.getNome() + " HP: " + e.getVita());
        }

        System.out.println("Nemici:");
        for (Nemico n : nemici) {
            if (n.isVivo()) System.out.println(n.getNome() + " HP: " + n.getVita());
        }
        System.out.println("----------------------------");
    }

    public int getExpTotale() {
        return expTotale;
    }

    public void setExpTotale(int expTotale) {
        this.expTotale = expTotale;
    }

    public void prossimoCombattimento(Party party) {
        Combattimento c = new Combattimento(party, nemici);
        boolean vittoria = c.avviaCombattimento();

        if (vittoria) {
            System.out.println("🎁 Ricompensa dungeon: " + ricompensa + " oro!");
            party.guadagnaOro(ricompensa);

            int exp = c.getExpTotale();
            System.out.println("✨ EXP totale ottenuta: " + exp);

            for (Eroe e : party.getPartyArray()) {
                if (e != null && e.isVivo()) {
                    e.guadagnaEsperienza(exp);
                }
            }
        }
    }


}
