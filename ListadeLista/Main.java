package ListadeLista;

public class Main {
    
    public static void main(String[] args) {
     
        Lista lista = new Lista();
        lista.inicializa();

        /*
        lista.inserirEstadoOC("Paraná");
        lista.inserirEstadoOC("R");
        lista.inserirEstadoOC("W");
        lista.inserirEstadoOC("A");
        lista.inserirEstadoOC("E");
        */
        
        // item A.
        lista.inserirPares("Teste1", "Paraná");
        lista.inserirPares("Teste2", "R");
        lista.inserirPares("Teste3", "Paraná");
        lista.inserirPares("Teste4", "A");
        lista.inserirPares("Teste5", "E");
        lista.inserirPares("Teste6", "W");

        // item B.
        

        // item C.
        Estado est = lista.buscarEstado("Paraná");
        System.out.println("Estado: "+est);
        // item D.
        lista.exibirCidades("Paraná");

        // item E.
        System.out.println("Achou? "+lista.buscarPares("paraná", "teste3"));
        System.out.println("Achou? "+lista.buscarPares("paraná", "teste11"));
        
        lista.exibirTudo();
    }

}
