package controllers;

import javafx.fxml.Initializable;
import screens.ModelAndView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerGenericScreen <T extends Object> implements Initializable {

    private ModelAndView viewName;

    public void setViewName(ModelAndView viewName) {
        this.viewName = viewName;
    }

    public ModelAndView getViewName() {
        return viewName;
    }

    public void initialize(URL location, ResourceBundle resources) {

    }
}
