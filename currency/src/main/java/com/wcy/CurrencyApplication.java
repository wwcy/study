package com.wcy;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.*;
import java.net.URL;

//@SpringBootApplication
public class CurrencyApplication {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//SpringApplication.run(CurrencyApplication.class, args);
		/*CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://localhost:8080/cas/serviceValidate?ticket=ST-1-WQsFILckP4ZmcWWTx7dnP2nvc8EHaier-PC&service=http%3A%2F%2F127.0.0.1%3A9090%2F");
		CloseableHttpResponse response = httpClient.execute(httpGet);
		//4.判断状态码
		if(response.getStatusLine().getStatusCode()==200){
			HttpEntity entity = response.getEntity();
			//使用工具类EntityUtils，从响应中取出实体表示的内容并转换成字符串
			String string = EntityUtils.toString(entity, "utf-8");
			System.out.println(string);
		}
		//5.关闭资源
		response.close();
		httpClient.close();*/
		/*URL url = new URL("http://localhost:8080/cas/serviceValidate?ticket=ST-1-orMrqV2LYOR1R9J-ywH-jKLUAJ0Haier-PC&service=http%3A%2F%2F127.0.0.1%3A9090%2F");

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		//Sets the flag indicating whether this URLConnection allows input. It cannot be set after the connection is established.
		conn.setDoInput(true);
		if (conn.getResponseCode() == 200) {
			InputStream input = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(input, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			System.out.println(br.readLine());
			br.close();
		}*/

	/*	Serializable s = "";
		System.out.println(s.toString());*/

	// \u000d System.out.println("Hello World!");

		Class c = Class.forName("com.wcy.CurrencyApplication$TestClass");
		//ClassLoader l = ClassLoader.getSystemClassLoader();
		//Class c= l.loadClass("com.wcy.CurrencyApplication$TestClass");

	}

	static class TestClass{
		private String name;

		static {
			sayHello();
		}

		public TestClass(String text){
			System.out.println("构造器："+text);
		}

		public static  void sayHello(){
			System.out.println("sayHello-----------");
		}
	}

}
