package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Estef
 */
public class AutorizarFiltro implements Filter {
    
    private static final boolean debug = true;

    private FilterConfig filterConfig = null;
    
    public AutorizarFiltro() {
    }    
    
    public void doFilter(
            ServletRequest servletRequest, 
            ServletResponse servletResponse,
            FilterChain chain
    ) throws IOException, ServletException {
        
        Throwable problem = null;
        
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        
        try {
            String acao = request.getParameter("txtAcao");
            HttpSession session = request.getSession();
            boolean usuarioNaoEstaLogado = 
                    (session.getAttribute("usuarioLogado") == null);
            boolean ehUmaAcaoProtegida = !(acao.equals("Login") || acao.equals("FormLogin"));
            
            if(ehUmaAcaoProtegida && usuarioNaoEstaLogado){
                response.sendRedirect("entrada?txtAcao=FormLogin");
                return;
            }
            
            chain.doFilter(request, response);
        } catch (Throwable t) {

            problem = t;
            t.printStackTrace();
        }

    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("AutorizarFiltro:Initializing filter");
            }
        }
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
