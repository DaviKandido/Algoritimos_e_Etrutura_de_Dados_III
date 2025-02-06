
import java.text.DecimalFormat;


public class Livro{
  protected int idLivro;
  protected String titulo;
  protected String autor;
  protected float preco;
  
  private DecimalFormat df = new DecimalFormat("#,###.00");

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
           "\nPreço: R$" + df.format(this.preco);
          
  }

}