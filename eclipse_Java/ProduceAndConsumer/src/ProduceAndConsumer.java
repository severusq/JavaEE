/**
 * 
 */

/**
 * @author aval
 *
 */
import java.lang.*;

public class ProduceAndConsumer { //线程之间的通信

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tickets t = new Tickets(10);
		new Producer(t).start();
		new Consumer(t).start();
	}

}

class Tickets { //线程共享的资源类
	int size;
	int number = 0;
	boolean availiable = false;
	public Tickets(int size) {
		this.size = size;
	}
	public synchronized void put() { //生产票，synchronized实现尝试获取对象的锁旗标，如果失败则进入等待池
		if (availiable) { //如果有票需要卖出去
			try {
				wait(); //释放对象的锁旗标，线程暂停，进入等待池
			}
			catch (Exception e) {
				
			}
		}
		System.out.println("Producer puts ticket "+(++number)); //生产票
		availiable = true;
		notify(); //唤醒正在等待该对象锁旗标的第一个进程
	}
	public synchronized void sell() { //售票函数，也可以用synchronized(t){}，或者像这样用在函数声明中
		if (!availiable) { //如果没有可以卖的票，就释放锁旗标暂停线程
			try {
				wait();
			}
			catch (Exception e) {
				
			}
		}
		System.out.println("Consumer buys ticket "+number);
		availiable = false;
		notify(); //唤醒存票的进程
		if (number == size) {
			number++; //如果相等了那就不会再存票了如果没有这一步则程序无法结束
		}
	}
}

class Producer extends Thread { //生产票的类
	Tickets t = null;
	public Producer(Tickets t) {
		this.t = t;
	}
	@Override
	public void run() {
		while (t.number < t.size) {
			t.put();
		}
	}
}

class Consumer extends Thread { //售票类
	Tickets t = null;
	public Consumer(Tickets t) {
		this.t = t;
	}
	public void run() {
		while (t.number <= t.size) {
			t.sell();
		}
	}
}