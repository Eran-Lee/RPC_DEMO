package com.rpc.client;

import com.rpc.service.Calculate;
import com.rpc.service.impl.CalculateImpl;

public class ClientTest {

	public static void main(String[] args) {
		Calculate calculate = new CalculateImpl();
		int add = calculate.add(12, 12);
		System.out.println(add);
	}

}
