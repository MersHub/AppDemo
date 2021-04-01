package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.animations.Shake;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller<authsSignButton> {


    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button authsSignButton;

    @FXML
    private Button LoginSignUpButton;

    @FXML
     void initialize ()
     {
         authsSignButton.setOnAction(actionEvent -> {
             String loginText = login_field.getText().trim();
             String loginPassword = password_field.getText().trim();

             if(!loginText.equals("") && !loginPassword.equals(""))
                 loginUser(loginText , loginPassword);
             else
                 System.out.println("Login and password is empty");



         });

         LoginSignUpButton.setOnAction(event -> {

             openNewScene("/sample/SignUp.fxml");

         } );
     }

    private void loginUser(String loginText, String loginPassword)
    {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUsername(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        while (true)
        {
            try {
                if (!result.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            counter++;

        }

        if (counter >= 1) {
            openNewScene("/sample/app.fxml");

        }
        else
            {
                Shake userLoginAnim = new Shake (login_field);
                Shake userPassAnim = new Shake(password_field);
                userLoginAnim.playAnim();
                userPassAnim.playAnim();
            }
    }

    public  void openNewScene (String window)
    {
        LoginSignUpButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

}