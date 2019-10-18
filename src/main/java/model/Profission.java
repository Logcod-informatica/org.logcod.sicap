package model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "seq_perfission",sequenceName = "seq_perfission",initialValue = 1, allocationSize = 1)
public class Profission {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_perfission")
    private long idProfissao;
    @Column(nullable = false)
    private String profissao;

    public long getIdProfissao() {
        return idProfissao;
    }

    public void setIdProfissao(long idProfissao) {
        this.idProfissao = idProfissao;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
}
