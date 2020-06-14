package application.ViewModels;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class TitleViewModel extends ViewModel implements Initializable{
	
	private Timeline appear;
	private int fps = 144;
	private double GROW_SPEED = 0.1/fps;
	
	@FXML
	protected ImageView title;
	
	@FXML
	protected Button btnJouer;
	
	@FXML
	protected Button btnScores;
	
	@FXML
	protected void onClick(ActionEvent evnt)
	{
		try {
			if(evnt.getTarget()==btnJouer)
				Main.gameManager.loadGame();
			
			if(evnt.getTarget()==btnScores)
				Main.gameManager.showScores();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		btnJouer.setScaleX(0.9);
		btnJouer.setScaleY(0.9);
		btnScores.setScaleX(0.9);
		btnScores.setScaleY(0.9);
		title.setScaleX(0.9);
		title.setScaleY(0.9);
		title.setSmooth(true);
		
		appear = new Timeline(new KeyFrame(Duration.millis(1000/(fps*4)), e->appearAction()));
		appear.setCycleCount(144);
		appear.play();
		
	}
	
	public void appearAction() {
		btnJouer.setScaleX(btnJouer.getScaleX()+GROW_SPEED);
		btnScores.setScaleX(btnScores.getScaleX()+GROW_SPEED);
		btnJouer.setScaleY(btnJouer.getScaleY()+GROW_SPEED);
		btnScores.setScaleY(btnScores.getScaleY()+GROW_SPEED);
		title.setScaleY(btnJouer.getScaleY()+GROW_SPEED);
		title.setScaleX(btnJouer.getScaleX()+GROW_SPEED);
	}
}
