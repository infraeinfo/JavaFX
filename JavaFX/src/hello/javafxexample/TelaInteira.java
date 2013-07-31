package hello.javafxexample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TelaInteira extends Application 
{
	public static void main (String []args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primario)
	{
		primario.setTitle("Titulo");
		
		StackPane sp = new StackPane();
		Text texto = new Text("Isso é uma tela cheia feita por JavaFX...");
		texto.setFont(Font.font(null, FontWeight.BOLD, 72));
		texto.setFill(Color.BLUE);
		sp.getChildren().add(texto);
		
		Scene cena = new Scene(sp);
		primario.setScene(cena);
		
		primario.setFullScreen(true);
		primario.show();
	}
}
