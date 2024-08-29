package com.nombreCompania.appfacturas.model;

public class ÍtemFactura {
private Producto producto;
private int cantidad;

    public ÍtemFactura(Producto Producto, int cantidad) {
        this.producto = Producto;
        this.cantidad = cantidad;
    }


    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public float calcularImporte() {
        return (float) (cantidad*producto.getPrecio());
    }


    @Override
    public String toString() {
        return producto.getNombre() + "\t" + cantidad + "\t" + calcularImporte();
    }
}