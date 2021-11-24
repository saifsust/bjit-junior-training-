package org.bjit.initDestroy;

import org.bjit.dependencyInjection.Address;

public class PatientFactory {
    public Patient createPatient(String name, int age, Address address){
        System.out.println("Factory Class");
        return new Patient(name, age, address);
    }

}
