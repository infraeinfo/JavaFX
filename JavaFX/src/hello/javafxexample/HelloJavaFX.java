package hello.javafxexample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloJavaFX extends Application
{
	@Override
	public void start(Stage stage) throws Exception
	{
		Button bt = new Button("Escreva HelloWorld");
		bt.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent arg0)
			{
				System.out.println("MothaFucker Hello World");
			}
		});
		
		StackPane root = new StackPane();
		Scene scene = new Scene(root, 300, 150);
		root.getChildren().add(bt);
		
		stage.setTitle("Hello World in JavaFX");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String []args)
	{
		Application.launch(args);
	}
}
