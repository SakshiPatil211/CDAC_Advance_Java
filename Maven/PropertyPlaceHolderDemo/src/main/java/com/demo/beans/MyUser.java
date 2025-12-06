package com.demo.beans;

public class MyUser {
	private int uid;
	private String unmae;
	private String addr;
	public MyUser() {
		super();
	}
	public MyUser(int uid, String unmae, String addr) {
		super();
		this.uid = uid;
		this.unmae = unmae;
		this.addr = addr;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUnmae() {
		return unmae;
	}
	public void setUnmae(String unmae) {
		this.unmae = unmae;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", unmae=" + unmae + ", addr=" + addr + "]";
	}
}
