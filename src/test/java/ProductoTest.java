import factories.implementations.ProductoDao;
import models.Producto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProductoTest {

    @Test
    public void TestMasVeinte(){
        ProductoDao productoDao = new ProductoDao();
        List<Producto> productos = productoDao.read("WHERE cant_exist > 20");
        for (Producto producto : productos){
            System.out.println(producto.getDescripcion());
        }
    }

    @Test
    public void readMenosQuince(){
        ProductoDao productoDao = new ProductoDao();
        List<Producto> productos = productoDao.read("WHERE cant_exist < 15");
        for (Producto producto : productos){
            System.out.println(producto.getDescripcion());
        }
    }

    @Test
    public void readMismaClasificacion(){
        ProductoDao productoDao = new ProductoDao();
        List<Producto> productos = productoDao.read("WHERE clasificacion = comida and precio > 15.50");
        for (Producto producto : productos){
            System.out.println(producto.getDescripcion());
        }
    }

    @Test
    public void readEntreVeinteYCuarentaycinco(){
        ProductoDao productoDao = new ProductoDao();
        List<Producto> productos = productoDao.read("WHERE precio BETWEEN 20.30 and 45.00");
        for (Producto producto : productos){
            System.out.println(producto.getDescripcion());
        }
    }

    @Test
    public void readProductosClasificacion(){
        ProductoDao productoDao = new ProductoDao();
        List<String> clasificaciones = productoDao.grupo("GROUP BY clasificacion");
        for (String clasificacion : clasificaciones){
            System.out.println(clasificacion.toString());
        }
    }
}
