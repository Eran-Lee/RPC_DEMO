package com.rpc.service.impl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.rpc.bean.CalculateRequest;
import com.rpc.service.Calculate;

public class CalculateImpl implements Calculate {

	@Override
	public int add(int a, int b) {
		try {
            @SuppressWarnings("resource")
			Socket socket = new Socket("127.0.0.1", 8080);
            // 将请求序列化
            CalculateRequest calculateRpcRequest = new CalculateRequest(a, b, "add");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            // 将请求发给服务提供方
            objectOutputStream.writeObject(calculateRpcRequest);
            System.out.println("发起远程调用！！");

            // 将响应体反序列化
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object response = objectInputStream.readObject();

            if (response instanceof Integer) {
                return (Integer) response;
            } else {
                throw new InternalError();
            }

        } catch (Exception e) {
            throw new InternalError();
        }
	}
}
