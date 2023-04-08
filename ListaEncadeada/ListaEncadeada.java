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

            while(busca!=null && busca.getInfo()!=info)
                busca = busca.getProx();
        
        return busca;
    }

    public void remover(int info)
    {
       No aux = busca_exaustiva(info);
       
       if(aux != null)
       {
         if(inicio == fim)
            inicializa();
         else
            if(aux == inicio)
            {
                inicio = inicio.getProx();
                inicio.setAnt(null);
            }
            else
                if(aux == fim)
                {
                    fim = fim.getAnt();
                    fim.setProx(null);
                }
                else
                {
                    aux.getAnt().setProx(aux.getProx());
                    aux.getProx().setAnt(aux.getAnt());      
                }
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
