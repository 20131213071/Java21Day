package java21Day;

import java.util.concurrent.Callable;

public class TestCallable<V> implements Callable<V>{
	@Override
	public V call() throws Exception {
		String name = Thread.currentThread().getName();
		return (V)("return name is "+ name.toString());
	}
	public static void main(String agrs[]){
		TestCallable<String> tt = new TestCallable<String>();

		
		
	}

}
