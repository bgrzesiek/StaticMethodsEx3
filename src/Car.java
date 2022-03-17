public class Car {
    public static int START_ENGINE = 100;
    public static int ERROR_CHECK_ENGINE = 200;
    public static int FUEL_EMPTY = 300;
    public static int FLAP_OF_FUEL_IS_OPEN = 400;
    public static int DOOR_OF_TRUNK_ARE_OPEN = 500;

    private double fuelLevel;
    private boolean isEngineOK;
    private boolean fuelFlapOpen;
    private boolean areDoorOfTrunkColsed;
    private boolean engineON;

    public Car(double fuelLevel, boolean isEngineOK, boolean fuelFlaOpen, boolean areDoorOfTrunkColsed, boolean EngineON) {
        this.fuelLevel = fuelLevel;
        this.isEngineOK = isEngineOK;
        this.fuelFlapOpen = fuelFlaOpen;
        this.areDoorOfTrunkColsed = areDoorOfTrunkColsed;
        this.engineON = EngineON;
    }

    int start() {
        int systemCheck = systemCheck();
        setEngineON(true);
        return systemCheck;
    }

    private int systemCheck() {
        if (!isEngineOK)
            return ERROR_CHECK_ENGINE;
        if (fuelLevel <= 0)
            return FUEL_EMPTY;
        if (fuelFlapOpen)
            return FLAP_OF_FUEL_IS_OPEN;
        if (areDoorOfTrunkColsed)
            return DOOR_OF_TRUNK_ARE_OPEN;
        return START_ENGINE;
    }

    String status(){
        if (systemCheck() == START_ENGINE)
            return "Wszystkie systemy sprawne, możesz wyruszyć w podróż.";
        String status = "Status samochodu: \n";
       if (!engineON)
           status += " > Silnik uszkodzony\n";
       if (fuelLevel <=0)
           status += " > Brak paliwa\n";
       if (fuelFlapOpen)
           status += " > Zamknij wlew paliwa\n";
       if (areDoorOfTrunkColsed)
           status += " > Drzwi lub bagażnik są otwarte\n";
       if (engineON)
           status += " > Silnik włączony";
       else
           status += " > Silnik wyłączony";
       return status;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        if (fuelLevel<=0){
            engineON =false;
        }
        this.fuelLevel = fuelLevel;
    }

    public boolean isEngineOK() {
        return isEngineOK;
    }

    public void setEngineOK(boolean engineOK) {
        if (!engineOK)
            engineON =false;

        isEngineOK = engineOK;
    }

    public boolean FuelFlapOpen() {
        return fuelFlapOpen;
    }

    public void setFuelFlaOpen(boolean fuelFlapOpen) {
        this.fuelFlapOpen = fuelFlapOpen;
    }

    public boolean isAreDoorOfTrunkColsed() {
        return areDoorOfTrunkColsed;
    }

    public void setAreDoorOfTrunkColsed(boolean areDoorOfTrunkColsed) {
        this.areDoorOfTrunkColsed = areDoorOfTrunkColsed;
    }

    public boolean isEngineON() {
        return engineON;
    }

    public void setEngineON(boolean engineON) {
        int systemCheck = systemCheck();
        if (systemCheck == ERROR_CHECK_ENGINE || systemCheck == FUEL_EMPTY) {
            engineON = false;
        } else {
            this.engineON = engineON;
        }
    }
}

