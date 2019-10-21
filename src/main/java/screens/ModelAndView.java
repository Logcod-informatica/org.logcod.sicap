package screens;

import controllers.AssociateFormController;
import controllers.AuthenticationController;
import controllers.HomeController;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import show.Main;

import java.awt.*;
import java.io.InputStream;
import java.util.Objects;

public class ModelAndView {

    public String screenHome(String page, String logado) {
        System.out.println( "Log-> "+logado);
        if (Objects.nonNull(logado) && !logado.equals("user-not-logged-in")) {
            HomeController homeController = (HomeController) screen(page);
            homeController.setViewName(this);
            Dimension d = screenSize();
            Main.getStage().setHeight(d.height);
            Main.getStage().setWidth(d.width);

            return "successfully";
        } else {

            return null;
        }
    }

    public Dimension screenSize() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        return dimension;
    }

    public void screenLogged(String page) {
        AuthenticationController authenticationController = (AuthenticationController) screen(page);
        authenticationController.setViewName(this);
        authenticationController.imageLogo();

    }

    public void screenFormAssociate(String page) {
        AssociateFormController associateFormController = (AssociateFormController) screen(page);
        associateFormController.setViewName(this);
      //  if (Objects.nonNull(associateFormController.editarAssociate())) ;
    }

    private ModelAndView viewName;

    public void setViewName(ModelAndView viewName) {
        this.viewName = viewName;
    }

    public ModelAndView getViewName() {
        return viewName;
    }

    private Initializable screen(String page) {
        try {
            FXMLLoader loader = new FXMLLoader();
            InputStream stream = getClass().getClassLoader().getResourceAsStream(page + ".fxml");
            loader.setBuilderFactory(new JavaFXBuilderFactory());
            loader.setLocation(getClass().getClassLoader().getResource(page));
            AnchorPane anchorPane = (AnchorPane) loader.load(stream);
            stream.close();
            Scene scene = new Scene(anchorPane);

            Main.getStage().setScene(scene); // executa controller de telas
            return (Initializable) loader.getController();
        } catch (Exception e) {
            System.out.println("Pagina solicitada não encontrada! " + e.fillInStackTrace());
            return null;
        }
    }


}
