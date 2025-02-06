
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class main {
  
  public static void main(String[] args) {
      Livro l1 = new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien", 49.9F);
      Livro l2 = new Livro(2, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", 59.9F);

      // System.out.println(l1);
      // System.out.println(l2);

      FileOutputStream arq;
      DataOutputStream dados;
      FileInputStream arq2;
      DataInputStream dados2;

      try {

        /* ESCRITA */
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

        /* LEITURA */
        Livro l3 = new Livro();
        Livro l4 = new Livro();

        arq2 = new FileInputStream("dados/livros.db");
        dados2 = new DataInputStream(arq2);

        l3.idLivro = dados2.readInt();
        l3.titulo = dados2.readUTF();
        l3.autor = dados2.readUTF();
        l3.preco = dados2.readFloat();

        System.out.println(l3);

        l4.idLivro = dados2.readInt();
        l4.titulo = dados2.readUTF();
        l4.autor = dados2.readUTF();
        l4.preco = dados2.readFloat();

        System.out.println(l4);

        
      }catch (Exception e) {
        System.out.println("Erro ao gravar o arquivo" + e.getMessage());

      }
      
  }
}
