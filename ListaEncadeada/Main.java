package ListaEncadeada;

public class Main {

    private ListaEncadeada lista;

    public Main()
    {
        lista = new ListaEncadeada();
    }

    public void executa()
    {
        lista.gerarListaAleatoria(20);
        System.out.println("\n----------------------------ORDENAÇÃO POR INSERÇÃO DIRETA----------------------------"); 
        lista.exibirDesordenado();
        lista.insercaoDireta();
        lista.exibirFormatado();

        lista.gerarListaPredefinida();
        System.out.println("\n----------------------------ORDENAÇÃO POR INSERÇÃO BINÁRIA----------------------------"); 
        lista.exibirDesordenado();
        lista.insercaoBinaria();
        lista.exibirFormatado();

        lista.gerarListaAleatoria(20);
        System.out.println("\n----------------------------ORDENAÇÃO POR SELEÇÃO DIRETA----------------------------"); 
        lista.exibirDesordenado();
        lista.selecaoDireta();
        lista.exibirFormatado();

        lista.gerarListaAleatoria(20);
        System.out.println("\n----------------------------ORDENAÇÃO POR BUBBLESORT----------------------------"); 
        lista.exibirDesordenado();
        lista.bubbleSort();
        lista.exibirFormatado();

        lista.gerarListaAleatoria(20);
        System.out.println("\n----------------------------ORDENAÇÃO POR SHAKESORT----------------------------"); 
        lista.exibirDesordenado();
        lista.shake();
        lista.exibirFormatado();

        lista.gerarListaAleatoria(20);
        System.out.println("\n----------------------------ORDENAÇÃO POR SHELSORT----------------------------"); 
        lista.exibirDesordenado();
        lista.shell();
        lista.exibirFormatado();

        lista.gerarListaAleatoria(20);
        System.out.println("\n----------------------------ORDENAÇÃO POR HEAPSORT----------------------------"); 
        lista.exibirDesordenado();
        lista.heap();
        lista.exibirFormatado();

        lista.gerarListaAleatoria(20);
        System.out.println("\n----------------------------ORDENAÇÃO POR QUICK-SEM-PIVO----------------------------"); 
        lista.exibirDesordenado();
        lista.quickSemPivo();
        lista.exibirFormatado();

        lista.gerarListaAleatoria(20);
        System.out.println("\n----------------------------ORDENAÇÃO POR QUICK-COM-PIVO----------------------------"); 
        lista.exibirDesordenado();
        lista.quickComPivo();
        lista.exibirFormatado();
        
        lista.gerarListaAleatoria(16);
        System.out.println("\n----------------------------ORDENAÇÃO POR MERGE----------------------------"); 
        lista.exibirDesordenado();
        lista.mergeSort_priImp();
        lista.exibirFormatado();

        lista.gerarListaAleatoria(20);
        System.out.println("\n----------------------------ORDENAÇÃO POR GNOMESORT----------------------------"); 
        lista.exibirDesordenado();
        lista.gnomeSort();
        lista.exibirFormatado();

        lista.gerarListaAleatoria(20);
        System.out.println("\n----------------------------ORDENAÇÃO POR COMBSORT----------------------------"); 
        lista.exibirDesordenado();
        lista.combSort();
        lista.exibirFormatado();
       
        lista.gerarListaAleatoria(20);
        System.out.println("\n----------------------------ORDENAÇÃO POR TIMSORT----------------------------"); 
        lista.exibirDesordenado();
        lista.timSort();
        lista.exibirFormatado();

        lista.gerarListaAleatoria(20);
        System.out.println("\n----------------------------ORDENAÇÃO POR RADIXSORT----------------------------"); 
        lista.exibirDesordenado();
        lista.radixSort();
        lista.exibirFormatado();
  
    }

    public static void main(String[] args) {

      Main main = new Main();
      main.executa();   
        
    }
}
