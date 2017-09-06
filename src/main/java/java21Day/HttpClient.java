package java21Day;

import java.io.IOException;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClient {
	public String get(String url){
		CloseableHttpClient httpClient = null;
		HttpGet httpGet = null; 
		try{
			/*实例化HttpClient对象
			createDefault()
			Creates CloseableHttpClient instance with default configuration.*/
			httpClient = HttpClients.createDefault();
			//构建RequestConfig对象;创建HttpGet对象,设置RequestConfig
			RequestConfig requestConfig = 
					RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();
			httpGet = new HttpGet(url);
			httpGet.setConfig(requestConfig);
			//执行请求并获取response对象
			HttpResponse response = httpClient.execute(httpGet);
			//获取响应正文对象
			HttpEntity httpEntity = response.getEntity();
			return EntityUtils.toString(httpEntity, "utf-8");
		}catch(ClientProtocolException e){//in case of an http protocol error
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(httpGet!=null){
					httpGet.releaseConnection();
				}if(httpClient!=null){
					httpClient.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return null;
	}
	//param format name=zhangsan&age=18,
	public String post(String url,Map<String,String> param){
		CloseableHttpClient httpClient = null;
		HttpPost httpPost = null;
		try{
			httpClient = HttpClients.createDefault();
			httpPost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(20000).build();
			httpPost.setConfig(requestConfig);
			////构建表单参数完毕，产生一个List<NameValuePair>的对象
			//其中BasicNameValuePair是产生一个key-value的键值对对象
			List<NameValuePair> ps = new ArrayList<NameValuePair>();
			for(String key: param.keySet()){
				ps.add(new BasicNameValuePair(key,param.get(key)));
			}
			//设置请求正文，设置表单参数
			httpPost.setEntity(new UrlEncodedFormEntity(ps));
			
			//执行请求并获取response对象
			CloseableHttpResponse response = httpClient.execute(httpPost);
			//获取响应正文对象
			HttpEntity httpEntity = response.getEntity();
			return EntityUtils.toString(httpEntity,"utf-8");
		}catch(ClientProtocolException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(httpPost!= null){
					httpPost.releaseConnection();
				}if(httpClient!= null){
					httpClient.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return null;
	}
	public String postJson(String url,String body){
		CloseableHttpClient httpClient = null;
		HttpPost httpPost = null;
		try{
			httpClient = HttpClients.createDefault();
			RequestConfig requetsConfig = RequestConfig.custom().setConnectionRequestTimeout(20000).setSocketTimeout(2000).build();
			httpPost = new HttpPost(url);
			httpPost.setConfig(requetsConfig);
			/*body格式{"name":"zhangsan","age","18"}
			new StringEntity(body)利用bode构建一个请求正文对象,
			StringEntity支持Content-Type为application/json
			*/
			httpPost.setEntity(new StringEntity(body));
			CloseableHttpResponse response = httpClient.execute(httpPost);
			HttpEntity httpEntity = response.getEntity();
			return EntityUtils.toString(httpEntity);
		}catch(ClientProtocolException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(httpPost!= null){
					httpPost.releaseConnection();
				}if(httpClient!= null){
					httpClient.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return null;
	}
	//body格式为 name=zhangsan&age=18,
	public String postextend(String url,String body){
		CloseableHttpClient httpClient = null;
		HttpPost httpPost = null;
		try{
			httpClient = HttpClients.createDefault();
			httpPost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).setSocketTimeout(30000).build();
			httpPost.setConfig(requestConfig);
			
/*			List<NameValuePair> list = new ArrayList<NameValuePair>();
			for(String key:param.keySet()){
				list.add(new BasicNameValuePair(key,param.get(key)));
			}
			httpPost.setEntity(new UrlEncodedFormEntity(list));
*/
			//setHeader是设置请求头，该句代码是指设置Content-Type,要设置其它的请求头，也是用setHeader方法。
			httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
			httpPost.setEntity(new StringEntity(body));
			
			CloseableHttpResponse response = httpClient.execute(httpPost);
			HttpEntity httpEntity = response.getEntity();
			return EntityUtils.toString(httpEntity, "utf-8");
		}catch(ClientProtocolException e){
			e.printStackTrace();
		}catch(IOException w){
			w.printStackTrace();
		}finally{
			try{
				if(httpClient!=null){
					httpClient.close();
				}if(httpPost!=null){
					httpPost.releaseConnection();
				}
			}catch(IOException w){
				w.printStackTrace();
			}

		}
		return null;
	}
	/*public List<HttpCookie> postCookie(String url,Map<String,String>param){
		CloseableHttpClient httpClient = null;
		HttpPost httpPost = null;
		try{
			//BasicCookieStore extends Object  implements CookieStore
			CookieStore cookieStore = (CookieStore) new BasicCookieStore();
			httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
			RequestConfig rc = RequestConfig.custom().setConnectionRequestTimeout(2000).build();
			httpPost.setConfig(rc);
			List<NameValuePair> ps = new ArrayList<NameValuePair>();
			for (String pKey : param.keySet()) {
			ps.add(new BasicNameValuePair(pKey, param.get(pKey)));
			}
			httpPost.setEntity(new UrlEncodedFormEntity(ps));
			HttpResponse response = httpClient.execute(httpPost);
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				return cookieStore.getCookies();
			}
		}catch(ClientProtocolException e){
			e.printStackTrace();
		}catch(IOException w){
			w.printStackTrace();
		}finally{
			try{
				if(httpClient!=null){
					httpClient.close();
				}if(httpPost!=null){
					httpPost.releaseConnection();
				}
			}catch(IOException w){
				w.printStackTrace();
			}
		}
		//return new ArrayList<Cookie>(0);
	}*/
	/*public String getCookie(String url , List<HttpCookie> cookies){
		CloseableHttpClient httpClient = null;
		HttpGet httpGet = null;
		try{
			httpClient = HttpClients.createDefault();
			CookieStore cookieStore = (CookieStore) new BasicCookieStore();
			for(HttpCookie cookie : cookies){
				cookieStore.add(null, cookie);
			}
			httpClient = 
					HttpClients.custom().setDefaultCookieStore(cookieStore).build();
			RequestConfig requestConfig = 
					RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();     
			httpGet = new HttpGet(url);
			httpGet.setConfig(requestConfig);
			HttpResponse response = httpClient.execute(httpGet);
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				return EntityUtils.toString(response.getEntity(), "utf-8");
			}
		}catch(ClientProtocolException e){
			e.printStackTrace();
		}catch(IOException w){
			w.printStackTrace();
		}finally{
			try{
				if(httpClient!=null){
					httpClient.close();
				}if(httpGet!=null){
					httpGet.releaseConnection();
				}
			}catch(IOException w){
				w.printStackTrace();
			}
		}*/
	}

