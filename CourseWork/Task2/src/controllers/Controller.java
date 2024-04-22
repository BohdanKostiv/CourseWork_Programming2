package controllers;

import app.GCUToursApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Destination;
import model.GCUTour;
import repositories.Repository;
import views.AddGCUTourController;
import views.AddPlaceController;
import views.GCUTourListController;
import views.RootLayoutController;

import java.io.IOException;
import java.util.List;

public class Controller {
    private Stage primaryStage;
    private BorderPane rootLayout;

   public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
   }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GCUToursApp.class.getResource("/views/RootLayout.fxml"));

            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            RootLayoutController rootLayoutController = loader.getController();
            rootLayoutController.setMainController(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public void listGCUTours() {
       ObservableList<GCUTour> GCUTourData = FXCollections.observableArrayList();
       Repository repository = new Repository();
       List<GCUTour> GCUToursList = repository.getGCUTours();
       GCUTourData.setAll(GCUToursList);
       try {
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(GCUToursApp.class.getResource("/views/GCUTourList.fxml"));
           AnchorPane gcuToursView = (AnchorPane) loader.load();

           rootLayout.setCenter(gcuToursView);

           GCUTourListController controller = loader.getController();

       } catch (IOException e) {
            e.printStackTrace();
       }
   }

   public void addGCUTourForm() {
       try {
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(GCUToursApp.class.getResource("/views/AddGCUTour.fxml"));
           AnchorPane page = loader.load();

           Stage dialogStage = new Stage();
           dialogStage.setTitle("Add GCU Tour");
           dialogStage.initModality(Modality.WINDOW_MODAL);
           dialogStage.initOwner(primaryStage);
           Scene scene = new Scene(page);
           dialogStage.setScene(scene);

           AddGCUTourController controller = loader.getController();
           controller.setDialogStage(dialogStage);
           controller.setMainController(this);

           dialogStage.showAndWait();
           listGCUTours();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public void addGCUTour(String tourDate, int tourDuration) {
       GCUTour newTour = new GCUTour(tourDate, tourDuration);
       Repository repository = new Repository();
       repository.addGCUTour(newTour);
   }

   public void addPlaceForm() {
       try {
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(GCUToursApp.class.getResource("/views/AddPlaceVisited.fxml"));
           AnchorPane page = loader.load();

           Stage dialogStage = new Stage();
           dialogStage.setTitle("Add Place Visited");
           dialogStage.initModality(Modality.WINDOW_MODAL);
           dialogStage.initOwner(primaryStage);
           Scene scene = new Scene(page);
           dialogStage.setScene(scene);

           AddPlaceController controller = loader.getController();
           controller.setDialogStage(dialogStage);
           controller.setMainController(this);

           dialogStage.showAndWait();
           listGCUTours();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public void addPlace(String placeName, String country, int GCUTourId) {
       Destination newDestination = new Destination(placeName, country, GCUTourId);
       Repository repository = new Repository();
       repository.addPlace(newDestination);
   }

}
