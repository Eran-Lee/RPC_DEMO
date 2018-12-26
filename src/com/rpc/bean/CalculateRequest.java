package com.rpc.bean;

import java.io.Serializable;

public class CalculateRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int a;
	private int b;
	private String methodName;
	
	public CalculateRequest(int a, int b, String methodName) {
		this.a = a;
		this.b = b;
		this.methodName = methodName;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
}
