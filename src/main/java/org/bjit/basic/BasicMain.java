package org.bjit.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BasicMain {
        public  static void main(String[] arg){ new BasicMain().solve(); }
        private  void solve(){
                ApplicationContext context = getContextUsingClassPathXmlApplicationContext();
                properyBase(context);
                constructorBase(context, "building-constructor");
                combine(context, "building-combine");
                close((ClassPathXmlApplicationContext) context);
        }

        private void combine(ApplicationContext context, String s){
                constructorBase(context, "building-combine");
        }

        private void constructorBase(ApplicationContext context, String s) {
                Building building = (Building) context.getBean(s);
                System.out.println(building);
                System.out.println(building.getArea());
        }

        private void properyBase(ApplicationContext context) {
                constructorBase(context, "building");
        }

        public  ApplicationContext getContextUsingClassPathXmlApplicationContext(){
               return new ClassPathXmlApplicationContext("file:src/main/java/org/bjit/basic/beans-context.xml");
        }

        public ApplicationContext getContextUsingFileSystemXmlApplicationContext(){
                return new FileSystemXmlApplicationContext("src/main/java/org/bjit/basic/beans-context.xml");
        }

        public  void close(FileSystemXmlApplicationContext context){
            context.close();
        }
        public  void close(ClassPathXmlApplicationContext context){
                context.close();
        }
}
