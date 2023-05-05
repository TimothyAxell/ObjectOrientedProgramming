/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyek_pbo;

import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author WIN10
 */
public class MasterStok extends javax.swing.JFrame {

    /**
     * Creates new form MasterStok
     */
    
    Object[] rows;
    DefaultTableModel model;
    Statement st;
    ResultSet rs;
    PreparedStatement pr;
    
    int jabatan;
    public MasterStok(int jabatan) {
        initComponents();
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
        this.jabatan = jabatan;
        System.out.println(jabatan);
        if (jabatan == 0 || jabatan == 2) {
            btnUpdate.setVisible(false);
            //btnAktifkan.setVisible(false);
            btnInsert.setVisible(false);
            btnDelete.setVisible(false);
        }
        reset();
       
        tblStok.setDefaultEditor(Object.class, null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
        rows = new Object[]{"ID","Nama Barang","Harga Normal","Jenis","Stok","Harga Grosir"};
        model = new DefaultTableModel(rows,0);
        tblStok.setModel(model);
        tampil();
        tblStok.getTableHeader().setReorderingAllowed(false);
    }
    
    

    private MasterStok() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void tampil()
    {
        try {
            refreshTabel();
            st = Proyek_PBO.conn.createStatement();
            String sql = "select b.IDBARANG,b.NAMABARANG,b.HARGANORMAL,j.NAMAJENIS, b.STOK, b.HARGAGROSIR from barang b, jenisbarang j where b.fk_jenis = j.idjenis and b.stok > 0 order by b.IDBARANG";
            rs = st.executeQuery(sql);
            while (rs.next()) {                
                Object vdata = new Object[]{rs.getInt("IDBARANG"),rs.getString("NAMABARANG"),rs.getInt("HARGANORMAL"),rs.getString("NAMAJENIS"),rs.getInt("STOK"),rs.getInt("HARGAGROSIR")};
                model.addRow((Object[]) vdata);
            }
            
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MasterStok.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tblStok = new javax.swing.JTable();
        cmbHarga = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tbCari = new javax.swing.JTextField();
        tbID = new javax.swing.JTextField();
        tbNama = new javax.swing.JTextField();
        tbHarga = new javax.swing.JTextField();
        cbFilterJenis = new javax.swing.JComboBox<>();
        tbStok = new javax.swing.JTextField();
        btnBack1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labelSelectedBarang = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        CMBJenis = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblStok.setModel(new javax.swing.table.DefaultTableModel(
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
        tblStok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblStokMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblStok);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 130, 1140, 420));

        cmbHarga.setBackground(new java.awt.Color(187, 187, 187));
        cmbHarga.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        cmbHarga.setForeground(new java.awt.Color(0, 0, 0));
        cmbHarga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Harga Terendah - Harga Tertinggi", "Harga Tertinggi - Harga Terendah" }));
        cmbHarga.setBorder(null);
        cmbHarga.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbHargaItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 220, 30));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 900, 490, -1));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 660, 490, -1));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 720, 490, -1));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 780, 490, -1));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Stok");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Jenis");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 810, -1, 30));

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Harga");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 870, -1, 30));

        btnSearch.setBackground(new java.awt.Color(204, 204, 204));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyek_pbo/searchBlc(1).png"))); // NOI18N
        btnSearch.setBorder(null);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, 30, 30));

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Stok");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 750, -1, -1));

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Nama Barang");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 680, -1, 42));

        tbCari.setBackground(new java.awt.Color(204, 204, 204));
        tbCari.setBorder(null);
        tbCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbCariKeyTyped(evt);
            }
        });
        getContentPane().add(tbCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 320, 30));

        tbID.setBackground(new java.awt.Color(255, 255, 255));
        tbID.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 14)); // NOI18N
        tbID.setForeground(new java.awt.Color(0, 0, 0));
        tbID.setBorder(null);
        getContentPane().add(tbID, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 620, 490, 41));

        tbNama.setBackground(new java.awt.Color(255, 255, 255));
        tbNama.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 14)); // NOI18N
        tbNama.setForeground(new java.awt.Color(0, 0, 0));
        tbNama.setBorder(null);
        getContentPane().add(tbNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 680, 490, 39));

        tbHarga.setBackground(new java.awt.Color(255, 255, 255));
        tbHarga.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 14)); // NOI18N
        tbHarga.setForeground(new java.awt.Color(0, 0, 0));
        tbHarga.setBorder(null);
        getContentPane().add(tbHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 860, 490, 38));

        cbFilterJenis.setBackground(new java.awt.Color(187, 187, 187));
        cbFilterJenis.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        cbFilterJenis.setForeground(new java.awt.Color(0, 0, 0));
        cbFilterJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bolpen dan Pensil", "Alat lukis dan Warna", "Kertas dan Amplop", "Aksesoris Komputer dan HP", "Buku Ilmu Pengetahuan", "Buku Tulis", "Novel dan Fiksi", "SEMUA" }));
        cbFilterJenis.setBorder(null);
        cbFilterJenis.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFilterJenisItemStateChanged(evt);
            }
        });
        getContentPane().add(cbFilterJenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 80, 250, 30));

        tbStok.setBackground(new java.awt.Color(255, 255, 255));
        tbStok.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 14)); // NOI18N
        tbStok.setForeground(new java.awt.Color(0, 0, 0));
        tbStok.setBorder(null);
        getContentPane().add(tbStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 740, 490, 39));

        btnBack1.setBackground(new java.awt.Color(24, 90, 102));
        btnBack1.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 12)); // NOI18N
        btnBack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyek_pbo/Back(3).png"))); // NOI18N
        btnBack1.setBorder(null);
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton3.setBackground(new java.awt.Color(24, 90, 102));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyek_pbo/minimize(2).png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 10, 30, 30));

        jButton4.setBackground(new java.awt.Color(24, 90, 102));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyek_pbo/Exit (3).png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, 30, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyek_pbo/HeaderHistory.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 50));

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("ID");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 630, -1, -1));
        getContentPane().add(labelSelectedBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 570, 200, 200));

        btnInsert.setBackground(new java.awt.Color(204, 204, 204));
        btnInsert.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        btnInsert.setForeground(new java.awt.Color(0, 0, 0));
        btnInsert.setText("Insert");
        btnInsert.setBorder(null);
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 860, 130, 65));

        btnDelete.setBackground(new java.awt.Color(204, 204, 204));
        btnDelete.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete.setText("Delete");
        btnDelete.setBorder(null);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 860, 130, 65));

        btnUpdate.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdate.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate.setText("Update");
        btnUpdate.setBorder(null);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 780, 130, 65));

        CMBJenis.setBackground(new java.awt.Color(187, 187, 187));
        CMBJenis.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        CMBJenis.setForeground(new java.awt.Color(0, 0, 0));
        CMBJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bolpen dan Pensil", "Alat lukis dan Warna", "Kertas dan Amplop", "Aksesoris Komputer dan HP", "Buku Ilmu Pengetahuan", "Buku Tulis", "Novel dan Fiksi" }));
        CMBJenis.setBorder(null);
        getContentPane().add(CMBJenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 810, 490, 30));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyek_pbo/TextStokck.png"))); // NOI18N
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 800, -1));

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyek_pbo/bgHistory.png"))); // NOI18N
        jLabel11.setText("jLabel4");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel11.setDoubleBuffered(true);
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1190, 930));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 810, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
        if (jabatan == 0) {
            formPilihManager f = new formPilihManager(jabatan);
            f.setVisible(true);
            this.dispose();
        }else if (jabatan == 2) {
            formPilihKasir f = new formPilihKasir(jabatan);
            f.setVisible(true);
            this.dispose();
        }
        else{
            LoginForm f = new LoginForm();
            f.setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.setExtendedState(MasterStok.ICONIFIED);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    public void refreshTabel()
    {
        model = new DefaultTableModel(rows,0);
        tblStok.setModel(model);
    }
    
    private void tblStokMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStokMousePressed
        // TODO add your handling code here:
        int idx = tblStok.getSelectedRow();
        String kode = model.getValueAt(idx, 0).toString();
        tbID.setText(kode);
        String nama = model.getValueAt(idx, 1).toString();
        tbNama.setText(nama);
        String stok = model.getValueAt(idx, 4).toString();
        tbStok.setText(stok);
        String jenis = model.getValueAt(idx, 3).toString();
        if (jenis.equals("Bolpen dan Pensil")) {
            CMBJenis.setSelectedIndex(0);
        }else if (jenis.equals("Alat lukis dan Warna")) {
            CMBJenis.setSelectedIndex(1);
            
        }else if (jenis.equals("Kertas dan Amplop")) {
            CMBJenis.setSelectedIndex(2);
            
        }else if (jenis.equals("Aksesoris Komputer dan HP")) {
            CMBJenis.setSelectedIndex(3);
            
        }else if (jenis.equals("Buku Ilmu Pengetahuan")) {
            CMBJenis.setSelectedIndex(4);
            
        }else if (jenis.equals("Buku Tulis")) {
            CMBJenis.setSelectedIndex(5);
            
        }else if (jenis.equals("Novel dan Fiksi")) {
            CMBJenis.setSelectedIndex(6);
            
        }
        String harga = model.getValueAt(idx, 2).toString();
        tbHarga.setText(harga);
        
        ImageIcon iconproduk = new ImageIcon("Gambar_Produk/"+kode+".jpg");
        //ImageIcon iconproduk = new ImageIcon(getClass().getResource(("/proyek_pbo/Gambar_Produk/"+kode+".jpg")));
        Image gambarproduk = iconproduk.getImage();
        Image scaleproduk = gambarproduk.getScaledInstance(labelSelectedBarang.getWidth(), labelSelectedBarang.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon produkscaled = new ImageIcon(scaleproduk);
        labelSelectedBarang.setIcon(produkscaled);
    }//GEN-LAST:event_tblStokMousePressed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:

            refreshTabel();
            pr = Proyek_PBO.conn.prepareStatement("INSERT INTO BARANG(NAMABARANG,HARGANORMAL,FK_JENIS,STOK,HARGAGROSIR) VALUES(?,?,?,?,?)");
            pr.setString(1,tbNama.getText());
            pr.setInt(2,Integer.parseInt(tbHarga.getText()));
//            pr.setInt(3,Integer.parseInt(tbJenis.getText()));
                        pr.setInt(3,CMBJenis.getSelectedIndex()+1);

            pr.setInt(4,Integer.parseInt(tbStok.getText()));
            pr.setInt(5,Integer.parseInt(tbHarga.getText()));
            int rowUpdated = pr.executeUpdate();
            if (rowUpdated==1) {
                JOptionPane.showMessageDialog(rootPane, "Berhasil Insert");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Gagal Insert");
            }
            tampil();
            clear();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            //Logger.getLogger(MasterStok.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    public void clear()
    {
        tbID.setText("");
        tbNama.setText("");
        tbStok.setText("");
        tbHarga.setText("");
    }
    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            refreshTabel();

            pr = Proyek_PBO.conn.prepareStatement("UPDATE BARANG  set stok = 0 where IDBARANG = ?");

            pr.setInt(1,Integer.parseInt(tbID.getText()));
            int rowUpdated = pr.executeUpdate();
            if (rowUpdated==1) {
                JOptionPane.showMessageDialog(rootPane, "Berhasil Delete");
                clear();
                reset();
                labelSelectedBarang.setIcon(null);
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Gagal Delete");
            }
            tampil();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            //Logger.getLogger(MasterStok.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            refreshTabel();

            pr = Proyek_PBO.conn.prepareStatement("UPDATE BARANG SET NAMABARANG = ? , HARGANORMAL = ? , FK_JENIS = ?, STOK =?,HARGAGROSIR = ? where IDBARANG = ?");
            pr.setString(1,tbNama.getText());
            pr.setInt(2,Integer.parseInt(tbHarga.getText()));
            pr.setInt(3,CMBJenis.getSelectedIndex()+1);
            pr.setInt(4,Integer.parseInt(tbStok.getText()));
            pr.setInt(5,Integer.parseInt(tbHarga.getText()));
            pr.setInt(6,Integer.parseInt(tbID.getText()));
            int rowUpdated = pr.executeUpdate();
            if (rowUpdated==1) {
                JOptionPane.showMessageDialog(rootPane, "Berhasil Update");
                clear();
                reset();
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Gagal Update");
            }
            tampil();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            //Logger.getLogger(MasterStok.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cbFilterJenisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFilterJenisItemStateChanged
        // TODO add your handling code here:
        int ctr = cbFilterJenis.getSelectedIndex();
        String kat = cbFilterJenis.getItemAt(ctr);
        int ctr2 = cmbHarga.getSelectedIndex();
        String order = "";
        if (ctr2==0) {
            order = "asc";
        }
        else
        {
            
            order = "desc";
        }
        if (kat.equals("SEMUA")) {
            tampil();
        }
        else
        {
            if (order.equals("asc")) {
                try {
                refreshTabel();
                pr = Proyek_PBO.conn.prepareStatement("select b.IDBARANG,b.NAMABARANG,b.HARGANORMAL,j.NAMAJENIS, b.STOK, b.HARGAGROSIR from barang b, jenisbarang j where b.fk_jenis = j.idjenis and lower(j.namajenis) like ? and lower(b.namabarang) like ? and b.stok > 0 order by b.harganormal asc");
                pr.setString(1,"%"+kat+"%");
                pr.setString(2,"%"+tbCari.getText()+"%");
                rs = pr.executeQuery();
                while (rs.next()) {                
                    Object vdata = new Object[]{rs.getInt("IDBARANG"),rs.getString("NAMABARANG"),rs.getInt("HARGANORMAL"),rs.getString("NAMAJENIS"),rs.getInt("STOK"),rs.getInt("HARGAGROSIR")};
                    model.addRow((Object[]) vdata);
                }
                rs.close();

                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(MasterStok.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else if (order.equals("desc")) {
                try {
                refreshTabel();
                pr = Proyek_PBO.conn.prepareStatement("select b.IDBARANG,b.NAMABARANG,b.HARGANORMAL,j.NAMAJENIS, b.STOK, b.HARGAGROSIR from barang b, jenisbarang j where b.fk_jenis = j.idjenis and lower(j.namajenis) like ? and lower(b.namabarang) like ? and b.stok > 0 order by b.harganormal desc");
                pr.setString(1,"%"+kat+"%");
                pr.setString(2,"%"+tbCari.getText()+"%");
                rs = pr.executeQuery();
                while (rs.next()) {                
                    Object vdata = new Object[]{rs.getInt("IDBARANG"),rs.getString("NAMABARANG"),rs.getInt("HARGANORMAL"),rs.getString("NAMAJENIS"),rs.getInt("STOK"),rs.getInt("HARGAGROSIR")};
                    model.addRow((Object[]) vdata);
                }
                rs.close();

                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(MasterStok.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        
    }//GEN-LAST:event_cbFilterJenisItemStateChanged

    private void tbCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbCariKeyTyped
        // TODO add your handling code here:
        int ctr = cbFilterJenis.getSelectedIndex();
        String kat = cbFilterJenis.getItemAt(ctr);
        if (kat.equals("SEMUA")) {
            kat = "";
        }
        int ctr2 = cmbHarga.getSelectedIndex();
        String order = "";
        if (ctr2==0) {
            order = "asc";
        }
        else
        {
            
            order = "desc";
        }
        if (order.equals("asc")) {
                try {
                refreshTabel();
                pr = Proyek_PBO.conn.prepareStatement("select b.IDBARANG,b.NAMABARANG,b.HARGANORMAL,j.NAMAJENIS, b.STOK, b.HARGAGROSIR from barang b, jenisbarang j where b.fk_jenis = j.idjenis and lower(j.namajenis) like ? and lower(b.namabarang) like ? and b.stok > 0 order by b.harganormal asc");
                pr.setString(1,"%"+kat+"%");
                pr.setString(2,"%"+tbCari.getText()+"%");
                rs = pr.executeQuery();
                while (rs.next()) {                
                    Object vdata = new Object[]{rs.getInt("IDBARANG"),rs.getString("NAMABARANG"),rs.getInt("HARGANORMAL"),rs.getString("NAMAJENIS"),rs.getInt("STOK"),rs.getInt("HARGAGROSIR")};
                    model.addRow((Object[]) vdata);
                }
                rs.close();

                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(MasterStok.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (order.equals("desc")) {
                try {
                refreshTabel();
                pr = Proyek_PBO.conn.prepareStatement("select b.IDBARANG,b.NAMABARANG,b.HARGANORMAL,j.NAMAJENIS, b.STOK, b.HARGAGROSIR from barang b, jenisbarang j where b.fk_jenis = j.idjenis and lower(j.namajenis) like ? and lower(b.namabarang) like ? and b.stok > 0 order by b.harganormal desc");
                pr.setString(1,"%"+kat+"%");
                pr.setString(2,"%"+tbCari.getText()+"%");
                rs = pr.executeQuery();
                while (rs.next()) {                
                    Object vdata = new Object[]{rs.getInt("IDBARANG"),rs.getString("NAMABARANG"),rs.getInt("HARGANORMAL"),rs.getString("NAMAJENIS"),rs.getInt("STOK"),rs.getInt("HARGAGROSIR")};
                    model.addRow((Object[]) vdata);
                }
                rs.close();

                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(MasterStok.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }//GEN-LAST:event_tbCariKeyTyped

    private void cmbHargaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbHargaItemStateChanged
        // TODO add your handling code here:
        int ctr2 = cbFilterJenis.getSelectedIndex();
        String kat = cbFilterJenis.getItemAt(ctr2);
        if (kat.equals("SEMUA")) {
            kat = "";
        }
        int ctr = cmbHarga.getSelectedIndex();
        if (ctr==0) {
            try {
                refreshTabel();
                pr = Proyek_PBO.conn.prepareStatement("select b.IDBARANG,b.NAMABARANG,b.HARGANORMAL,j.NAMAJENIS, b.STOK, b.HARGAGROSIR from barang b, jenisbarang j where b.fk_jenis = j.idjenis and lower(b.NAMABARANG) like ? and lower(j.namajenis) like ? and b.stok > 0 order by harganormal asc");
                pr.setString(1,"%"+tbCari.getText().toLowerCase()+"%");
                pr.setString(2,"%"+kat+"%");
                rs = pr.executeQuery();
                while (rs.next()) {                
                    Object vdata = new Object[]{rs.getInt("IDBARANG"),rs.getString("NAMABARANG"),rs.getInt("HARGANORMAL"),rs.getString("NAMAJENIS"),rs.getInt("STOK"),rs.getInt("HARGAGROSIR")};
                    model.addRow((Object[]) vdata);
                }
                rs.close();

                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(MasterStok.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            try {
                refreshTabel();
                pr = Proyek_PBO.conn.prepareStatement("select b.IDBARANG,b.NAMABARANG,b.HARGANORMAL,j.NAMAJENIS, b.STOK, b.HARGAGROSIR from barang b, jenisbarang j where b.fk_jenis = j.idjenis and lower(b.NAMABARANG) like ? and lower(j.namajenis) like ? and b.stok > 0 order by harganormal desc");
                pr.setString(1,"%"+tbCari.getText().toLowerCase()+"%");
                pr.setString(2,"%"+kat+"%");
                rs = pr.executeQuery();
                while (rs.next()) {                
                    Object vdata = new Object[]{rs.getInt("IDBARANG"),rs.getString("NAMABARANG"),rs.getInt("HARGANORMAL"),rs.getString("NAMAJENIS"),rs.getInt("STOK"),rs.getInt("HARGAGROSIR")};
                    model.addRow((Object[]) vdata);
                }
                rs.close();

                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(MasterStok.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cmbHargaItemStateChanged

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    
    public void reset()
    {
        tbNama.setText("");
        tbID.setText("");
        tbStok.setText("");
//        tbJenis.setText("");
        tbHarga.setText("");
        
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
            java.util.logging.Logger.getLogger(MasterStok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterStok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterStok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterStok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterStok().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CMBJenis;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbFilterJenis;
    private javax.swing.JComboBox<String> cmbHarga;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel labelSelectedBarang;
    private javax.swing.JTextField tbCari;
    private javax.swing.JTextField tbHarga;
    private javax.swing.JTextField tbID;
    private javax.swing.JTextField tbNama;
    private javax.swing.JTextField tbStok;
    private javax.swing.JTable tblStok;
    // End of variables declaration//GEN-END:variables
}
