package show;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import screens.ModelAndView;

public class Main extends Application {
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    protected Image image(String url) {
        try {
            return new Image(getClass().getClassLoader().getResourceAsStream(url));

        } catch (Exception e) {
            return null;
        }

    }

    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.getIcons().add(image("screen/images/png/monitor.png"));
        stage.setTitle("Sistema de Cadastro de Pescadores de Acupe");
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        ModelAndView andView = new ModelAndView();
        andView.screenLogged("screen/authentication/authentication");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
