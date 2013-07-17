package hello.javafxexample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application
{	
	String user = "Ramses";
	String pw = "12345";
	String checkUser, checkPw;
	
	public static void main(String []args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("JavaFX Login");
		
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10,50,50,50));
		
		//Adicionando HBox
		HBox hb = new HBox();
		hb.setPadding(new Insets(20,20,20,30));
		
		//Adicionando gridPane
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20,20,20,20));
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		
		//Implementando campos para o gridPane
		Label lblUserName = new Label("Nome de Usuário");
		final TextField txtUserName = new TextField();
		Label lblPassword = new Label("Senha");
		final PasswordField pf = new PasswordField();
		Button btnLogin = new Button("Login");
		final Label lblMessage = new Label();
		
		//Adicionando os campos no gridPane
		gridPane.add(lblUserName, 0, 0);
		gridPane.add(txtUserName, 1, 0);
		gridPane.add(lblPassword, 0, 1);
		gridPane.add(pf, 1, 1);
		gridPane.add(btnLogin, 2, 1);
		gridPane.add(lblMessage, 1, 2);
		
		//Reflection para o gridPane
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		gridPane.setEffect(r);
		
		//Efeito DropShadow
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(5);
		dropShadow.setOffsetY(5);
		
		//Adicionando os textos e o DropShadow
		Text text = new Text("JavaFX Login1");
		text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
		text.setEffect(dropShadow);
		
		//Adicionando Texto ao HBox
		hb.getChildren().add(text);
		
		//Identificadores dos campos
		bp.setId("bp");
		gridPane.setId("root");
		btnLogin.setId("btnLogin");
		text.setId("text");
		
		//Ação para o btnLogin (não consegui fazer esse trecho funcionar
     /*   btnLogin.setOnAction(new EventHandler() {
       	    @Override
            public void handle(ActionEvent event) {
             checkUser = txtUserName.getText().toString();
             checkPw = pf.getText().toString();
             if(checkUser.equals(user) && checkPw.equals(pw)){
              lblMessage.setText("Congratulations!");
              lblMessage.setTextFill(Color.GREEN);
             }
             else{
              lblMessage.setText("Incorrect user or pw.");
              lblMessage.setTextFill(Color.RED);
             }
             txtUserName.setText("");
             pf.setText("");
            }
            });
		*/
		//Adicionando HBox e GridPane Layout
		bp.setTop(hb);
		bp.setCenter(gridPane);
		
		//Adicionando BorderPane no app e carregando o CSS
		Scene scene = new Scene(bp);
		scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
		primaryStage.setScene(scene);
			primaryStage.titleProperty().bind(scene.widthProperty().asString().concat(" : ").concat(scene.heightProperty().asString()));
		primaryStage.show();
	}
}
