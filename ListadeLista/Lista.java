package ListadeLista;

public class Lista {
    
    private Estado inicio;

    public Lista() {
    }

    public void inicializa()
    {
        this.inicio = null;
    }
    
    public Estado buscarEstado(String nome){

        Estado aux = inicio;

        if(aux != null)
        {     
            while(aux.getProx_est() != null && !aux.getNome().equalsIgnoreCase(nome))
                aux = aux.getProx_est();

            if(aux!=null && aux.getNome().equalsIgnoreCase(nome))
                return aux;
        } 
        
        return null;
    }   

    public Cidade buscarCidade(String nome) 
    {
        Estado auxE = inicio;

        while(auxE != null)
        {
            Cidade auxC = auxE.getProx_cid();
            while(auxC != null && !auxC.getNome().equalsIgnoreCase(nome))
                auxC = auxC.getProx();

            if(auxC != null && auxC.getNome().equalsIgnoreCase(nome))
                return auxC;

             auxE = auxE.getProx_est();
        }
        
        return null;
    }
    
    public boolean buscarCidadeEstado(String nome, Estado no)   
    {
        Cidade aux = no.getProx_cid();

        while(aux != null && !aux.getNome().equalsIgnoreCase(nome))
            aux = aux.getProx();
        
        if(aux != null && aux.getNome().equalsIgnoreCase(nome))
                return true;
        
        return false;
    }

    public boolean buscaPares(String nomeEstado, String nomeCidade)
    {
        Estado buscaEstado = buscarEstado(nomeEstado);

        if(buscaEstado != null) 
            return (buscarCidadeEstado(nomeCidade, buscaEstado));
        else
            return false;
    }


    public void inserirEstado(String nome){

        Estado nova = new Estado(nome, null, null);

        if(inicio == null)
            inicio = nova;
        else
        {
            Estado aux = inicio;

            while(aux.getProx_est()!= null)
                aux = aux.getProx_est();

            aux.setProx_est(nova);
        }
    }

    public void inserirEstadoOC(String nome){

        Estado nova = new Estado(nome, null, null);

            Estado atual = inicio;
            Estado ant = null;

            while(atual != null && nome.compareTo(atual.getNome())>=0)
            {
                ant = atual;
                atual = atual.getProx_est();
            }

            if(ant == null)
            {
                nova.setProx_est(inicio);
                inicio = nova;
            }
            else
            {
                ant.setProx_est(nova);
                nova.setProx_est(atual);
            }
        
    }


    public void inserirCidade(String nome){

        Cidade nova = new Cidade(nome, null);

        if(inicio != null)
            if(inicio.getProx_cid() == null)
                inicio.setProx_cid(nova);
            else
                if(inicio.getProx_cid()!= null)
                {
                    Cidade aux = inicio.getProx_cid();

                    while(aux.getProx()!=null)
                        aux = aux.getProx();

                    aux.setProx(nova);
                }
    }

    public void inserirCidade2(String nome, String nome_estado){

        Cidade nova = new Cidade(nome, null);

        if(inicio != null && inicio.getNome().equalsIgnoreCase(nome_estado))
            if(inicio.getProx_cid() == null)
                inicio.setProx_cid(nova);
            else
                if(inicio.getProx_cid()!= null)
                {
                    Cidade aux = inicio.getProx_cid();

                    while(aux.getProx()!=null)
                        aux = aux.getProx();

                    aux.setProx(nova);
                }
            else
            {
                Estado aux = inicio;

                while(aux.getProx_est() != null && !aux.getProx_est().getNome().equalsIgnoreCase(nome_estado))
                    aux = aux.getProx_est();

                if(aux.getProx_est()!= null && aux.getProx_est().getNome().equalsIgnoreCase(nome_estado))
                {
                    if(inicio.getProx_cid() == null)
                      inicio.setProx_cid(nova);
                    else
                    if(inicio.getProx_cid()!= null)
                    {
                        Cidade aux2 = inicio.getProx_cid();

                        while(aux2.getProx()!=null)
                            aux2 = aux2.getProx();

                        aux2.setProx(nova);
                    }
                }
                else
                 System.out.println("Estado nao existe: ");
            }
    }



    public void exibirEstado(){

        Estado aux = inicio;

        while(aux != null)
        {
            System.out.println("Estado: "+aux.getNome());
            aux = aux.getProx_est();
        }
    }

    public void exibirTudo(){

        Estado aux = inicio;
        
        if(inicio != null)
        {
            Cidade aux2 = inicio.getProx_cid();
            
            while(aux != null)
            {
                System.out.println("Estado: "+aux.getNome());
                while(aux2!=null)
                {
                    System.out.println("Cidade: "+aux2.getNome());
                    aux2 = aux2.getProx();
                }
                aux = aux.getProx_est();
            }
        }
        else   
            System.out.println("Lista vazia");
    }




}
