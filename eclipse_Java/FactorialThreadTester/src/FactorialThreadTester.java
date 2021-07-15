
public class FactorialThreadTester {

	public static void main(String[] args) { //���߳�
		// TODO Auto-generated method stub
		TestThread thread[] = new TestThread[3]; //�ȸ��������ռ䣬����Ԫ�ػ��ǲ����Է��ʵ�
		System.out.println("Starting threads");
		for (int i = 0; i < 3; i++) { //���������߳�
			thread[i] = new TestThread(); //�ٸ�ÿһ������Ԫ�ط���ռ�
			new Thread(thread[i], "Thread"+i).start(); //����start�����run����
		}
		System.out.println("Threads started, main ends");
	}

}

class TestThread implements Runnable { //Ҫô�̳�Thread�࣬Ҫôʵ��Runnable�ӿ�
	private int sleeptime;
	public TestThread() {
		sleeptime = (int) (Math.random() * 6000);
	}
	public void run() { //�ؼ���run����
		try {
			System.out.println(Thread.currentThread().getName() + "going for sleep for " + sleeptime);
			Thread.sleep(sleeptime); //��ͣһ��ʱ��
		}
		catch (InterruptedException exception) {
			
		}
		System.out.println(Thread.currentThread().getName()+"finished"); //�ȵõ���ǰ�̵߳�����
	}
}