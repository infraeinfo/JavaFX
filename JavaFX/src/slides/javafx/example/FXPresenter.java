package slides.javafx.example;

import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class FXPresenter extends Application
{
	@Override
	public void start(Stage stage) throws Exception
	{
		final Presentation presentation = new Presentation();
		presentation.addSlide(new Slide("Slide1.fxml"));
		presentation.addSlide(new Slide("Slide2.fxml"));
		
		final Scene scene = new Scene(presentation);
		stage.setScene(scene);
		stage.setFullScreen(true);
		presentation.start();
		List<Screen> screens = Screen.getScreens();
		
		stage.show();
	}
	
	public static void main(String []args)
	{
		launch(args);
	}
}
