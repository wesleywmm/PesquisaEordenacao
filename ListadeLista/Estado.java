package ListadeLista;

public class Estado {
    
    private String nome;
    private Estado prox_est;
    private Cidade prox_cid;

    public Estado(String nome, Estado prox_est, Cidade prox_cid) {
        this.nome = nome;
        this.prox_est = prox_est;
        this.prox_cid = prox_cid;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Estado getProx_est() {
        return prox_est;
    }
    public void setProx_est(Estado prox_est) {
        this.prox_est = prox_est;
    }
    public Cidade getProx_cid() {
        return prox_cid;
    }
    public void setProx_cid(Cidade prox_cid) {
        this.prox_cid = prox_cid;
    }
    @Override
    public String toString() {
        return "Estado [nome=" + nome + ", prox_est=" + prox_est + ", prox_cid=" + prox_cid + "]";
    }

    
}
