package application;

import java.io.IOException;

import application.ViewModels.Game3ViewModel;
import application.ViewModels.GameOverViewModel;
import application.ViewModels.HighScoreViewModel;
import application.ViewModels.ScoresViewModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SceneLoader {
	
	private Stage stage;
	
	public static final int SCENE_TITLE	=0;
	public static final int SCENE_GAME3	=1;
	public static final int SCENE_SCORES=2;
	public static final int SCENE_GAMEOVER=3;
	public static final int SCENE_HIGH_SCORE=4;
	
	public SceneLoader(Stage stage) {
		this.stage=stage;
	}
	
	public void switchTo(int scene) throws IOException {
		
		switch(scene) {
			case SCENE_TITLE:
				makeSceneTitle(stage);
				break;
			case SCENE_GAME3:
				makeSceneGame3(stage);
				break;
			case SCENE_SCORES:
				makeSceneScores(stage);
				break;
			case SCENE_GAMEOVER:
				makeSceneGameover(stage);
				break;
			case SCENE_HIGH_SCORE:
				makeSceneHighScore(stage);
				break;
			default:
				makeSceneTitle(stage);
				break;
		}
	}
	
	private void makeSceneGameover(Stage stage) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Views/GameOverView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root,1280,720);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		scene.setFill(Color.WHITE);
		stage.setScene(scene);
		GameOverViewModel vm = loader.<GameOverViewModel>getController();
		vm.load();
		//return scene;
	}

	private void makeSceneTitle(Stage stage) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Views/TitleView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root,1280,720);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		scene.setFill(Color.WHITE);
		stage.setScene(scene);
		//return scene;
	}
	
	private void makeSceneGame3(Stage stage) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Views/Game3View.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root,1280,720);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		scene.setFill(Color.WHITE);
		stage.setScene(scene);
		Game3ViewModel vm = loader.<Game3ViewModel>getController();
		vm.load();
		//return scene;
	}
	
	private void makeSceneScores(Stage stage) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Views/Scores.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root,1280,720);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		scene.setFill(Color.WHITE);
		stage.setScene(scene);
		ScoresViewModel vm = loader.<ScoresViewModel>getController();
		vm.load();
		//return scene;
	}
	
	private void makeSceneHighScore(Stage stage) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Views/HighScoreView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root,1280,720);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		scene.setFill(Color.WHITE);
		stage.setScene(scene);
		HighScoreViewModel vm = loader.<HighScoreViewModel>getController();
		vm.load();
		//return scene;
	}
}
