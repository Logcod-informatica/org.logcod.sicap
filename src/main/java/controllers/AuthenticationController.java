package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import model.Employee;
import repository.RepositoryAdmin;
import repository.RepositoryEmployee;
import screens.ModelAndView;
import utilities.Utilities;

import java.io.InputStream;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AuthenticationController implements Initializable {
    @FXML
    private TextField user;
    @FXML
    private PasswordField passwd;
    @FXML
    private ImageView fotoPerfil, key, padlock;
    @FXML
    private Label msg;

    private ModelAndView viewName;

    public void setViewName(ModelAndView viewName) {
        this.viewName = viewName;
    }

    public ModelAndView getViewName() {
        return viewName;
    }

    RepositoryAdmin repository = new RepositoryAdmin();

    public TextField getUser() {
        return user;
    }

    public void notLoggedIn(String user) {
        if (Objects.isNull(user))
            msg.setText("Login ou senha invalidos!");
        msg.setTextFill(Paint.valueOf("red"));
    }

    private String msgText = null;

    public String getMsgText() {
        return msgText;
    }

    @FXML
    private String logar(ActionEvent event) {
        String logged = repository.administratorLoggedIn(user.getText(), passwd.getText());
        ModelAndView ecreen = new ModelAndView();
        msgText = ecreen.screenHome("screen/home", logged);
        notLoggedIn(msgText);
        return msgText;
    }




    public void imageLogo() {
        fotoPerfil.setImage(Utilities.image("screen/images/avatar.png"));
        key.setImage(Utilities.image("screen/images/png/avatar.png"));
        padlock.setImage(Utilities.image("screen/images/png/padlock.png"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
