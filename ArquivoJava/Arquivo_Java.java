package ArquivoJava;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arquivo_Java {
    
    private String nomearquivo;
    private int comp, mov;
    private RandomAccessFile arquivo;

    public Arquivo_Java(String nomearquivo)
    {
        try
        {
            arquivo = new RandomAccessFile(nomearquivo, "rw");
        } catch (IOException e)
        { }
    }

    public void truncate(long pos) //desloca eof
    {
        try
        {
            arquivo.setLength(pos * Registro.length());
        } catch (IOException exc)
        { }
    }

    //semelhante ao feof() da linguagem C
    //verifica se o ponteiro esta no <EOF> do arquivo
    public boolean eof()  
    {
        boolean retorno = false;
        try
        {
            if (arquivo.getFilePointer() == arquivo.length())
                retorno = true;                               
        } catch (IOException e)
        { }
        return (retorno);
    }

    //insere um Registro no final do arquivo, passado por parametro
    public void inserirRegNoFinal(Registro reg)
    {
        seekArq(filesize());//ultimo byte
        reg.gravaNoArq(arquivo);
    }


    public int filesize()
    {
        try 
        {
            return (int)arquivo.length()/Registro.length();
        } 
        catch (Exception e)
        {
            return 0;
        }
           
    }

    public void exibirArq()
    {
        int i;
        Registro aux = new Registro();
        seekArq(0);
        i = 0;
        while (!this.eof())
        {
            System.out.println("Posicao " + i);
            aux.leDoArq(arquivo);
            aux.exibirReg();
            i++;
        }
    }

    public void exibirUmRegistro(int pos)
    {
        Registro aux = new Registro();
        seekArq(pos);
        System.out.println("Posicao " + pos);
        aux.leDoArq(arquivo);
        aux.exibirReg();
    }

    public void seekArq(int pos)
    {
        try
        {
            arquivo.seek(pos * Registro.length());
        } catch (IOException e)
        { }
    }

    public void leArq()
    {
        int codigo, idade;
        String nome;
        codigo = Entrada.leInteger("Digite o codigo");
        while (codigo != 0)
        {
            nome = Entrada.leString("Digite o nome");
            idade = Entrada.leInteger("Digite a idade");
            inserirRegNoFinal(new Registro(codigo, nome, idade));
            codigo = Entrada.leInteger("Digite o codigo");
        }
    }


    public void initComp() 
    {
       comp = 0; 
    }
    
    public void initMov() 
    {
        mov = 0;
    }
    
    public int getComp() 
    {
        return comp;
    }
    
    public int getMov() 
    {
        return mov;
    }

    public void ordenado()
    {
        for(int i = 1; i<= 1024;i++)
        {
            inserirRegNoFinal(new Registro(i));
        }
    }

    public void reverso()
    {
        for(int i = 1024; i>= 0;i--)
        {
            inserirRegNoFinal(new Registro(i));
        }

    }
     
    public void randomico()
    {
        Random random = new Random();
        List<Integer> ListaInt = new ArrayList<>();
        int numeroAleatorio;
        while (ListaInt.size() < 1024) 
        {
             numeroAleatorio = random.nextInt(1024);
            if (!ListaInt.contains(numeroAleatorio))
            {
                ListaInt.add(numeroAleatorio);
                inserirRegNoFinal(new Registro(ListaInt.size()));
            }
        }
    }
    

    //.............................................................................
    /*
    insira aqui os metodos de Ordenacao;
    */

    public int buscaBinaria(Registro chave, int TL)
    {
        int inicio=0, fim = TL-1, meio = fim /2;
        Registro aux = new Registro();
        seekArq(meio);
        aux.leDoArq(arquivo);
        while(inicio < fim && chave.getCodigo()!= aux.getCodigo())
        {
            if(chave.getCodigo() < aux.getCodigo())
            {
                fim = meio-1;
                comp++;
            }
            else
                inicio = meio+1;
            
            meio = (inicio+fim)/2;
            seekArq(meio);
            aux.leDoArq(arquivo);
        }
        if(chave.getCodigo() > aux.getCodigo())
            return meio +1;
        return meio;
    }
    
    public void insercaoBinaria()
    {
        int i, pos;
        Registro aux = new Registro();
        Registro aux2 = new Registro();
        Registro aux3 = new Registro();
        for(i = 0; i < filesize(); i++)
        {
            seekArq(i);
            aux.leDoArq(arquivo);
            pos = buscaBinaria(aux,i);
            for (int j = i; j>pos; j--)
            {
                seekArq(j);
                aux2.leDoArq(arquivo);
                seekArq(j-1);
                aux3.leDoArq(arquivo);
                
                seekArq(j);
                aux3.gravaNoArq(arquivo);
                seekArq(j-1);
                aux2.gravaNoArq(arquivo);
                mov += 2;
            }
            seekArq(pos);
            aux.gravaNoArq(arquivo);
        }
    } 

    public void shakeSort()
    {
        int inicio = 0, fim = filesize()-1;
        Registro reg = new Registro();
        Registro regaux = new Registro();
        while(inicio < fim)
        {
            for(int i = inicio; i<fim; i++)
            {
                seekArq(i);
                reg.leDoArq(arquivo);
                seekArq(i+1);
                regaux.leDoArq(arquivo);
                if(reg.getCodigo() > regaux.getCodigo())
                {
                    comp++;
                    seekArq(i);
                    regaux.gravaNoArq(arquivo);
                    seekArq(i+1);
                    reg.gravaNoArq(arquivo);
                    mov += 2;
                }
            }
            fim--;
            for(int i = fim; i > inicio;i--)
            {
                seekArq(i);
                reg.leDoArq(arquivo);
                seekArq(i-1);
                regaux.leDoArq(arquivo);
                if(reg.getCodigo() < regaux.getCodigo())
                {
                    comp++;
                    seekArq(i);
                    regaux.gravaNoArq(arquivo);
                    seekArq(i-1);
                    reg.gravaNoArq(arquivo);
                    mov +=2;
                }
            }
            inicio++;
        }
    }

    public void bubbleSort()
    {
        int TL = filesize();
        Registro reg = new Registro();
        Registro regaux = new Registro();
        while(TL > 1)
        {
            for(int i = 0; i < TL - 1; i++)
            {
                seekArq(i);
                reg.leDoArq(arquivo);
                regaux.leDoArq(arquivo);
                if(reg.getCodigo() > regaux.getCodigo())
                {
                    comp++;
                    seekArq(i);
                    regaux.gravaNoArq(arquivo);
                    reg.gravaNoArq(arquivo);
                    mov +=2;
                }
            }
            TL--;
        }
    }

    public void selecaoDireta()
    {
        Registro reg = new Registro();
        Registro regmenor = new Registro();
        int menor, TL = filesize();
        for(int i = 0; i < TL-1;i++)
        {
            menor = i;
            seekArq(i);
            regmenor.leDoArq(arquivo);
            for(int j = i+1; j < TL;j++)
            {
                seekArq(j);
                reg.leDoArq(arquivo);
                if(reg.getCodigo() < regmenor.getCodigo())
                {
                    comp++;
                    menor = j;
                    seekArq(j);
                    regmenor.leDoArq(arquivo);
                }
            }
            seekArq(i);
            reg.leDoArq(arquivo);
            seekArq(menor);
            reg.gravaNoArq(arquivo);
            seekArq(i);
            regmenor.gravaNoArq(arquivo);
            mov += 2;
        }
    }

    //.............................................................................



    public void executa() throws IOException
    {
        int tempIni, tempFim;
        
        FileWriter arqTxtResultado = new FileWriter("C:\\Users\\wesle\\OneDrive\\Área de Trabalho\\PO\\PesquisaEordenacao\\ArquivoJava\\TabelaDeResultados.txt");
        PrintWriter gravarArq = new PrintWriter(arqTxtResultado);
        
        // Inserecao Binaria
        initComp();initMov();
        ordenado();
        tempIni = (int) System.currentTimeMillis();
        insercaoBinaria();
        tempFim = (int) System.currentTimeMillis();
        gravarArq.printf("Inserção binaria %n");
        gravarArq.printf("Arquivo ordenado -> Tempo: %d em milessimos %n Comparações: %d Movimentações: %d %n", (tempFim - tempIni), getComp(), getMov());

        initComp();initMov();
        reverso();
        tempIni=(int) System.currentTimeMillis();
        insercaoBinaria();
        tempFim=(int)System.currentTimeMillis();
        gravarArq.printf("Arquivo reverso -> Tempo: %d em milessimos %n Comparações: %d Movimentações: %d %n", (tempFim - tempIni), getComp(), getMov());

        // ShakeSort

        initComp();initMov();
        ordenado();
        tempIni = (int) System.currentTimeMillis();
        shakeSort();
        tempFim = (int) System.currentTimeMillis();
        gravarArq.printf("ShakeSort %n");
        gravarArq.printf("Arquivo ordenado -> Tempo: %d em milessimos %n Comparações: %d Movimentações: %d %n", (tempFim - tempIni), getComp(), getMov());

        initComp();initMov();
        reverso();
        tempIni=(int) System.currentTimeMillis();
        shakeSort();
        tempFim=(int)System.currentTimeMillis();
        gravarArq.printf("Arquivo reverso -> Tempo: %d em milessimos %n Comparações: %d Movimentações: %d %n", (tempFim - tempIni), getComp(), getMov());
        
        // BubbleSort

        initComp();initMov();
        ordenado();
        tempIni = (int) System.currentTimeMillis();
        bubbleSort();
        tempFim = (int) System.currentTimeMillis();
        gravarArq.printf("BubbleSort %n");
        gravarArq.printf("Arquivo ordenado -> Tempo: %d em milessimos %n Comparações: %d Movimentações: %d %n", (tempFim - tempIni), getComp(), getMov());

        initComp();initMov();
        bubbleSort();
        tempIni=(int) System.currentTimeMillis();
        bubbleSort();
        tempFim=(int)System.currentTimeMillis();
        gravarArq.printf("Arquivo reverso -> Tempo: %d em milessimos %n Comparações: %d Movimentações: %d %n", (tempFim - tempIni), getComp(), getMov());

        // Selecao Direta

        initComp();initMov();
        ordenado();
        tempIni = (int) System.currentTimeMillis();
        selecaoDireta();
        tempFim = (int) System.currentTimeMillis();
        gravarArq.printf("Seleçao Direta %n");
        gravarArq.printf("Arquivo ordenado -> Tempo: %d em milessimos %n Comparações: %d Movimentações: %d %n", (tempFim - tempIni), getComp(), getMov());

        initComp();initMov();
        reverso();
        tempIni=(int) System.currentTimeMillis();
        selecaoDireta();
        tempFim=(int)System.currentTimeMillis();
        gravarArq.printf("Arquivo reverso -> Tempo: %d em milessimos %n Comparações: %d Movimentações: %d %n", (tempFim - tempIni), getComp(), getMov());


        gravarArq.close();

    }


}
