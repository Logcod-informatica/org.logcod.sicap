package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import model.Associate;
import screens.ModelAndView;
import utilities.Utilities;

import java.net.URL;
import java.util.ResourceBundle;

public class AssociateFormController implements Initializable {

    private ModelAndView viewName;
    @FXML
    private ImageView foto;
    @FXML
    private RadioButton cbFeminino, cbMasculino, cbOutros;

    final ToggleGroup grupo = new ToggleGroup();

    public void grupos() {
        cbFeminino.setToggleGroup(grupo);
        cbMasculino.setToggleGroup(grupo);
        cbOutros.setToggleGroup(grupo);

    }

    public void setViewName(ModelAndView viewName) {
        this.viewName = viewName;
    }


    public ModelAndView getViewName() {
        return viewName;
    }

    public Associate editarAssociate(Associate associate) {
        return associate;
    }

    public void initialize(URL location, ResourceBundle resources) {
        foto.setImage(Utilities.image("screen/images/avatar.png"));
        grupos();


    }
}
