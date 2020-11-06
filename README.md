# 组队系统后端springboot2.0
```text
1. springboot整合tkmybatis
2. 日志管理使用：log4j2
3. UI接口：swagger2
4. mybatis反向工程
5. aop事务管理和aop日志管理
6. springboot初始化操作
7. springboot security
8. IDEA如何debug操作
9. JWT做Token认证
10. eureka服务注册和发现
11. OpenFeign
12. webSocket通信
13. elasticsearch测试类
14. zookeeper
15. kafka 消息队列
16. rabbitmq 消息队列
    ...

```

## BUG
```text
 1. driud无法访问问题 已经解决
 2. webSocket通信
    ...
```

## 问题
```text
 spring security 跳过登录认证和身份认证如何实现
```  


### git的操作笔记
**git测试 -- 回滚到openFegin分支再重新提交**
```text
git reset --soft HEAN_ID 指定版本ID  
修改代码
git add .
git commit -m "回退"
git push -f origin master 强制提交代码
```
**回退到指定版本提交**
```text
 git revert -n HEAD_ID
```
