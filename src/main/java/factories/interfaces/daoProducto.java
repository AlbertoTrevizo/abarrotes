package factories.interfaces;

import models.Producto;

import java.util.List;

public interface daoProducto {

    public void create(Producto obj);

    public List<Producto> read(String criteria);

    public List<String> grupo(String criteria);
}
