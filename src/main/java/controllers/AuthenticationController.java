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
     private ImageView fotoPerfil;

     private ModelAndView viewName;

    public void setViewName(ModelAndView viewName) {
        this.viewName = viewName;
    }

    public ModelAndView getViewName() {
        return viewName;
    }
  //  RepositoryEmployee repositoryEmployee = new RepositoryEmployee();
    @FXML
     private String logar(ActionEvent event){
         String logged = "screen/home";
        // String employee = repositoryEmployee.employeeLogged(user.getText());
         return "screen/home";
     }
     public void imageLogo(){
         try{
            // fotoPerfil.setBlendMode(new Blend().getMode());
             fotoPerfil.setImage(new Image(getClass().getClassLoader().getResourceAsStream("screen/images/avatar.png")));
         }catch (Exception e){
             System.out.println("Imagem não encontrada!");
         }
     }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

         }
}
