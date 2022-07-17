public class FilmeTO {

    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    private String categoria;
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    private String nota;
    
    public String getNota() {
        return nota;
    }
    public void setNota(String nota) {
        this.nota = nota;
    }

    public FilmeTO(String nome, String categoria, String nota){
        this.nome = nome;
        this.categoria = categoria;
        this.nota = nota;
    }

}