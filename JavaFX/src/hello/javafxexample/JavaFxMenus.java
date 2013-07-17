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
	private MenuBar buildMenuBarWithMenus(final ReadOnlyDoubleProperty menuWidthProperty)
	{
		final MenuBar menuBar = new MenuBar();
		//Parte do menu (File)
		final Menu fileMenu = new Menu("Arquivo");
		fileMenu.getItems().add(new MenuItem("Novo"));
		fileMenu.getItems().add(new MenuItem("Abrir"));
		fileMenu.getItems().add(new MenuItem("Salvar"));
		fileMenu.getItems().add(new MenuItem("Salvar Como"));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Sair"));
		menuBar.getMenus().add(fileMenu);
		
		//Parte do menu chamado Exemplos
		final Menu examplesMenu = new Menu("Exemplos");
		examplesMenu.getItems().add(new MenuItem("Exemplo de Texto"));
		examplesMenu.getItems().add(new MenuItem("Exemplo de Objetos"));
		examplesMenu.getItems().add(new MenuItem("Exemplo de Animação"));
		menuBar.getMenus().add(examplesMenu);
		
		//Parte do menu chamado Help
		final Menu helpMenu = new Menu("Ajuda");
		final MenuItem searchMenuItem = new MenuItem("Procurar...");
		searchMenuItem.setDisable(true);
		helpMenu.getItems().add(searchMenuItem);
		final MenuItem onlineManualItem = new MenuItem("Manual Online");
		onlineManualItem.setVisible(false);
		helpMenu.getItems().add(onlineManualItem);
		helpMenu.getItems().add(new SeparatorMenuItem());
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
		helpMenu.getItems().add(aboutMenuItem);
		menuBar.getMenus().add(helpMenu);
		
		menuBar.prefWidthProperty().bind(menuWidthProperty);
		
		return menuBar;
	}
	
	public void start(final Stage stage)
	{
		stage.setTitle("Criando Menus JavaFX");
		final Group rootGroup = new Group();
		final Scene scene = new Scene(rootGroup, 900, 600, Color.WHEAT);
		final MenuBar menuBar = buildMenuBarWithMenus(stage.widthProperty());
		rootGroup.getChildren().add(menuBar);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(final String[] arguments)
	{
		Application.launch(arguments);
	}
}
