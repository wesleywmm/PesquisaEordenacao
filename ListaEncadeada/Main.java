package ListaEncadeada;

public class Main {

    private ListaEncadeada lista;

    public Main()
    {
        lista = new ListaEncadeada();
    }

    public void executa()
    {
        lista.inserirNoInicio(10);
        lista.inserirNoInicio(20);
        lista.inserirNoInicio(30);
        lista.inserirNoFim(60);
        lista.inserirNoFim(50);
        lista.inserirNoFim(12);
        lista.inserirNoFim(1);
        lista.inserirNoInicio(16);
        //System.out.println(lista.busca_exaustiva(11));
        //System.out.println(lista.busca_exaustiva(10).getAnt().getInfo());
        //lista.remover(20);

        //lista.insercaoDireta();
        //lista.selecaoDireta();
        //lista.bubbleSort(); 
        //lista.shake();
        //lista.shell();
        //lista.heap();
        //lista.quickSemPivo();
        //lista.quickComPivo();
        //lista.insercaoBinaria();
        //lista.mergeSort_priImp();
        //lista.mergeSort_segImp(lista);
        //lista.gnomeSort();
        //lista.combSort();
        
        lista.exibirFormatado();
        
        lista.exibirFormatado();
    }

    public static void main(String[] args) {

      Main main = new Main();
      main.executa();   
        
    }
}
