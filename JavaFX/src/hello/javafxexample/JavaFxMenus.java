package hello.javafxexample;

import static java.lang.System.out;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaFxMenus extends Application
{
	private MenuBar construaMenucomBarras(final ReadOnlyDoubleProperty menuWidthProperty)
	{
		final MenuBar barraMenu = new MenuBar();
		//Parte do menu (File)
		final Menu arquivoMenu = new Menu("Arquivo");
		arquivoMenu.getItems().add(new MenuItem("Novo"));
		arquivoMenu.getItems().add(new MenuItem("Abrir"));
		arquivoMenu.getItems().add(new MenuItem("Salvar"));
		arquivoMenu.getItems().add(new MenuItem("Salvar Como"));
		arquivoMenu.getItems().add(new SeparatorMenuItem());
		arquivoMenu.getItems().add(new MenuItem("Sair"));
		barraMenu.getMenus().add(arquivoMenu);
		
		//Parte do menu chamado Exemplos
		final Menu exemplosMenu = new Menu("Exemplos");
		exemplosMenu.getItems().add(new MenuItem("Exemplo de Texto"));
		exemplosMenu.getItems().add(new MenuItem("Exemplo de Objetos"));
		exemplosMenu.getItems().add(new MenuItem("Exemplo de Animação"));
		barraMenu.getMenus().add(exemplosMenu);
		
		//Parte do menu chamado Help
		final Menu menuAjuda = new Menu("Ajuda");
		final MenuItem procuraMenuItem = new MenuItem("Procurar...");
		procuraMenuItem.setDisable(true);
		menuAjuda.getItems().add(procuraMenuItem);
		final MenuItem onlineManualItem = new MenuItem("Manual Online");
		onlineManualItem.setVisible(false);
		menuAjuda.getItems().add(onlineManualItem);
		menuAjuda.getItems().add(new SeparatorMenuItem());
		final MenuItem aboutMenuItem =
				MenuItemBuilder.create()
					.text("Sobre")
					.onAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e)
						{
							out.println("Você clicou em Sobre!");
						}
					})
					.accelerator(new KeyCodeCombination(
							KeyCode.A, KeyCombination.CONTROL_DOWN))
					.build();
		menuAjuda.getItems().add(aboutMenuItem);
		barraMenu.getMenus().add(menuAjuda);
		
		barraMenu.prefWidthProperty().bind(menuWidthProperty);
		
		return barraMenu;
	}
	
	public void start(final Stage estagio)
	{
		estagio.setTitle("Criando Menus JavaFX");
		final Group grupoRaiz = new Group();
		final Scene cena = new Scene(grupoRaiz, 900, 600, Color.WHEAT);
		final MenuBar menuBarra = construaMenucomBarras(estagio.widthProperty());
		grupoRaiz.getChildren().add(menuBarra);
		estagio.setScene(cena);
		estagio.show();
	}
	
	public static void main(final String[] arguments)
	{
		Application.launch(arguments);
	}
}
