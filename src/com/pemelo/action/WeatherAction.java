package com.pemelo.action;

import java.io.IOException;

import com.pemelo.service.WeatherService;

public class WeatherAction extends BasicAction{
	/**
	 * 
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
			//cityName="³É¶¼";
			if(cityName==null||cityName.isEmpty()){
				return "error";
			}
			System.out.println("cityName : "+cityName);
			weatherService.getWeatherInfo(cityName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		weatherInfo=weatherService.getWeather();
		return "success";
	}
}
