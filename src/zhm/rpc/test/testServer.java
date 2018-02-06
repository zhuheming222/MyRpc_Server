/**
 * test.java
 * zhm.rpc.test
 * 2017年10月9日下午10:18:33
 *
 */
package zhm.rpc.test;

import zhm.rpc.server.IServer;
import zhm.rpc.server.rpcServerImpl;
import zhu.rpc.reflect.ServerReflect;

/**
 * @author zhuheming
 * test
 * 2017年10月9日下午10:18:33
 */
public class testServer {
	public static void main(String args[]) throws InterruptedException{
		IServer is=new rpcServerImpl();
		Thread serverThread1=new Thread(new ServerReflect(is,8083));
		Thread serverThread2=new Thread(new ServerReflect(is,8084));
		serverThread1.start();
		serverThread2.start();
		serverThread1.join();
		serverThread2.join();
	}

}
