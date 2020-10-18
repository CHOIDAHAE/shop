package com.sh.project.vo;

public class QBoardVO {
	private int i_board;
	private int idx;
	private int b_pw;
	private String title;
	private String content;
	private String w_dt;
	private String m_dt;
	private String u_id;
	private int hits;
	private String search;
	
	
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public int getI_board() {
		return i_board;
	}
	public void setI_board(int i_board) {
		this.i_board = i_board;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getB_pw() {
		return b_pw;
	}
	public void setB_pw(int b_pw) {
		this.b_pw = b_pw;
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
	public String getW_dt() {
		return w_dt;
	}
	public void setW_dt(String w_dt) {
		this.w_dt = w_dt;
	}
	public String getM_dt() {
		return m_dt;
	}
	public void setM_dt(String m_dt) {
		this.m_dt = m_dt;
	}
}