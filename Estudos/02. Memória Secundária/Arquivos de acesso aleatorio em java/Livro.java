
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;


public class Livro{
  protected int idLivro;
  protected String titulo;
  protected String autor;
  protected float preco;
  
  private DecimalFormat df = new DecimalFormat("#,###.00");

  public Livro(){
    this.idLivro = -1;
    this.titulo = "";
    this.autor = "";
    this.preco = 0F; 
  }

  public Livro(int idLivro, String titulo, String autor, float preco){
    this.idLivro = idLivro;
    this.titulo = titulo;
    this.autor = autor;
    this.preco = preco; 
  }

  public String toString(){
   
    return "\nID: " + this.idLivro +
           "\nTítulo: " + this.titulo +
           "\nAutor: " + this.autor +
           "\nPreço: R$ " + df.format(this.preco);   
  }

  public byte[] toByteArray() throws IOException{
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutput dos = new DataOutputStream(baos);

    dos.writeInt(this.idLivro);
    dos.writeUTF(this.titulo);
    dos.writeUTF(this.autor);
    dos.writeFloat(this.preco);
    
    return baos.toByteArray();
  }

  public boolean fromByteArray(byte[] bytes) throws IOException{
    ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
    DataInputStream dis = new DataInputStream(bais);

    this.idLivro = dis.readInt();
    this.titulo = dis.readUTF();
    this.autor = dis.readUTF();
    this.preco = dis.readFloat();

    return true;
  }

}