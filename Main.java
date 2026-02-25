import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Dungeon> arrayDungeon = new ArrayList<>();


        Commerciante commerciante = new Commerciante();

        System.out.println("Benvenuto nel mio gioco RPG");
        System.out.println("Regole: ");
        System.out.println("Potrai creare un party di 4 eroi e andare all'avventura");
        System.out.println("Sei pronto a raggiungere le rovine di Lordran");
        System.out.println("Una landa una volta rigogliosa ma oggi casa di mostre e creature");
        System.out.println("Voi eroi avrete il compito di conquistarle e guadagnare una fortuna");

        System.out.println("Iniziamo creando il party");
        System.out.println("Scegli bene loro ti accompagneranno per tutta l'avventura");
        Party party = new Party();
        party.creaParty();
        System.out.println("Ora che hai creato i tuoi eroi");
        System.out.println("Puoi partire all'avventura");
        System.out.println("Ad inizio gioco e dopo ogni dungeon avrai la possibilita di acquistare beni dal commerciante");
        System.out.println("Consiglio : acquista tutto ciò che puoi ti servirà , ai morti i soldi non servono");
        System.out.println("Hai due strade davanti :");
        System.out.println("Andare diretto alle rovine di Lordran ");
        System.out.println("o");
        System.out.println("Esplorare dungeon e potenziarti");
        System.out.println("Sta tutto a voi eroi");
        System.out.println("Buona fortuna ve ne servirà");


        DungeonFinale finale = null;
        do {

            int scelta = 0;

            System.out.println("Benvenuto dal commerciante");
            commerciante.apriNegozio(party);
            System.out.println("Hai affrontato : "+ arrayDungeon.size());
            System.out.println("Vuoi andare alle rovine di Lordran o esplorare dungeon minori");
            System.out.println("Digita 1 per esplorare un dungeon");
            System.out.println("Digita 2 per Rovine di Lordran (Fortemente sconsigliato ad inizio gioco)");
            scelta = input.nextInt();

            switch (scelta) {
                case 1:
                    Dungeon dungeon = new Dungeon();
                    arrayDungeon.add(dungeon);
                    dungeon.avviaDungeon();
                    dungeon.prossimoCombattimento(party);
                    break;
                case 2:

                    finale = new DungeonFinale();
                    finale.avviaDungeon();
                    finale.prossimoCombattimento(party);
                    break;

                default:
                    System.out.println("Scelta non valida");
                    break;

            }

        } while (!party.partyMorto() &&  (finale==null || !finale.DungeonCleared()));

        if (!party.partyMorto()) {
            System.out.println("Complimenti hai ucciso Gwyn e salvato Lordran");
            System.out.println("Fine gioco , grazie per averlo provato");
            System.out.println("Hai completato il gioco affrontando " + arrayDungeon.size()+1);
            System.out.println("Statistiche finali eroi");
            party.partyMorto();
        }else{
            System.out.println("Sei morto");
        }
    }
}