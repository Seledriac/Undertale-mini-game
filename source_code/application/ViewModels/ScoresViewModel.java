package application.ViewModels;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.Models.ScoreModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class ScoresViewModel extends ViewModel implements Initializable{
	
	@FXML
	protected Text scores;
	
	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void onMouseClicked() {
		Main.gameManager.goToMainMenu();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<ScoreModel> list_scores = ScoreModel.list12();
		for(int i=0; i<list_scores.size(); i++) {
			String str = list_scores.get(i).toString()+"\n";
			scores.setText(scores.getText()+str);
		}
		
	}

}
