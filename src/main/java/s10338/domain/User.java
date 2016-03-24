package s10338.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @Column(name = "name", nullable = false, length = 15)
    private String name;

    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Column(name = "email", unique = true, nullable = false, length = 200)
    private String email;

    @OneToMany(targetEntity = Commit.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "username", insertable=false, updatable=false)
    public List<Commit> commits;

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

    public List<Commit> getCommits() {
        return commits;
    }

    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }
}
