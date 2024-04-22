package views;

import controllers.Controller;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.GCUTour;

public class GCUTourListController {

    @FXML
    private TableView<GCUTour> tourTable;
    @FXML
    private TableColumn<GCUTour, Integer> tourIdColumn;
    @FXML
    private TableColumn<GCUTour, String> tourDateColumn;
    @FXML
    private TableColumn<GCUTour, Integer> durationColumn;
    @FXML
    private TableColumn<GCUTour, String> destinationsColumn;

    public GCUTourListController(){
    }

    @FXML
    private void initialize() {
        tourIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tourDateColumn.setCellValueFactory(new PropertyValueFactory<>("tourDate"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("tourDuration"));
        destinationsColumn.setCellValueFactory(new PropertyValueFactory<>("destinationsVisited"));
    }

}

