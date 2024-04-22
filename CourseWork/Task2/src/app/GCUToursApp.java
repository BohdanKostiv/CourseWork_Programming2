package app;

import controllers.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Application Class
 *
 * @author Martin Gallacher
 * @author Bobby Law
 */
public class GCUToursApp extends Application {
    private Stage primaryStage;

   @Override
   public void start(Stage primaryStage) {
      this.primaryStage = primaryStage;
      this.primaryStage.setTitle("GCU Tours App");
      Controller controller = new Controller(primaryStage);
      controller.initRootLayout();
   }

    /**
     * Starts the application by invoking the class method run
     *
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }
}

