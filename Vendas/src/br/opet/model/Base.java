package br.opet.model;

import java.sql.Date;

public class Base {

	private int isdelete;
	private int user_delete;
	private Date dt_delete;

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public int getUser_delete() {
		return user_delete;
	}

	public void setUser_delete(int user_delete) {
		this.user_delete = user_delete;
	}

	public Date getDt_delete() {
		return dt_delete;
	}

	public void setDt_delete(Date dt_delete) {
		this.dt_delete = dt_delete;
	}

}
