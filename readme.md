#### Adapter模式
对于适配器模式可以想象一个插座，有不同种类的接口，然后可以给不同的设备进行充电，利用Adapter模式可以使用不同的类。

#### ServletContext
在每一个tomcat容器的服务中,通过connecter传递给Engine,然后一个Engine内部根据域名有一个或者多个主机，然后每个主机内部有多个servletContext,由每个servletContext管理链接的发送，然后给对应的Servlet进行处理。