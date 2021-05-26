package br.com.zup.MercadoLivre.Login;

public class UsuarioResponse {

    private String email;

    public String getEmail() {
        return email;
    }

    public UsuarioResponse(Usuario usuario) {

        this.email = usuario.getUsername();
    }
}
