package pl.bartlomiej_swies.model.auxiliaryMethods;

public interface Connection {

    boolean isUserConnectedToTheInternet();
    String getIpAddress();
}
