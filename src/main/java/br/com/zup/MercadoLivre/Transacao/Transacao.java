package br.com.zup.MercadoLivre.Transacao;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long idpagamento;

    @ManyToOne
    private Compra compra;

    @NotNull
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public Compra getCompra() {
        return compra;
    }

    public Transacao(Compra compra, StatusPagamento statusPagamento, Long idpagamento) {
        this.compra = compra;
        this.dateTime = LocalDateTime.now();
        this.statusPagamento = statusPagamento;
        this.idpagamento = idpagamento;
    }


}
