package cn.edu.zzti.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String username;
	private String password;
	private String schoolname;
	private String direction;
	private List<String> talents = new ArrayList<>();

	public String getSchoolname() {
		return schoolname;
	}
	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public User(String username, String password) {
		this.username=username;
		this.password=password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getTalents() {
		return talents;
	}
	public void setTalents(List<String> talents) {
		this.talents = talents;
	}
	
}
