package br.com.zup.MercadoLivre.RankingVendedor;

public class RankingVendedorDto {

    private Long idVendedor;

    private Long idCompra;

    public Long getIdVendedor() {
        return idVendedor;
    }

    public RankingVendedorDto(Long idVendedor, Long idCompra) {
        this.idVendedor = idVendedor;
        this.idCompra = idCompra;
    }

    public Long getIdCompra() {
        return idCompra;
    }
}
