package RedWork.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 发送短信的接口类
 * @author wanzh
 *
 */
public class SendMessageutil {
	/**
	 * 用于发送短信的工具类
	 * @param phone
	 * @param code
	 * @return boolean
	 * @throws IOException 
	 */
	public static String sendMessage(String phone,int code) throws IOException {
		System.out.println("code"+code);
		String strCode = Integer.toString(code);
		//中文编码
		System.out.println(phone);
		String str =URLEncoder.encode("#code#="+strCode,"utf-8");
		//建立URL连接
		URL url= new URL("http://v.juhe.cn/sms/send?mobile="+phone+"&tpl_id=61935&tpl_value="+str+"&key=75bf10452b680036f1351bef34a36beb");
		HttpURLConnection connect = (HttpURLConnection)url.openConnection();
		connect.connect();
		
		//读取内容
		BufferedReader br= new BufferedReader(new InputStreamReader(connect.getInputStream(),"utf-8"));
		StringBuffer sb = new StringBuffer();
		
		String lineData = null;
		while((lineData=br.readLine())!=null)
		{
			System.out.println("lineData"+lineData);
			sb.append(lineData);
		}
		br.close();
		String data = sb.toString();
	    
		return data;
		
	}
}
