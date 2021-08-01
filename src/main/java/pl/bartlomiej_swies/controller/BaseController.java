package pl.bartlomiej_swies.controller;

import pl.bartlomiej_swies.view.ViewFactory;

/**
 * Base App controller
 *
 * @author Bartłomiej Święs
 * @see <a href:"https://bartlomiej-swies.pl/" target:"_blank">Author website</a>
 * @version 0.0.1
 *
 * JavaFX version 11
 */
public abstract class BaseController {

    /**
     * View generating object
     *
     * @var ViewFactory
     */
    private ViewFactory viewFactory;

    /**
     * FXML file name
     *
     * @var String
     */
    private String fxmlName;

    /**
     * Class constructor
     *
     * @param viewFactory
     * @param fxmlName
     */
    public BaseController(ViewFactory viewFactory, String fxmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    /**
     * Get the fxml file name
     *
     * @return String - fxml file name
     */
    public String getFxmlName() {
        return fxmlName;
    }

    /**
     * get the generating view object
     *
     * @return ViewFactory
     */
    public ViewFactory getViewFactory() {
        return viewFactory;
    }
}