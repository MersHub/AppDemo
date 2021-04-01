package sample;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imageButtonOk;

    @FXML
    void initialize() {
        assert imageButtonOk != null : "fx:id=\"imageButtonOk\" was not injected: check your FXML file 'app.fxml'.";

    }
}
