package threads;

import ui.MovingController;

public class FallingThreads extends Thread{

	private MovingController mc;
	private boolean c;
	
	public FallingThreads(MovingController mc, boolean c) {
		this.mc = mc;
		this.c = c;
	}
	public void run() {
		while(c) {
			mc.faller();
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
