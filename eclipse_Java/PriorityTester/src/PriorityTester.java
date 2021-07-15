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
				yield(); //���������е��߳���ִͣ�У��������������ֱ����ȼ��ߵ��߳�������Դ
				try {
					//sleep(1); //�����ȼ��͵��̻߳��ᣬ���������������ȼ���û�к�����
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
