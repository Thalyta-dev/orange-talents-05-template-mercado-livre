package br.com.zup.MercadoLivre.Opnião;
public class OpniaoResponse {

    private String titulo;

    private Integer nota;

    private  String descricao;


    public String getTitulo() {
        return titulo;
    }

    public OpniaoResponse(Opniao  opniao) {

        this.titulo = opniao.getTitulo();
        this.nota = opniao.getNota();
        this.descricao = opniao.getDescricao();
    }

    public Integer getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }




}
