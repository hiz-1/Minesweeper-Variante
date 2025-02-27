import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Spielfeldgröße einlesen
        System.out.println("Feldgröße eingeben (Zeilen Spalten): ");
        int zeilen = sc.nextInt();
        int spalten = sc.nextInt();
        sc.nextLine(); // Scanner-Fix nach nextInt()

        Spiel spiel = new Spiel(zeilen, spalten);
        spiel.druckeSpielfeld();

        // Spieler 1 erstellen
        System.out.println("Spieler 1, gib deinen Namen ein:");
        String name1 = sc.nextLine();

        System.out.println("Spieler 1, wähle G (Grün) oder R (Rot):");
        String stein1 = sc.nextLine().toUpperCase();
        Spieler spieler1 = new Spieler(stein1, name1);

        // Spieler 2 bekommt automatisch den anderen Stein
        System.out.println("Spieler 2, gib deinen Namen ein:");
        String name2 = sc.nextLine();
        String stein2 = stein1.equals("G") ? "R" : "G";
        Spieler spieler2 = new Spieler(stein2, name2);

        System.out.println(spieler1.getName() + " spielt mit " + spieler1.getStein());
        System.out.println(spieler2.getName() + " spielt mit " + spieler2.getStein());

        // Spiel starten
        System.out.println("Steine werden platziert...");
        spiel.platziereSteine();
        spiel.druckeSpielfeld();

        while (!spiel.istSpielBeendet()) {
            spiel.spielzug();
        }

        spiel.druckeZahlenFeld();
        spiel.druckeSpielfeld();
        spiel.bestimmeGewinner(spieler1, spieler2);

        sc.close();
    }
}
