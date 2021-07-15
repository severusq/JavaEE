/**
 * 
 */

/**
 * @author aval
 *
 */
import java.lang.*;

public class ProduceAndConsumer { //�߳�֮���ͨ��

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

class Tickets { //�̹߳������Դ��
	int size;
	int number = 0;
	boolean availiable = false;
	public Tickets(int size) {
		this.size = size;
	}
	public synchronized void put() { //����Ʊ��synchronizedʵ�ֳ��Ի�ȡ���������꣬���ʧ�������ȴ���
		if (availiable) { //�����Ʊ��Ҫ����ȥ
			try {
				wait(); //�ͷŶ��������꣬�߳���ͣ������ȴ���
			}
			catch (Exception e) {
				
			}
		}
		System.out.println("Producer puts ticket "+(++number)); //����Ʊ
		availiable = true;
		notify(); //�������ڵȴ��ö��������ĵ�һ������
	}
	public synchronized void sell() { //��Ʊ������Ҳ������synchronized(t){}���������������ں���������
		if (!availiable) { //���û�п�������Ʊ�����ͷ��������ͣ�߳�
			try {
				wait();
			}
			catch (Exception e) {
				
			}
		}
		System.out.println("Consumer buys ticket "+number);
		availiable = false;
		notify(); //���Ѵ�Ʊ�Ľ���
		if (number == size) {
			number++; //���������ǾͲ����ٴ�Ʊ�����û����һ��������޷�����
		}
	}
}

class Producer extends Thread { //����Ʊ����
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

class Consumer extends Thread { //��Ʊ��
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