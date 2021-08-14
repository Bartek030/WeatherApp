package pl.bartlomiej_swies.model.weatherData;

public class WindConditions {
    private final float speed;
    private final int deg;

    public WindConditions(float speed, int deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public float getSpeed() {
        return speed;
    }

    public int getDeg() {
        return deg;
    }
}
