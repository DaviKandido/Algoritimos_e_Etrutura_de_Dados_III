
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
  
  public static void main(String[] args) {
      Livro l1 = new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien", 49.9F);
      Livro l2 = new Livro(2, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", 59.9F);

      // System.out.println(l1);
      // System.out.println(l2);

      FileOutputStream arq;
      DataOutputStream dados;
      FileInputStream arq2;
      DataInputStream dados2;
      byte[] ba;

      try {

        /* ESCRITA */
        arq = new FileOutputStream("dados/livros.db");
        dados = new DataOutputStream(arq);

        ba = l1.toByteArray();
        dados.writeInt(ba.length);
        dados.write(ba);
        
        ba = l2.toByteArray();
        dados.writeInt(ba.length);
        dados.write(ba);


        arq.close();

        /* LEITURA */
        Livro l3 = new Livro();
        Livro l4 = new Livro();
        int tam;

        arq2 = new FileInputStream("dados/livros.db");
        dados2 = new DataInputStream(arq2);

        tam = dados2.readInt();
        ba = new byte[tam];
        dados2.read(ba);
        l3.fromByteArray(ba);

        tam = dados2.readInt();
        ba = new byte[tam];
        dados2.read(ba);
        l4.fromByteArray(ba);

        System.out.println(l3);
        System.out.println(l4);
        
      }catch (Exception e) {
        System.out.println("Erro ao gravar o arquivo" + e.getMessage());

      }
      
  }
}
