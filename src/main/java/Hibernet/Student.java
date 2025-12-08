package Hibernet;



import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity(name="Student")
@Table(name="studetn_table")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class Student {
    @Id
    @Column(name="studetn_id")
    private int id;
    private FullName fullName;
//     this data will be not stored into the database
//    @Transient
    private long marks;
    public Student(int id, FullName name, long marks) {
        this.id = id;
        this.fullName = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + fullName + '\'' +
                ", marks=" + marks +
                '}';
    }

    public Student(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(FullName name) {
        this.fullName = name;
    }

    public void setMarks(long marks) {
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public FullName getName() {
        return fullName;
    }

    public long getMarks() {
        return marks;
    }
}
