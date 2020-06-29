
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * 
 * @author Jeremy
 *
 */
public class AlertWindow
{
    
    //Private utility class so it can't be instantiated
    private AlertWindow()
    {
	
    }
    /**
     * Displays a new alert pop-up window.
     *
     * @param title The title of the window
     * @param message Intended message for user to read
     * @return 
     */
    public void display(String title, String message)
    {
	Stage alertStage = new Stage();
	
	//Make it so that when this stage appears, this one has priority and doesn't allow interaction with others
	alertStage.initModality(Modality.APPLICATION_MODAL);
	alertStage.setTitle(title);
	alertStage.setMinWidth(300);
	alertStage.setMinHeight(150);
	alertStage.setAlwaysOnTop(true);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(1));

        //Creates the message to be displayed
        Label messageLabel = new Label(message);

        //Creates Button object to close out of window
        Button okayButton = new Button("Okay");
        okayButton.setOnAction(event ->
        {
            alertStage.close();
        });

        //Adds and displays message and okayButton in the window.
        gridPane.getChildren().addAll(messageLabel, okayButton);
        GridPane.setConstraints(messageLabel, 0,0);
        GridPane.setConstraints(okayButton, 1,1);

        alertStage.setScene(new Scene(gridPane));
        alertStage.showAndWait(); //Display and force user to close
    }
}
