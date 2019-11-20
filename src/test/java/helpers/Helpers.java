package helpers;

public class Helpers {
	public void waitForTime(int timeToWait) {
		try {
			Thread.sleep(timeToWait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
