package show;

import javafx.application.Application;
import javafx.stage.Stage;
import screens.ModelAndView;

public class Main extends Application {
     private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Sistema de Cadastro de Pescadores");
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        ModelAndView andView = new ModelAndView();
        andView.screenLogged("screen/authentication/authentication");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
