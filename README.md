# MyRpc_Server
服务提供者
主要代码在src中，
src\zhu\rpc\reflect 主要用于接收服务消费者请求的方法和参数，使用反射生成一个代理对象，执行请求的方法，返回方法执行的结果
src\zhm\rpc\base 主要用于基础的操作，包括dom4j方式读取xml文件。
src\zhm\rpc\ioc 主要用于模仿spring 的ioc，主要用于模仿spring 的ioc，
src\zhm\rpc\serializer 主要用于各个序列化方式的实现
src\zhm\rpc\server 用于测试的方法，服务提供者提供的服务
