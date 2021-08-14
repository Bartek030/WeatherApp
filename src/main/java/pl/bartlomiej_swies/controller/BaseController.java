package pl.bartlomiej_swies.controller;

import pl.bartlomiej_swies.view.ViewFactory;

public abstract class BaseController {

    protected final ViewFactory viewFactory;
    private final String fxmlName;

    public BaseController(ViewFactory viewFactory, String fxmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}