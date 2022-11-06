package Zad_30_Samochod;

class Car {
    static final int CAR_IS_STARTED = 100;
    static final int ENGINE_FAILURE = 200;
    static final int LACK_OF_FUEL = 300;
    static final int FUEL_FILLER_FLAP_IS_OPEN = 400;
    static final int DOORS_OR_BOOT_ARE_OPEN = 500;
    private int fuelLevel;
    private boolean isEngineOK;
    private boolean isFuelFillerFlapClosed;
    private boolean areDoorsAndBootClosed;
    private boolean isEngineStarted;



    public Car(int fuelLevel, boolean isEngineOK, boolean isFuelFillerFlapClosed, boolean areDoorsAndBootClosed) {
        this.fuelLevel = fuelLevel;
        this.isEngineOK = isEngineOK;
        this.isFuelFillerFlapClosed = isFuelFillerFlapClosed;
        this.areDoorsAndBootClosed = areDoorsAndBootClosed;
    }

    int start() {
        setEngineStatus();
        return getCode(isEngineStarted);
    }

    private int getCode(boolean isEngineStarted) {
        if (isEngineStarted) {
            return getCodeWhenCarIsStarted();
        } else {
            return getCodeWhenCarIsNotStarted();
        }
    }

    private void setEngineStatus() {
        this.isEngineStarted = checkEngineStatus();
    }

    private boolean checkEngineStatus() {
        return isEngineOK && fuelLevel > 0;
    }

    private int getCodeWhenCarIsNotStarted() {
        if (!isEngineOK) {
            return ENGINE_FAILURE;
        } else if (fuelLevel == 0) {
            return LACK_OF_FUEL;
        }
        return 0;
    }

    private int getCodeWhenCarIsStarted() {
        if (!areDoorsAndBootClosed) {
            return DOORS_OR_BOOT_ARE_OPEN;
        } else if (!isFuelFillerFlapClosed) {
            return FUEL_FILLER_FLAP_IS_OPEN;
        }
        return CAR_IS_STARTED;
    }

    String status() {
        String status = "";
        if (isEngineOK && fuelLevel > 0 && isFuelFillerFlapClosed && areDoorsAndBootClosed) {
            status += "Wszystkie systemy sprawne, mo¿esz wyruszyæ w bezpieczn¹ podró¿.";
        } else {
            status += "Wykryte usterki:\n";
            if (!isEngineOK) status += "- zepsuty silnik\n";
            if (fuelLevel == 0) status += "- brak paliwa\n";
            if (!isFuelFillerFlapClosed) status += "- otwarta klapa wlewu paliwa\n";
            if (!areDoorsAndBootClosed) status += "- otwarte drzwi lub baga¿nik\n";
        }
        return status;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public boolean isEngineOK() {
        return isEngineOK;
    }

    public void setEngineOK(boolean engineOK) {
        isEngineOK = engineOK;
    }

    public boolean isFuelFillerFlapClosed() {
        return isFuelFillerFlapClosed;
    }

    public void setFuelFillerFlapClosed(boolean fuelFillerFlapClosed) {
        isFuelFillerFlapClosed = fuelFillerFlapClosed;
    }

    public boolean isAreDoorsAndBootClosed() {
        return areDoorsAndBootClosed;
    }

    public void setAreDoorsAndBootClosed(boolean areDoorsAndBootClosed) {
        this.areDoorsAndBootClosed = areDoorsAndBootClosed;
    }

    public boolean isEngineStarted() {
        return isEngineStarted;
    }

    public void setEngineStarted(boolean engineStarted) {
        isEngineStarted = engineStarted;
    }
}
