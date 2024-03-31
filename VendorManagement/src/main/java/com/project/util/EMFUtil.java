package com.project.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFUtil {

	private static EntityManagerFactory managerFactory;

    public static EntityManagerFactory getManagerFactory() {
        return managerFactory;
    }

    static{
        System.out.println("Creating the EMFUtil...!!");
        managerFactory= Persistence.createEntityManagerFactory("x-workz");
    }
}
