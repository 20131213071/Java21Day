package java21Day;

import java.io.File;

public class TestException extends RuntimeException{
	
	public TestException() {
		super();
	}
	public TestException(String message) {
		super(message);
	}
	public void test(){
		int a = 9;
		if(a>0){
			//throw关键字通常用在方法体中，并且抛出一个异常对象
			//程序在执行到throw语句时立即停止，它后面的语句都不执行
			throw new TestException("this is a exception");
		}
	}
	
	public void fileb(){
		File file = new File("/home/dir");
		int a = 10;
		if(a>0){
			throw new RuntimeException();//利用Throw抛出异常
		}
		System.out.println("creat new exception");	
	}
}
