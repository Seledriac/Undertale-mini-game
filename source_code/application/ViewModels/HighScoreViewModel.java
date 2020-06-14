package application.ViewModels;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class HighScoreViewModel extends ViewModel implements Initializable{
	
	
	private int fps = 200;
	private Timeline move;
	private double GROW_SPEED = 0.025;
	private double initial_scale;
	private int highScore;
	private double rotate_speed = 2.2;
	private int tourne_slow = 320;
	private int color_eclair_blue_int = 0;
	private Timeline eclair;
	private int sens_eclair_blue = 1;
	
	@FXML
	protected Rectangle rectangleFond;
	
	@FXML
	protected ImageView HighScore;
	
	@FXML
	protected ImageView PogChamp;
	
	@FXML
	protected Text highScoreText;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		highScore = Game3ViewModel.getScore();
		if(highScore ==1)
			highScoreText.setText("YOU HAVE SCORED "+highScore+" POINT");
		else {
			highScoreText.setText("YOU HAVE SCORED "+highScore+" POINTS");
		}
		
		sens_eclair_blue=1;
		color_eclair_blue_int=0;
		eclair = new Timeline(new KeyFrame(Duration.millis(1000.0/(150.0*5.0)), e->eclairBlueAction()));
		eclair.setCycleCount(300);
		eclair.play();
		sens_eclair_blue=1;
		
		initial_scale = 0.5;
		PogChamp.setScaleX(initial_scale);
		PogChamp.setScaleY(initial_scale);
		HighScore.setScaleY(initial_scale);
		HighScore.setScaleX(initial_scale);
		HighScore.setSmooth(true);
		PogChamp.setSmooth(true);
		
		move = new Timeline(new KeyFrame(Duration.millis(1000/fps), e->moveAction()));
		move.setCycleCount(Timeline.INDEFINITE);
		move.play();		
	}
	
	private void moveAction() {
		if(PogChamp.getScaleX()<2) {
			PogChamp.setScaleX(PogChamp.getScaleX()+GROW_SPEED);
			PogChamp.setScaleY(PogChamp.getScaleY()+GROW_SPEED);
			HighScore.setScaleX(HighScore.getScaleX()+GROW_SPEED/2.0);
			HighScore.setScaleY(HighScore.getScaleY()+GROW_SPEED/2.0);
		}
		if(PogChamp.getRotate()<tourne_slow) {
			PogChamp.setRotate(PogChamp.getRotate()+rotate_speed);
			HighScore.setRotate(HighScore.getRotate()-rotate_speed);
		}
		else {
			rotate_speed = 0.02;
			PogChamp.setRotate(PogChamp.getRotate()+rotate_speed);
			HighScore.setRotate(HighScore.getRotate()-rotate_speed);
		}
	}
	
	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void onKeyPressed(KeyEvent evnt) {
		if(evnt.getCode() == KeyCode.SPACE) {
			move.stop();
			Main.gameManager.goToMainMenu();
		}
	}
	
	private void eclairBlueAction() {
		
		rectangleFond.setStyle("-fx-fill: rgb(0, "+color_eclair_blue_int+", 0);");
		
		if(sens_eclair_blue==-1)
			color_eclair_blue_int--;
		if(sens_eclair_blue ==1)
			color_eclair_blue_int++;
		if(color_eclair_blue_int == 150) {
			sens_eclair_blue =-1;
		}
		
	}

}
