package application.ViewModels;

import java.net.URL;
import java.util.ResourceBundle;
import application.ViewModels.Game3ViewModel;
import application.Main;
import application.Models.ScoreModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class GameOverViewModel extends ViewModel implements Initializable{
	
	private int gameOverScore;
	private int color_eclair_red_int = 0;
	private Timeline eclair_rouge;
	private int sens_eclair_red = 1;
	
	@FXML
	protected Rectangle rectangleFond;
	
	@FXML
	protected Text gameOverText;
	
	@FXML
	protected Text highScoreInfoText;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		sens_eclair_red=1;
		color_eclair_red_int=0;
		eclair_rouge = new Timeline(new KeyFrame(Duration.millis(1000.0/(255*5.0)), e->eclairRougeAction()));
		eclair_rouge.setCycleCount(510);
		eclair_rouge.play();
		sens_eclair_red=1;
		
		highScoreInfoText.setText("(The high score is " + ScoreModel.listMax().getScore() + " points)");
		gameOverScore = Game3ViewModel.getScore();
		if(gameOverScore ==1)
			gameOverText.setText("YOU HAVE SCORED " + gameOverScore + " POINT");
		else {
			gameOverText.setText("YOU HAVE SCORED " + gameOverScore + " POINTS");
		}
	}
	
	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void onKeyPressed(KeyEvent evnt) {
		if(evnt.getCode() == KeyCode.SPACE) {
			Main.gameManager.goToMainMenu();
		}
	}
	
	private void eclairRougeAction() {
		
		rectangleFond.setStyle("-fx-fill: rgb("+color_eclair_red_int+", 0, 0);");
		
		if(sens_eclair_red==-1)
			color_eclair_red_int--;
		if(sens_eclair_red ==1)
			color_eclair_red_int++;
		if(color_eclair_red_int == 255) {
			sens_eclair_red =-1;
		}
		
	}
	
}
