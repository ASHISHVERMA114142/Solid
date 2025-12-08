package org.dewOps.ProxyDesignPattern;

import java.nio.file.AccessDeniedException;

public class Main {
    public static void main(String[] args) throws AccessDeniedException {
        System.out.println("ProxyDesignPattern");
        EmployeeDo employeeDo=new EmployeeDo();
        EmployeeDao employeeDao=new EmployeeDaoProxy(new EmployeeDaoImpl());
        employeeDao.createEntry("ADMIN",employeeDo);
        System.out.println("END of ProxyDesignPattern");
    }
}
