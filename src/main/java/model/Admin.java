package model;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "start-admin-access", query = "select a from  Admin  a where a.user like :user and  a.passwd like :passwd")
})
public class Admin {
    @Id
    @Column(unique = true)
    private String user;
    private String passwd;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
