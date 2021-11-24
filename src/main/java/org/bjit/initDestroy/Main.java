package org.bjit.initDestroy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public void solve(){
        ApplicationContext context = getContextUsingClassPathXmlApplicationContext();
        //scope(context, "default-scope");
        // scope(context,"factoryBeanId");
      //
        scope(context, "prototype-scope");
        close((ClassPathXmlApplicationContext) context);
    }

    private void scope(ApplicationContext context, String s) {
        System.out.println("================================ "+s+" ================================");
        Patient patient = (Patient) context.getBean(s);
        Patient patient1 = (Patient) context.getBean(s);
        System.out.println(patient.hashCode());
        System.out.println(patient1.hashCode());
    }




    public static void main(String[] args){ new Main().solve(); }

    public  ApplicationContext getContextUsingClassPathXmlApplicationContext(){
        return new ClassPathXmlApplicationContext("file:src/main/java/org/bjit/initDestroy/beans.xml");
    }

    public  void close(ClassPathXmlApplicationContext context){
        context.close();
    }
}
