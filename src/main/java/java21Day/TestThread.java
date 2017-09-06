package java21Day;

public class TestThread extends Thread{
	//继承Thread类
	@Override
	public void run() {
		//currentThread()     返回对当前正在执行的线程对象的引用。
		System.out.println(Thread.currentThread().getName());
	}
	public static void main (String args[]){
		TestThread t1 = new TestThread();
		TestThread t2 = new TestThread();
		TestThread t3 = new TestThread();
		t1.setName("this is thread 1");
		t1.start();
		t2.setName("this is thread 2");
		t2.start();
		t3.setName("this is thread 2");
		t3.start();
	}
}
