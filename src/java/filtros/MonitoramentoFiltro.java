package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Estef
 */
public class MonitoramentoFiltro implements Filter {
    
    private static final boolean debug = true;

    private FilterConfig filterConfig = null;
    
    public MonitoramentoFiltro() {
    }    
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        Throwable problem = null;
        try {
            long antes = System.currentTimeMillis();
            String acao = request.getParameter("txtAcao");
            
            chain.doFilter(request, response);
            
            long depois = System.currentTimeMillis();
            System.out.println(
                    "Tempo de execução da ação: " + acao + " = " + (depois - antes)
            );
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
                log("MonitoramentoFiltro:Initializing filter");
            }
        }
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
