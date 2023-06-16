public class TrainTest {
    public static void main(String[] args) {
        // Erstelle den Triebwagen
        Train train1 = new Train("412", "elektrisch", 13500, 250);

        // Gib die Informationen über den Zug aus
        Waggon waggon1 = new Waggon(50,24,3,1,true);
        Waggon waggon2 = new Waggon(100,12,64,2,true);
        Waggon waggon3 = new Waggon(100,32,11,2,true);
        Waggon waggon4 = new Waggon(50,17,11,1,true);

        train1.setHintererWaggon(waggon1);
        waggon1.setNaechsterWaggon(waggon2);
        waggon2.setNaechsterWaggon(waggon3);
        waggon3.setNaechsterWaggon(waggon4);


        train1.traintoString();
    }
}