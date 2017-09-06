package java21Day;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUrlConnection {
	public String request(String url, String param){
		HttpURLConnection conn = null;
		BufferedWriter bw = null;
		BufferedReader rd = null;
		StringBuilder sb = new StringBuilder ();//StringBuilder 是类
		String line = null;
		String response = null;
		try{
			//错：HttpURLConnection c = new HttpURLConnection(new URL(curl).openConnection());
			//抽象类的上转 add cast to URLConnection是HttpURLConnection的父类，都是抽象类
			conn = (HttpURLConnection) new URL(url).openConnection();
			//openConnection() 返回一个 URLConnection 对象，它表示到 URL 所引用的远程对象的连接。
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setDoOutput(true);//允许请求正文，默认false
			conn.setDoInput(true);//允许响应正文，默认true
			conn.setReadTimeout(2000);
			conn.setUseCaches(false);//是否使用缓存
			conn.connect();//建立连接
			
			//将参数输出，发送给服务器
			bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(),"UTF-8"));
			bw.write(param);
			bw.flush();
			
/*conn.getInputStream()返回InputStream,
 *构造器InputStreamReader(InputStream in),
 *构造器BufferedReader(Reader in);
  Reader子类BufferedReader和InputStreamReader*/
			
			//从服务器获取响应正文并返回
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
				while((line = rd.readLine())!=null){
				sb.append(line);
				}
			response = sb.toString();
			}catch(MalformedURLException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				try{
					if(bw!=null){
						bw.close();
					}
					if(rd!=null){
						rd.close();
					}if(conn!=null){
						conn.disconnect();
					}
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		return response;
	}
	public String get(String url){
		BufferedWriter bw = null;
		BufferedReader br = null;
		HttpURLConnection conn = null;
		String line = null;
		StringBuilder sb = new StringBuilder();
		String respond = null;
		try{
			conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(2000);
			conn.setUseCaches(true);
			conn.connect();
		    bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(),"utf-8"));
			bw.flush();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while((line = br.readLine())!= null){
				sb.append(line);
			}
			 respond = sb.toString();
		}catch (MalformedURLException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(bw!=null){
					bw.close();
				}
				if(br!=null){
					br.close();
				}if(conn!=null){
					conn.disconnect();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return respond;
	}
	String post(String url,String param){
		HttpURLConnection conn = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		String line = null;
		StringBuilder sb = new StringBuilder();
		String respond = null;
		try{
			conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setConnectTimeout(3000);
			conn.connect();
			bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(),"utf-8"));
			bw.write(param);
			bw.flush();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while((line=br.readLine())!=null){
				sb.append(line);
			}
			respond = sb.toString();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(bw!=null){
					bw.close();
				}
				if(br!= null){
					br.close();
				}
				if(conn!=null){
					conn.disconnect();
				}
			}catch(IOException w){
				w.printStackTrace();
			}
		}
		return respond;
	}
}
