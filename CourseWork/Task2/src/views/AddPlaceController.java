package views;

import controllers.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPlaceController {
    @FXML
    private TextField placeIdField;
    @FXML
    private TextField placeNameField;
    @FXML
    private TextField countryField;

    private Stage dialogStage;

    private Controller mainController;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            mainController.addPlace(placeNameField.getText(), countryField.getText(), Integer.parseInt(placeIdField.getText()));
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (placeIdField.getText() == null || placeIdField.getText().length() == 0) {
            errorMessage += "No valid place ID!\n";
        }
        if (placeNameField.getText() == null || placeNameField.getText().length() == 0) {
            errorMessage += "No valid place name!\n";
        }
        if (countryField.getText() == null || countryField.getText().length() == 0) {
            errorMessage += "No valid country!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }

    }
    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }
}
