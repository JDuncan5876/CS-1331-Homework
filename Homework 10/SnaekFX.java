import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Main SnaekFX Application
 *
 * @author Shashank Singh
 * @author Severus Snaek
 * @version 1.0
 */
public class SnaekFX extends Application {

    /**
     * The size of each Snaek cell
     */
    public static final int CELL_SIZE = 24;

    /**
     * The size of the board in cells (GAME_SIZE x GAME_SIZE)
     */
    public static final int GAME_SIZE = 21;

    /**
     * The delay in milliseconds between each movement of the Snaek
     */
    public static final int GAME_DELAY = 100;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Severus Snaek");

        Pane pane = new Pane();
        Scene scene = new Scene(pane, CELL_SIZE * GAME_SIZE,
                CELL_SIZE * GAME_SIZE);

        SnaekController snaekController = new SnaekController(scene, pane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Entry point of the program
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
