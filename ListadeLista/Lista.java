package ListadeLista;

public class Lista {
    
    private Estado inicio;

    public Lista() {
    }

    public void inicializa()
    {
        this.inicio = null;
    }
    
    public Estado buscarEstado(String nome){        // item C.

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
    
    public boolean buscarCidadeEstado(String nome, Estado no)       // so é chamado se nao for nula
    {
        Cidade aux = no.getProx_cid();

        while(aux != null && !aux.getNome().equalsIgnoreCase(nome))
            aux = aux.getProx();
        
        if(aux != null && aux.getNome().equalsIgnoreCase(nome))
                return true;
        
        return false;
    }

    public boolean buscarPares(String nomeEstado, String nomeCidade) // item E.
    {
        Estado buscaEstado = buscarEstado(nomeEstado);

        if(buscaEstado != null) 
            return (buscarCidadeEstado(nomeCidade, buscaEstado));
        else
            return false;
    }

    public boolean buscarEstadoBoolean(String nome)
    {
        Estado aux = inicio;

        if(aux != null)
        {     
            while(aux.getProx_est() != null && !aux.getNome().equalsIgnoreCase(nome))
                aux = aux.getProx_est();

            if(aux!=null && aux.getNome().equalsIgnoreCase(nome))
                return true;
        }    
        return false;
    }

    public void inserirEstado(String nome){             //insere tipo fila

        Estado nova = new Estado(nome, null, null);

        if(!buscarEstadoBoolean(nome))
        {
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
        else
            System.out.println("Estado ja cadastrado!");
        
    }

    public void inserirEstadoOC(String nome){           //insere estado em ordem crescente

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

    public void inserirPares(String nome_cidade, String nome_estado)  //item A.
    {  
            inserirEstado(nome_estado);
            Estado busca = buscarEstado(nome_estado);
            Cidade nova_cid = new Cidade(nome_cidade, null);

            if(busca.getProx_cid() == null)
                busca.setProx_cid(nova_cid);
            else
            {
                Cidade aux = busca.getProx_cid();
                
                while(aux.getProx()!=null)
                        aux = aux.getProx();

                aux.setProx(nova_cid);
            }
        }

    public void exibirEstado(){ //exibe todos estados

        Estado aux = inicio;

        while(aux != null)
        {
            System.out.println("Estado: "+aux.getNome());
            aux = aux.getProx_est();
        }
    }

    public void exibirCidades(String nome_estado)           // item D.
    {
        Estado aux = buscarEstado(nome_estado);

        if(aux != null)
        {
            Cidade cidaux = aux.getProx_cid();
            while(cidaux != null)
            {
                System.out.println("Cidade: "+cidaux.getNome());
                cidaux = cidaux.getProx();   
            }
        }
        else   
            System.out.println("Este Estado nao possui nenhuma cidade Cadastrada!");
    }

    public void exibirTudo(){  // exibe todos estados e suas cidades

        Estado aux = inicio;
        
        if(aux != null)
        {
            while(aux != null)
            {
                Cidade aux2 = aux.getProx_cid();
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
