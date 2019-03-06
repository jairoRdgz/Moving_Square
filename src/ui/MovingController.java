package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import threads.MovingThreads;

public class MovingController {

    @FXML
    private Pane pane;

    @FXML
    private Button mover;

    @FXML
    private Rectangle square;

    @FXML
    private Button parar;
    
    private MovingThreads mt;
    
    private boolean r;

    @FXML
    void move(ActionEvent event) {
    	mt = new MovingThreads(this,r);
    	mt.start();
    	
    	mover.setDisable(true);
    	parar.setDisable(false);
    }

    @FXML
    void stop(ActionEvent event) {
    	mover.setDisable(false);
    	parar.setDisable(true);
    	mt.s();
    	r = mt.getR();
    }
    
    public boolean rigth(boolean r) {
    	if(r) {
    		square.setLayoutX(square.getLayoutX()+6);
    		square.setRotate(square.getRotate()+6);
    		System.out.println("Derecha");
    	}
    	if(square.getLayoutX()>=pane.getWidth()-square.getWidth()) {
			r = false;
		}
		return r;
    }
    
    public boolean left(boolean r) {
    	if(!r) {
    		square.setLayoutX(square.getLayoutX()-6);
    		square.setRotate(square.getRotate()-6);
    		System.out.println("Izquierda");
    	}
    	if(square.getLayoutX()<=0) {
			r = true;
		}	
		return r;
    }
    
    
    @FXML
    void initialize() {
        
    }
}
