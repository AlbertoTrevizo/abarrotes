package models;

public class Producto {
    public static final String FIELDS = "id_producto, descripcion, precio, clasificacion, " +
            "cant_exist, cant_max, cant_min";
    public static final String COUNT = "clasificacion, count(clasificacion)";
    public static final String TABLE = "productos";
    public static final String Q_ALL = String.format("SELECT %s FROM %s", FIELDS, TABLE);
    public static final String Q_GROUP = String.format("SELECT %s FROM %s", COUNT, TABLE);
    private Long id;
    private String descripcion;
    private Float precio;
    private String clasificacion;
    private Integer cantExistencia;
    private Integer cantMin;
    private Integer cantMax;

    public Producto() {
    }

    public Producto(Long id, String descripcion, Float precio, String clasificacion, Integer cantExistencia, Integer cantMin, Integer cantMax) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.clasificacion = clasificacion;
        this.cantExistencia = cantExistencia;
        this.cantMin = cantMin;
        this.cantMax = cantMax;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Integer getCantExistencia() {
        return cantExistencia;
    }

    public void setCantExistencia(Integer cantExistencia) {
        this.cantExistencia = cantExistencia;
    }

    public Integer getCantMin() {
        return cantMin;
    }

    public void setCantMin(Integer cantMin) {
        this.cantMin = cantMin;
    }

    public Integer getCantMax() {
        return cantMax;
    }

    public void setCantMax(Integer cantMax) {
        this.cantMax = cantMax;
    }
}
