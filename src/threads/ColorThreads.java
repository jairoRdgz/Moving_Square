package threads;

import ui.MovingController;

public class ColorThreads extends Thread{
	
	MovingController mc;
	private boolean r;
	
	public ColorThreads(MovingController mc, boolean r) {
		this.mc = mc;
		this.r = true;
	}
	
	public void run() {
		while(r) {
			mc.ChangeColor();
			
			try {
				sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void r() {
		r = !r;
	}
	
}