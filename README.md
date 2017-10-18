2017-10-11
	完成了Udp通信验证，udp通信的接受不需需要线程，需要删掉
2017-10-12
	完成了Tcp通信和Udp通信，能够正常使用，
	udp的接受线程还没有删掉，udp构造方法有问题，在外界不方便设置ip地址和端口号。
2017-10-18 
	完成了messageBuffer的唤醒功能，最大程度上降低了messageBuffer和外界的耦合度。
	创建了抽象类messageBufferArouce类，每个模块的唤醒操作都需要实现这个抽象类的抽象接口，再以参数的形式传递给messageBuffer
	删除了udp的接受线程，完善了udp的构造方法，在非通信模块中可以通过buildUdpCommunication方法进行ip地址和端口号的赋值
	粗略的对udp通信和tcp通信进行了测试，能实现简单的通信。
	为server增加了command方法，让搭建服务器的时候可以通过命令行进行服务器搭建。
	唤醒功能还仅仅是在server上，并没有复制到Client上。
	唤醒功能还未进行测试。
	
