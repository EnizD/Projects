import java.util.Random;

public class Waggon {
    private int gesamtSitzplaetze;
    private int reservierteSitzplaetze;
    private int freieSitzplaetze;

    private int klasse;

    private boolean istDoppelstock;

    private String toiletteStatus;
    private Waggon naechsterWaggon;

    public Waggon() {
        this.gesamtSitzplaetze = 0;
        this.reservierteSitzplaetze = 0;
        this.freieSitzplaetze = 0;
        this.klasse = 1;
        this.istDoppelstock = false;
        this.naechsterWaggon = null;

        Random rand = new Random();

        int n = rand.nextInt(10);

        if (n == 7 || n == 8) {
            this.toiletteStatus = "WC besetzt";
        } else if (n == 9) {
            this.toiletteStatus = "WC defekt";
        } else {
            this.toiletteStatus = "WC frei";
        }

    }

    public Waggon(int gesamtSitzplaetze,
                  int reservierteSitzplaetze,
                  int freieSitzplaetze,
                  int klasse,
                  boolean istDoppelstock) {
        if (gesamtSitzplaetze <= 0 || klasse < 1 || klasse > 2 || gesamtSitzplaetze < reservierteSitzplaetze || gesamtSitzplaetze < freieSitzplaetze) {
            throw new IllegalArgumentException("Ungültige Parameter für den Waggon.");
        }

        this.gesamtSitzplaetze = gesamtSitzplaetze;
        this.klasse = klasse;
        this.istDoppelstock = istDoppelstock;
        this.reservierteSitzplaetze = reservierteSitzplaetze;
        this.freieSitzplaetze = freieSitzplaetze;
        this.naechsterWaggon = null;

        Random rand = new Random();

        int n = rand.nextInt(10);

        if (n == 7 || n == 8) {
            this.toiletteStatus = "WC besetzt";
        } else if (n == 9) {
            this.toiletteStatus = "WC defekt";
        } else {
            this.toiletteStatus = "WC frei";
        }

    }

    public void setNaechsterWaggon(Waggon naechsterWaggon) {
        this.naechsterWaggon = naechsterWaggon;
    }

    public void printInfo() {
        System.out.println("Waggoninformationen:");
        System.out.println("Klasse: " + klasse);
        System.out.println("Gesamtanzahl Sitzplätze: " + gesamtSitzplaetze);
        System.out.println("Freie Sitzplätze: " + freieSitzplaetze);
        System.out.println("Reservierte Sitzplätze: " + reservierteSitzplaetze);
        System.out.println("Doppelstockwagen: " + istDoppelstock);
        System.out.println("Toilette-Status: " + toiletteStatus);

        if (naechsterWaggon != null) {
            System.out.println("Hinter diesem Waggon befindet sich ein weiterer Waggon.");
        } else {
            System.out.println("Hinter diesem Waggon befindet sich nichts.");
        }
    }
}

