
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuItemBuilder;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 

class NewCuisineWindow {

	public Cuisine MaCuisine;

	public Cuisine getMonCuisine() {
		return MaCuisine;
	}

	public void setMonCuisine(Cuisine monCuisine) {
		MaCuisine = monCuisine;
	}
	

	
	
	NewCuisineWindow(){
		Stage Window = new Stage();
		final Group root = new Group();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Text scenetitle = new Text("Ajouter une cuisine");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label nomCuisineLabel = new Label("Nom de la cuisine:");
		grid.add(nomCuisineLabel, 0, 1);

		final TextField nomCuisineTextField = new TextField();
		grid.add(nomCuisineTextField, 1, 1);

		Button boutonEnregistrer = new Button("Enregistrer");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(boutonEnregistrer);
		grid.add(hbBtn, 1, 4);
		
		final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        
        boutonEnregistrer.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent e) {
                
            	MaCuisine = new Cuisine(nomCuisineTextField.getText());
            	if(MaCuisine != null)
            	{
            	AppCore.AjouterCuisineToList(MaCuisine);
            	actiontarget.setFill(Color.LIMEGREEN);
                actiontarget.setText("Enregistrement r�ussi");
            	}
            	else
            	{
            	actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Bouton appuy�");
            	}               
                
            }
        });

		Window.setScene(new Scene(grid, 400, 200));
		Window.show();
		
		
		
	}
	
	
}