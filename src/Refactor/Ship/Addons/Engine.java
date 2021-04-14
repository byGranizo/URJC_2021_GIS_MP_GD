package Refactor.Ship.Addons;

public class Engine {
    private EngineType type;
    private int speed;

    public Engine(EngineType type, int speed) {
        this.type = type;
        this.speed = speed;
    }

    public EngineType getType() {
        return type;
    }

    public void setType(EngineType type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
