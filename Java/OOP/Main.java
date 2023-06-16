public class Main {


    public static void main(String[] args) {

        Waggon waggon2 = new Waggon(50, 25,3, 1, false);
        Waggon waggon3 = new Waggon(60, 25,3,2, true);
        waggon2.setNaechsterWaggon(waggon3);
        waggon2.printInfo();
        waggon3.printInfo();

        Train train1 = new Train();
        train1.traintoString();

        Train train2 = new Train("ICE 4", "elektrisch", 6000, 320);
        train2.traintoString();

        Waggon waggon = new Waggon(50, 25,3,2, false);
        train2.setHintererWaggon(waggon);
        train2.traintoString();
    }
}
