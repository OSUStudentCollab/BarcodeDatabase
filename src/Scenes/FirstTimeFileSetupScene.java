package Scenes;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * @author Jeremy
 *
 */
public class FirstTimeFileSetupScene extends GenericBackNextScene
{


    private final TextField inCategoriesTextField;
    private final Button rightArrowButton, leftArrowButton;
    private final TableView<String> categoryTable;
    
    public FirstTimeFileSetupScene()
    {
	super();
	
	/*
	 * Items on the left side
	 */
	inCategoriesTextField = new TextField();
	inCategoriesTextField.setPromptText("Add category here");
	super.root.setLeft(inCategoriesTextField);
	
	/*
	 * Center buttons
	 */
	VBox arrowButtons = new VBox();
	rightArrowButton = new Button("-->");
	leftArrowButton = new Button("<--");
	arrowButtons.getChildren().addAll(rightArrowButton, leftArrowButton);
	super.root.setCenter(arrowButtons);
	
	/*
	 * Top items, will probably be changed later
	 */
	Label centerLabel = new Label("Add/Remove Categories");
	super.root.setTop(centerLabel);
	
	/*
	 * Right item: list of all categories
	 */
	categoryTable = new TableView<>();
	categoryTable.setEditable(false);
	//Have it so that the table only shows the number of columns added to it
	categoryTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	
	TableColumn<String, String> categoryColumn = new TableColumn<>("Categories");
	categoryColumn.setEditable(false);
	categoryColumn.setSortable(false); //No need for this to be sorted
	categoryTable.getColumns().add(categoryColumn);
	
	super.root.setRight(categoryTable);
	
	
    }
    
    private void setupFirstTimeHandlers()
    {
	rightArrowButton.setOnAction(event ->
	{
	 /*
	  * Add item typed in text field to the column
	  */
	});
	
	leftArrowButton.setOnAction(event ->
	{
	    /*
	     * Remove selected iterm in column and transfer the text to the text field
	     */
	});
	
	super.backButton.setOnAction(event ->
	{
	    /*
	     * Go back to start scene, make sure to load in previously loaded setttings/files
	     */
	});
	
	super.nextButton.setOnAction(event ->
	{
	    /*
	     * 
	     */
	});
    }

}
