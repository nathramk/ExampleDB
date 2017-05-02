package pe.edu.upeu.example.frm;

import android.widget.EditText;

import pe.edu.upeu.example.R;
import pe.edu.upeu.example.Register;
import pe.edu.upeu.example.bean.Carrito;

/**
 * Created by Alumnos on 02/05/2017.
 */

public class FrmCarritoHelper {
    private EditText txtProduct,txtCantidad,txtPrecio,txtTotal;

    public FrmCarritoHelper(Register register){
        txtProduct = (EditText)register.findViewById(R.id.txtProduct);
        txtCantidad = (EditText) register.findViewById(R.id.txtCantidad);
        txtPrecio = (EditText) register.findViewById(R.id.txtPrecio);
        txtTotal = (EditText) register.findViewById(R.id.txtTotal);
    }
    public void setCarrito(Carrito carrito){

        txtProduct.setText(carrito.getDesProducto());
        txtCantidad.setText(carrito.getCantidad());
        txtPrecio.setText(carrito.getPrecio());
        txtTotal.setText(carrito.getTotal());

    }

    public Carrito getCarrito(){

        Carrito carrito = new Carrito();
        carrito.setDesProducto(txtProduct.getText().toString());
        carrito.setCantidad(txtCantidad.getText().length());
        carrito.setCantidad(txtTotal.getText().length());
        carrito.setTotal(txtTotal.getText().length());

        return carrito;
    }
}
