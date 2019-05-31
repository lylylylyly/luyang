package com.luyang.test;

import com.luyang.annotation.InitFields;

public class A {
	
	private String aaa;
	
	private String bbb;
	
	@InitFields
	private String ccc;
	
	@InitFields
	private int ddd;
	
	public String getCcc() {
		return ccc;
	}

	public void setCcc(String ccc) {
		this.ccc = ccc;
	}

	public String getBbb() {
		return bbb;
	}

	@InitFields
	public void setBbb(String bbb) {
		this.bbb = bbb;
	}

	public String getAaa() {
		return aaa;
	}

	@InitFields
	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	@Override
	public String toString() {
		return "A [aaa=" + aaa + ", bbb=" + bbb + ", ccc=" + ccc + ", ddd=" + ddd + "]";
	}
	
}
