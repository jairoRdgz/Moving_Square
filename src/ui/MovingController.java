package ui;

import java.util.ArrayList;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import threads.ColorThreads;
import threads.FallingThreads;
import threads.MovingThreads;

public class MovingController {

    @FXML
    private Pane pane;

    @FXML
    private Button mover;

    @FXML
    private Rectangle square;
    
    @FXML
    private Button fall;

    @FXML
    private Button parar;
    
    private MovingThreads mt;
    
    private ColorThreads ct;
    
    private FallingThreads ft;
    
    private boolean r;
    
    @FXML
    void falling(ActionEvent event) {
    	ft = new FallingThreads(this, r);
    	ft.start();
    }
    
    public boolean faller() {
    	boolean f = false;
    	if(square.getLayoutY() < pane.getHeight()-square.getHeight()) {
    		square.setLayoutY(square.getLayoutY()+2);
    		f = true;
    	}else {
    		f = false;
    	}
    	return f;
    }
    
    @FXML
    void create(MouseEvent  event) {
    	double x = event.getX();
    	double y = event.getY();
    	
    	ArrayList<Rectangle> squareList = new ArrayList<Rectangle>();
    	square = new Rectangle(x, y, square.getWidth(), square.getHeight());
    	squareList.add(square);
    	
    	pane.getChildren().add(square);
    }
    
    @FXML
    void move(ActionEvent event) {
    	mt = new MovingThreads(this,r);
    	ct = new ColorThreads(this,r);
    	
    	mover.setDisable(true);
    	parar.setDisable(false);
    	
    	mt.start();
    	ct.start();
    }

    @FXML
    void stop(ActionEvent event) {
    	mover.setDisable(false);
    	parar.setDisable(true);
    	
    	mt.s();
    	ct.r();
    	
    	r = mt.getR();
    }
    
    public Paint colors() {
    	Random ran =  new Random();
    	 int color = ran.nextInt(3);
    	 Paint flag ;
    	 if(color == 1) {
    		 flag = Color.RED;
    	 }else if(color == 2) {
    		 flag = Color.GREEN;
    	 }else if(color == 3) {
    		 flag = Color.BLUE;

    	 }else {
    		 flag = Color.BLACK;
    	 }
    	 
    	 return flag;
    }
    
    public void ChangeColor() {
    	square.setFill(colors());
    	
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
