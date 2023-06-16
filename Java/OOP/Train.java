public class Train {
    private final String baureihe;
    private final String antriebsart;
    private final int ps;
    private final int hoechstgeschwindigkeit;
    private Waggon hintererWaggon;

    public Train() {
        this.baureihe = "";
        this.antriebsart = "";
        this.ps = 0;
        this.hoechstgeschwindigkeit = 0;
        this.hintererWaggon = null;
    }

    public Train(String baureihe, String antriebsart, int ps, int hoechstgeschwindigkeit) {
        this.baureihe = baureihe;
        this.antriebsart = antriebsart;
        this.ps = ps;
        this.hoechstgeschwindigkeit = hoechstgeschwindigkeit;
        this.hintererWaggon = null;
    }

    public void setHintererWaggon(Waggon waggon) {
        this.hintererWaggon = waggon;
    }


        public String traintoString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Triebwageninformationen:\n");
            sb.append("Baureihe: ").append(baureihe).append("\n");
            sb.append("Antriebsart: ").append(antriebsart).append("\n");
            sb.append("PS: ").append(ps).append("\n");
            sb.append("Höchstgeschwindigkeit: ").append(hoechstgeschwindigkeit).append("\n");

            if (hintererWaggon != null) {
                sb.append("Hinter dem Triebwagen befindet sich ein Waggon.\n");
                sb.append(hintererWaggon.toString()); // Informationen über den hinteren Waggon hinzufügen
            } else {
                sb.append("Hinter dem Triebwagen befindet sich nichts.\n");
            }

            return sb.toString();
        }

        // ...
    }

