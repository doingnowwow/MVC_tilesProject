package kr.or.ddit.vo;

import java.util.List;

public class FreeVO {
	private String rnum;
	private String free_no      ;
	private String free_title   ;
	private String free_content ;
	private String free_reg_date;
	private String free_hit     ;
	private String free_ip      ;
	private String mem_id       ;
	private String free_status  ;
	private List<Free_FileVO> items;
	
	
	public String getFree_no() {
		return free_no;
	}
	public void setFree_no(String free_no) {
		this.free_no = free_no;
	}
	public String getFree_title() {
		return free_title;
	}
	public void setFree_title(String free_title) {
		this.free_title = free_title;
	}
	public String getFree_content() {
		return free_content;
	}
	public void setFree_content(String free_content) {
		this.free_content = free_content;
	}
	public String getFree_reg_date() {
		return free_reg_date;
	}
	public void setFree_reg_date(String free_reg_date) {
		this.free_reg_date = free_reg_date;
	}
	public String getFree_hit() {
		return free_hit;
	}
	public void setFree_hit(String free_hit) {
		this.free_hit = free_hit;
	}
	public String getFree_ip() {
		return free_ip;
	}
	public void setFree_ip(String free_ip) {
		this.free_ip = free_ip;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getFree_status() {
		return free_status;
	}
	public void setFree_status(String free_status) {
		this.free_status = free_status;
	}
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public List<Free_FileVO> getItems() {
		return items;
	}
	public void setItems(List<Free_FileVO> items) {
		this.items = items;
	}
	
	
	
}
