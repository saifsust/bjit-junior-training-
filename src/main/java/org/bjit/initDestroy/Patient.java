package org.bjit.initDestroy;

import org.bjit.dependencyInjection.Address;

public class Patient {
    public  static final String ON_CREATE = "Bean is instantiated!";
    public  static final String ON_DESTROY = "Bean is Destroyed!";
    public static final String ON_FACTORY = "Factory method is called!";
    private  String  name;
    private int age;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Patient(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }



    public void onCreate(){
        System.out.println(ON_CREATE);
        System.out.println(this);
    }
    public  void onDestroy(){
        System.out.println(ON_DESTROY);
        System.out.println(this);
    }


    public static Patient onFactory(String name, String age, Address address){
        System.out.println(ON_FACTORY);
        System.out.println(name);
        System.out.println(age);
        System.out.println(address);
        return new Patient(name, 25, address);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
