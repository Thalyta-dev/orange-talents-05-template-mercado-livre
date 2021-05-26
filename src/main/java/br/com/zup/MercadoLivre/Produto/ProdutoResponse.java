package br.com.zup.MercadoLivre.Produto;

import br.com.zup.MercadoLivre.Categoria.Categoria;
import br.com.zup.MercadoLivre.Login.UsuarioResponse;
import br.com.zup.MercadoLivre.Opnião.Opniao;
import br.com.zup.MercadoLivre.Opnião.OpniaoResponse;
import br.com.zup.MercadoLivre.Pergunta.Pergunta;
import br.com.zup.MercadoLivre.Pergunta.PerguntaResponse;
import br.com.zup.MercadoLivre.Produto.Caracteristicas.Caracteristicas;
import br.com.zup.MercadoLivre.Produto.Caracteristicas.CaracteristicasReponse;
import br.com.zup.MercadoLivre.Produto.Imagens.ImagemResponse;
import br.com.zup.MercadoLivre.Produto.Imagens.Imagens;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProdutoResponse {


    private UsuarioResponse vendedor;

    private  String nomeProduto;

    private BigDecimal preco;

    private Float mediaNota;

    private Integer numeroTotalNotas;

    private  String descricao;

    private Set<CaracteristicasReponse> listaCaracteristicasProduto;

    private List<OpniaoResponse> listaOpnioesResponse;

    private  List<PerguntaResponse> listaPerguntasResponse;

    private List<ImagemResponse> listaImagensProduto;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Set<CaracteristicasReponse> getCaracteristicasReponse() {
        return listaCaracteristicasProduto;
    }

    public List<OpniaoResponse> getOpniaoResponses() {
        return listaOpnioesResponse;
    }

    public List<PerguntaResponse> getPerguntaResponses() {
        return listaPerguntasResponse;
    }

    public Float getMediaNota() {
        return mediaNota;
    }

    public Integer getNumeroTotalNotas() {
        return numeroTotalNotas;
    }

    public List<ImagemResponse> getImagemResponse() {
        return listaImagensProduto;
    }

    public ProdutoResponse(UsuarioResponse usuarioResponse,String nomeProduto, BigDecimal preco, String descricao, Set<CaracteristicasReponse> caracteristicasReponse, List<OpniaoResponse> opniaoResponses, List<PerguntaResponse> perguntaResponses,
                           Float mediaNota, Integer numeroTotalNotas, List<ImagemResponse> imagemResponse) {
        this.vendedor= usuarioResponse;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.descricao = descricao;
        this.listaCaracteristicasProduto = caracteristicasReponse;
        this.listaOpnioesResponse = opniaoResponses;
        this.listaPerguntasResponse = perguntaResponses;
        this.mediaNota = mediaNota;
        this.numeroTotalNotas = numeroTotalNotas;
        this.listaImagensProduto = imagemResponse;
    }


    public ProdutoResponse(Produto produto, ProdutoRepository produtoRepository) {
        this.vendedor = new UsuarioResponse(produto.getVendedor());
        this.nomeProduto = produto.getNome();
        this.preco = produto.getValor();
        this.descricao = produto.getDescricao();
        this.listaCaracteristicasProduto = produto.getCaracteristicas().stream().map(o -> new CaracteristicasReponse(o)).collect(Collectors.toSet());
        this.listaOpnioesResponse = produto.getOpniao().stream().map(o -> new OpniaoResponse(o)).collect(Collectors.toList());
        this.listaPerguntasResponse = produto.getPerguntas().stream().map(o -> new PerguntaResponse(o)).collect(Collectors.toList());
        this.listaImagensProduto = produto.getImagens().stream().map(o -> new ImagemResponse(o)).collect(Collectors.toList());
        this.mediaNota = produtoRepository.mediaDeAvaliaçoes(produto.getId()).get();
        this.numeroTotalNotas = produtoRepository.quantidadeNota(produto.getId()).get();

    }
}
