package ListadeLista;

public class Cidade {
    
    private String nome;
    private Cidade prox;
    
    public Cidade(String nome, Cidade prox) {
        this.nome = nome;
        this.prox = prox;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getProx() {
        return prox;
    }

    public void setProx(Cidade prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return "Cidade [nome=" + nome + ", prox=" + prox + "]";
    }
    
}
