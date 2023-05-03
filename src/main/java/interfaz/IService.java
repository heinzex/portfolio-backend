package interfaz;

import java.util.List;
import model.Usuario;

public interface IService <T>{

          public List<T> traerLista();

          public Object traer(Long id);
          
          public void crear(T obj);
          
          public boolean editar(T obj);
          
          public void eliminar(Long obj);
          
          default public Usuario traerPorEmail(String user){
                    return null;
          }
}
