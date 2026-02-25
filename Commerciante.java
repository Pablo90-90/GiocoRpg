import java.util.Scanner;

public class Commerciante {

    private Scanner input = new Scanner(System.in);

    public void apriNegozio(Party party) {
        boolean esci = false;

        while (!esci) {
            System.out.println("\n🛒 Benvenuto dal Commerciante!");
            System.out.println("1) Compra pozione (+1) - 10 oro");
            System.out.println("2) Compra arma (+2 attacco) - 20 oro");
            System.out.println("3) Compra armatura (+2 difesa, +1 armatura) - 20 oro");
            System.out.println("0) Esci");

            int scelta = input.nextInt();
            input.nextLine(); // pulisci buffer

            switch (scelta) {
                case 1 -> compraPozione(party, 10);
                case 2 -> compraArma(party, 20);
                case 3 -> compraArmatura(party, 20);
                case 0 -> esci = true;
                default -> System.out.println("Scelta non valida!");
            }
        }
    }

    private void compraPozione(Party party, int prezzo) {
        if (party.getOro_totale() >= prezzo) {
            party.spendiOro(prezzo);
            for (Eroe e : party.getPartyArray()) {
                if (e != null) e.aumentaPozione(1);
            }
            System.out.println("Acquistata 1 pozione per ogni eroe!");
        } else {
            System.out.println("Non hai abbastanza oro!");
        }
    }

    private void compraArma(Party party, int prezzo) {
        if (party.getOro_totale() >= prezzo) {
            party.spendiOro(prezzo);
            for (Eroe e : party.getPartyArray()) {
                if (e != null) e.setAttacco(e.getAttacco() + 2);
            }
            System.out.println("Attacco aumentato di 2 per ogni eroe!");
        } else {
            System.out.println("Non hai abbastanza oro!");
        }
    }

    private void compraArmatura(Party party, int prezzo) {
        if (party.getOro_totale() >= prezzo) {
            party.spendiOro(prezzo);
            for (Eroe e : party.getPartyArray()) {
                if (e != null) {
                    e.setDifesa(e.getDifesa() + 2);
                    e.setArmatura(e.getArmatura() + 1);
                }
            }
            System.out.println("Difesa e armatura aumentate per ogni eroe!");
        } else {
            System.out.println("Non hai abbastanza oro!");
        }
    }
}
