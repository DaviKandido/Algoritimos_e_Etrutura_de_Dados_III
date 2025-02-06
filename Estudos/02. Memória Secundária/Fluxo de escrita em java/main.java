
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class main {
  
  public static void main(String[] args) {
      Livro l1 = new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien", 49.9F);
      Livro l2 = new Livro(2, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", 59.9F);

      System.out.println(l1);
      System.out.println(l2);

      FileOutputStream arq;
      DataOutputStream dados;

      try {
        arq = new FileOutputStream("dados/livros.db");
        dados = new DataOutputStream(arq);

        dados.writeInt(l1.idLivro);
        dados.writeUTF(l1.titulo);
        dados.writeUTF(l1.autor);
        dados.writeFloat(l1.preco);

        dados.writeInt(l2.idLivro);
        dados.writeUTF(l2.titulo);
        dados.writeUTF(l2.autor);
        dados.writeFloat(l2.preco);

        dados.close();
        arq.close();

      } catch (Exception e) {
        System.out.println("Erro ao gravar o arquivo" + e.getMessage());

      }
      
  }
}
