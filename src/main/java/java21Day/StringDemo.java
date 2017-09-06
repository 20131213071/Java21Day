package java21Day;

public class StringDemo {
	private  String demoString = "ceshibaixiaosheng";
	/** 
	 * @MethodName: testString 
	 * @Description: learn how to use String 
	 * @Parameter: 
	 * @return void
	 * @Example: TODO
	 * @ModificationHistory: 
	 * Author		Date		Description(Why & What is modified)
	 * -----------------------------------------------------------------------------------
	 * smx - 2017年2月9日 上午10:29:44 - First Release
	 * 
	 */
	public  void  testString(){
	//字符串相加，也可用+来表示
	String dsg = demoString.concat(" very good!");
	System.out.println(dsg);		//输出ceshibaixiaosheng very good!
	
	//字符串的长度
	int  len = demoString.length();	
	System.out.println(len);		//输出17
	
	//比较两个字符串是否相等
	boolean eq = "baixiaosheng".equals(demoString);
	System.out.println(eq);			//输出false
	
	//取子字符串,从第5个字符开始，到第8个字符，但不包含第8个字符
	String sub = demoString.substring(5, 8);
	System.out.println(sub);		//输出bai
	
	//取子字符串，从第5个字符开始一直到字符串尾
	String subString = demoString.substring(5);
	System.out.println(subString);	//输出baixiaosheng
	
	//判断是否以某个字符串开头
	boolean  sw = demoString.startsWith("ceshi");
	System.out.println(sw);			//输出true
	
	//判断是否以某个字符串结尾
	boolean  ew = demoString.endsWith("baixiaosheng");
	System.out.println(ew);			//输出true
	
	//找出子字符串在字符串中第一次出现的index，如果找不到则返回-1
	int  subIndex = demoString.indexOf("bai");
	System.out.println(subIndex);	//输出5
	
	int  lastIndex = demoString.lastIndexOf("e");
	System.out.println(lastIndex);//输出14
	
	System.out.println(demoString.toUpperCase());
	System.out.println(demoString.toLowerCase());
	System.out.println(" baixiaosheng ".trim());//将字符串首尾的空格去掉,baixiaosheng
	
	String subReplace = demoString.replace("ceshi", "");
	System.out.println(subReplace);
	
	String subReplaceF = demoString.replaceFirst("e", "");//支持正则
	System.out.println(subReplaceF);//输出cshibaixiaosheng
	
	String subReplaceA = demoString.replaceAll("e", "");//支持正则
	System.out.println(subReplaceA);//输出cshibaixiaoshng
	}
	public  static  void  main(String[] args) {
		StringDemo s = new  StringDemo();
		s.testString();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(s);
	}
}