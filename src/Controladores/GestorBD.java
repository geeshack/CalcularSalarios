package Controladores;

import java.io.Console;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hectorg
 */
public class GestorBD {

    SqlConnection conn = new SqlConnection();
    Connection con = null;

    public GestorBD() {
    }

    public ArrayList listaProductos(int tipo, String buscar) {
        ArrayList misProductos = new ArrayList();
        Producto producto = new Producto();
        String SQL = "";
        int codSucursal = Session.getInstance().getCodSucursal();
        try {
            if (tipo == 1) {
                SQL = "select cod_producto, nombre, familia, marca, tipo, precio, p.descripcion as descripcion, cant_por_caja, precioPorMenor, precioPorMayor, precioMinMenor, precioMinMayor, u.descripcion as unidad from producto p,unidad u where p.nombre like '%" + buscar + "%' and p.cod_unidad = u.cod_unidad";
            } else if (tipo == 2) {
                SQL = "select cod_producto, nombre, familia, marca, tipo, precio, p.descripcion as descripcion, cant_por_caja, precioPorMenor, precioPorMayor, precioMinMenor, precioMinMayor, u.descripcion as unidad from producto p,unidad u where p.descripcion like '%" + buscar + "%' and p.cod_unidad = u.cod_unidad";
            } else {
                SQL = "select cod_producto, nombre, familia, marca, tipo, precio, p.descripcion as descripcion, cant_por_caja, precioPorMenor, precioPorMayor, precioMinMenor, precioMinMayor, u.descripcion as unidad from producto p,unidad u where p.cod_unidad = u.cod_unidad";
            }
            //System.out.print(SQL);
            conn.conectar();
            con = conn.con;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                producto = new Producto();
                producto.setCodProducto(rs.getString("cod_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setFamilia(rs.getString("familia"));
                producto.setMarca(rs.getString("marca"));
                producto.setTipo(rs.getString("tipo"));
                producto.setPrecio(rs.getString("precio"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCant_por_caja(rs.getInt("cant_por_caja"));
                producto.setPrecioPorMenor(rs.getString("precioPorMenor"));
                producto.setPrecioPorMayor(rs.getString("precioPorMayor"));
                producto.setPrecioMinPorMenor(rs.getString("precioMinMenor"));
                producto.setPrecioMinPorMayor(rs.getString("precioMinMayor"));
                producto.setCant_disponible(BuscarCantidadProducto(rs.getString("cod_producto")));
                producto.setCajas_disponible(BuscarCantidadCajas(rs.getString("cod_producto")));
                producto.setUnidad(rs.getString("unidad"));
                //producto.setCajas_disponible(rs.getInt(10));

                misProductos.add(producto);
            }
            con.close();
            return misProductos;
        } catch (Exception es) {
            System.out.print(es.getMessage());
            return misProductos;
        }
    }

    /*
    public ArrayList getListaClientes(String busqueda) {
    ArrayList misClientes = new ArrayList();
    ClienteClass miCliente = new ClienteClass();
    try {
    String SQL = "select * from cliente where nombre LIKE '%" + busqueda + "%' or apellidoP LIKE '%" + busqueda + "%' or apellidoM LIKE '%" + busqueda + "%' or nit LIKE '%" + busqueda + "%'";
    conn.conectar();
    con = conn.con;

    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(SQL);
    while (rs.next()) {
    miCliente = new ClienteClass();
    miCliente.setCodigoCliente(rs.getString(1));
    miCliente.setNombre(rs.getString(2));
    miCliente.setApellidoPaterno(rs.getString(3));
    miCliente.setApellidoMaterno(rs.getString(4));
    miCliente.setNit(rs.getString(5));
    misClientes.add(miCliente);
    }
    con.close();
    return misClientes;
    } catch (Exception es) {
    return null;
    }
    }

     * 
     */
    public String setSucursal(Sucursal sucursal) {
        try {
            String SQL = "insert into sucursal (nombre,direccion,encargado) values ('" + sucursal.getNombreSucursal() + "','" + sucursal.getDireccion() + "','" + sucursal.getEncargado() + "')";
            conn.conectar();
            con = conn.con;

            Statement stmt = con.createStatement();
            stmt.execute(SQL);
            con.close();
            return "todo blue";
        } catch (Exception es) {
            return es.toString();
        }
    }

    


}


