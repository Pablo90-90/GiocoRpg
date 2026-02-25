import java.util.Scanner;

public class Party {

    private Eroe[] partyArray; // array di 4 eroi
    private int oro;
    private Scanner input = new Scanner(System.in);

    public Party() {
        partyArray = new Eroe[4]; // max 4 eroi
        oro = 0;
    }

    // Crea il party con scelta guidata
    public void creaParty() {
        System.out.println("Creazione del party di 4 eroi:");

        for (int i = 0; i < 4; i++) {
            System.out.println("\nSeleziona la classe del tuo eroe " + (i + 1) + ":");
            System.out.println("1) Guerriero");
            System.out.println("2) Mago");
            System.out.println("3) Paladino");
            System.out.println("4) Arciere");

            int sceltaClasse = input.nextInt();
            input.nextLine(); // pulisci buffer

            System.out.println("Inserisci il nome del tuo eroe:");
            String nome = input.nextLine();

            Sesso sesso = null;
            while (sesso == null) {
                System.out.println("Sesso (M/F): ");
                String sessoInput = input.nextLine();
                if (sessoInput.equalsIgnoreCase("M")) {
                    sesso = Sesso.MASCHIO;
                } else if (sessoInput.equalsIgnoreCase("F")) {
                    sesso = Sesso.FEMMINA;
                } else {
                    System.out.println("Inserisci M o F!");
                }
            }

            Eroe eroe = switch (sceltaClasse) {
                case 1 -> new Guerriero(nome, sesso);
                case 2 -> new Mago(nome, sesso);
                case 3 -> new Paladino(nome, sesso);
                case 4 -> new Arciere(nome, sesso);
                default -> {
                    System.out.println("Scelta non valida, assegnato Guerriero di default.");
                    yield new Guerriero(nome, sesso);
                }
            };

            partyArray[i] = eroe;
            System.out.println("Eroe aggiunto: " + nome + " (" + eroe.getClass().getSimpleName() + ")");
        }
    }


        // getter party
        public Eroe[] getPartyArray () {
            return partyArray;
        }

        public int getOro_totale () {
            return oro;
        }

        public void guadagnaOro ( int oroGuadagnato){
            oro += oroGuadagnato;
            System.out.println("Oro totale del party: " + oro);
        }

        public int spendiOro ( int spesa){
            oro -= spesa;
            return oro;
        }

        public boolean partyMorto () {
            for (Eroe e : partyArray) {
                if (e != null && e.isVivo()) return false;
            }
            return true;
        }
}