package konstantinesoft.firstrestapispring.entities;

public class BlogPost {
    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoLettura;

    public BlogPost() {}

    public BlogPost(String categoria, String titolo, String cover, String contenuto, int tempoLettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = cover;
        this.contenuto = contenuto;
        this.tempoLettura = tempoLettura;
    }

    public BlogPost(int id, String categoria, String titolo, String cover, String contenuto, int tempoLettura) {
        this.id = id;
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = cover;
        this.contenuto = contenuto;
        this.tempoLettura = tempoLettura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public int getTempoLettura() {
        return tempoLettura;
    }

    public void setTempoLettura(int tempoLettura) {
        this.tempoLettura = tempoLettura;
    }
}
