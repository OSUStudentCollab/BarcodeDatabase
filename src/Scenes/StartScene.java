package Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 * @author Jeremy
 *
 */
public class StartScene extends GenericBackNextScene
{

    /*
     * All JavaFX control nodes who will need to have handlers. 
     */
    private Button selectFileButton;
    private TextField fileTextField;
    
    public StartScene()
    {
	//TODO: MAKE THIS LOOK PRETTY
	super();
	
	/*
	 * Create VBox where row 0 contains text, row 1 contains file name and entry stuff
	 */
	
	VBox fileInputRoot = new VBox();
	fileInputRoot.setPadding(new Insets(HB_NAV_BUTTONS_PADDING_ALL_DIR));
	/*
	 * Top:
	 */
	Label introLabel = new Label("Please select a .csv file to edit:");
	fileInputRoot.getChildren().add(introLabel);
	
	/*
	 * Bottom half: File stuff
	 */
	Label fileLabel = new Label("File name:");
	fileTextField = new TextField();
	fileTextField.setEditable(false);
	selectFileButton = new Button("Select File");
	
	//Container to store bottom half stuff
	final int columns = 3;
	final int rows = 1;
	TilePane fileContainer = new TilePane();
	fileContainer.setOrientation(Orientation.HORIZONTAL);
	fileContainer.setAlignment(Pos.CENTER);
	fileContainer.setPrefColumns(columns);
	fileContainer.setPrefRows(rows);
	fileContainer.getChildren().addAll(fileLabel, fileTextField, selectFileButton);
	fileInputRoot.getChildren().add(fileContainer);
	
	super.backButton.setVisible(false);
	super.root.setCenter(fileInputRoot);
    }
    
    private void setupStartHandlers()
    {
	selectFileButton.setOnAction(event ->
	{
	    /*
	     * TLDR
	     * 
	     * User uploads/selects a file, 
	     * update fileTextField to match
	     */
	}); 
	
	super.nextButton.setOnAction(event ->
	{
	    /*
	     * TLDR:
	     * IF NO VALID FILE IS SELECTED, POP UP ERROR MSG
	     * 
	     * OTHERWISE CONTINUTE
	     */
	});
	
    }
    

}
