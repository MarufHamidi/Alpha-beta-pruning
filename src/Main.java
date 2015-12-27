
import java.io.InputStream;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * @author maruf
 */
public class Main extends Application {

    public static Stage stage;
    public static TicTacToeGUIController guiController;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        stage = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream("TicTacToeGUI.fxml");
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource("TicTacToeGUI.fxml"));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }

        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(1);
            }
        });

        stage.show();
        
        guiController = loader.getController();
        guiController.setApp(this);
        
        State initial = new State(null, State.Player.MAX);
        initial = initial.result(initial.alphaBetaSearch());
        guiController.loadState(initial);
        
    }

    public static void main(String[] args) throws Exception {  
        launch(args);
    }
}