/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acao;

import dao.Banco;
import interfaces.IcontroleCalculadora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Imc;

/**
 *
 * @author Estef
 */
public class Calculadora implements IcontroleCalculadora{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {                
        Double peso = Double.parseDouble(req.getParameter("txtPeso"));
        Double altura = Double.parseDouble(req.getParameter("txtAltura")); 
        
        Imc imc = new Imc();
        imc.setPeso(peso);
        imc.setAltura(altura);

        req.setAttribute("imc", imc);
        
        return "forward:calculadora_imc.jsp";
    }
    
}
