package br.com.zup.MercadoLivre.Produto.Caracteristicas;

public class CaracteristicasReponse {

    private String nome;

    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public CaracteristicasReponse(Caracteristicas caracteristicas) {
        this.nome = caracteristicas.getNome();
        this.descricao = caracteristicas.getDescricao();
    }
}
