package ListaEncadeada;

import java.util.Random;

public class ListaEncadeada {
    
    private No inicio, fim;
    private int tamanho;

    public ListaEncadeada() {
        inicio = fim = null;
    }

    public void inicializa()
    {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void gerarListaPredefinida()
    {
        inicializa();
        inserirNoInicio(10);
        inserirNoInicio(20);
        inserirNoInicio(30);
        inserirNoFim(60);
        inserirNoFim(50);
        inserirNoFim(12);
        inserirNoFim(1);
        inserirNoInicio(16);
    }

    public void gerarListaAleatoria(int qntNumeros)
    {
        inicializa();
        Random random = new Random();
        int numAleatorio = random.nextInt(100) + 1;
        boolean flag = true;

        for(int i = 0; i < qntNumeros; i++)
        {
            if(flag)
                inserirNoInicio(numAleatorio);
            else   
                inserirNoFim(numAleatorio);
            
            flag = !flag;

            numAleatorio = random.nextInt(100) + 1;
        }
    }
   
    public int getTamanho()
    {
        return tamanho;
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
   
    public void heap()
    {
        int TL2 = tamanho, FE, FD, maiorF, aux;

        while(TL2 > 1)
        {
            for(int pai = TL2/2-1; pai >=0; pai--)
            {
                FE = 2*pai+1;
                FD = FE+1;
                maiorF = FE;

                if(FD < TL2 && retornaDist(FD).getInfo() > retornaDist(FE).getInfo())
                    maiorF = FD;

                if(retornaDist(maiorF).getInfo() > retornaDist(pai).getInfo())
                {
                    aux = retornaDist(maiorF).getInfo();
                    retornaDist(maiorF).setInfo(retornaDist(pai).getInfo());
                    retornaDist(pai).setInfo(aux);
                }
            }

            aux = inicio.getInfo();
            inicio.setInfo(retornaDist(TL2-1).getInfo());
            retornaDist(TL2-1).setInfo(aux);
            TL2 --;
        }

    }

    public void quickSP(int ini, int fi)
    {
        int i = ini, j = fi, aux;

        while(i<j)
        {
            while(i<j && retornaDist(i).getInfo() <= retornaDist(j).getInfo())
                i++;

            aux = retornaDist(i).getInfo();
            retornaDist(i).setInfo(retornaDist(j).getInfo());
            retornaDist(j).setInfo(aux);

            while(i<j && retornaDist(j).getInfo() >= retornaDist(i).getInfo())
                j--;
            
            aux = retornaDist(i).getInfo();
            retornaDist(i).setInfo(retornaDist(j).getInfo());
            retornaDist(j).setInfo(aux);
        }

        if(ini < i-1)
            quickSP(ini, i-1); 
        if(j+1 < fi)
            quickSP(j+1, fi);  

    }

    public void quickSemPivo()
    {
        quickSP(0, tamanho-1);
    }

    public void quickCP(int ini, int fi)
    {
        int i = ini, j = fi, aux, pivo;
        pivo = retornaDist((ini+fi)/2).getInfo();

        while(i < j)
        {
            while(retornaDist(i).getInfo() < pivo)
                i++;

            while(retornaDist(j).getInfo() > pivo)
                j--;
            
            if(i <= j)
            {
                aux = retornaDist(i).getInfo();
                retornaDist(i).setInfo(retornaDist(j).getInfo());
                retornaDist(j).setInfo(aux);
                i++;
                j--;
            }
        }
        if(ini < j)
            quickCP(ini, j);
        if(i < fi)
            quickCP(i, fi);
        
    }

    public void quickComPivo()
    {
        quickCP(0, tamanho-1);
    }

    public int buscaBinaria(int chave, int fi)
    {
        int ini = 0, fim = fi-1, meio = fim/2 ; 
        No posMeio = retornaDist(meio);

        while(ini < fim && chave != posMeio.getInfo())
        {
            if(chave < posMeio.getInfo())
                fim = meio-1;
            else
                ini = meio +1;

            meio = (ini+fim)/2;
            posMeio = retornaDist(meio);
        }
        posMeio = retornaDist(meio);
        if(chave > posMeio.getInfo())
            return meio+1;
        else   
            return meio;
    }

    public void insercaoBinaria()
    {
        int pos, aux;

        for(int i = 1; i< tamanho; i++)
        {
            aux = retornaDist(i).getInfo();
            pos = buscaBinaria(aux, i);

            for(int j = i; j>pos; j--)
                retornaDist(j).setInfo(retornaDist(j-1).getInfo());

            retornaDist(pos).setInfo(aux);
        }
    }

    public void particao(ListaEncadeada l1, ListaEncadeada l2)
    {
        int tam = tamanho/2;
        No partL1, partL2;

        if(l1.inicio != null && l2.inicio !=  null)
        {
            partL1 = l1.inicio;
            partL2 = l2.inicio;
            for(int i = 0; i< tam; i++)
            {

                l1.retornaDist(i).getInfo();
                partL1.setInfo(retornaDist(i).getInfo());
                partL1 = partL1.getProx();  
                partL2.setInfo(retornaDist(i+tam).getInfo());
                partL2 = partL2.getProx();
            } 
        }
        else
        {
            for(int i = 0; i< tam; i++)
            {
               l1.inserirNoFim(retornaDist(i).getInfo());
               l2.inserirNoFim(retornaDist(i+tam).getInfo());
            } 
        }
        
    }

    public void fusao(ListaEncadeada l1, ListaEncadeada l2, int seq)
    {
        int i = 0, j = 0, k = 0, aux_seq = seq;

        while(k < tamanho)
        {
            while(i < seq && j < seq)
                if(l1.retornaDist(i).getInfo() < l2.retornaDist(j).getInfo())
                    retornaDist(k++).setInfo(l1.retornaDist(i++).getInfo());
                else
                    retornaDist(k++).setInfo(l2.retornaDist(j++).getInfo()); 

            while(i < seq)
                retornaDist(k++).setInfo(l1.retornaDist(i++).getInfo());

            while(j < seq)
                retornaDist(k++).setInfo(l2.retornaDist(j++).getInfo()); 

            seq = seq + aux_seq;
        }

    }

    public void mergeSort_priImp()
    {
        int seq = 1;
        ListaEncadeada l1 = new ListaEncadeada();
        ListaEncadeada l2 = new ListaEncadeada();

        while(seq < tamanho)
        {
            particao(l1,l2);
            fusao(l1,l2,seq);
            seq = seq *2;
        }
    }

    public void fusao_2(ListaEncadeada aux, int ini1, int fim1, int ini2, int fim2)
    {
        
            int i = ini1, j = ini2, k = 0;

            while(i <= fim1 && j <= fim2)
                if(retornaDist(i).getInfo() < retornaDist(j).getInfo())
                    aux.retornaDist(k++).setInfo(retornaDist(i++).getInfo());
                else
                    aux.retornaDist(k++).setInfo(retornaDist(j++).getInfo());
            
            while(i <= fim1)
                aux.retornaDist(k++).setInfo(retornaDist(i++).getInfo());

            while(j <= fim2)
                aux.retornaDist(k++).setInfo(retornaDist(j++).getInfo());
                    
            for(i = 0; i < k; i++)
                retornaDist(i+ini1).setInfo(aux.retornaDist(i).getInfo());
        
    }

    public void mergeSort(ListaEncadeada aux, int esq, int dir)
    {
        int meio;
        if(esq < dir)
        {
            meio = (esq +dir)/2;
            mergeSort(aux, esq, meio);
            mergeSort(aux, meio+1, dir);
            fusao_2(aux, esq, meio, meio+1, dir);
        }
    }

    public void mergeSort_segImp(ListaEncadeada Laux)
    {
        mergeSort(Laux, 0, tamanho-1);
    }

    public void gnomeSort()
    {
        int i = 0, aux;

        while(i <= tamanho-1)
        {
            if(i == 0)
                i++;
            if(retornaDist(i).getInfo() >= retornaDist(i-1).getInfo())
                i++;
            else
            {
                aux = retornaDist(i).getInfo();
                retornaDist(i).setInfo(retornaDist(i-1).getInfo());
                retornaDist(i-1).setInfo(aux);
                i--;
            }
        }

    }
    
    public int getNextGap(int gap){
        gap = (int)(gap/1.2473);
        if (gap < 1)
            return 1;
        return gap;
    }

    public void combSort()
    {
        int TL = tamanho, gap = TL;
        boolean swapped = true;
        
        while (gap != 1 || swapped == true){
            gap = getNextGap(gap);
            swapped = false;
            
            for (int i=0; i<TL-gap; i++)
            {
                if (retornaDist(i).getInfo() > retornaDist(i+gap).getInfo()){
                    int aux = retornaDist(i).getInfo();
                    retornaDist(i).setInfo(retornaDist(i+gap).getInfo());
                    retornaDist(i+gap).setInfo(aux);
                    swapped = true;
                }
            }
        }
    }

    public int min(int a, int b)
    {  
        if(a < b)  
            return a;      
        return b;   
    }

    public int maiorValor()
    {
        No aux = inicio;
        int maior = inicio.getInfo();
        
        for (int i = 1; i <= tamanho; i++)
        {
            if (aux.getInfo() > maior)
                maior = aux.getInfo();
            aux = aux.getProx();
        }
        return maior;
    }
    
    public void countingSort(int exp)
    {
        No p = inicio;
        
        int aux[] = new int[tamanho]; 
        int count[] = new int[10];
        
        for(int i=0; i<10; i++)
            count[i] = 0;

        for (int i = 0; i < tamanho; i++)
        {
            count[(p.getInfo()/exp) % 10]++;
            p = p.getProx();
        }
 
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        for (int i = tamanho-1; i >= 0; i--) 
        {
            p = retornaDist(i);
            aux[count[(p.getInfo()/exp) % 10] - 1] = p.getInfo();
            count[(p.getInfo()/exp) % 10]--;
        }
 
        p = inicio;
        for (int i = 0; i < tamanho; i++)
        {
            p.setInfo(aux[i]);
            p = p.getProx();
        }
    }

    public void radixSort()
    {
        int max = maiorValor();
 
        for (int espo = 1; max/espo > 0; espo = espo * 10)
            countingSort(espo);
    }

    public void insercaoDiretaTim(int ini, int fi){
        int auxInfo, ppos;
        
        if(inicio != null)
        {
            for(int i=ini+1; i<=fi; i++)
            {    
                auxInfo = retornaDist(i).getInfo();
                ppos = i;
                
                while(ppos > ini && auxInfo < retornaDist(ppos-1).getInfo()) 
                    retornaDist(ppos).setInfo(retornaDist(ppos--).getAnt().getInfo());

                retornaDist(ppos).setInfo(auxInfo);
            }
        }
    }

    public void mergeTim(int esq, int meio, int dir) {
        ListaEncadeada l1 = new ListaEncadeada();
        ListaEncadeada l2 = new ListaEncadeada();

        int tl1=meio-esq+1, tl2=(dir-meio);
        int i, j, k;
        
        for (i = 0; i < tl1; i++)
            l1.inserirNoFim(retornaDist(esq+i).getInfo());
        for (i = 0; i < tl2; i++) 
            l2.inserirNoFim(retornaDist(meio+1+i).getInfo());

        i = 0;
        j = 0;
        k = esq;
        while (i < tl1 && j < tl2) 
        {
            if (l1.retornaDist(i++).getInfo() <= l2.retornaDist(j++).getInfo()) 
            {
                retornaDist(k++).setInfo(l1.retornaDist(i++).getInfo()); 
                l1.retornaDist(i++).setInfo(l1.retornaDist(i++).getProx().getInfo());
            } 
            else 
            {
                retornaDist(k++).setInfo(l2.retornaDist(j++).getInfo());
                l2.retornaDist(j++).setInfo(l2.retornaDist(j++).getProx().getInfo());
            }
           
        }
        while (i < tl1) 
        {
            retornaDist(k++).setInfo(l1.retornaDist(i++).getInfo());
            l1.retornaDist(i++).setInfo(l1.retornaDist(i++).getProx().getInfo());   
        }

        while (j < tl2) 
        {
            retornaDist(k++).setInfo(l2.retornaDist(j++).getInfo());
            l2.retornaDist(j++).setInfo(l2.retornaDist(j++).getProx().getInfo());
        }
    }

    public void timSort()
    {
        int i, tam, bloco=32, ini, meio, fim;  
        
        for (i = 0; i < tamanho; i+=bloco)  
            insercaoDiretaTim(i, min((i+bloco-1),(tamanho-1)));  
        
        for (tam = bloco; tam < tamanho; tam = 2*tam)
        {  
            for (ini = 0; ini < tamanho; ini += 2*tam)
            {  
                meio = ini + tam - 1;  
                fim = min((ini + 2*tam - 1), (tamanho-1)); 
                
                if(meio < fim)
                    mergeTim(ini, meio, fim);  
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

        System.out.println("Tamanho: "+tamanho);
    }

    public void exibirDesordenado()
    {
        No aux = inicio;
        System.out.print("Numeros Desordenados:\t[");
        while(aux != null){
            System.out.print(" "+aux.getInfo());
            aux = aux.getProx();
        }
        System.out.println(" ]");
    }

    public void exibirFormatado()
    {
        No aux = inicio;

        System.out.print("Numeros Ordenados: \t[");
        while(aux != null){
            System.out.print(" "+aux.getInfo());
            aux = aux.getProx();
        }
        System.out.println(" ]");
    }

    
}
