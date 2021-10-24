package acao;

import interfaces.IcontroleCalculadora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Estef
 */
public class FormLogin implements IcontroleCalculadora {
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "forward:formLogin.jsp";
    }
}
