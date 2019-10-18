package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Employee;
import repository.RepositoryAdmin;
import repository.RepositoryEmployee;
import screens.ModelAndView;

import java.net.URL;
import java.util.ResourceBundle;

public class AuthenticationController implements Initializable {
    @FXML
    private TextField user;
    @FXML
    private PasswordField passwd;
    @FXML
    private ImageView fotoPerfil,key,padlock;

    private ModelAndView viewName;

    public void setViewName(ModelAndView viewName) {
        this.viewName = viewName;
    }

    public ModelAndView getViewName() {
        return viewName;
    }

     RepositoryAdmin repository = new RepositoryAdmin();

    @FXML
    private String logar(ActionEvent event) {
        String logged = repository.administratorLoggedIn(user.getText(),passwd.getText());
        ModelAndView ecreen = new ModelAndView();
        String msg = ecreen.screenHome("screen/home",logged);
        return msg;
    }

    public void imageLogo() {
        try {
            // fotoPerfil.setBlendMode(new Blend().getMode());
            fotoPerfil.setImage(new Image(getClass().getClassLoader().getResourceAsStream("screen/images/avatar.png")));
            key.setImage(new Image(getClass().getClassLoader().getResourceAsStream("screen/images/png/avatar.png")));
            padlock.setImage(new Image(getClass().getClassLoader().getResourceAsStream("screen/images/png/padlock.png")));

        } catch (Exception e) {
            System.out.println("Imagem não encontrada!");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
