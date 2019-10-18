package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import screens.ModelAndView;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private AnchorPane screenHome;

    private ModelAndView viewName;

    public void setViewName(ModelAndView viewName) {
        this.viewName = viewName;
    }

    public ModelAndView getViewName() {
        return viewName;
    }

    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public String logar(MouseEvent event){
        ModelAndView view = new ModelAndView();
        view.screenLogged("screen/authentication/authentication");
        return "ok";
    }
}
