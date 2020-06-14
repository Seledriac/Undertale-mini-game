package application.ViewModels;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.Models.ScoreModel;
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

public class Game3ViewModel extends ViewModel implements Initializable {
	
	private int color_eclair_white_int = 0;
	private int color_eclair_red_int = 0;
	private static int  score = 0;
	private int vies = 3;
	private Timeline win,time,eclair,eclair_rouge;
	private int sens_eclair_white = 1;
	private int sens_eclair_red = 1;
	private int fps=144;
	private int sens_rectangle = 1;
	private double recSpeed = 3;
	
	@FXML
	protected ImageView coeur_1;
	
	@FXML
	protected ImageView coeur_2;
	
	@FXML
	protected ImageView coeur_3;
	
	@FXML
	protected Rectangle rectangleCentral;
	
	@FXML
	protected Rectangle rectangleCentral1;
	
	@FXML
	protected Rectangle rectangleFond;
	
	@FXML
	protected Text gameText;
	
	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		score = 0;
		time = new Timeline(new KeyFrame(Duration.millis(1000/fps), e->timeAction()));
		time.setCycleCount(Timeline.INDEFINITE);
		time.play();
		rectangleCentral1.setSmooth(true);
		rectangleCentral.setSmooth(true);	
	}
	
	private void timeAction() {
		
		if(rectangleCentral.getX()>= 1250 || rectangleCentral.getX()<=0) {
			sens_rectangle=sens_rectangle*-1;
		}
		
		if(rectangleCentral.getX() > rectangleCentral1.getX() && rectangleCentral.getX() < (rectangleCentral1.getX() + rectangleCentral1.getWidth())) {
			rectangleCentral1.setStyle("-fx-fill: blue;");
		}
		else {
			rectangleCentral1.setStyle("-fx-fill: white;");
		}
		
		rectangleCentral.setX(rectangleCentral.getX()+(sens_rectangle*recSpeed));

	}

	@FXML
	public void onKeyPressed (KeyEvent evnt) {
		
		if (evnt.getCode() == KeyCode.SPACE) {
				
			if(rectangleCentral.getX() < rectangleCentral1.getX() || rectangleCentral.getX() > rectangleCentral1.getX() + rectangleCentral1.getWidth()) {
				lose_vie();
				if(vies!=0) {
					sens_eclair_red=1;
					color_eclair_red_int=0;
					eclair_rouge = new Timeline(new KeyFrame(Duration.millis(1000.0/(127.0*(3-vies)*10.0)), e->eclairRougeAction()));
					eclair_rouge.setCycleCount(254*(3-vies));
					eclair_rouge.play();
					sens_eclair_red=1;
				}
			}
			else {
				
				score++;
				gameText.setText("SCORE : "+score);
				
				sens_eclair_white=1;
				color_eclair_white_int=0;
				eclair = new Timeline(new KeyFrame(Duration.millis(1000.0/(150.0*10.0)), e->eclairAction()));
				eclair.setCycleCount(300);
				eclair.play();
				sens_eclair_white=1;
				
				recSpeed=recSpeed+0.1;
				if(rectangleCentral1.getWidth()*Math.pow(0.99, 10)>70) {
					win = new Timeline(new KeyFrame(Duration.millis(1000/fps), e->winAction()));
					win.setCycleCount(10);
					win.play();
				}
				
			}
			
			if(vies == 0)
				loseAction();
			
		}
		
	}
	
	private void lose_vie() {
		vies--;
		if(vies == 2)
			coeur_3.setOpacity(0);
		if(vies == 1)
			coeur_2.setOpacity(0);
		if(vies == 0)
			coeur_1.setOpacity(0);
	}
	
	private void loseAction() {
		time.stop();
		if(ScoreModel.isBestScore(score)) {	
			Main.gameManager.newHighScore();
		}
		else {
			Main.gameManager.lose();
		}
	}

	private void winAction() {
		double diff = 0;
		rectangleCentral1.setWidth(rectangleCentral1.getWidth()-(diff=rectangleCentral1.getWidth()*0.01));
		rectangleCentral1.setX(rectangleCentral1.getX()+diff/2.0);
	}
	
	private void eclairAction() {
		
		rectangleFond.setStyle("-fx-fill: rgb("+color_eclair_white_int+", "+color_eclair_white_int+", "+color_eclair_white_int+");");
		
		if(sens_eclair_white==-1)
			color_eclair_white_int--;
		if(sens_eclair_white ==1)
			color_eclair_white_int++;
		if(color_eclair_white_int == 150) {
			sens_eclair_white =-1;
		}
		
	}
	
	private void eclairRougeAction() {
		
		rectangleFond.setStyle("-fx-fill: rgb("+color_eclair_red_int+", 0, 0);");
		
		if(sens_eclair_red==-1)
			color_eclair_red_int--;
		if(sens_eclair_red ==1)
			color_eclair_red_int++;
		if(color_eclair_red_int == 127*(3-vies)) {
			sens_eclair_red =-1;
		}
		
	}
	
	@FXML
	public void onMouseClicked() {
		time.stop();
		Main.gameManager.goToMainMenu();
	}
	
	public static int getScore() {
		return score;
	}
	
}
