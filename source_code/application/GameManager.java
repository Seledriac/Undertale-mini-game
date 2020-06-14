package application;

import java.io.IOException;
import application.Models.ScoreModel;
import application.ViewModels.Game3ViewModel;

public class GameManager {
	
	public void loadGame() throws IOException
	{
		Main.sceneLoader.switchTo(SceneLoader.SCENE_GAME3);
	}
	
	public void showScores() throws IOException
	{
		Main.sceneLoader.switchTo(SceneLoader.SCENE_SCORES);	
	}
	
	public void goToMainMenu()
	{
		try {
			Main.sceneLoader.switchTo(SceneLoader.SCENE_TITLE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void lose() {
		try {
			addScore();
			Main.sceneLoader.switchTo(SceneLoader.SCENE_GAMEOVER);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void newHighScore() {
		try {
			addScore();
			Main.sceneLoader.switchTo(SceneLoader.SCENE_HIGH_SCORE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addScore() {
		java.util.Date date = new java.util.Date();
		long time = date.getTime();
		ScoreModel.insert(new ScoreModel(0, Game3ViewModel.getScore(), new java.sql.Date(time)));

	}
	
}
