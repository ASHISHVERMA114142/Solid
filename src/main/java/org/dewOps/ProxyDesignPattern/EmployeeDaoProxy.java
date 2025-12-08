package org.dewOps.ProxyDesignPattern;

import java.nio.file.AccessDeniedException;

public class EmployeeDaoProxy implements EmployeeDao{

    EmployeeDao employeeDao;
    EmployeeDaoProxy(EmployeeDao employeeDao){
        this.employeeDao=employeeDao;
    }
    @Override
    public void createEntry(String client, EmployeeDo employeeDao) throws AccessDeniedException {
        if(client=="ADMIN"){
            this.employeeDao.createEntry(client,employeeDao);
        }else{
            throw new AccessDeniedException("Access Denied thanks for coming here ");
        }
    }

    @Override
    public void deleteEntry(String client, int id) throws AccessDeniedException {
        if(client=="ADMIN"){
            this.employeeDao.deleteEntry(client,id);
        }else{
            throw new AccessDeniedException("Access Denied thanks for coming here ");
        }
    }

    @Override
    public String getEntry(String client, int id) throws AccessDeniedException {
        if(client=="ADMIN" || client=="USER"){
           return  this.employeeDao.getEntry(client,id);
        }else{
            throw new AccessDeniedException("Access Denied thanks for coming here ");
        }
    }
}
