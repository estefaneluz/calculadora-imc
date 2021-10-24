
package dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author Estef
 */
public class Banco {
    private static List<Usuario> listaUsuarios = new ArrayList<>();
    
    static {
        Usuario usuario = new Usuario();
        usuario.setLogin("admin");
        usuario.setSenha("123");
        
        listaUsuarios.add(usuario);
    }
    
    public Usuario existeUsuario(String login, String senha){
        for(Usuario usuario : listaUsuarios) {
            if(usuario.validar(login, senha)){
                return usuario;
            }
        }
        
        return null;
    }
}
