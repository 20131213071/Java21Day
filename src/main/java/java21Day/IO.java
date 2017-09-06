package java21Day;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IO {
	//流读取
	public void readByte(String filename) {
		InputStream io = null;
		try {
			io = new FileInputStream(filename);
			byte[] byteBuffer = new byte[1024];
			int read = 0;
			while((read = io.read(byteBuffer))!=-1 ){
				System.out.write(byteBuffer, 0, read);
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(io!= null){
					io.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	//buffered读取
	public String readByBuffer(String filePath) {
		StringBuffer input = new StringBuffer();
		try{
			String encoding = "UTF-8";
			File file = new File(filePath);
			if(file.isFile()&&file.exists()){
				FileInputStream fileInput = new FileInputStream(file);//构造器接收file文件和路径，返回InputStream
				InputStreamReader read = new InputStreamReader(fileInput,encoding);//构造器接收InputStream
				BufferedReader bufferedReader = new BufferedReader(read);//InputStreamReader和BufferedReader都是Reader的子类
//BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream (file),encoding));
BufferedReader buf = new BufferedReader(new FileReader(file));
				String line = null;
				while((line = bufferedReader.readLine())!=null){
					input.append(line.trim());
				}
				fileInput.close();
				read.close();
				bufferedReader.close();
			}else{
				System.out.println("not found file");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return input.toString();
	}
	//流写入
	public void writeByte(String filename) {
		InputStream io = null;	
	}
	//buffered写入
	public void writeByBuffer(String filePath) {
		try{
			File file= new File(filePath);
			BufferedWriter bufferedWriter = new BufferedWriter (new OutputStreamWriter(new FileOutputStream(file)));
			BufferedWriter buf = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write("hello world");
			bufferedWriter.flush();
			bufferedWriter.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
}
