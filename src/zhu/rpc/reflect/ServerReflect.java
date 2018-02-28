/**
 * serverReflect.java
 * zhu.rpc.reflect
 * 2017��10��9������9:24:47
 *
 */
package zhu.rpc.reflect;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.lang3.reflect.MethodUtils;

import zhm.rpc.ioc.BeanLoaderImpl;

/**
 * @author zhuheming serverReflect 2017��10��9������9:24:47
 */
public class ServerReflect implements Runnable {

	private static BeanLoaderImpl seriBean = new BeanLoaderImpl();
	private Object object;
	private int port;

	public ServerReflect(Object object, int port) {
		this.object = object;
		this.port = port;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// �½�����
		try {
			System.out.println("server connect");
			ServerSocket ss = new ServerSocket(port);

			while (true) {
				String method=null;
				try {
					final Socket socket = ss.accept();
					// ��������
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					try {
						// �õ��������Ͳ����б�
						System.out.println("get object");
						System.out.println("socket ReceiveBufferSize ");
						method = ois.readUTF();
						System.out.println("socket ReceiveBufferSize ");
						System.out.println("method: " + method);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						//ois();
					}

					System.out.println("object deserialize");

					Object[] getObject = (Object[])seriBean.getDefaultBean().receive(socket);
					System.out.println("method : " + method.toString());
					System.out.println("args :  " + getObject.toString());
					
					// ����õ���Ӧ������ִ�н��
					System.out.println("invoke Method!");
//					MethodUtils.invokeMethod(object, "testMethod1", null);
//					System.out.println("invoke Method:"+method);
					Object resultObject=MethodUtils.invokeMethod(object, method,getObject);

					try {
						// ���ؽ��
						System.out.println("send object");

						// ��Ϊʹ�ø������л���ʽдobject
						//oos.write(seriBean.getDefaultBean().serialize(resultObject));
						seriBean.getDefaultBean().send(socket, resultObject);
						// oos.writeObject(resultObject);
					} catch (Exception e) {
						//oos.writeObject(e);
						e.printStackTrace();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
