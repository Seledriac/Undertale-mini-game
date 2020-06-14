package application;

import application.Models.ScoreModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static SceneLoader sceneLoader;
	
	public static GameManager gameManager;
	
	@Override
	public void start(Stage primaryStage) {
		
		ScoreModel.createTableScores();
				
		try {
			
			sceneLoader=new SceneLoader(primaryStage);
			
			gameManager=new GameManager();
			
			primaryStage.setTitle("Undertale");
			
			sceneLoader.switchTo(SceneLoader.SCENE_TITLE);
			
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
