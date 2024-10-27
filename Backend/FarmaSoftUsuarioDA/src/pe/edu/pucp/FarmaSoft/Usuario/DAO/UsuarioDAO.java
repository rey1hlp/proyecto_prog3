
package pe.edu.pucp.FarmaSoft.Usuario.DAO;

import java.util.ArrayList;
import pe.edu.pucp.FarmaSoft.Usuario.Model.Usuario;

public interface UsuarioDAO {
    int insertar(Usuario usuario);
    Usuario obtenerPorDni(int dni);
    int actualizar(Usuario usuario);
    int eliminar(int dni);
    
    int darDeBaja(int dni);
    int darDeAlta(int dni);
    ArrayList<Usuario> listarTodos();
    //ArrayList<Usuario> listarPorFiltros();
    
}
