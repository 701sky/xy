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
 * ���Ͷ��ŵĽӿ���
 * @author wanzh
 *
 */
public class SendMessageutil {
	/**
	 * ���ڷ��Ͷ��ŵĹ�����
	 * @param phone
	 * @param code
	 * @return boolean
	 * @throws IOException 
	 */
	public static String sendMessage(String phone,int code) throws IOException {
		System.out.println("code"+code);
		String strCode = Integer.toString(code);
		//���ı���
		System.out.println(phone);
		String str =URLEncoder.encode("#code#="+strCode,"utf-8");
		//����URL����
		URL url= new URL("http://v.juhe.cn/sms/send?mobile="+phone+"&tpl_id=61935&tpl_value="+str+"&key=75bf10452b680036f1351bef34a36beb");
		HttpURLConnection connect = (HttpURLConnection)url.openConnection();
		connect.connect();
		
		//��ȡ����
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
