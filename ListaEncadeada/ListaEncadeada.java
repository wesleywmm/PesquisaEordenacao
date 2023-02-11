package ListaEncadeada;

public class ListaEncadeada {
    
    private No inicio, fim;

    public ListaEncadeada() {
    }

    public void inicializa()
    {
        this.inicio = null;
        this.fim = null;
    }
    
    public void inserirNoInicio(int info)
    {
        No nova = new No(null, null, info);
        
        if(inicio == null)
            inicio = fim = nova;
        else
        {
            inicio.setAnt(nova);
            nova.setProx(inicio);
            inicio = nova;
        }
    }

    public void inserirNoFim (int info)
    {
        No nova = new No(null,null , info);

        if(fim == null)
            inicio = fim = nova;
        else
        {
            fim.setProx(nova);
            nova.setAnt(fim);
            fim = nova;
        }
    }

    public No busca_exaustiva(int info)
    {   
        No busca = inicio;

        if(inicio.getInfo() == info)
            return inicio;
        else
        {
            while(busca.getProx()!=null && busca.getInfo()!=info)
                busca = busca.getProx();

            if(busca!=null && busca.getInfo()==info)
                return busca;
            else
                return null;
        }

    }

    public void remover(int info)
    {
       if(inicio.getInfo() == info)
       {
            inicio = inicio.getProx();
            inicio.setAnt(null);
       }
       else
        if(fim.getInfo() == info)
        {
            fim = fim.getAnt();
            fim.setProx(null);
        }
        else
        {
            No aux = inicio;

            while(aux.getProx() != null && aux.getInfo()!= info)
                aux = aux.getProx();
            
            if(aux!=null && aux.getInfo()==info)
            {
                aux.getAnt().setProx(aux.getProx());
                aux.getProx().setAnt(aux.getAnt());
            }
            else
                System.out.println("Nao encontrado!");
        }

    }
    
    public void exibir()
    {
        No aux = inicio;

        while(aux != null)
        {
            System.out.println("Info: "+aux.getInfo());
            aux = aux.getProx();
        }
    }

    
}
