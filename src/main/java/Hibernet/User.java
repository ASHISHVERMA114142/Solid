package Hibernet;


import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.Cache;

import javax.persistence.*;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name="user")
public class User {
    @Id
    public int id;
    public String name;
    public int money;
//    @OneToOne
//    public Laptop laptop;
//    public Laptop getLaptopId() {
//        return laptop;
//    }
//
//    public void setLaptopId(Laptop laptopId) {

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", laptopList=" + laptopList +
                '}';
    }
//        this.laptop = laptopId;
//    }


    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    public List<Laptop> laptopList=new ArrayList<>();
    public List<Laptop> getLaptopList() {
        return laptopList;
    }

    public void setLaptopList(List<Laptop> laptopList) {
        this.laptopList = laptopList;
    }
    public User(){}
    public User(int id, String name, int money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


}


