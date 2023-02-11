package ListadeLista;

public class Main {
    
    public static void main(String[] args) {
     
        Lista lista = new Lista();
        
        lista.inicializa();

        lista.inserirEstado("Paraná");
        lista.inserirEstado("Santa Catarina");
        lista.inserirEstado("São Paulo");
        lista.inserirCidade("Apucarana");
        lista.inserirCidade("Arapongas");
        lista.inserirCidade("Maringa");

     /* 
        lista.inserirCidade2("Apucarana", "Paraná");
        lista.inserirCidade2("ApucaranaB", "Paraná");
        lista.inserirCidade2("ApucaranaC", "Paraná");
        lista.inserirCidade2("Blumenal", "Santa Catarina");
     */

        lista.exibirTudo();
      //System.out.println(lista.buscarEstado("PARANÁ")); 
      //System.out.println(lista.buscarCidade("apucarana"));

      //System.out.println("Achou? "+lista.buscaPares("paraná", "Maringa"));


    }

}
