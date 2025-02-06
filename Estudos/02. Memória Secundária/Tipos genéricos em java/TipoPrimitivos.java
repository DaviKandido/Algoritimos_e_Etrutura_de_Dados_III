
public class TipoPrimitivos {

  public static void main(String[] args) {


    // List<Usuario> usuarios = new ArrayList<Usuario>();
    // List<Cliente> clientes = new ArrayList<Cliente>();
    // List<Produto> produtos = new ArrayList<Produto>();


    // List<String> lista = new ArrayList<String>();
    // lista.add("Olá mundo!");
    // String s = lista.get(0);   // não é necessária a coerção de tipos


    Caixa caixa = new Caixa();
    caixa.armazena(new String("Olá mundo"));
    String s = (String)caixa.recupera();
    System.out.println(s);


    Caixa<Integer> caixaDeInteiro = new Caixa<>();
    Caixa<String>  caixaDeString  = new Caixa<>();
    Caixa<Produto> caixaDeProduto = new Caixa<>();
  }
}


// public class Cliente implements Entidade {
//   protected int idCliente;
//   public int getID() {
//     return idCliente;
//   }
//   ...
// }

// public class Produto implements Entidade {
//   protected int idProduto;
//   public int getID() {
//     return idProduto;
//   }
//   ...
// }