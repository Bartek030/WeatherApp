package pl.bartlomiej_swies.controller;

import pl.bartlomiej_swies.view.ViewFactory;

public abstract class BaseController {

    private ViewFactory viewFactory;
    private String fxmlName;

    public BaseController(ViewFactory viewFactory, String fxmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }
}