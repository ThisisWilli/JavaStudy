package com.study.designpattern.proxypattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @program: JavaStudy
 * @description: 应用这个类来生成代理类
 * @author: Hoodie_Willi
 * @create: 2020-04-20 14:00
 **/

public class ProxyInvocationHandler /*implements InvocationHandler*/ {

    // 被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public ProxyInvocationHandler() {
    }

    // 生成得到代理类
    public Object getProxy(){
        // this是指业务增强 第一个参数目标类的类加载器，目标类的实现的接口，实现InvocationHandler方法并重写invoke方法的类，也可以写lambda表达式
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) ->{
            System.out.println(proxy.getClass().getName() + " " + method.toString() + " " + Arrays.toString(args));
            return method.invoke(target, args);
        });
    }

    /*@Override
    // 处理代理类并返回result
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 动态代理的本质，就是使用反射机制实现
        return method.invoke(target, args);
    }*/
}
