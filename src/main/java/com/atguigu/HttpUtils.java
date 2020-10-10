package com.atguigu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import java.io.*;

/**
 * @author tuxiaoqiang
 * @create 2020-08-13 16:52
 */
public class HttpUtils {

	public static String get(String url) throws IOException {
		//1、创建HttpClient
		HttpClient client = new HttpClient();
		//2、创建Method
		GetMethod getMethod = new GetMethod(url);
		//3、发起请求
		//404 - url不存在
		//500 - 接口代码报错
		//200 - 请求成功
		int code = client.executeMethod(getMethod);
		//4、判断请求是否成功
		//http://localhost:8080/abc/23?yy=zhangsan&name=wangwu
		if (code == 200) {
			//5、打印结果
			return getMethod.getResponseBodyAsString();
		}
		return null;
	}
	public static void post(String url,String content) throws IOException{
		//1、创建HttpClient
		HttpClient client = new HttpClient();
		//2、创建Method
		PostMethod method = new PostMethod(url);
		//3、设置body参数
		//设置参数
		StringRequestEntity entity = new StringRequestEntity(content,"application/json","utf-8");
		method.setRequestEntity(entity);
		//4、发起请求
		int code = client.executeMethod(method);
		//5、判断请求是否成功
		if(code==200){
			System.out.println(method.getResponseBodyAsString());
		}
		//6、打印结果
	}
	public static void main(String[] args) throws IOException {
		//get("http://localhost:8080/abc/23?yy=zhangsan&name=wangwu");
		FileReader fileReader = new FileReader(new File("f:/pmt.json"));
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String  str = null;
		String url = "https://restapi.amap.com/v3/ip?ip=%s&output=JSON&key=1210e33db393b7214ffeafa974b84c2d";
		while ((str = bufferedReader.readLine())!=null){
			JSONObject jsonObject = JSON.parseObject(str);
			JSONObject jsonObject1 = JSON.parseObject(get(String.format(url, jsonObject.getString("ip"))));
			//get(String.format(url,str));
			System.out.println(jsonObject);
		}
	}

}
class Area{
	private String status;
	private String info;
	private String infocode;
	private  String province;
	private String city;
	private String adcode;
	private  String rectange;

	public Area() {
	}

	public Area(String status, String info, String infocode, String province, String city, String adcode, String rectange) {
		this.status = status;
		this.info = info;
		this.infocode = infocode;
		this.province = province;
		this.city = city;
		this.adcode = adcode;
		this.rectange = rectange;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfocode() {
		return infocode;
	}

	public void setInfocode(String infocode) {
		this.infocode = infocode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public String getRectange() {
		return rectange;
	}

	public void setRectange(String rectange) {
		this.rectange = rectange;
	}
}
