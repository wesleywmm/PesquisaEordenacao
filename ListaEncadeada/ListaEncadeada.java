package ListaEncadeada;

public class ListaEncadeada {
    
    private No inicio, fim;
    private int tamanho = 0;

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
        tamanho ++;
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
        tamanho ++;
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
        tamanho --;  
        }  
    }

    public void insercaoDireta()
    {
        int aux;

        No pi = inicio.getProx(), ppos;

        while(pi != null)
        {
            aux = pi.getInfo();
            ppos = pi;

            while(ppos != inicio && aux < ppos.getAnt().getInfo())
            {
                ppos.setInfo(ppos.getAnt().getInfo());
                ppos = ppos.getAnt();   
            }
            ppos.setInfo(aux);
            pi = pi.getProx();
        }

    }
    
    public void selecaoDireta()
    {
        No pI, pJ, pMenor;
        int menor;
        
        pI = inicio;

        while(pI.getProx() != null)
        {
            pMenor = pI;
            menor = pI.getInfo();
            pJ = pI.getProx();

            while(pJ != null)
            {
                if(pJ.getInfo() < menor)
                {
                    pMenor = pJ;
                    menor = pJ.getInfo();
                }
                pJ =pJ.getProx();   
            }

            pMenor.setInfo(pI.getInfo());
            pI.setInfo(menor);
            pI = pI.getProx();
        }
        
    }   

    public void bubbleSort()
    {
        No pI = inicio, TL2 = fim;
        int aux; 
        
        while(TL2.getAnt() != null)
        {
            while(pI.getProx() != null)
            {
                if(pI.getInfo() > pI.getProx().getInfo())
                {
                    aux = pI.getInfo();
                    pI.setInfo(pI.getProx().getInfo());
                    pI.getProx().setInfo(aux);
                }
                 pI = pI.getProx();
            }
            pI = inicio;
            TL2 = TL2.getAnt();
        } 
    }

    public void shake()
    {
        No ini = inicio, fi = fim, i;
        int aux;

        while(ini != fi.getAnt())
        {
            for(i = ini; i != fi; i = i.getProx())
                if(i.getInfo() > i.getProx().getInfo())
                {
                    aux = i.getInfo();
                    i.setInfo(i.getProx().getInfo());
                    i.getProx().setInfo(aux);
                }

            for(i = fi; i != ini; i = i.getAnt())
               if(i.getInfo() < i.getAnt().getInfo())
               {
                    aux = i.getInfo();
                    i.setInfo(i.getAnt().getInfo());
                    i.getAnt().setInfo(aux);
               }
                
            ini = ini.getProx();
        }
    }

    public No retornaDist(int dist)
    {
        No busca = inicio;
        for(; dist > 0; dist --)
            busca = busca.getProx(); 
        return busca;
    }

    public void shell()
    {
        int dist, aux;
        dist = 4;

        while(dist > 0)
        {
            for(int i = 0; i < dist; i++)
                for(int j = i; j + dist < tamanho; j = j+dist)
                    if(retornaDist(j).getInfo() > retornaDist(j+dist).getInfo())
                    {
                        aux = retornaDist(j).getInfo();
                        retornaDist(j).setInfo(retornaDist(j+dist).getInfo());
                        retornaDist(j+dist).setInfo(aux);
                     
                        for(int k = j; k - dist >= i && retornaDist(k).getInfo() < retornaDist(k-dist).getInfo(); k = k - dist)
                        {
                            aux = retornaDist(k).getInfo();
                            retornaDist(k).setInfo(retornaDist(k-dist).getInfo());
                            retornaDist(k-dist).setInfo(aux);
                        }
                    }
            
                    dist = dist / 2;
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

        System.out.println("Tamanho: "+tamanho);
    }

    
}
