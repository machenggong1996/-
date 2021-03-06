# aof 重写

[Redis之AOF重写及其实现原理](https://blog.csdn.net/hezhiqiang1314/article/details/69396887)

## AOF后台重写

重写将redis写命令合并

aof_rewrite函数可以创建新的AOF文件，但是这个函数会进行大量的写入操作，所以调用这个函数的线程将被长时间的阻塞，因为Redis服务器使用单线程来处理命令请求；所以如果直接是服务器进程调用AOF_REWRITE函数的话，那么重写AOF期间，服务器将无法处理客户端发送来的命令请求；
Redis不希望AOF重写会造成服务器无法处理请求，所以Redis决定将AOF重写程序放到子进程（后台）里执行。这样处理的最大好处是：
子进程进行AOF重写期间，主进程可以继续处理命令请求；
子进程带有主进程的数据副本，使用子进程而不是线程，可以避免在锁的情况下，保证数据的安全性。

## 使用子进程进行AOF重写的问题

子进程在进行AOF重写期间，服务器进程还要继续处理命令请求，而新的命令可能对现有的数据进行修改，这会让当前数据库的数据和重写后的AOF文件中的数据不一致。

## 如何修正

为了解决这种数据不一致的问题，Redis增加了一个AOF重写缓存，这个缓存在fork出子进程之后开始启用，Redis服务器主进程在执行完写命令之后，会同时将这个写命令追加到AOF缓冲区和AOF重写缓冲区
即子进程在执行AOF重写时，主进程需要执行以下三个工作：
执行client发来的命令请求；
将写命令追加到现有的AOF文件中；
将写命令追加到AOF重写缓存中

## 同步效果

重写通过定时事件将aof缓存中的数据写入aof文件，最多丢失一个定时循环事件的数据