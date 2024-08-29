//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package com.nombreCompania.appfacturas.model;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNif("5555-5");
        cliente.setNombre("Andrés");

        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese una descripción de la factura: ");
        String descripcion = s.nextLine();
        Factura factura = new Factura(descripcion, cliente);

        Producto producto;

        System.out.println();

        for(int i = 0; i<5; i++){
            producto = new Producto();
            System.out.print("Ingrese producto nº " + producto.getCodigo() + ": ");
            producto.setNombre(s.nextLine());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(s.nextFloat());

            System.out.print("Ingrese la cantidad: ");
            factura.addItemFactura(new ÍtemFactura(producto, s.nextInt()));

            System.out.println();
            s.nextLine();
        }
        System.out.println(factura);
    }
}