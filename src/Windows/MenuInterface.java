package Windows;

import javafx.application.Application;
import javafx.stage.Stage;
/**
 * 
 * @author Jeremy
 *
 */
public final class MenuInterface extends Application
{

    public MenuInterface()
    {
	// TODO Auto-generated constructor stub
	//Has to be public
    }

    public static void main(String[] args)
    {
	//From application, starts setup and other javafx stuff, and calls start
	launch(args);

    }

    @Override
    public void start(Stage primaryStage)
    {
	//Starting point
	//Instantiate MVC objects for Windows.MenuInterface
	MenuInterfaceModel model = new MenuInterfaceModel();
	MenuInterfaceView view = new MenuInterfaceView();
	MenuInterfaceController controller = new MenuInterfaceController(model, view);
	
	//Pass controller in to view
	view.initController(controller);
    }

}
