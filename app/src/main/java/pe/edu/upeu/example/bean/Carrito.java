package pe.edu.upeu.example.bean;

/**
 * Created by Alumnos on 02/05/2017.
 */

public class Carrito {
    private Long codProducto;
    private String desProducto;
    private int cantidad;
    private int precio;
    private int total;

    public Carrito(){

    }

    public Long getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Long codProducto) {
        this.codProducto = codProducto;
    }

    public String getDesProducto() {
        return desProducto;
    }

    public void setDesProducto(String desProducto) {
        this.desProducto = desProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Carrito(Long codProducto, String desProducto, int cantidad, int precio, int total) {
        this.codProducto = codProducto;
        this.desProducto = desProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "desProducto='" + desProducto + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", total=" + total +
                '}';
    }
}
