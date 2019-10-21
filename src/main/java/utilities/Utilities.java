package utilities;

import javafx.scene.image.Image;

public class Utilities {

    public static Image image(String url){
        try {
           return new Image(Utilities.class.getClassLoader().getResourceAsStream(url));
        }catch (Exception e){
            System.out.println("image não existe");
            return null;
        }


    }
}
