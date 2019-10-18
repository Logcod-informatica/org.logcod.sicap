package controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Associate;
import screens.ModelAndView;

import java.net.URL;
import java.util.ResourceBundle;

public class AssociateFormController <T extends Object> implements Initializable {

    private ModelAndView viewName;
    private TextField name;
    private TextField user;
    private TextField passwd;
    private TextField cpf;
    private TextField rg;

    public void setViewName(ModelAndView viewName) {
        this.viewName = viewName;
    }

    public ModelAndView getViewName() {
        return viewName;
    }

    public Associate editarAssociate(){
       return null;
    }

    public void initialize(URL location, ResourceBundle resources) {

    }
}
