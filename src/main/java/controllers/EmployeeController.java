package controllers;

import javafx.fxml.Initializable;
import screens.ModelAndView;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {

    private ModelAndView viewName;

    public void setViewName(ModelAndView viewName) {
        this.viewName = viewName;
    }

    public ModelAndView getViewName() {
        return viewName;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
