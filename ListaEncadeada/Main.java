package ListaEncadeada;

public class Main {
    
    public static void main(String[] args) {

        ListaEncadeada lista = new ListaEncadeada();

        lista.inicializa();
        lista.inserirNoInicio(10);
        lista.inserirNoInicio(20);
        lista.inserirNoInicio(30);
        lista.inserirNoFim(40);
        lista.inserirNoFim(50);
        lista.inserirNoInicio(5);
        lista.exibir();

        //System.out.println(lista.busca_exaustiva(11));
        //System.out.println(lista.busca_exaustiva(10).getAnt().getInfo());
        //lista.remover(20);

        //lista.insercaoDireta();
        //lista.selecaoDireta();
        //lista.bubbleSort();

        lista.exibir();
    }
}
