package com.sinc.project.board.model.vo;


/*

CREATE TABLE SPRING_BOARD_TBL(
SEQ NUMBER PRIMARY KEY,
TITLE VARCHAR2(50) NOT NULL,
CONTENT VARCHAR2(4000),
WRITER VARCHAR2(50) REFERENCES SPRING_MEM_TBL(ID),
REGDATE DATE DEFAULT SYSDATE,
VIEWCNT NUMBER DEFAULT 0
);

CREATE SEQUENCE BOARD_SEQ;

INSERT INTO SPRING_BOARD_TBL VALUES(BOARD_SEQ.NEXTVAL, '공지','내용1','admin', DEFAULT, DEFAULT);
INSERT INTO SPRING_BOARD_TBL VALUES(BOARD_SEQ.NEXTVAL, '공지','내용2','admin', DEFAULT, DEFAULT);


 */



public class BoardVO {
	private int seq;
	private String title, content, writer, regdate;
	private int viewcnt;
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardVO(int seq, String title, String content, String writer, String regdate, int viewcnt) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", regdate=" + regdate + ", viewcnt=" + viewcnt + "]";
	}
	
	
}
