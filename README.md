此项目使用Spring-boot搭建，模拟了集群服务(分别对应application-peer1.yml、application-peer2.yml、application-peer3.yml三个配置)。

首先，在HOSTS文件下建立映射(可以省略此步)

127.0.0.1 peer1
127.0.0.1 peer2
127.0.0.1 peer3

然后，分别建立yml配置文件。


启动时，
Run As → Run Configuration，选择 Arguments 标签，在里面输入:

--spring.profiles.active=peer1，即可分别启动三个服务，实现集群。

同时，使用Spring-session，配合redis实现了集群中的session共享。

