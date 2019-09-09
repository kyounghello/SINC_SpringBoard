package com.sinc.project.user.model.vo;

/*
CREATE TABLE SPRING_MEM_TBL(
ID VARCHAR2(50) PRIMARY KEY,
PWD VARCHAR2(50) NOT NULL,
NAME VARCHAR2(50) NOT NULL,
POINT NUMBER DEFAULT 1000,
IMGSRC VARCHAR2(50)
);

INSERT INTO SPRING_MEM_TBL VALUES('admin','admin','관리자',DEFAULT, 'images.png');


 */


public class UserVO {
	private String id,pwd,name;
	private int point;
	private String imgsrc;
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserVO(String id, String pwd, String name, int point, String imgsrc) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.point = point;
		this.imgsrc = imgsrc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", point=" + point + ", imgsrc=" + imgsrc + "]";
	}
	
	
}
