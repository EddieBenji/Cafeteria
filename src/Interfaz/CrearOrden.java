/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Daos.DaoCompra;
import Daos.DaoOrden;
import Principal.Orden;
import Principal.Producto;
import Tablas.TablaMenu;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Joaquin Martinez
 */
public class CrearOrden extends javax.swing.JFrame {

    private TablaMenu menuB;
    private Orden ordenParaEditar;

    //Los productos son aquellos que aparecerán en la tabla de menú.
    //Los productos ordenados, son aquellos que aparecerán en la segunda tabla
    //(La de la derecha). 
    private ArrayList<Producto> productosOrdenados;

    //Dao que se usará para guardar los productos ordenados:
    private DaoOrden daoOrden;
    private DaoCompra daoCompra;

    private void inicializarVentana() {
        try {
            //Objetos para el manejo de la BD:
            this.daoOrden = new DaoOrden();
            this.daoCompra = new DaoCompra();

            //Objetos para el manejo de la interfaz:
            productosOrdenados = new ArrayList<>();
            menuB = new TablaMenu();
            menuB.inicializarTabla(this.tablaMenu);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CrearOrden.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CrearOrden() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.inicializarVentana();
    }

    public void setProductosOrdenados(ArrayList<Producto> productosOrdenados) {
        this.productosOrdenados = productosOrdenados;
    }

    public void setOrdenParaEditar(Orden ordenParaEditar) {
        this.ordenParaEditar = ordenParaEditar;
        this.menuB.llenarTablaProductosOrdenados(this.tablaOrdenActual1,
                ordenParaEditar.getListaProductos());
        this.productosOrdenados = ordenParaEditar.getListaProductos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregarAOrden = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardarOrden = new javax.swing.JButton();
        btnVolverMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaMenu = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaOrdenActual1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAgregarAOrden.setText("Agregar");
        btnAgregarAOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAOrdenActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGuardarOrden.setText("Guardar orden");
        btnGuardarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarOrdenActionPerformed(evt);
            }
        });

        btnVolverMenu.setText("Volver al menú principal");
        btnVolverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverMenuActionPerformed(evt);
            }
        });

        jLabel1.setText("Menú");

        tablaMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tablaMenu.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tablaMenu);

        jLabel2.setText("Orden actual");

        tablaOrdenActual1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tablaOrdenActual1.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tablaOrdenActual1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnAgregarAOrden)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(204, 204, 204))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVolverMenu)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addGap(51, 51, 51)
                        .addComponent(btnGuardarOrden)
                        .addGap(117, 117, 117))))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(360, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(74, 74, 74)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarOrden)
                    .addComponent(btnEliminar)
                    .addComponent(btnAgregarAOrden))
                .addGap(35, 35, 35)
                .addComponent(btnVolverMenu)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(101, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMenuActionPerformed
        // TODO add your handling code here:
        MenuPrincipal volverMenu = new MenuPrincipal();
        volverMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverMenuActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Eliminamos la info del renglón seleccionado:
        this.productosOrdenados.remove(this.tablaOrdenActual1.getSelectedRow());
        this.menuB.llenarTablaProductosOrdenados(this.tablaOrdenActual1, productosOrdenados);

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarAOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAOrdenActionPerformed

        //Obtenemos la info del producto seleccionado:
        int id = Integer.valueOf(this.tablaMenu.getModel().getValueAt(this.tablaMenu.getSelectedRow(), 0).toString());
        String nombreProducto = this.tablaMenu.getModel().getValueAt(this.tablaMenu.getSelectedRow(), 1).toString();
        String clasificacion = this.tablaMenu.getModel().getValueAt(this.tablaMenu.getSelectedRow(), 2).toString();
        double precio = Double.valueOf(this.tablaMenu.getModel().getValueAt(this.tablaMenu.getSelectedRow(), 3).toString());

        this.productosOrdenados.add(new Producto(id, nombreProducto, clasificacion, precio));
        this.menuB.llenarTablaProductosOrdenados(this.tablaOrdenActual1, productosOrdenados);
    }//GEN-LAST:event_btnAgregarAOrdenActionPerformed

    private void abrirVentanaDeDetalleDeLaOrden(Orden orden) {
        VerOrden2 v = new VerOrden2();
        v.setOrden(orden);
        v.setVisible(true);
        v.initView();
        this.dispose();
    }

    private void btnGuardarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarOrdenActionPerformed
        try {
            if (this.ordenParaEditar != null) {
                this.daoCompra.eliminarProductosDeLaCompra(ordenParaEditar);
                this.ordenParaEditar.setListaProductos(productosOrdenados);
                if (!this.ordenParaEditar.getListaProductos().isEmpty()) {
                    this.daoOrden.actualizarPrecioTotal(ordenParaEditar);
                    this.daoOrden.insertarProductosDeOrden(ordenParaEditar);
                    this.abrirVentanaDeDetalleDeLaOrden(ordenParaEditar);
                } else {
                    mostrarMensajeDeError();
                }
            } else if (!productosOrdenados.isEmpty()) {
                //Debemos agarrar a los productos ordenados:
                //seteamos la orden creada:
                Orden orden = new Orden("EN CURSO", productosOrdenados);
                this.daoOrden.setOrden(orden);
                this.daoOrden.insertarEnOrden();
                this.abrirVentanaDeDetalleDeLaOrden(orden);
            } else {
                mostrarMensajeDeError();
            }

        } catch (SQLException ex) {
            Logger.getLogger(CrearOrden.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarOrdenActionPerformed

    private void mostrarMensajeDeError() {
        JOptionPane.showMessageDialog(rootPane, "Debes seleccionar productos para guardar");

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrearOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearOrden().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAOrden;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarOrden;
    private javax.swing.JButton btnVolverMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable tablaMenu;
    private javax.swing.JTable tablaOrdenActual1;
    // End of variables declaration//GEN-END:variables
}
