/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author SENA
 */
public class Cliente {
    private int idCliente;
    private String nombreCliente;
    private String documentoCliente;
    private String direccionCliente;
    private String celularCliente;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombreCliente=" + nombreCliente + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idCliente;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return this.idCliente == other.idCliente;
    }
    public Iterator<Cliente> listar(){
        ArrayList<Cliente> losClientes = new ArrayList<>();
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM "+this.getClass().getSimpleName()+"s");
            ResultSet rs = sql.executeQuery();
            Cliente unCliente;
            while (rs.next()){
                unCliente = new Cliente();
                unCliente.setIdCliente(rs.getInt ("idClientes"));
                unCliente.setNombreCliente(rs.getString ("nombreCliente"));
                unCliente.setDocumentoCliente(rs.getString  ("documentoCliente"));
                unCliente.setDireccionCliente(rs.getString ("direccionCliente"));
                unCliente.setCelularCliente(rs.getString("celularCliente"));
                losClientes.add(unCliente);
                
            }
        }catch (SQLException ex){
            System.err.println("Error al listar estudiante:"+ex.getMessage());
        }
       if (losClientes.isEmpty()){
            Cliente miCliente = new Cliente();
            miCliente.setNombreCliente("No hay clientes");
            losClientes.add(miCliente);
        }  
        return losClientes.iterator();
    }    
    public void insertar(){
        try {
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("INSERT INTO clientes VALUES(NULL,?,?,?,?)");
            sql.setString(1, this.getNombreCliente());
            sql.setString(2, this.getDocumentoCliente());
            sql.setString(3, this.getDireccionCliente());
            sql.setString(4, this.getCelularCliente());
            System.out.println(sql);
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+ "Insertado correctamente");
        }catch (SQLException ex){
            System.err.println("Error al insertar "+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
    }
    public void modificar(){
        try {
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("UPDATE clientes SET nombreCliente = ?, documentoCliente = ?, direccionCliente =?, celularCliente =? WHERE idClientes =? ");
            sql.setString(1, this.getNombreCliente());
            sql.setString(2, this.getDocumentoCliente());
            sql.setString(3, this.getDireccionCliente());
            sql.setString(4, this.getCelularCliente());
            sql.setInt(5, this.getIdCliente());
            System.out.println(sql);
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+ "modificado correctamente");
            
        }catch (SQLException ex){
            System.err.println("Error al modificar "+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
      
    }
    public void eliminar(){
        try{
            PreparedStatement sql =  ConexionBD.conexion.prepareStatement("DELETE FROM  clientes WHERE idClientes = ?" );
            sql.setInt(1, this.getIdCliente());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+ "Eliminado correctamente");
        }catch (SQLException ex){
            System.err.println("Error al eliminar "+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
    }
    public Iterator<Cliente> buscar(String busqueda){
        ArrayList<Cliente> losClientes = new ArrayList<>();
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM "+this.getClass().getSimpleName()+"s WHERE nombreCliente LIKE ? OR documentoCliente LIKE ? OR direccionCliente LIKE ? OR celularCliente LIKE ?");
            sql.setString(1,"%"+busqueda+"%");
            sql.setString(2,"%"+busqueda+"%");
            sql.setString(3,"%"+busqueda+"%");
            sql.setString(4,"%"+busqueda+"%");
            ResultSet rs = sql.executeQuery();
            Cliente unCliente;
            while (rs.next()){
                unCliente = new Cliente();
                unCliente.setIdCliente(rs.getInt("idClientes"));
                unCliente.setNombreCliente(rs.getString("nombreCliente"));
                unCliente.setDocumentoCliente(rs.getString("documentoCliente"));
                unCliente.setDireccionCliente(rs.getString ("direccionCliente"));
                unCliente.setCelularCliente(rs.getString("celularCliente"));
                losClientes.add(unCliente);
            }
        }catch (SQLException ex){
            System.err.println("Error al buscar "+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
        return losClientes.iterator();
    }
    public   Cliente buscarPorId (int elId){
        Cliente unCliente = new Cliente();
        unCliente.setNombreCliente("Cliente no existe");
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM clientes  WHERE idClientes = ?");
            sql.setInt(1, elId);
            ResultSet rs  =  sql.executeQuery();
            while (rs.next()){
                unCliente.setIdCliente(rs.getInt ("idClientes"));
                unCliente.setNombreCliente(rs.getString ("nombreCliente"));
                unCliente.setDocumentoCliente(rs.getString ("documentoCliente"));
                unCliente.setDireccionCliente(rs.getString ("direccionCliente"));
                unCliente.setCelularCliente(rs.getString ("celularCliente"));
            }
        }catch (SQLException ex){
            System.err.println("Error al buscar por Id"+ex.getMessage());
        }
        return unCliente;
    }

}
