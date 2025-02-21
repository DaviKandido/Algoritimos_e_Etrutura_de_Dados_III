import aeds3.*;

public class Principal {
    
    public static void main(String[] args) {
        try {
            Arquivo arqLivros = new Arquivo("livros");
            Livro l = arqLivros.read("9788595159907");
            if(l != null) {
                System.out.println(l.getTitulo());
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void popular(Arquivo arquivo) throws Exception {
        Livro l1 = new Livro("9788575225639", "Entendendo Algoritmos", "Aditya Y. Bhargava", 51.30F);
        Livro l2 = new Livro("9788595159907", "Algoritmos - Teoria e Prática", "Thomas H. Cormen", 416.52F);
        arquivo.create(l1);
        arquivo.create(l2);
    }
}
