public class Spieler {
    private String stein;
    private int punkte;
    private String name;

    public Spieler(String stein, String name) {
        this.stein = stein;
        this.name = name;
        this.punkte = 0;
    }

    public String getStein() {
        return stein;
    }

    public int getPunkte() {
        return punkte;
    }

    public String getName() {
        return name;
    }

    public void addPunkte(int summe) {
        punkte += summe;
    }
}
