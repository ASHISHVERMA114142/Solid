package org.dewOps.ProxyDesignPattern;

import java.nio.file.AccessDeniedException;

public interface EmployeeDao {
    void createEntry(String client , EmployeeDo employeeDao) throws AccessDeniedException;
    void deleteEntry(String client , int id) throws AccessDeniedException;
    String getEntry(String client,int id) throws AccessDeniedException;
}
