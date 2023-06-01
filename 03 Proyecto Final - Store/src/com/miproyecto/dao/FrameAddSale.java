package com.miproyecto.dao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;

public class FrameAddSale extends javax.swing.JFrame {

    private DefaultTableModel tableModel;

    public FrameAddSale(FrameMenuPrincipal menuPrincipal) {
        //Inicializar Componentes   
        initComponents();

        //Preconfiguraciones
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //Cerrar este JFRAME
        setTitle("Agregar Venta");                          //Título de la ventana
        setLocationRelativeTo(null);                        //Centrar Ventana
        setVisible(true);                                   //Habilitar Ventana
        setResizable(false);                                //No redimensionable   

        //Acción: Habilitar menú principal
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                menuPrincipal.setVisible(true);
            }
        });

        // Crear el modelo de tabla con las columnas necesarias
        String[] columnNames = {"Producto", "Cantidad", "Valor"};
        tableModel = new DefaultTableModel(columnNames, 0);

        // Asignar el modelo de tabla a la JTable
        tableDetailSale.setModel(tableModel);
        
                //Acción: Agregar prducto
        buttonAddProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setMenuEnabled(false); // deshabilitar menu
                javax.swing.SwingUtilities.invokeLater(() -> {
                    FrameSearchProduct FrameSearchProduct = new FrameSearchProduct(FrameAddSale.this);
                    FrameSearchProduct.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            setMenuEnabled(true); // Habilitar menu
                        }
                    });
                });
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroud = new javax.swing.JPanel();
        labelNIT = new javax.swing.JLabel();
        textFieldNIT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDetailSale = new javax.swing.JTable();
        textFieldTotal = new javax.swing.JTextField();
        labelTotal = new javax.swing.JLabel();
        buttonAdd = new javax.swing.JButton();
        buttonValidate = new javax.swing.JButton();
        buttonAddProduct = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelNIT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNIT.setText("NIT");

        tableDetailSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Producto", "Producto", "Cantidad", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDetailSale);

        labelTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelTotal.setText("Total");

        buttonAdd.setText("Agregar Venta");

        buttonValidate.setText("Validar");

        buttonAddProduct.setText("Agregar Producto");

        javax.swing.GroupLayout backgroudLayout = new javax.swing.GroupLayout(backgroud);
        backgroud.setLayout(backgroudLayout);
        backgroudLayout.setHorizontalGroup(
            backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroudLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(backgroudLayout.createSequentialGroup()
                        .addGroup(backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNIT))
                        .addGap(18, 18, 18)
                        .addGroup(backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroudLayout.createSequentialGroup()
                                .addComponent(labelTotal)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(backgroudLayout.createSequentialGroup()
                                .addComponent(textFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addComponent(buttonAddProduct)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonValidate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonAdd)))))
                .addContainerGap())
        );
        backgroudLayout.setVerticalGroup(
            backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroudLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNIT)
                    .addComponent(labelTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldNIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAdd)
                    .addComponent(buttonValidate)
                    .addComponent(buttonAddProduct))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroud, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        //Metodo: Deshabilitar menú agregar venta
    public void setMenuEnabled(boolean enabled) {
        setEnabled(enabled);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroud;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonAddProduct;
    private javax.swing.JButton buttonValidate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelNIT;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JTable tableDetailSale;
    private javax.swing.JTextField textFieldNIT;
    private javax.swing.JTextField textFieldTotal;
    // End of variables declaration//GEN-END:variables
}
