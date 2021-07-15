class TestThread extends Thread {
	private int tick = 1;
	private int num;
	public TestThread(int i) {
		this.num = i;
	}
	@Override
	public void run() {
		while(tick < 40000) {
			tick++;
			if((tick % 5000) == 0) {
				System.out.println("Thread #" + num +", tick = " + tick);
				yield(); //让正在运行的线程暂停执行，但理论上马上又被优先级高的线程抢了资源
				try {
					//sleep(1); //给优先级低的线程机会，不过这里运行优先级并没有很明显
				}
				catch (Exception e) {
					
				}
			}
		}
	}
}
public class PriorityTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestThread[] runners = new TestThread[2];
		for(int i = 0; i < 2; i++) {
			runners[i] = new TestThread(i);
		}
		runners[0].setPriority(2);
		runners[1].setPriority(5);
		for (int i = 0; i < 2; i++) {
			runners[i].start();
		}
	}

}
