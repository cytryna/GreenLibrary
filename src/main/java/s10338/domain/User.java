package s10338.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @OneToMany(targetEntity = Lending.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "username", insertable=false, updatable=false)
    public List<Lending> lendings;

    public User() {
    }

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Lending> getLendings() {
        return lendings;
    }

    public void setLendings(List<Lending> libraries) {
        this.lendings = libraries;
    }
}
