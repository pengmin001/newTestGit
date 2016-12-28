package com.example.model;

public class HomeModel {
	private String title;
	private int  image;
	private String url;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public HomeModel(String title, int image, String url) {
		super();
		this.title = title;
		this.image = image;
		this.url = url;
	}
	
	
	
	
	
	

}
