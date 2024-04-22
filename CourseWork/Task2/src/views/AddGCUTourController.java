package views;

import controllers.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddGCUTourController {
    @FXML
    private DatePicker tourDatePicker;
    @FXML
    private TextField tourDurationField;

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
            mainController.addGCUTour(String.valueOf(tourDatePicker.getValue()), Integer.parseInt(tourDurationField.getText()));
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (tourDatePicker.getValue() == null) {
            errorMessage += "No valid tour date!\n";
        }
        if (tourDurationField.getText() == null || tourDurationField.getText().isEmpty()) {
            errorMessage += "No valid tour duration!\n";
        } else {
            try {
                int duration = Integer.parseInt(tourDurationField.getText());
                if (duration <= 0) {
                    errorMessage += "Invalid tour duration! Please enter a positive integer.\n";
                }
            } catch (NumberFormatException e) {
                errorMessage += "Invalid tour duration! Please enter a valid number.\n";
            }
        }

        if (errorMessage.isEmpty()) {
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
