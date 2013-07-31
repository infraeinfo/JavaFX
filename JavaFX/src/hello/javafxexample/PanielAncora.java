package hello.javafxexample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PanielAncora extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primeiroEstagio)
	{
		primeiroEstagio.setTitle("Painel Ancora");
		AnchorPane painel = new AnchorPane();
		ListView lista = new ListView();
		
		painel.setTopAnchor(lista, 10.0);
		painel.setLeftAnchor(lista, 10.0);
		painel.setRightAnchor(lista, 85.0);
		painel.setBottomAnchor(lista, 10.0);
		
		Button botao1 = new Button("Botão 1");
		painel.setTopAnchor(botao1, 10.0);
		painel.setRightAnchor(botao1, 10.0);
		
		Button botao2 = new Button("Botão 2");
		painel.setTopAnchor(botao2, 10.0);
		painel.setRightAnchor(botao2, 10.0);
		
		painel.getChildren().addAll(lista, botao1, botao2);
		
		Scene cena = new Scene(painel);
		primeiroEstagio.setScene(cena);
		primeiroEstagio.show();
	}
}
