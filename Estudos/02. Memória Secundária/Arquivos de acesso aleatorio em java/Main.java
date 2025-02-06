
import java.io.RandomAccessFile;

public class Main {
  
  public static void main(String[] args) {
      Livro l1 = new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien", 49.9F);
      Livro l2 = new Livro(2, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", 59.9F);

      // System.out.println(l1);
      // System.out.println(l2);

      RandomAccessFile arq;
      byte[] ba;

      try {

        /* ESCRITA */
        arq = new RandomAccessFile("dados/livros.db", "rw");

        long p1 = arq.getFilePointer();

        ba = l1.toByteArray();
        arq.writeInt(ba.length);
        arq.write(ba);

        long p2 = arq.getFilePointer();
        
        ba = l2.toByteArray();
        arq.writeInt(ba.length);
        arq.write(ba);


        /* LEITURA */
        Livro l3 = new Livro();
        Livro l4 = new Livro();
        int tam;

        arq.seek(p2); //volta o ponteiro para o inicio do 2º livro

        tam = arq.readInt();
        ba = new byte[tam];
        arq.read(ba);
        l3.fromByteArray(ba);

        arq.seek(p1); //volta o ponteiro para o inicio do 1º livro

        tam = arq.readInt();
        ba = new byte[tam];
        arq.read(ba);
        l4.fromByteArray(ba);

        System.out.println(l3);
        System.out.println(l4);

        arq.close();
        
      }catch (Exception e) {
        System.out.println("Erro ao gravar o arquivo: " + e.getMessage());

      }
      
  }
}

// ID: 1, POS: 0
// ID: 2, POS: 50