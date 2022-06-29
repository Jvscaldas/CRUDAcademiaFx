package application;

import java.io.IOException;

import application.controller.BeneficioBasico;
import application.controller.IMensalidadeStrategy;
import application.controller.PlanoBasico;
import application.controller.PlanoBlack;
import application.controller.PlanoGold;
import application.model.Beneficio;
import application.model.Plano;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		try {
			AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("Main.fxml"));
			Scene scene = new Scene(anchorPane);

			primaryStage.setScene(scene);
			primaryStage.setTitle("CRUD Academia Hibernate");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		IMensalidadeStrategy calc;
// 		calc = new PlanoBasico();
//		calc = new PlanoGold();
		calc = new PlanoBlack();
		calc.calcMensalidade();

		Beneficio b = new Beneficio();
		b.setPlano(Plano.Black);
		BeneficioBasico bb = new BeneficioBasico();
		bb.nextBeneficio(b);

		System.out.println(b);

		launch(args);
	}
}
