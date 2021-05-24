package br.com.zup.MercadoLivre.Produto.Caracteristicas;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class CarasteristcasRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    public Caracteristicas toModel(){

        return  new Caracteristicas(this.nome,this.descricao);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarasteristcasRequest that = (CarasteristcasRequest) o;
        return nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
