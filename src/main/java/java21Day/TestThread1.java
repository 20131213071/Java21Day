package java21Day;

public class TestThread1 implements Runnable{
	@Override
	public void run() {
		Thread.currentThread().getName();
	}
	public static void main(String args[]){
		TestThread t1 = new TestThread();
		Thread thread1 = new Thread(t1);
		thread1.setName("1");
		thread1.start();
		TestThread t2 = new TestThread();
		Thread thread2 = new Thread(t2);
		thread2.setName("2");
		thread2.start();
		TestThread t3 = new TestThread();
		Thread thread3 = new Thread(t3);
		thread3.setName("3");
		thread3.start();
	}
}
