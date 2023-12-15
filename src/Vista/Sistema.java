/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Cliente;
import Modelo.ClienteDao;
import Modelo.DatosLocal;
import Modelo.Detalle;
import Modelo.Eventos;
import Modelo.Mascotas;
import Modelo.MascotasDao;
import Modelo.Productos;
import Modelo.ProductosDao;
import Modelo.Proveedor;
import Modelo.ProveedorDao;
import Modelo.Venta;
import Modelo.VentaDao;
import Reportes.Excel;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


/**
 *
 * @author felip
 */
public final class Sistema extends javax.swing.JFrame {

    Cliente cl = new Cliente();
    ClienteDao client = new ClienteDao();
    Proveedor pr = new Proveedor();
    ProveedorDao PrDao = new ProveedorDao();
    Productos pro = new Productos();
    ProductosDao ProDao = new ProductosDao();
    Venta v = new Venta();
    VentaDao Vdao = new VentaDao();
    Detalle Dv = new Detalle();
    DatosLocal DatL = new DatosLocal();
    Eventos event = new Eventos();
    Mascotas mas = new Mascotas();
    MascotasDao masDao = new MascotasDao();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel tmp = new DefaultTableModel();
    int item;
    double Totalpagar = 0.00;

    public Sistema() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtIdCliente.setVisible(false);
        txtIdVenta.setVisible(false);
        txtIdProductos.setVisible(false);
        txtIdProveedor.setVisible(false);
        txtIdpro.setVisible(false);
        txtIdMascotas.setVisible(false);
        txtTelefonoventa.setVisible(false);
        txtDirecionCV.setVisible(false);
        txtRazonCV.setVisible(false);
        AutoCompleteDecorator.decorate(cbxProveedorPro);
        ProDao.ConsultarProveedor(cbxProveedorPro);
        txtIdLocal.setVisible(false);
        ListarDatosLocal();
        
    }

    public void ListarCliente() {
        List<Cliente> ListarCl = client.ListarCliente();
        modelo = (DefaultTableModel) TableCliente.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < ListarCl.size(); i++) {
            ob[0] = ListarCl.get(i).getId();
            ob[1] = ListarCl.get(i).getDni();
            ob[2] = ListarCl.get(i).getNombre();
            ob[3] = ListarCl.get(i).getTelefono();
            ob[4] = ListarCl.get(i).getDireccion();
            ob[5] = ListarCl.get(i).getRazon();
            modelo.addRow(ob);

        }
        TableCliente.setModel(modelo);
    }

    public void ListarProveedor() {
        List<Proveedor> ListarPr = PrDao.ListarProveedor();
        modelo = (DefaultTableModel) TableProveedor.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < ListarPr.size(); i++) {
            ob[0] = ListarPr.get(i).getId();
            ob[1] = ListarPr.get(i).getRuc();
            ob[2] = ListarPr.get(i).getNombre();
            ob[3] = ListarPr.get(i).getTelefono();
            ob[4] = ListarPr.get(i).getDireccion();
            ob[5] = ListarPr.get(i).getRazon();
            modelo.addRow(ob);

        }
        TableProveedor.setModel(modelo);
    }

    public void ListarProductos() {
        List<Productos> ListarPro = ProDao.ListarProductos();
        modelo = (DefaultTableModel) TableProducto.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < ListarPro.size(); i++) {
            ob[0] = ListarPro.get(i).getId();
            ob[1] = ListarPro.get(i).getCodigo();
            ob[2] = ListarPro.get(i).getNombre();
            ob[3] = ListarPro.get(i).getProveedor();
            ob[4] = ListarPro.get(i).getStock();
            ob[5] = ListarPro.get(i).getPrecio();

            modelo.addRow(ob);

        }
        TableProducto.setModel(modelo);
    }

    public void ListarVenta() {
        List<Venta> ListarVenta = Vdao.ListarVentas();
        modelo = (DefaultTableModel) TableVentas.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < ListarVenta.size(); i++) {
            ob[0] = ListarVenta.get(i).getId();
            ob[1] = ListarVenta.get(i).getCliente();
            ob[2] = ListarVenta.get(i).getVendedor();
            ob[3] = ListarVenta.get(i).getTotal();
            modelo.addRow(ob);

        }
        TableVentas.setModel(modelo);
    }    
    
    public void ListarDatosLocal(){
        DatL = ProDao.BuscarDatos();
        txtIdLocal.setText(""+DatL.getId());
        txtRucLocal.setText(""+DatL.getRuc());
        txtNombreEmpresa.setText(""+DatL.getNombre());
        txtTelefonoLocal.setText(""+DatL.getTelefono());
        txtDireccionLocal.setText(""+DatL.getDireccion());
        txtRazonLocal.setText(""+DatL.getRazon());        
    }
    
    public void ListarMascotas(){
        List<Mascotas> ListarMas = masDao.ListarMascotas();
        modelo = (DefaultTableModel)TableMascotas.getModel();
        Object[] ob = new Object[7];
        for (int i = 0; i < ListarMas.size(); i++){
            ob[0] = ListarMas.get(i).getId();
            ob[1] = ListarMas.get(i).getCodigo();
            ob[2] = ListarMas.get(i).getNombre();
            ob[3] = ListarMas.get(i).getSexo();
            ob[4] = ListarMas.get(i).getStock();
            ob[5] = ListarMas.get(i).getTamaño();
            ob[6] = ListarMas.get(i).getPeso();
            modelo.addRow(ob);
        }
        TableCliente.setModel(modelo);
    }
    
    
    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;

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

        jPanel1 = new javax.swing.JPanel();
        btnNuevaVenta = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnLocal = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        LabelVendedor = new javax.swing.JLabel();
        btnAdoptar = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        btnNuevaVenta1 = new javax.swing.JButton();
        btnClientes1 = new javax.swing.JButton();
        btnProductos1 = new javax.swing.JButton();
        btnVentas1 = new javax.swing.JButton();
        btnLocal1 = new javax.swing.JButton();
        btnProveedor1 = new javax.swing.JButton();
        btnAdoptar1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnEliminarventa = new javax.swing.JButton();
        txtCodigoVenta = new javax.swing.JTextField();
        txtDescripcionVenta = new javax.swing.JTextField();
        txtCantidadVenta = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        txtEstockDisponible = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableVenta = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtRucVenta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNombreClienteventa = new javax.swing.JTextField();
        btnGenerarVenta = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        LabelTotal = new javax.swing.JLabel();
        txtTelefonoventa = new javax.swing.JTextField();
        txtDirecionCV = new javax.swing.JTextField();
        txtRazonCV = new javax.swing.JTextField();
        txtIdpro = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtDniCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtTelefonoCliente = new javax.swing.JTextField();
        txtDireccionCliente = new javax.swing.JTextField();
        txtRazonCliente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableCliente = new javax.swing.JTable();
        btnGuardarCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        btnNuevoCliente = new javax.swing.JButton();
        txtIdCliente = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtRucProveedor = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        txtTelefonoProveedor = new javax.swing.JTextField();
        txtDireccionProveedor = new javax.swing.JTextField();
        txtRazonProveedor = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableProveedor = new javax.swing.JTable();
        btnGuardarProveedor = new javax.swing.JButton();
        btnEditarProveedor = new javax.swing.JButton();
        btnEliminarProvedor = new javax.swing.JButton();
        btnNuevoProveedor = new javax.swing.JButton();
        txtIdProveedor = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtCodigoPro = new javax.swing.JTextField();
        txtDescripcionPro = new javax.swing.JTextField();
        txtStockPro = new javax.swing.JTextField();
        txtPrecioPro = new javax.swing.JTextField();
        cbxProveedorPro = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableProducto = new javax.swing.JTable();
        btnGuardarPro = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        btnEliminarPro = new javax.swing.JButton();
        btnNuevoPro = new javax.swing.JButton();
        btnExelPro = new javax.swing.JButton();
        txtIdProductos = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableVentas = new javax.swing.JTable();
        btnPdfVentas = new javax.swing.JButton();
        txtIdVenta = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtRucLocal = new javax.swing.JTextField();
        txtNombreEmpresa = new javax.swing.JTextField();
        txtTelefonoLocal = new javax.swing.JTextField();
        txtDireccionLocal = new javax.swing.JTextField();
        txtRazonLocal = new javax.swing.JTextField();
        bntActualicarLocal = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        txtIdLocal = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        txtSexoMas = new javax.swing.JTextField();
        txtStockMas = new javax.swing.JTextField();
        txtTamañoMas = new javax.swing.JTextField();
        txtPesoMas = new javax.swing.JTextField();
        txtNombreMas = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TableMascotas = new javax.swing.JTable();
        btnEliminarMascotas = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        txtCodigoMas = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        txtIdMascotas = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        btnNuevaVenta2 = new javax.swing.JButton();
        btnClientes2 = new javax.swing.JButton();
        btnProductos2 = new javax.swing.JButton();
        btnVentas2 = new javax.swing.JButton();
        btnLocal2 = new javax.swing.JButton();
        btnProveedor2 = new javax.swing.JButton();
        LabelVendedor2 = new javax.swing.JLabel();
        btnAdoptar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(135, 206, 235));

        btnNuevaVenta.setText("Comprar o Adoptar");
        btnNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });

        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnProductos.setText("Productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        btnProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnProductosKeyPressed(evt);
            }
        });

        btnVentas.setText("Ventas y Adopciones");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnLocal.setText("Local");
        btnLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalActionPerformed(evt);
            }
        });

        btnProveedor.setText("Proveedores");
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        LabelVendedor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LabelVendedor.setText("VETERINARIA");

        btnAdoptar.setText("Mascotas");
        btnAdoptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdoptarActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(135, 206, 235));

        btnNuevaVenta1.setText("Comprar o Adoptar");
        btnNuevaVenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVenta1ActionPerformed(evt);
            }
        });

        btnClientes1.setText("Clientes");
        btnClientes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientes1ActionPerformed(evt);
            }
        });

        btnProductos1.setText("Productos");
        btnProductos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductos1ActionPerformed(evt);
            }
        });
        btnProductos1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnProductos1KeyPressed(evt);
            }
        });

        btnVentas1.setText("Ventas y Adopciones");
        btnVentas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentas1ActionPerformed(evt);
            }
        });

        btnLocal1.setText("Local");
        btnLocal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocal1ActionPerformed(evt);
            }
        });

        btnProveedor1.setText("Proveedores");
        btnProveedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedor1ActionPerformed(evt);
            }
        });

        btnAdoptar1.setText("Mascotas");
        btnAdoptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdoptar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevaVenta1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnClientes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProductos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnVentas1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(btnLocal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProveedor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAdoptar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(btnNuevaVenta1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientes1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProveedor1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProductos1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVentas1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLocal1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdoptar1)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAdoptar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLocal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVentas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(btnProductos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevaVenta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(LabelVendedor)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(LabelVendedor)
                .addGap(18, 18, 18)
                .addComponent(btnNuevaVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLocal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdoptar)
                .addContainerGap(144, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 590));

        jTabbedPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTabbedPane1KeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Codigo:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Descripcion:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Cantidad:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Precio:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Stock:");
        jLabel7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel7KeyPressed(evt);
            }
        });

        btnEliminarventa.setText("Cancelar");
        btnEliminarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarventaActionPerformed(evt);
            }
        });
        btnEliminarventa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarventaKeyPressed(evt);
            }
        });

        txtCodigoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoVentaActionPerformed(evt);
            }
        });
        txtCodigoVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoVentaKeyTyped(evt);
            }
        });

        txtDescripcionVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionVentaKeyTyped(evt);
            }
        });

        txtCantidadVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadVentaKeyTyped(evt);
            }
        });

        txtPrecioVenta.setEditable(false);
        txtPrecioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVentaActionPerformed(evt);
            }
        });

        txtEstockDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstockDisponibleActionPerformed(evt);
            }
        });

        TableVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(TableVenta);
        if (TableVenta.getColumnModel().getColumnCount() > 0) {
            TableVenta.getColumnModel().getColumn(0).setPreferredWidth(30);
            TableVenta.getColumnModel().getColumn(1).setPreferredWidth(100);
            TableVenta.getColumnModel().getColumn(2).setPreferredWidth(30);
            TableVenta.getColumnModel().getColumn(3).setPreferredWidth(30);
            TableVenta.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Dni/Ruc:");

        txtRucVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucVentaActionPerformed(evt);
            }
        });
        txtRucVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucVentaKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Nombre:");

        txtNombreClienteventa.setEditable(false);
        txtNombreClienteventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteventaActionPerformed(evt);
            }
        });
        txtNombreClienteventa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreClienteventaKeyTyped(evt);
            }
        });

        btnGenerarVenta.setText("Comprar/Adoptar");
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Total a pagar");

        LabelTotal.setText("-----------");

        txtTelefonoventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoventaActionPerformed(evt);
            }
        });

        txtIdpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdproActionPerformed(evt);
            }
        });
        txtIdpro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdproKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtRucVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtNombreClienteventa, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefonoventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDirecionCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRazonCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel10)
                        .addGap(46, 46, 46)
                        .addComponent(LabelTotal)
                        .addGap(60, 60, 60))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtCodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtEstockDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(btnEliminarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(txtIdpro, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addGap(63, 63, 63))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEstockDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(LabelTotal)
                            .addComponent(btnGenerarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRucVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreClienteventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefonoventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDirecionCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRazonCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Dni/Ruc:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Nombre:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Telefono:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Dirección:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Razon social:");

        txtDniCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniClienteActionPerformed(evt);
            }
        });
        txtDniCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniClienteKeyTyped(evt);
            }
        });

        txtNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreClienteKeyTyped(evt);
            }
        });

        txtTelefonoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoClienteKeyTyped(evt);
            }
        });

        txtDireccionCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionClienteKeyTyped(evt);
            }
        });

        txtRazonCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonClienteKeyTyped(evt);
            }
        });

        TableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI/RUC", "NOMBRE", "TELEFONO", "DIRECCION", "RAZON"
            }
        ));
        TableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableCliente);
        if (TableCliente.getColumnModel().getColumnCount() > 0) {
            TableCliente.getColumnModel().getColumn(0).setPreferredWidth(20);
            TableCliente.getColumnModel().getColumn(1).setPreferredWidth(50);
            TableCliente.getColumnModel().getColumn(2).setPreferredWidth(100);
            TableCliente.getColumnModel().getColumn(3).setPreferredWidth(50);
            TableCliente.getColumnModel().getColumn(4).setPreferredWidth(80);
            TableCliente.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        btnGuardarCliente.setText("Guardar");
        btnGuardarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClienteActionPerformed(evt);
            }
        });
        btnGuardarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarClienteKeyPressed(evt);
            }
        });

        btnEditarCliente.setText("Editar");
        btnEditarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });

        btnEliminarCliente.setText("Eliminar");
        btnEliminarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        btnNuevoCliente.setText("Limpiar tablas");
        btnNuevoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtRazonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel15)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(23, 23, 23)))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(txtNombreCliente)))
                    .addComponent(txtDireccionCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnGuardarCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtRazonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditarCliente)
                            .addComponent(btnGuardarCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarCliente)
                            .addComponent(btnNuevoCliente))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab2", jPanel3);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Ruc:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Nombre:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Telefono:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Dirección:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Razon S:");

        txtRucProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucProveedorKeyTyped(evt);
            }
        });

        txtNombreProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProveedorKeyTyped(evt);
            }
        });

        txtTelefonoProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoProveedorKeyTyped(evt);
            }
        });

        txtDireccionProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionProveedorKeyTyped(evt);
            }
        });

        txtRazonProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonProveedorKeyTyped(evt);
            }
        });

        TableProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "RUC", "NOMBRE", "TELEFONO", "DIRECCION", "RAZON"
            }
        ));
        TableProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProveedorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableProveedor);
        if (TableProveedor.getColumnModel().getColumnCount() > 0) {
            TableProveedor.getColumnModel().getColumn(0).setPreferredWidth(20);
            TableProveedor.getColumnModel().getColumn(1).setPreferredWidth(40);
            TableProveedor.getColumnModel().getColumn(2).setPreferredWidth(100);
            TableProveedor.getColumnModel().getColumn(3).setPreferredWidth(50);
            TableProveedor.getColumnModel().getColumn(4).setPreferredWidth(80);
            TableProveedor.getColumnModel().getColumn(5).setPreferredWidth(70);
        }

        btnGuardarProveedor.setText("Guardar");
        btnGuardarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProveedorActionPerformed(evt);
            }
        });

        btnEditarProveedor.setText("Editar");
        btnEditarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProveedorActionPerformed(evt);
            }
        });

        btnEliminarProvedor.setText("Eliminar");
        btnEliminarProvedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProvedorActionPerformed(evt);
            }
        });

        btnNuevoProveedor.setText("Limpiar tablas");
        btnNuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProveedorActionPerformed(evt);
            }
        });

        txtIdProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProveedorActionPerformed(evt);
            }
        });
        txtIdProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdProveedorKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(11, 11, 11)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDireccionProveedor)
                                .addComponent(txtRazonProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(txtRucProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtIdProveedor))
                                .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17)
                                .addComponent(jLabel19))
                            .addGap(11, 11, 11)
                            .addComponent(txtTelefonoProveedor)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(btnEliminarProvedor)
                            .addGap(8, 8, 8)
                            .addComponent(btnNuevoProveedor))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(btnGuardarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtRucProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtRazonProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarProveedor)
                            .addComponent(btnEditarProveedor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarProvedor)
                            .addComponent(btnNuevoProveedor)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel4);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Codigo:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Descripcion:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Stock:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Precio:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Proveedor:");

        txtCodigoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoProActionPerformed(evt);
            }
        });
        txtCodigoPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProKeyTyped(evt);
            }
        });

        txtDescripcionPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionProActionPerformed(evt);
            }
        });
        txtDescripcionPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionProKeyTyped(evt);
            }
        });

        txtStockPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockProKeyTyped(evt);
            }
        });

        txtPrecioPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioProKeyTyped(evt);
            }
        });

        cbxProveedorPro.setEditable(true);

        TableProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO", "DESCRIPCION", "PROVEEDOR", "STOCK", "PRECIO"
            }
        ));
        TableProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProductoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TableProducto);
        if (TableProducto.getColumnModel().getColumnCount() > 0) {
            TableProducto.getColumnModel().getColumn(0).setPreferredWidth(20);
            TableProducto.getColumnModel().getColumn(1).setPreferredWidth(50);
            TableProducto.getColumnModel().getColumn(2).setPreferredWidth(100);
            TableProducto.getColumnModel().getColumn(3).setPreferredWidth(60);
            TableProducto.getColumnModel().getColumn(4).setPreferredWidth(40);
            TableProducto.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        btnGuardarPro.setText("Guardar");
        btnGuardarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProActionPerformed(evt);
            }
        });

        btnEditarProducto.setText("Editar");
        btnEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductoActionPerformed(evt);
            }
        });

        btnEliminarPro.setText("Eliminar");
        btnEliminarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProActionPerformed(evt);
            }
        });

        btnNuevoPro.setText("Limpiar tablas");
        btnNuevoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProActionPerformed(evt);
            }
        });

        btnExelPro.setText("Generar Excel");
        btnExelPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExelProActionPerformed(evt);
            }
        });

        txtIdProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProductosActionPerformed(evt);
            }
        });
        txtIdProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdProductosKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtStockPro, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                            .addComponent(txtPrecioPro)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(txtCodigoPro)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDescripcionPro, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(cbxProveedorPro, 0, 1, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(btnGuardarPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(btnEliminarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnExelPro))
                        .addComponent(btnNuevoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtCodigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtDescripcionPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtStockPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtPrecioPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(cbxProveedorPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditarProducto)
                            .addComponent(btnGuardarPro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarPro)
                            .addComponent(btnExelPro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevoPro))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 81, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel5);

        TableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CLIENTE", "VENDEDOR", "TOTAL"
            }
        ));
        jScrollPane5.setViewportView(TableVentas);
        if (TableVentas.getColumnModel().getColumnCount() > 0) {
            TableVentas.getColumnModel().getColumn(0).setPreferredWidth(20);
            TableVentas.getColumnModel().getColumn(1).setPreferredWidth(60);
            TableVentas.getColumnModel().getColumn(2).setPreferredWidth(60);
            TableVentas.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        btnPdfVentas.setText("PDF");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnPdfVentas)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 47, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPdfVentas)
                    .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("tab5", jPanel6);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Ruc:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Nombre de empresa:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Telefono:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Dirección:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Razon social:");

        txtRucLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucLocalActionPerformed(evt);
            }
        });

        txtNombreEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEmpresaActionPerformed(evt);
            }
        });

        bntActualicarLocal.setText("Actualizar");
        bntActualicarLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntActualicarLocalActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel32.setText("DATOS DEL LOCAL");

        txtIdLocal.setText("jTextField1");
        txtIdLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdLocalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel30)
                            .addComponent(txtDireccionLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRucLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtRazonLocal, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel31))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel29)
                            .addComponent(txtTelefonoLocal)
                            .addComponent(bntActualicarLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel32))
                    .addComponent(txtIdLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(364, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIdLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addGap(90, 90, 90)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRucLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccionLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazonLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntActualicarLocal))
                .addGap(183, 183, 183))
        );

        jTabbedPane1.addTab("tab6", jPanel7);

        txtSexoMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSexoMasActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Mascota:");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Tamaño:");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Peso:");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Stock:");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Sexo:");

        TableMascotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO", "MASCOTA", "SEXO", "STOCK", "TAMAÑO", "PESO"
            }
        ));
        TableMascotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMascotasMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(TableMascotas);

        btnEliminarMascotas.setText("Eliminar");
        btnEliminarMascotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMascotasActionPerformed(evt);
            }
        });

        jButton8.setText("Ingresar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("Codigo:");

        jButton5.setText("Limpiar Tablas");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtIdMascotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdMascotasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtIdMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel43)
                                .addComponent(jLabel40)
                                .addComponent(jLabel42)
                                .addComponent(jLabel34)
                                .addComponent(jLabel41)
                                .addComponent(jLabel44))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtSexoMas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                .addComponent(txtPesoMas, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTamañoMas, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtStockMas, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombreMas)
                                .addComponent(txtCodigoMas)))
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEliminarMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(txtIdMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(txtCodigoMas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreMas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSexoMas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStockMas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTamañoMas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPesoMas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41)))
                    .addComponent(jLabel44))
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarMascotas)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab7", jPanel10);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 1000, 420));

        jPanel11.setBackground(new java.awt.Color(135, 206, 235));

        btnNuevaVenta2.setText("Comprar o Adoptar");
        btnNuevaVenta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVenta2ActionPerformed(evt);
            }
        });

        btnClientes2.setText("Clientes");
        btnClientes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientes2ActionPerformed(evt);
            }
        });

        btnProductos2.setText("Productos");
        btnProductos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductos2ActionPerformed(evt);
            }
        });
        btnProductos2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnProductos2KeyPressed(evt);
            }
        });

        btnVentas2.setText("Ventas y Adopciones");
        btnVentas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentas2ActionPerformed(evt);
            }
        });

        btnLocal2.setText("Local");
        btnLocal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocal2ActionPerformed(evt);
            }
        });

        btnProveedor2.setText("Proveedores");
        btnProveedor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedor2ActionPerformed(evt);
            }
        });

        LabelVendedor2.setText("Vida Indormatico");

        btnAdoptar2.setText("Mascotas");
        btnAdoptar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdoptar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevaVenta2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnClientes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProductos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnVentas2, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
            .addComponent(btnLocal2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProveedor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAdoptar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelVendedor2)
                .addGap(39, 39, 39))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(LabelVendedor2)
                .addGap(18, 18, 18)
                .addComponent(btnNuevaVenta2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientes2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProveedor2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProductos2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVentas2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLocal2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdoptar2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, -10, 1010, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnNuevaVentaActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        // TODO add your handling code here:
        LimpiarTable();
        ListarCliente();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
        LimpiarTable();
        ListarProveedor();
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        // TODO add your handling code here:
        LimpiarTable();
        ListarProductos();
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnProductosKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductosKeyPressed

    private void btnLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_btnLocalActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
        LimpiarTable();
        ListarVenta();    
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnAdoptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdoptarActionPerformed
        // TODO add your handling code here:
        LimpiarTable();
        ListarMascotas();
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_btnAdoptarActionPerformed

    private void btnNuevaVenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVenta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevaVenta1ActionPerformed

    private void btnClientes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClientes1ActionPerformed

    private void btnProductos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductos1ActionPerformed

    private void btnProductos1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnProductos1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductos1KeyPressed

    private void btnVentas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVentas1ActionPerformed

    private void btnLocal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLocal1ActionPerformed

    private void btnProveedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProveedor1ActionPerformed

    private void btnAdoptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdoptar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdoptar1ActionPerformed

    private void btnNuevaVenta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVenta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevaVenta2ActionPerformed

    private void btnClientes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientes2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClientes2ActionPerformed

    private void btnProductos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductos2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductos2ActionPerformed

    private void btnProductos2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnProductos2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductos2KeyPressed

    private void btnVentas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentas2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVentas2ActionPerformed

    private void btnLocal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocal2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLocal2ActionPerformed

    private void btnProveedor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedor2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProveedor2ActionPerformed

    private void btnAdoptar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdoptar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdoptar2ActionPerformed

    private void jTabbedPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabbedPane1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1KeyPressed

    private void txtIdMascotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdMascotasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdMascotasActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        LimpiarMascotas();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if(!"".equals(txtCodigoMas.getText()) || !"".equals(txtNombreMas.getText()) || !"".equals(txtSexoMas.getText()) || !"".equals(txtStockMas.getText()) || !"".equals(txtTamañoMas.getText()) || !"".equals(txtPesoMas.getText())) {
            mas.setCodigo(txtCodigoMas.getText());
            mas.setNombre(txtNombreMas.getText());
            mas.setSexo(txtCodigoMas.getText());
            mas.setStock(Integer.parseInt(txtStockMas.getText()));
            mas.setTamaño(Integer.parseInt(txtTamañoMas.getText()));
            mas.setPeso(Integer.parseInt(txtPesoMas.getText()));
            masDao.RegistrarMascotas(mas);
            JOptionPane.showMessageDialog(null, "Cliente Registrado");
        }else{
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnEliminarMascotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMascotasActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtIdMascotas.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "esta seguro de eliminar?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdMascotas.getText());
                masDao.EliminarMascotas(id);
                LimpiarTable();
                ListarProveedor();
                LimpiarProveedor();
            }
        } else {
            JOptionPane.showMessageDialog(null, "selecciones una fila");
        }   
    }//GEN-LAST:event_btnEliminarMascotasActionPerformed

    private void TableMascotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMascotasMouseClicked
        // TODO add your handling code here:
        int fila = TableMascotas.rowAtPoint(evt.getPoint());
        txtIdMascotas.setText(TableMascotas.getValueAt(fila, 0).toString());
        txtCodigoMas.setText(TableMascotas.getValueAt(fila, 1).toString());
        txtNombreMas.setText(TableMascotas.getValueAt(fila, 2).toString());
        txtSexoMas.setText(TableMascotas.getValueAt(fila, 3).toString());
        txtStockMas.setText(TableMascotas.getValueAt(fila, 4).toString());
        txtTamañoMas.setText(TableMascotas.getValueAt(fila, 5).toString());
        txtPesoMas.setText(TableMascotas.getValueAt(fila, 6).toString());
    }//GEN-LAST:event_TableMascotasMouseClicked

    private void txtSexoMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSexoMasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSexoMasActionPerformed

    private void txtIdLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdLocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdLocalActionPerformed

    private void bntActualicarLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntActualicarLocalActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtRucLocal.getText()) || !"".equals(txtNombreEmpresa.getText()) || !"".equals(txtTelefonoLocal.getText()) || !"".equals(txtDireccionLocal.getText())) {
            DatL.setRuc(Integer.parseInt(txtRucLocal.getText()));
            DatL.setNombre(txtNombreEmpresa.getText());
            DatL.setTelefono(Integer.parseInt(txtTelefonoLocal.getText()));
            DatL.setDireccion(txtDireccionLocal.getText());
            DatL.setRazon(txtRazonLocal.getText());
            DatL.setId(Integer.parseInt(txtIdLocal.getText()));
            ProDao.ModificarDatos(DatL);
            JOptionPane.showMessageDialog(null, "Cliente Modificado");
            ListarDatosLocal();
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }//GEN-LAST:event_bntActualicarLocalActionPerformed

    private void txtNombreEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEmpresaActionPerformed

    private void txtRucLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucLocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucLocalActionPerformed

    private void txtIdProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdProductosKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProductosKeyPressed

    private void txtIdProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProductosActionPerformed

    private void btnExelProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExelProActionPerformed
        // TODO add your handling code here:
        Excel.reporte();
    }//GEN-LAST:event_btnExelProActionPerformed

    private void btnNuevoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProActionPerformed
        // TODO add your handling code here:
        LimpiarProductos();
    }//GEN-LAST:event_btnNuevoProActionPerformed

    private void btnEliminarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtIdProductos.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "estas seguro de eliminar?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdProductos.getText());
                ProDao.EliminarProductos(id);
                LimpiarTable();
                LimpiarProductos();
                ListarProductos();
            }

        }

    }//GEN-LAST:event_btnEliminarProActionPerformed

    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed
        // TODO add your handling code here:
        if ("".equals(txtIdProductos.getText())) {
            JOptionPane.showMessageDialog(null, "seleccione una fila");
        } else {
            if (!"".equals(txtCodigoPro.getText()) || !"".equals(txtDescripcionPro.getText()) || !"".equals(txtStockPro.getText()) || !"".equals(txtPrecioPro.getText())) {
                pro.setCodigo(txtCodigoPro.getText());
                pro.setNombre(txtDescripcionPro.getText());
                pro.setProveedor(cbxProveedorPro.getSelectedItem().toString());
                pro.setStock(Integer.parseInt(txtStockPro.getText()));
                pro.setPrecio(Double.parseDouble(txtPrecioPro.getText()));
                pro.setId(Integer.parseInt(txtIdProductos.getText()));
                ProDao.ModificarProductos(pro);
                JOptionPane.showMessageDialog(null, "Producto Modificado");
                LimpiarTable();
                ListarProductos();
                LimpiarProductos();
            }
        }
    }//GEN-LAST:event_btnEditarProductoActionPerformed

    private void btnGuardarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtCodigoPro.getText()) || !"".equals(txtDescripcionPro.getText()) || !"".equals(cbxProveedorPro.getSelectedItem()) || !"".equals(txtStockPro.getText()) || !"".equals(txtPrecioPro.getText())) {
            pro.setCodigo(txtCodigoPro.getText());
            pro.setNombre(txtDescripcionPro.getText());
            pro.setProveedor(cbxProveedorPro.getSelectedItem().toString());
            pro.setStock(Integer.parseInt(txtStockPro.getText()));
            pro.setPrecio(Double.parseDouble(txtPrecioPro.getText()));
            ProDao.RegistrarProductos(pro);
            JOptionPane.showMessageDialog(null, "Productos Registrado");
            LimpiarTable();
            ListarProveedor();
            LimpiarProveedor();

        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }//GEN-LAST:event_btnGuardarProActionPerformed

    private void TableProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProductoMouseClicked
        // TODO add your handling code here:
        int fila = TableProducto.rowAtPoint(evt.getPoint());
        txtIdProductos.setText(TableProducto.getValueAt(fila, 0).toString());
        txtCodigoPro.setText(TableProducto.getValueAt(fila, 1).toString());
        txtDescripcionPro.setText(TableProducto.getValueAt(fila, 2).toString());
        cbxProveedorPro.setSelectedItem(TableProducto.getValueAt(fila, 3).toString());
        txtStockPro.setText(TableProducto.getValueAt(fila, 4).toString());
        txtPrecioPro.setText(TableProducto.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_TableProductoMouseClicked

    private void txtPrecioProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioProKeyTyped
        // TODO add your handling code here:
        event.numberDecimalKeyPress(evt, txtIdProductos);
    }//GEN-LAST:event_txtPrecioProKeyTyped

    private void txtStockProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockProKeyTyped
        // TODO add your handling code here:
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtStockProKeyTyped

    private void txtDescripcionProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionProKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionProKeyTyped

    private void txtDescripcionProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionProActionPerformed

    private void txtCodigoProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProKeyTyped
        // TODO add your handling code here:
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCodigoProKeyTyped

    private void txtCodigoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProActionPerformed

    private void txtIdProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdProveedorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProveedorKeyPressed

    private void txtIdProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProveedorActionPerformed

    private void btnNuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProveedorActionPerformed
        // TODO add your handling code here:
        LimpiarProveedor();
    }//GEN-LAST:event_btnNuevoProveedorActionPerformed

    private void btnEliminarProvedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProvedorActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtIdProveedor.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "esta seguro de eliminar?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdProveedor.getText());
                PrDao.EliminarProveedor(id);
                LimpiarTable();
                ListarProveedor();
                LimpiarProveedor();
            }
        } else {
            JOptionPane.showMessageDialog(null, "selecciones una fila");
        }
    }//GEN-LAST:event_btnEliminarProvedorActionPerformed

    private void btnEditarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProveedorActionPerformed
        // TODO add your handling code here:
        if ("".equals(txtIdProveedor.getText())) {
            JOptionPane.showMessageDialog(null, "selecciones una fila");

        } else {
            if (!"".equals(txtRucProveedor.getText()) || !"".equals(txtNombreProveedor.getText()) || !"".equals(txtTelefonoProveedor.getText()) || !"".equals(txtDireccionProveedor.getText()) || !"".equals(txtRazonProveedor.getText())) {

                pr.setRuc(Integer.parseInt(txtRucProveedor.getText()));
                pr.setNombre(txtNombreProveedor.getText());
                pr.setTelefono(Integer.parseInt(txtTelefonoProveedor.getText()));
                pr.setDireccion(txtDireccionProveedor.getText());
                pr.setRazon(txtRazonProveedor.getText());
                pr.setId(Integer.parseInt(txtIdProveedor.getText()));
                PrDao.ModificarProveedor(pr);
                JOptionPane.showMessageDialog(null, "proveedor modificado");
                LimpiarTable();
                ListarProveedor();
                LimpiarProveedor();
            }
        }
    }//GEN-LAST:event_btnEditarProveedorActionPerformed

    private void btnGuardarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProveedorActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtRucProveedor.getText()) || !"".equals(txtNombreProveedor.getText()) || !"".equals(txtTelefonoProveedor.getText()) || !"".equals(txtDireccionProveedor.getText()) || !"".equals(txtRazonProveedor.getText())) {
            pr.setRuc(Integer.parseInt(txtRucProveedor.getText()));
            pr.setNombre(txtNombreProveedor.getText());
            pr.setTelefono(Integer.parseInt(txtTelefonoProveedor.getText()));
            pr.setDireccion(txtDireccionProveedor.getText());
            pr.setRazon(txtRazonProveedor.getText());
            PrDao.RegistrarProveedor(pr);
            JOptionPane.showMessageDialog(null, "proveedor guardado");
            LimpiarTable();
            ListarProveedor();
            LimpiarProveedor();

        } else {
            JOptionPane.showMessageDialog(null, "los campos estan vacios");
        }
    }//GEN-LAST:event_btnGuardarProveedorActionPerformed

    private void TableProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProveedorMouseClicked
        // TODO add your handling code here:
        int fila = TableProveedor.rowAtPoint(evt.getPoint());
        txtIdProveedor.setText(TableProveedor.getValueAt(fila, 0).toString());
        txtRucProveedor.setText(TableProveedor.getValueAt(fila, 1).toString());
        txtNombreProveedor.setText(TableProveedor.getValueAt(fila, 2).toString());
        txtTelefonoProveedor.setText(TableProveedor.getValueAt(fila, 3).toString());
        txtDireccionProveedor.setText(TableProveedor.getValueAt(fila, 4).toString());
        txtRazonProveedor.setText(TableProveedor.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_TableProveedorMouseClicked

    private void txtRazonProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonProveedorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonProveedorKeyTyped

    private void txtDireccionProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionProveedorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionProveedorKeyTyped

    private void txtTelefonoProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoProveedorKeyTyped
        // TODO add your handling code here:
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtTelefonoProveedorKeyTyped

    private void txtNombreProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProveedorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProveedorKeyTyped

    private void txtRucProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucProveedorKeyTyped
        // TODO add your handling code here:
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtRucProveedorKeyTyped

    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        // TODO add your handling code here:
        LimpiarCliente();
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtIdCliente.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "estas seguro de eliminar?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdCliente.getText());
                client.EliminarCliente(id);
                LimpiarTable();
                LimpiarCliente();
                ListarCliente();
            }

        }
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        // TODO add your handling code here:
        if ("".equals(txtIdCliente.getText())) {
            JOptionPane.showMessageDialog(null, "seleccione una fila");
        } else {

            if (!"".equals(txtDniCliente.getText()) || !"".equals(txtNombreCliente.getText()) || !"".equals(txtTelefonoCliente.getText())) {
                cl.setDni(Integer.parseInt(txtDniCliente.getText()));
                cl.setNombre(txtNombreCliente.getText());
                cl.setTelefono(Integer.parseInt(txtTelefonoCliente.getText()));
                cl.setDireccion(txtDireccionCliente.getText());
                cl.setRazon(txtRazonCliente.getText());
                cl.setId(Integer.parseInt(txtIdCliente.getText()));

                client.ModificarCliente(cl);
                JOptionPane.showMessageDialog(null, "Cliente Modificado");
                LimpiarTable();
                LimpiarCliente();
                ListarCliente();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void btnGuardarClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarClienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarClienteKeyPressed

    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtDniCliente.getText()) || !"".equals(txtNombreCliente.getText()) || !"".equals(txtTelefonoCliente.getText()) || !"".equals(txtDireccionCliente.getText())) {
            cl.setDni(Integer.parseInt(txtDniCliente.getText()));
            cl.setNombre(txtNombreCliente.getText());
            cl.setTelefono(Integer.parseInt(txtTelefonoCliente.getText()));
            cl.setDireccion(txtDireccionCliente.getText());
            cl.setRazon(txtRazonCliente.getText());
            client.RegistrarCliente(cl);

            LimpiarTable();
            LimpiarCliente();
            ListarCliente();
            JOptionPane.showMessageDialog(null, "cliente rgistrado");
        } else {
            JOptionPane.showMessageDialog(null, "los campos estan vacios");

        }
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void TableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableClienteMouseClicked
        // TODO add your handling code here:
        int fila = TableCliente.rowAtPoint(evt.getPoint());
        txtIdCliente.setText(TableCliente.getValueAt(fila, 0).toString());
        txtDniCliente.setText(TableCliente.getValueAt(fila, 1).toString());
        txtNombreCliente.setText(TableCliente.getValueAt(fila, 2).toString());
        txtTelefonoCliente.setText(TableCliente.getValueAt(fila, 3).toString());
        txtDireccionCliente.setText(TableCliente.getValueAt(fila, 4).toString());
        txtRazonCliente.setText(TableCliente.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_TableClienteMouseClicked

    private void txtRazonClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonClienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonClienteKeyTyped

    private void txtDireccionClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionClienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionClienteKeyTyped

    private void txtTelefonoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoClienteKeyTyped
        // TODO add your handling code here:
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtTelefonoClienteKeyTyped

    private void txtNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteKeyTyped

    private void txtDniClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniClienteKeyTyped
        // TODO add your handling code here:
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtDniClienteKeyTyped

    private void txtDniClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniClienteActionPerformed

    private void txtIdproKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdproKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtIdproKeyPressed

    private void txtIdproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdproActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdproActionPerformed

    private void txtTelefonoventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoventaActionPerformed

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
        // TODO add your handling code here:
        if (TableVenta.getRowCount() > 0) {
            if(!"".equals(txtNombreClienteventa.getText())) {
                RegistrarVenta();
                RegistrarDetalle();
                ActualizarStock();
                LimpiarTablaVenta();
                LimpiarClienteVenta();
            } else{
                JOptionPane.showMessageDialog(null, "Debes buscar un cliente");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay productos en la venta");
        }
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    private void txtNombreClienteventaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteventaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteventaKeyTyped

    private void txtNombreClienteventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteventaActionPerformed

    private void txtRucVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucVentaKeyTyped
        // TODO add your handling code here:
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtRucVentaKeyTyped

    private void txtRucVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucVentaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtRucVenta.getText())) {
                int dni = Integer.parseInt(txtRucVenta.getText());
                cl = client.Buscarcliente(dni);
                if (cl.getNombre() != null) {
                    txtNombreClienteventa.setText(""+cl.getNombre());
                    txtTelefonoventa.setText(""+cl.getTelefono());
                    txtDirecionCV.setText(""+cl.getDireccion());
                    txtRazonCV.setText(""+cl.getRazon());
                }else {
                    txtRucVenta.setText("");
                    JOptionPane.showMessageDialog(null, "El cliente no existe");
                }
            }
        }
    }//GEN-LAST:event_txtRucVentaKeyPressed

    private void txtRucVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucVentaActionPerformed

    private void txtEstockDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstockDisponibleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstockDisponibleActionPerformed

    private void txtPrecioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVentaActionPerformed

    private void txtCantidadVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVentaKeyTyped
        // TODO add your handling code here:
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCantidadVentaKeyTyped

    private void txtCantidadVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVentaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtCantidadVenta.getText())) {
                String cod = txtCodigoVenta.getText();
                String descripcion = txtDescripcionVenta.getText();
                int cant = Integer.parseInt(txtCantidadVenta.getText());
                double precio = Double.parseDouble(txtPrecioVenta.getText());
                double total = cant * precio;
                int stock = Integer.parseInt(txtEstockDisponible.getText());
                if (stock >= cant) {
                    item = item +1;
                    tmp = (DefaultTableModel) TableVenta.getModel();
                    for (int i = 0; i < TableVenta.getRowCount(); i++) {
                        if (TableVenta.getValueAt(i, 1).equals(txtDescripcionVenta.getText())) {
                            JOptionPane.showMessageDialog(null, "El producto ya esta registrado");
                            return;
                        }
                    }
                    ArrayList lista = new ArrayList();
                    lista.add(item);
                    lista.add(cod);
                    lista.add(descripcion);
                    lista.add(cant);
                    lista.add(precio);
                    lista.add(total);
                    Object[] o = new Object[5];
                    o[0] = lista.get(1);
                    o[1] = lista.get(2);
                    o[2] = lista.get(3);
                    o[3] = lista.get(4);
                    o[4] = lista.get(5);
                    tmp.addRow(o);
                    TableVenta.setModel(tmp);
                    TotalPagar();
                    LimpiarVenta();
                    txtCodigoVenta.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null, "Stock no disponible");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese cantidad");
            }
        }
    }//GEN-LAST:event_txtCantidadVentaKeyPressed

    private void txtDescripcionVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionVentaKeyTyped
        // TODO add your handling code here:
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtDescripcionVentaKeyTyped

    private void txtCodigoVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoVentaKeyTyped
        // TODO add your handling code here:
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCodigoVentaKeyTyped

    private void txtCodigoVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoVentaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtCodigoVenta.getText())) {
                String cod = txtCodigoVenta.getText();
                pro = ProDao.BuscarPro(cod);
                if (pro.getNombre() !=null) {
                    txtDescripcionVenta.setText(""+pro.getNombre());
                    txtPrecioVenta.setText(""+pro.getPrecio());
                    txtEstockDisponible.setText(""+pro.getStock());
                    txtCantidadVenta.requestFocus();
                }else{
                    LimpiarVenta();
                    txtCodigoVenta.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese el codigo del productos");
                txtCodigoVenta.requestFocus();
            }
        }
    }//GEN-LAST:event_txtCodigoVentaKeyPressed

    private void txtCodigoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoVentaActionPerformed

    private void btnEliminarventaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarventaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarventaKeyPressed

    private void btnEliminarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarventaActionPerformed
        // TODO add your handling code here:
        modelo = (DefaultTableModel) TableVenta.getModel();
        modelo.removeRow(TableVenta.getSelectedRow());
        TotalPagar ();
        txtCodigoVenta.requestFocus();
    }//GEN-LAST:event_btnEliminarventaActionPerformed

    private void jLabel7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7KeyPressed

    
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
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JLabel LabelVendedor;
    private javax.swing.JLabel LabelVendedor2;
    private javax.swing.JTable TableCliente;
    private javax.swing.JTable TableMascotas;
    private javax.swing.JTable TableProducto;
    private javax.swing.JTable TableProveedor;
    private javax.swing.JTable TableVenta;
    private javax.swing.JTable TableVentas;
    private javax.swing.JButton bntActualicarLocal;
    private javax.swing.JButton btnAdoptar;
    private javax.swing.JButton btnAdoptar1;
    private javax.swing.JButton btnAdoptar2;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnClientes1;
    private javax.swing.JButton btnClientes2;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEditarProveedor;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarMascotas;
    private javax.swing.JButton btnEliminarPro;
    private javax.swing.JButton btnEliminarProvedor;
    private javax.swing.JButton btnEliminarventa;
    private javax.swing.JButton btnExelPro;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnGuardarPro;
    private javax.swing.JButton btnGuardarProveedor;
    private javax.swing.JButton btnLocal;
    private javax.swing.JButton btnLocal1;
    private javax.swing.JButton btnLocal2;
    private javax.swing.JButton btnNuevaVenta;
    private javax.swing.JButton btnNuevaVenta1;
    private javax.swing.JButton btnNuevaVenta2;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnNuevoPro;
    private javax.swing.JButton btnNuevoProveedor;
    private javax.swing.JButton btnPdfVentas;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProductos1;
    private javax.swing.JButton btnProductos2;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnProveedor1;
    private javax.swing.JButton btnProveedor2;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton btnVentas1;
    private javax.swing.JButton btnVentas2;
    private javax.swing.JComboBox<String> cbxProveedorPro;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtCantidadVenta;
    private javax.swing.JTextField txtCodigoMas;
    private javax.swing.JTextField txtCodigoPro;
    private javax.swing.JTextField txtCodigoVenta;
    private javax.swing.JTextField txtDescripcionPro;
    private javax.swing.JTextField txtDescripcionVenta;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtDireccionLocal;
    private javax.swing.JTextField txtDireccionProveedor;
    private javax.swing.JTextField txtDirecionCV;
    private javax.swing.JTextField txtDniCliente;
    private javax.swing.JTextField txtEstockDisponible;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdLocal;
    private javax.swing.JTextField txtIdMascotas;
    private javax.swing.JTextField txtIdProductos;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtIdpro;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreClienteventa;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtNombreMas;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtPesoMas;
    private javax.swing.JTextField txtPrecioPro;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtRazonCV;
    private javax.swing.JTextField txtRazonCliente;
    private javax.swing.JTextField txtRazonLocal;
    private javax.swing.JTextField txtRazonProveedor;
    private javax.swing.JTextField txtRucLocal;
    private javax.swing.JTextField txtRucProveedor;
    private javax.swing.JTextField txtRucVenta;
    private javax.swing.JTextField txtSexoMas;
    private javax.swing.JTextField txtStockMas;
    private javax.swing.JTextField txtStockPro;
    private javax.swing.JTextField txtTamañoMas;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JTextField txtTelefonoLocal;
    private javax.swing.JTextField txtTelefonoProveedor;
    private javax.swing.JTextField txtTelefonoventa;
    // End of variables declaration//GEN-END:variables
    private void LimpiarCliente() {
        txtIdCliente.setText("");
        txtDniCliente.setText("");
        txtNombreCliente.setText("");
        txtTelefonoCliente.setText("");
        txtDireccionCliente.setText("");
        txtRazonCliente.setText("");

    }

    private void LimpiarProveedor() {
        txtIdProveedor.setText("");
        txtRucProveedor.setText("");
        txtNombreProveedor.setText("");
        txtTelefonoProveedor.setText("");
        txtDireccionProveedor.setText("");
        txtRazonProveedor.setText("");

    }

    private void LimpiarProductos() {
        txtIdpro.setText("");
        txtCodigoPro.setText("");
        cbxProveedorPro.setSelectedItem(null);
        txtDescripcionPro.setText("");
        txtStockPro.setText("");
        txtPrecioPro.setText("");

    }
    
    private void LimpiarMascotas() {
        txtIdMascotas.setText("");
        txtCodigoMas.setText("");
        txtNombreMas.setText("");
        txtSexoMas.setText("");
        txtStockMas.setText("");
        txtTamañoMas.setText("");
        txtPesoMas.setText("");
    }
    
    private void TotalPagar (){
        Totalpagar = 0.00;
        int numFila = TableVenta.getRowCount();
        for (int i = 0; i < numFila; i++) {
            double cal = Double.parseDouble(String.valueOf(TableVenta.getModel().getValueAt(i, 4)));
            Totalpagar = Totalpagar + cal;
        }
        LabelTotal.setText(String.format("%.2f", Totalpagar));
    }
    private void LimpiarVenta(){
        txtCodigoVenta.setText("");
        txtDescripcionVenta.setText("");
        txtCantidadVenta.setText("");
        txtEstockDisponible.setText("");
        txtPrecioVenta.setText("");
        txtIdVenta.setText("");
    }
    private void RegistrarVenta(){
        String cliente = txtNombreClienteventa.getText();
        String vendedor = LabelVendedor.getText();
        double monto = Totalpagar;
        v.setCliente(cliente);
        v.setVendedor(vendedor);
        v.setTotal(monto);
        Vdao.RegistrarVenta(v);
    }
    private void RegistrarDetalle() {
        int id = Vdao.IdVenta();
        for (int i = 0; i < TableVenta.getRowCount(); i++) {
            String cod = TableVenta.getValueAt(i, 0).toString();
            int cant = Integer.parseInt(TableVenta.getValueAt(i, 2).toString());
            double precio = Double.parseDouble(TableVenta.getValueAt(i, 3).toString());
            Dv.setCod_pro(cod);
            Dv.setCantidad(cant);
            Dv.setPrecio(precio);
            Dv.setId(id);
            Vdao.RegistrarDetalle(Dv);
        }
    }
    private void ActualizarStock(){
        for (int i = 0; i < TableVenta.getRowCount(); i++){
            String cod = TableVenta.getValueAt(i, 0).toString();
            int cant = Integer.parseInt(TableVenta.getValueAt(i, 2).toString());
            pro = ProDao.BuscarPro(cod);
            int StockActual = pro.getStock() - cant;
            Vdao.ActualiazarStock(StockActual, cod);
        }
    }
    private void LimpiarTablaVenta(){
        tmp = (DefaultTableModel)TableVenta.getModel();
        int fila =  TableVenta.getRowCount();
        for (int i = 0; i < fila; i++) {
            tmp.removeRow(0);
        }
    }
    private void LimpiarClienteVenta(){
        txtRucVenta.setText("");
        txtNombreClienteventa.setText("");
        txtTelefonoventa.setText("");
        txtDirecionCV.setText("");
        txtRazonCV.setText("");
    }
    private void LimpiarMascota() {
        txtIdpro.setText("");
        txtCodigoPro.setText("");
        cbxProveedorPro.setSelectedItem(null);
        txtDescripcionPro.setText("");
        txtStockPro.setText("");
        txtPrecioPro.setText("");
    }
}
