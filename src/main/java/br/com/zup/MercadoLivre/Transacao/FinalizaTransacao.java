package br.com.zup.MercadoLivre.Transacao;

import br.com.zup.MercadoLivre.NF.DadosNf;
import br.com.zup.MercadoLivre.NF.ServicoParaGerarNF;
import br.com.zup.MercadoLivre.Pergunta.Email;
import br.com.zup.MercadoLivre.RankingVendedor.RankingVendedorDto;
import br.com.zup.MercadoLivre.RankingVendedor.ServicoParaEnviarRankingVendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class FinalizaTransacao {

    @Autowired
    private Email enviarEmailServer;

    @Autowired
    private ServicoParaGerarNF servicoParaGerarNF;

    @Autowired
    private ServicoParaEnviarRankingVendedor rankingVendedor;


    public ResponseEntity<?> transacao(Transacao transacao, HttpServletRequest request) {


        DadosNf dadosNf = new DadosNf(transacao.getCompra().getComprador().getId(), transacao.getCompra().getId());

        RankingVendedorDto rankingDto = new RankingVendedorDto(transacao.getCompra().getProduto().getVendedor().getId(), transacao.getCompra().getId());

        if (transacao.getStatusPagamento().equals(StatusPagamento.SUCESSO)) {

            servicoParaGerarNF.gerarNfs(request.getHeader("Authorization"), dadosNf);

            rankingVendedor.ranking(request.getHeader("Authorization"), rankingDto);


            return ResponseEntity.ok().body(enviarEmailServer.enviarEmail(transacao.getCompra().getComprador().getUsername(),
                    transacao.getCompra().getProduto().getVendedor().getUsername(),
                    "A compra do produto " + transacao.getCompra().getProduto().getNome() + " foi finalizada com sucesso",
                    "A sua transação na plataforma " + transacao.getCompra().getMetodoPagamento() + " foi finalizada, agora aguarde o produto ser entregue"
            ));

        } else {


            String email = enviarEmailServer.enviarEmail(transacao.getCompra().getComprador().getUsername(),
                    transacao.getCompra().getProduto().getVendedor().getUsername(),
                    "A compra do produto " + transacao.getCompra().getProduto().getNome() + " não foi finalizada com sucesso ",
                    "A sua transação na plataforma " + transacao.getCompra().getMetodoPagamento() + " não foi realizada com sucesso, mas para tentar novamente acesse a url: "
            );

            return ResponseEntity.ok().body(email);


        }
    }
}
