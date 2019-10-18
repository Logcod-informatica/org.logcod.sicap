package model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "seq_Employee",sequenceName = "seq_Employee",initialValue = 1,allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = "start-employee-access",query = "select e from Employee e where e.user like :logged"),
        @NamedQuery(name = "consult-all-registered-employees", query = "select e from Employee e where e.nome like :filter")
})
public class Employee {
    @Id
    @Column(nullable = false)
    private long idEmployee;
    private String nome;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String rg;
    @Column(unique = true)
    private String  user;
    private String passwd;
    private String sexo;
    @OneToOne
    private Office office;

    public long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
