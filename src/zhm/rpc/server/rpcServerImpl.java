/**
 * rpcServerImpl.java
 * zhm.rpc.server
 * 2017年10月9日下午8:44:06
 *
 */
package zhm.rpc.server;

/**
 * @author zhuheming
 * rpcServerImpl
 * 2017年10月9日下午8:44:06
 */
public class rpcServerImpl implements IServer {

	/* (non-Javadoc)
	 * @see zhm.rpc.server.IServer#testMethod(java.lang.String)
	 */
	@Override
	public String testMethod(String arg) {
		// TODO Auto-generated method stub
		return "test, "+arg;
	}

	@Override
	public String testMethod1(String arg) {
		// TODO Auto-generated method stub
		return "hello, "+arg;
	}
	
	@Override
	public String testMethod2(String arg) {
		// TODO Auto-generated method stub
		return "world, "+arg;
	}
	

}
