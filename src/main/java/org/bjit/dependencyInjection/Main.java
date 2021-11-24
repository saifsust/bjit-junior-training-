package org.bjit.dependencyInjection;

import org.bjit.basic.BasicMain;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public void solve(){
        ApplicationContext context = getContextUsingClassPathXmlApplicationContext();
       constructorBaseInjection(context);
        propertyBaseInjection(context, "user-property-base");
        close((ClassPathXmlApplicationContext) context);
    }

    private void propertyBaseInjection(ApplicationContext context, String s) {
        Address address = (Address) context.getBean("address");
        System.out.println(address);
        User user = (User) context.getBean(s);
        System.out.println(user);
    }

    private void constructorBaseInjection(ApplicationContext context) {
        propertyBaseInjection(context, "user-constructor-base");
    }

    public static void main(String[] args){ new Main().solve(); }

    public  ApplicationContext getContextUsingClassPathXmlApplicationContext(){
        return new ClassPathXmlApplicationContext("file:src/main/java/org/bjit/dependencyInjection/beans.xml");
    }

    public  void close(ClassPathXmlApplicationContext context){
        context.close();
    }
}
