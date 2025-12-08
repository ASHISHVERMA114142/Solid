package Hibernet;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name="laptop")
public class Laptop {
    @Id
    public int laptopId;
    public  String laptopName;

    @ManyToOne
    public User user;

    public User getUser() {
        return user;
    }
    public Laptop(){}
    public void setUser(User user) {
        this.user = user;
    }

    public Laptop(int laptopId, String laptopName) {
        this.laptopId = laptopId;
        this.laptopName = laptopName;
    }

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }
}
