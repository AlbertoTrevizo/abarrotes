package factories.implementations;

import conections.Conexion;
import factories.interfaces.daoProducto;
import models.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao implements daoProducto{
    public void create(Producto obj) {

    }

    public List<Producto> read(String criteria) {
        List<Producto> productos = new ArrayList<>();
        try {
            Conexion conexion = Conexion.getInstance();
            Statement st = conexion.getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s",Producto.Q_ALL, criteria));
            while(rs.next()){
                productos.add(makeProduct(rs));
            }
        }catch (ClassNotFoundException | SQLException ex){

        }
        return productos;
    }

    @Override
    public List<String> grupo(String criteria) {
        List<String> clasificaciones = new ArrayList<>();
        try {
            Conexion conexion = Conexion.getInstance();
            Statement st = conexion.getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s",Producto.Q_GROUP, criteria));
            while(rs.next()){
                Integer i = 1;
                clasificaciones.add(rs.getString(i++));
                clasificaciones.add(rs.getString(i++));
            }
        }catch (ClassNotFoundException | SQLException ex){

        }
        return clasificaciones;
    }

    private Producto makeProduct(ResultSet rs) throws SQLException {
        Producto producto = new Producto();
        Integer i = 1;
        producto.setId(rs.getLong(i++));
        producto.setDescripcion(rs.getString(i++));
        producto.setPrecio(rs.getFloat(i++));
        producto.setClasificacion(rs.getString(i++));
        producto.setCantExistencia(rs.getInt(i++));
        producto.setCantMax(rs.getInt(i++));
        producto.setCantMin(rs.getInt(i++));
        return producto;
    }
}
