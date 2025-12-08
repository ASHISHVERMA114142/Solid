package org.dewOps.ProxyDesignPattern;

public class EmployeeDaoImpl implements EmployeeDao{
    @Override
    public void createEntry(String client, EmployeeDo employeeDao) {
        System.out.println("Entry has saved into database");
    }

    @Override
    public void deleteEntry(String client, int id) {
        System.out.println("Entry with id "+ id+" is deleted from the databse");
    }

    @Override
    public String getEntry(String client, int id) {
        return "This is your data";
    }
}
