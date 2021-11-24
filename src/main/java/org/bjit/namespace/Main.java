package org.bjit.namespace;

import org.bjit.dependencyInjection.Address;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public void solve(){
        ApplicationContext context = getContextUsingClassPathXmlApplicationContext();
        Address address = (Address) context.getBean("address");
        System.out.println(address);
        close((ClassPathXmlApplicationContext) context);
    }





    public static void main(String[] args){ new Main().solve(); }

    public  ApplicationContext getContextUsingClassPathXmlApplicationContext(){
        return new ClassPathXmlApplicationContext("file:src/main/java/org/bjit/namespace/beans.xml");
    }

    public  void close(ClassPathXmlApplicationContext context){
        context.close();
    }
}
