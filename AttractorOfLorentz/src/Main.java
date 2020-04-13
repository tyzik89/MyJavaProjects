import javafx.application.Application;
import javafx.stage.Stage;
import org.opencv.core.Core;
import algorithm.AttractorOfLorentz;

public class Main extends Application {

    static {
        // load the native OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        new AttractorOfLorentz().run();
    }
}
