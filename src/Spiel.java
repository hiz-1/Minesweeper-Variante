import java.util.Random;
import java.util.Scanner;

public class Spiel {
    private String[][] spielfeld;
    private int[][] zahlenFeld;
    private Scanner sc = new Scanner(System.in);
    private Random rand = new Random();

    public Spiel(int zeilen, int spalten) {
        spielfeld = new String[zeilen][spalten];
        zahlenFeld = new int[zeilen][spalten];

        // Initialisiere Spielfeld mit leeren Plätzen
        for (int i = 0; i < zeilen; i++) {
            for (int j = 0; j < spalten; j++) {
                spielfeld[i][j] = "-";
                zahlenFeld[i][j] = 0;
            }
        }
    }

    public void druckeSpielfeld() {
        for (String[] zeile : spielfeld) {
            System.out.println(String.join(" ", zeile));
        }
        System.out.println();
    }

    public void druckeZahlenFeld() {
        for (int[] zeile : zahlenFeld) {
            for (int zahl : zeile) {
                System.out.print(zahl + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void platziereSteine() {
        int row1 = rand.nextInt(spielfeld.length);
        int col1 = rand.nextInt(spielfeld[0].length);
        spielfeld[row1][col1] = "G";

        int row2, col2;
        do {
            row2 = rand.nextInt(spielfeld.length);
            col2 = rand.nextInt(spielfeld[0].length);
        } while (spielfeld[row2][col2].equals("G"));

        spielfeld[row2][col2] = "R";
    }

    public boolean istGueltigePosition(int zeile, int spalte) {
        return zahlenFeld[zeile][spalte] == 0;
    }

    public void setzeNummer(int zeile, int spalte, int zahl) {
        zahlenFeld[zeile][spalte] = zahl;
    }

    public void spielzug() {
        int zeile, spalte;
        do {
            System.out.println("Wähle eine Position für eine Zahl (Zeile Spalte):");
            zeile = sc.nextInt();
            spalte = sc.nextInt();
        } while (!istGueltigePosition(zeile, spalte));

        System.out.println("Welche Zahl möchtest du platzieren?");
        int zahl = sc.nextInt();
        setzeNummer(zeile, spalte, zahl);
        druckeZahlenFeld();
    }

    public boolean istSpielBeendet() {
        for (int[] zeile : zahlenFeld) {
            for (int zahl : zeile) {
                if (zahl == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void bestimmeGewinner(Spieler sp1, Spieler sp2) {
        int sumGrün = 0, sumRot = 0;

        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[0].length; j++) {
                if (spielfeld[i][j].equals("G")) {
                    sumGrün += zahlenFeld[i][j];
                } else if (spielfeld[i][j].equals("R")) {
                    sumRot += zahlenFeld[i][j];
                }
            }
        }

        if (sumGrün > sumRot) {
            System.out.println(sp1.getName() + " gewinnt mit " + sumGrün + " Punkten!");
        } else if (sumRot > sumGrün) {
            System.out.println(sp2.getName() + " gewinnt mit " + sumRot + " Punkten!");
        } else {
            System.out.println("Unentschieden!");
        }
    }
}
