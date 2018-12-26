package com.rpc.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.rpc.bean.CalculateRequest;
import com.rpc.service.Calculate;
import com.rpc.service.impl.CalculateImpl2;

public class ServerTest {

	private Calculate calculate = new CalculateImpl2();

	public static void main(String[] args) throws IOException {
		new ServerTest().run();
	}

	private void run() throws IOException {
		ServerSocket listener = new ServerSocket(8080);
		try {
			while (true) {
				Socket socket = listener.accept();
				try {
					// 将请求反序列化
					ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
					Object object = objectInputStream.readObject();


					// 调用服务
					int result = 0;
					if (object instanceof CalculateRequest) {
						CalculateRequest calculateRequest = (CalculateRequest) object;
						if ("add".equals(calculateRequest.getMethodName())) {
							result = calculate.add(calculateRequest.getA(), calculateRequest.getB());
						} else {
							throw new UnsupportedOperationException();
						}
					}

					// 返回结果
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
					objectOutputStream.writeObject(new Integer(result));
				} catch (Exception e) {
				} finally {
					socket.close();
				}
			}
		} finally {
			listener.close();
		}
	}

}
