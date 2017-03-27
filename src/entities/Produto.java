package entities;

import java.math.BigDecimal;

public class Produto {

    private Long id;
    private String nome;
    private BigDecimal preco;
    private Categoria categoria;

    public Produto(Long id, String nome, BigDecimal preco, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

}
