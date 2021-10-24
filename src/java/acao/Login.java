package acao;

import dao.Banco;
import interfaces.IcontroleCalculadora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author Estef
 */
public class Login implements IcontroleCalculadora{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("txtLogin");
        String senha = req.getParameter("txtSenha");
        
        Banco banco = new Banco();
        Usuario usuario = banco.existeUsuario(login, senha);

        if(usuario != null) {
            System.out.println("Usuário existe");
            HttpSession sessao = req.getSession();
            
            sessao.setAttribute("usuarioLogado", usuario);
            return "redirect:entrada?txtAcao=FormCalculadora";
        } else {
            return "redirect:entrada?txtAcao=FormLogin";
        }
    }
    
}
