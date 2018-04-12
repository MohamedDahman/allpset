package at.refugeecode.mp12socialnetwork.model;

import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany
    private List<Person> friendList = new ArrayList<>();


    public Person() {
    }

    public Person(Long id, String Name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public List<Person> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Person> friendList) {
        this.friendList = friendList;
    }
}
