package com.nombreCompania.appfacturas.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Factura {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ÍtemFactura[] items;



    private int indiceItems = 0;
    private static final int MAX_ITEMS = 10;
    private static int ultimoFolio = 0;

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.fecha = new Date();
        this.items = new ÍtemFactura[MAX_ITEMS];

        ultimoFolio++;
        this.folio = ultimoFolio;
    }

    public void addItemFactura(ÍtemFactura item) {
        if (indiceItems < MAX_ITEMS) {
            items[indiceItems] = item;
            indiceItems++;
        } else {
            System.out.println("No se pueden agregar más ítems. Se alcanzó el máximo permitido.");
        }
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (ÍtemFactura item : items) {
            if (item != null) {
                total += item.calcularImporte();
            }
        }
        return total;
    }


    public String generarDetalle() {
        StringBuilder builder = new StringBuilder("Factura Nº: ");
        builder.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIF: ")
                .append(cliente.getNif())
                .append("\nDescripción: ")
                .append(this.descripcion)
                .append("\n");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        builder.append("Fecha Emisión: ")
                .append(dateFormat.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\n");

        for (int i = 0; i < indiceItems; i++) {
            ÍtemFactura item = items[i];
            if (item != null) {
                builder.append(i + 1) // Número del ítem
                        .append("\t")
                        .append(item)
                        .append("\n");
            }
        }
        builder.append("\nGran Total: ")
                .append(calcularTotal());
        return builder.toString();
    }


    @Override
    public String toString() {
        return generarDetalle();
    }
}