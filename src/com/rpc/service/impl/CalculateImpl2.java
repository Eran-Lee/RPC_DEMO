package com.rpc.service.impl;

import com.rpc.service.Calculate;

public class CalculateImpl2 implements Calculate {

	@Override
	public int add(int a, int b) {
		System.out.println("接收到远程调用");
		return a+b;
	}

}
