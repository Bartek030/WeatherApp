package pl.bartlomiej_swies.model.weatherData;

public class WindConditions {
    private float speed;
    private int deg;

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
