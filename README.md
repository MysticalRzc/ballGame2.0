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
2017-10-20
	搞定了唤醒功能，并进行了简单的测试，上版本的唤醒功能复制到了Client上，但最新的还在Server上。
	经过测试唤醒功能能够满足在收到消息之后能够快速的将消息存放到MessageBuffer缓存器中，并且能够和唤醒线程保持线程安全。
	修改了udp的构造方法，有原来的单端口变成了收发独立的双端口模式
	导入了ClientIdManager类，但是并没有为Client分配Id,也没有为Client分配独立的线程。、
		ClientIdManager类需要进行优化，使用数组在数据量增大的时候查找的时间复杂度会大幅度提升，并且还会出现id片段零碎的情况，
		需要修改成其它数据类型（待分析）
	完善了command方法，同事为Client和Server设计了BuildByDefault方法，能够使用默认值搭建Server和Client，便于快速测试。
2017-11-6
	修改了一下文档中的通信约束，增加了通信报头、消息类型分类、默认端口号
	在客户端和服务器上增加了commTest模块，具体代码没有实现
2017-11-12
	文档中添加了服务器（客户端）启动部署约束，列出了每一步的stap代表的意义，
	完成了服务器（客户端）commTest通信验证模块，
	修改了控制台输出提示，更加简洁。取消了udp发送和接受的消息提示，但保留了messageBuffer启动的提示。
	messageBuffer消息写入增加限制，对消息长度小于16的消息不予放入消息缓存队列。
	需要添加消息级别，并对其验证。
2017-11-14
	为GameServer和GameClient添加了mode数据层，并把ip地址和端口号的校验放在了mode层
	编写了服务器ClientId和TableId分配模块，client启动后会想服务器发送一条ClientId获取请求。
	将Server和Client的mode独立出来，需求说明书添加了一条ClientId请求
	ClientId获取请求Server并没有相应的回复操作需要继续编写
	