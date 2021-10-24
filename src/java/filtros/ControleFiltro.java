package filtros;

import interfaces.IcontroleCalculadora;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Estef
 */
public class ControleFiltro implements Filter {
    
    private static final boolean debug = true;

    private FilterConfig filterConfig = null;
    
    public ControleFiltro() {
    }    
    
    public void doFilter(
            ServletRequest servletRequest, 
            ServletResponse servletResponse,
            FilterChain chain
    )   throws IOException, ServletException {
        
        Throwable problem = null;
        
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAcao = request.getParameter("txtAcao");
        String nomeDaClasse = "acao." + paramAcao;
        String nome = null;
        try {
            Class classe = Class.forName(nomeDaClasse);
            IcontroleCalculadora acao = (IcontroleCalculadora) 
                    classe.newInstance();
            nome = acao.executa(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }
        
        String[] tipoEndereco = nome.split(":");
        if(tipoEndereco[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher(
                    "WEB-INF/view/"+tipoEndereco[1]
            );
            
            rd.forward(request, response);
        } else {
            response.sendRedirect(tipoEndereco[1]);
        }
    }

    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("ControleFiltro:Initializing filter");
            }
        }
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
