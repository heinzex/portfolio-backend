package interfaz;

import java.util.List;

public interface IService <T>{

          public List<T> traerLista();

          public Object traer(Long id);
          
          public void crear(T obj);
          
          public boolean editar(T obj);
          
          public void eliminar(Long obj);
}
