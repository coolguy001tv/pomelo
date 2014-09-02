package com.pemelo.action;

import java.io.IOException;

import com.pemelo.service.WeatherService;

public class WeatherAction extends BasicAction{
	/**
	 * http://localhost:8080/pomelo_v1/weather?cityName=³É¶¼
	 */
	private static final long serialVersionUID = 1L;
	String weatherInfo;
	String cityName;

	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setWeatherInfo(String weatherInfo) {
		this.weatherInfo = weatherInfo;
	}
	public String getWeatherInfo() {
		return weatherInfo;
	}

	private WeatherService weatherService=new WeatherService();
	
	public String weather(){
		try {
			String city=new String(cityName.getBytes("iso8859-1"),"UTF-8");//
			if(city==null||city.isEmpty()){
				return "error";
			}
			System.out.println("city : "+city);
			weatherService.getWeatherInfo(city);
		} catch (IOException e) {
			e.printStackTrace();
		}
		weatherInfo=weatherService.getWeather();
		return "success";
	}
}
