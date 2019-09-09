package com.sinc.project.test.model.vo;

/*
CREATE TABLE SPRING_TEST_MEM_TBL(
	ID VARCHAR2(50) PRIMARY KEY,
	PWD VARCHAR2(50),
	NAME VARCHAR2(50)
);

INSERT INTO SPRING_TEST_MEM_TBL VALUES('park','park','박혜경');
INSERT INTO SPRING_TEST_MEM_TBL VALUES('admin','admin','관리자');

COMMIT;

 * 
 * 
 */


public class TestVO {
	private String id, pwd, name;

	public TestVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestVO(String id, String pwd, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
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

	@Override
	public String toString() {
		return "TestVO [id=" + id + ", pwd=" + pwd + ", name=" + name + "]";
	}
	
}
