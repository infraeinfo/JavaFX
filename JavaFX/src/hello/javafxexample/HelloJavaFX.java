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
	public void start(Stage estagio) throws Exception
	{
		Button botao = new Button("Escreva Motherfucker");
		botao.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent arg0)
			{
				System.out.println("MothaFucker Hello World");
			}
		});
		
		StackPane raiz = new StackPane();
		Scene cena = new Scene(raiz, 300, 150);
		raiz.getChildren().add(botao);
		
		estagio.setTitle("J A V A");
		estagio.setScene(cena);
		estagio.show();
	}
	
	public static void main(String []args)
	{
		Application.launch(args);
	}
}
