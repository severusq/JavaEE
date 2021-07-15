
public class FactorialThreadTester {

	public static void main(String[] args) { //多线程
		// TODO Auto-generated method stub
		TestThread thread[] = new TestThread[3]; //先给数组分配空间，数组元素还是不可以访问的
		System.out.println("Starting threads");
		for (int i = 0; i < 3; i++) { //开启三个线程
			thread[i] = new TestThread(); //再给每一个数组元素分配空间
			new Thread(thread[i], "Thread"+i).start(); //调用start后进入run函数
		}
		System.out.println("Threads started, main ends");
	}

}

class TestThread implements Runnable { //要么继承Thread类，要么实现Runnable接口
	private int sleeptime;
	public TestThread() {
		sleeptime = (int) (Math.random() * 6000);
	}
	public void run() { //关键的run函数
		try {
			System.out.println(Thread.currentThread().getName() + "going for sleep for " + sleeptime);
			Thread.sleep(sleeptime); //暂停一段时间
		}
		catch (InterruptedException exception) {
			
		}
		System.out.println(Thread.currentThread().getName()+"finished"); //先得到当前线程的名字
	}
}