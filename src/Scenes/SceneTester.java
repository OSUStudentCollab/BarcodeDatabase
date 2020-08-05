package Scenes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Generic class to load and test scenes. 
 * 
 * @author Jeremy
 *
 */
public final class SceneTester extends Application
{

    public SceneTester()
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
    public void start(Stage primaryStage) throws Exception
    {
	primaryStage.setTitle("Scene tester");
	Scene toBeShown = new StartScene();
//	Scene toBeShown = new FirstTimeFileSetupScene();
	
	primaryStage.setScene(toBeShown);
	primaryStage.show();
    }

}
