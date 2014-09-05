package com.pemelo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import net.sf.json.JSONObject;

public class WeatherService {

    private URLConnection connectionData; 
    private StringBuilder sb; 
    private BufferedReader br;// 读取data数据流  
    private String weather;
    //private JSONObject jsonData;  

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public boolean getWeatherInfo(String city) throws IOException{ 
           
        ///连接中央气象台的APi 
        URL url=new URL("http://api.map.baidu.com/telematics/v3/weather?location="+URLEncoder.encode(city,"UTF-8")+"&output=json&ak=D6c4bb8d6f5356d73b75811dca986894"); 
        connectionData = url.openConnection();  
        connectionData.setConnectTimeout(1000);  
		try {  
		    br = new BufferedReader(new InputStreamReader(connectionData.getInputStream(), "UTF-8"));  
		    sb = new StringBuilder();  
		    String line = null;  
		    while ((line = br.readLine()) != null){ 
		        sb.append(line);  
		    } 
		} catch (SocketTimeoutException e) {  
			System.out.println("连接超时");  
			return false;
		    
		} 
              
           String datas = sb.toString();    
           System.out.println(datas.toString());
          //jsonData = JSONObject.fromObject(datas);  
          //System.out.println(jsonData.toString());   
          //info = jsonData.getJSONObject("weatherinfo");  
           weather=datas;

          return true;
    }
    
//    public static void main(String[] a)
//    {
//    	WeatherService weatherService=new WeatherService();
//    	try {
//			weatherService.getWeatherInfo("成都");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
	
}
