import javafx.stage.Stage;
/**
 * 
 * @author Jeremy
 *
 */
public final class MenuInterfaceView extends Stage
{
    
    //Title of window
    public final static String TITLE = "Barcode Database Manager";
    
    private MenuInterfaceController controller; 

    public MenuInterfaceView()
    {
	this.setTitle(TITLE);
	this.setResizable(true);
	this.show();
    }
    
    public void initController(MenuInterfaceController controllerIn)
    {
	controller = controllerIn;
    }
    
}
