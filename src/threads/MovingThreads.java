package threads;

import ui.MovingController;

public class MovingThreads extends Thread{
	
	private MovingController mc;
	private boolean r;
	private boolean c;
	
	public MovingThreads(MovingController mc, boolean r) {
		this.mc = mc;
		this.r = r;
		c=true;
	}
	
	public void run() {
		while(c) {
			r = mc.rigth(r);
			r = mc.left(r);
			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	public void s() {
		c = !c;
	}
	
	public boolean getC() {
		return c;
	}
	
	public boolean getR() {
		return r;
	}
}
