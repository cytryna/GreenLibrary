package s10338.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

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
