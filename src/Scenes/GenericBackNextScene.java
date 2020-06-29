package Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 * Base class for all of the scenes
 * 
 * @author Jeremy
 *
 */
public class GenericBackNextScene extends Scene
{

    // Dimensions of window in pixels
    public static int HEIGHT = 690;
    public static int WIDTH = 690;

    // Needed generic bottom buttons
    private Button nextButton, backButton, returnButton;
    //Font for nav buttons
    private Font navButtonFont;
    //Font constants
    public final String NAV_BUTTON_FONT = "Comic Sans MS";
    public final int NAV_BUTTON_FONT_SIZE = 30; 
    
    // Button constants
    public final int NAV_BUTTON_WIDTH = 150, NAV_BUTTON_HEIGHT = 75;
    
    // Container to store navigation buttons
    private HBox hbNavigationButtons;
    public final int HB_NAV_BUTTONS_SPACING = 69;
    public final int HB_NAV_BUTTONS_PADDING_ALL_DIR = HB_NAV_BUTTONS_SPACING/2;

    // Container to store everything
    private BorderPane bpRoot;

    public GenericBackNextScene()
    {
	// Call super constructor to specify root/layout, width and height of the scene
	super(new Pane(), WIDTH, HEIGHT);
	bpRoot = new BorderPane();
	this.setRoot(bpRoot);

	//Font stuff
	navButtonFont = new Font(NAV_BUTTON_FONT, NAV_BUTTON_FONT_SIZE);
	// Instantiate buttons
	backButton = new Button("Back");
	nextButton = new Button("Next");
	returnButton = new Button("Return");
	//Set sizes and font of buttons
	setButtonsSameSize(NAV_BUTTON_WIDTH, NAV_BUTTON_HEIGHT, backButton, nextButton, returnButton);
	setButtonsSameFont(navButtonFont, backButton, nextButton, returnButton);

	//Instantiate container for buttons and set formatting stuff
	hbNavigationButtons = new HBox();
	hbNavigationButtons.getChildren().addAll(backButton, nextButton, returnButton);
	hbNavigationButtons.setAlignment(Pos.CENTER);
	hbNavigationButtons.setSpacing(HB_NAV_BUTTONS_SPACING);
	hbNavigationButtons.setPadding(new Insets(HB_NAV_BUTTONS_PADDING_ALL_DIR, 
		HB_NAV_BUTTONS_PADDING_ALL_DIR, HB_NAV_BUTTONS_PADDING_ALL_DIR, HB_NAV_BUTTONS_PADDING_ALL_DIR));

	//The bottom now has the nav. button container
	bpRoot.setBottom(hbNavigationButtons);
    }
    
    /** 
     * Sets size for every button passed in varargs buttons
     * 
     * @param width - desired width of button
     * @param height  - desired height of button
     * @param buttons - buttons passed
     */
    private static void setButtonsSameSize(int width, int height, Button ... buttons)
    {
	for (Button b : buttons)
	{
	    b.setMinSize(width, height);
	    b.setMaxSize(width, height);
	}
    }
    
    /**
     * Sets fonts for every button passed
     * 
     * @param font
     * @param buttons
     */
    private static void setButtonsSameFont(Font font, Button ... buttons)
    {
	for (Button b : buttons)
	{
	    b.setFont(font);
	}
    }

}
