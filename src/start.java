public class start {
    public static void main(String[] args) {

        Car car = new Car(10, true, false, false, true);
        System.out.println("Uruchomienie samochodu z paliwem, sprawnym silnikiem i wszystkim zamkniętym");
        car.start();
        System.out.println(car.status());

        car.setAreDoorOfTrunkColsed(true);
        System.out.println(car.status());

        System.out.println("Kończy się paliwo");
        car.setFuelLevel(0);
        System.out.println(car.status());
    }
}
