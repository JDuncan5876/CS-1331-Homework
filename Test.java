import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;

public class Test extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane p = new BorderPane();
        p.setRight(new Circle(50));
        p.setCenter(new Circle(100));
        Scene s = new Scene(p, 300, 300);
        primaryStage.setScene(s);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}