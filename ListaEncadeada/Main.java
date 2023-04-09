package ListaEncadeada;

public class Main {
    
    public static void main(String[] args) {

        ListaEncadeada lista = new ListaEncadeada();

        lista.inicializa();
        lista.inserirNoInicio(10);
        lista.inserirNoInicio(20);
        lista.inserirNoInicio(30);
        lista.inserirNoFim(60);
        lista.inserirNoFim(50);
        lista.inserirNoFim(12);
        lista.inserirNoFim(1);
        lista.inserirNoInicio(16);
        lista.exibir();

        //System.out.println(lista.busca_exaustiva(11));
        //System.out.println(lista.busca_exaustiva(10).getAnt().getInfo());
        //lista.remover(20);

        //lista.insercaoDireta();
        //lista.selecaoDireta();
        //lista.bubbleSort(); 
        //lista.shake();
        //lista.shell();
        //lista.heap();
        //lista.quickSemPivo(0, lista.getTamanho()-1);
        //lista.quickComPivo(0, lista.getTamanho()-1);

        lista.exibir();
    }
}
