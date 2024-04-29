/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import controlador.ControladorCliente;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;

/**
 *
 * @author SENA
 */
public class FRMCliente extends javax.swing.JInternalFrame {
    
    ControladorCliente ControladorCliente = new ControladorCliente();

    /**
     * Creates new form FRMCliente
     */
    public FRMCliente() {
        initComponents();
        TXTIdCliente.setValue(0);
        TXTIdCliente.setVisible(false);
        limpiarFormulario();
    }       
    private void limpiarFormulario(){
        TXTIdCliente.setValue(0);
        TXTNombreCliente.setText("Escriba Nombre");
        TXTDocumentoCliente.setText("Escriba Documento");
        TXTDireccionCliente.setText("Escriba Direccion");
        TXTCelularCliente.setText("Escriba Celular");
        TXTBuscarCliente.setText("Escriba texto a buscar");
        BTNModificar.setEnabled(false);
        BTNEliminar.setEnabled(false);
        llenarTabla();

    }

    public void llenarTabla() {
        Cliente unCliente = new Cliente();
        DefaultTableModel tabla = (DefaultTableModel)TBLCliente.getModel();
        Iterator<Cliente> itCliente = unCliente.listar();
        Object[] filaCliente = new Object[TBLCliente.getColumnCount()];
        tabla.setRowCount(0);
        while (itCliente.hasNext()){
            unCliente = itCliente.next();
            filaCliente[0] = unCliente.getIdCliente();
            filaCliente[1] = unCliente.getNombreCliente();
            filaCliente[2] = unCliente.getDocumentoCliente();
            filaCliente[3] = unCliente.getDireccionCliente();
            filaCliente[4] = unCliente.getCelularCliente();
            tabla.addRow(filaCliente);
        }
                  
    }
    
    private Cliente obtenerCliente(){
        Cliente elCliente = new Cliente();
        elCliente.setIdCliente((Integer) TXTIdCliente.getValue());
        elCliente.setNombreCliente(TXTNombreCliente.getText());
        elCliente.setDocumentoCliente(TXTDocumentoCliente.getText());
        elCliente.setDireccionCliente(TXTDireccionCliente.getText());
        elCliente.setCelularCliente(TXTCelularCliente.getText());
        return elCliente;
    }
    private void llenarTablaConBusqueda(String busqueda){
        Cliente unCliente = new Cliente();
        DefaultTableModel tabla = (DefaultTableModel)TBLCliente.getModel();
        Iterator<Cliente> itClientes = unCliente.buscar(busqueda);
        Object[] filaCliente = new Object[TBLCliente.getColumnCount()];
        tabla.setRowCount(0);
        while (itClientes.hasNext()){
            unCliente = itClientes.next();
            filaCliente[0] =unCliente.getIdCliente();
            filaCliente[1] =unCliente.getNombreCliente();
            filaCliente[2] =unCliente.getDocumentoCliente();
            filaCliente[3] =unCliente.getDireccionCliente();
            filaCliente[4] =unCliente.getCelularCliente();
            ((DefaultTableModel)TBLCliente.getModel()).addRow(filaCliente);
            
        }
        
    }
    

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        LBLNombre = new javax.swing.JLabel();
        LBLDocumento = new javax.swing.JLabel();
        LBLDireccion = new javax.swing.JLabel();
        LBLCelular = new javax.swing.JLabel();
        LBLBuscar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        TXTDocumentoCliente = new javax.swing.JTextField();
        TXTDireccionCliente = new javax.swing.JTextField();
        TXTCelularCliente = new javax.swing.JTextField();
        TXTBuscarCliente = new javax.swing.JTextField();
        TXTIdCliente = new javax.swing.JFormattedTextField();
        TXTNombreCliente = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        BTNInsertar = new javax.swing.JButton();
        BTNModificar = new javax.swing.JButton();
        BTNEliminar = new javax.swing.JButton();
        BTNCerrar = new javax.swing.JButton();
        BTNBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBLCliente = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setTitle("Formulario Cliente");
        setToolTipText("");

        LBLNombre.setText("Nombre");

        LBLDocumento.setText("Documento");

        LBLDireccion.setText("Direccion");

        LBLCelular.setText("Celular");

        LBLBuscar.setText("Buscar");

        TXTDocumentoCliente.setText("Escriba Documento");

        TXTDireccionCliente.setText("Escriba Direccion");

        TXTCelularCliente.setText("Escriba Celular");

        TXTBuscarCliente.setText("Escriba texto a buscar");
        TXTBuscarCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXTBuscarClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TXTBuscarClienteFocusLost(evt);
            }
        });
        TXTBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTBuscarClienteActionPerformed(evt);
            }
        });

        TXTIdCliente.setText("0");
        TXTIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTIdClienteActionPerformed(evt);
            }
        });

        TXTNombreCliente.setText("Escriba nombre");
        TXTNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTNombreClienteActionPerformed(evt);
            }
        });

        BTNInsertar.setText("Insertar");
        BTNInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNInsertarActionPerformed(evt);
            }
        });

        BTNModificar.setText("Modificar");
        BTNModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNModificarActionPerformed(evt);
            }
        });

        BTNEliminar.setText("Eliminar");
        BTNEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEliminarActionPerformed(evt);
            }
        });

        BTNCerrar.setText("Cerrar");
        BTNCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCerrarActionPerformed(evt);
            }
        });

        BTNBuscar.setText("Buscar");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BTNBuscar)
                            .addComponent(BTNModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTNEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTNCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTNInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(BTNInsertar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTNModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTNEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTNCerrar)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(61, 61, 61)
                .addComponent(BTNBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXTBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TXTCelularCliente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXTDireccionCliente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXTNombreCliente)
                            .addComponent(TXTDocumentoCliente))
                        .addGap(19, 19, 19)
                        .addComponent(TXTIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXTIdCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TXTDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(TXTDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TXTCelularCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TXTBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TBLCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Documento", "Direccion", "Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBLCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBLClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TBLCliente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(LBLDocumento)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(LBLNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LBLDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LBLCelular, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LBLBuscar, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(LBLNombre)
                        .addGap(18, 18, 18)
                        .addComponent(LBLDocumento)
                        .addGap(18, 18, 18)
                        .addComponent(LBLDireccion)
                        .addGap(18, 18, 18)
                        .addComponent(LBLCelular)
                        .addGap(27, 27, 27)
                        .addComponent(LBLBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXTIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTIdClienteActionPerformed

    private void TXTNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTNombreClienteActionPerformed

    private void BTNEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEliminarActionPerformed
        ControladorCliente.controlarAccion(evt, obtenerCliente());
        limpiarFormulario();
    }//GEN-LAST:event_BTNEliminarActionPerformed

    private void BTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCerrarActionPerformed
        doDefaultCloseAction();
    }//GEN-LAST:event_BTNCerrarActionPerformed

    private void BTNInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNInsertarActionPerformed
        ControladorCliente.controlarAccion(evt, obtenerCliente());
        limpiarFormulario();
    }//GEN-LAST:event_BTNInsertarActionPerformed

    private void BTNModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNModificarActionPerformed
        ControladorCliente.controlarAccion(evt, obtenerCliente());
        limpiarFormulario();
    }//GEN-LAST:event_BTNModificarActionPerformed

    private void TBLClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLClienteMouseClicked
        if(evt.getClickCount()==2){
            int fila = TBLCliente.rowAtPoint(evt.getPoint());
            if(fila>-1){
                TXTIdCliente.setValue((Integer) TBLCliente.getValueAt(fila, 0));
                TXTNombreCliente.setText((String) TBLCliente.getValueAt(fila,1));
                TXTDocumentoCliente.setText((String) TBLCliente.getValueAt(fila,2));
                TXTDireccionCliente.setText((String) TBLCliente.getValueAt(fila,3));
                TXTCelularCliente.setText((String) TBLCliente.getValueAt(fila,4));
                BTNModificar.setEnabled(true);
                BTNEliminar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_TBLClienteMouseClicked

    private void TXTBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTBuscarClienteActionPerformed
      
    }//GEN-LAST:event_TXTBuscarClienteActionPerformed

    private void TXTBuscarClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXTBuscarClienteFocusGained
        if(TXTBuscarCliente.getText().equals("Escriba el texto a buscar"));
        TXTBuscarCliente.setText("");
    }//GEN-LAST:event_TXTBuscarClienteFocusGained

    private void TXTBuscarClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXTBuscarClienteFocusLost
        if (TXTBuscarCliente.getText().isEmpty()){
            TXTBuscarCliente.setText("Escriba texto a buscar");
        }
    }//GEN-LAST:event_TXTBuscarClienteFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        llenarTablaConBusqueda(TXTBuscarCliente.getText());
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNBuscar;
    private javax.swing.JButton BTNCerrar;
    private javax.swing.JButton BTNEliminar;
    private javax.swing.JButton BTNInsertar;
    private javax.swing.JButton BTNModificar;
    private javax.swing.JLabel LBLBuscar;
    private javax.swing.JLabel LBLCelular;
    private javax.swing.JLabel LBLDireccion;
    private javax.swing.JLabel LBLDocumento;
    private javax.swing.JLabel LBLNombre;
    private javax.swing.JTable TBLCliente;
    private javax.swing.JTextField TXTBuscarCliente;
    private javax.swing.JTextField TXTCelularCliente;
    private javax.swing.JTextField TXTDireccionCliente;
    private javax.swing.JTextField TXTDocumentoCliente;
    private javax.swing.JFormattedTextField TXTIdCliente;
    private javax.swing.JTextField TXTNombreCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
