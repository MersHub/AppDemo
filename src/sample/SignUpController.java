package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField SignUp_country;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField SignUp_lastName;

    @FXML
    private TextField login_field;

    @FXML
    private CheckBox SignUpCheckBox_male;

    @FXML
    private CheckBox SignUpCheckBox_female;

    public SignUpController() {
    }

    @FXML
    void initialize ()
    {


        SignUpButton.setOnAction(actionEvent ->
        {
            signUpNewUser();

        });
    }

    private void signUpNewUser() {

        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstname = signUpName.getText();
        String lastname = SignUp_lastName.getText();
        String username = login_field.getText();
        String password = password_field.getText();
        String location = SignUp_country.getText();
        String gender = "";
        if (SignUpCheckBox_male.isSelected())
            gender = "Мужской";
        else
            gender = "Женский";

        User user = new User (firstname,lastname,username,password,location,gender);


        dbHandler.signUpUser(user);
    }


}
