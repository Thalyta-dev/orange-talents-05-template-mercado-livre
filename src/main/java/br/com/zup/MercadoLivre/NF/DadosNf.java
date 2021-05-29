package br.com.zup.MercadoLivre.NF;

public class DadosNf {

    private Long idComprador;

    private Long idCompra;

    public Long getIdComprador() {
        return idComprador;
    }

    public DadosNf(Long idComprador, Long idProduto) {
        this.idComprador = idComprador;
        this.idCompra = idCompra;
    }

    public Long getIdCompra() {
        return idCompra;
    }
}
