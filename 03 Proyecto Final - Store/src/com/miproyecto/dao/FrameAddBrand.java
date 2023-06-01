package com.miproyecto.dao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameAddBrand extends JFrame {

    private FrameMenuPrincipal menuPrincipal;

    public FrameAddBrand(FrameMenuPrincipal menuPrincipal) {
        
        //Inicializar componentes
        initComponents();

        //Preconfiguraciones
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //Cerrar este JFRAME
        setTitle("Agregar Marca");                          //Título de la ventana
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

        //Acción: Agregar marca
        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String brandName = textFieldBrand.getText();
                if (brandName.isEmpty()) {
                    JOptionPane.showMessageDialog(FrameAddBrand.this, "Favor agregar una marca válida");
                } else {
                    boolean brandExists = ExecProcedures.checkBrandExists(brandName);
                    if (brandExists) {
                        JOptionPane.showMessageDialog(FrameAddBrand.this, "La marca ya existe, favor agregar una válida");
                    } else {
                        ExecProcedures.addBrand(brandName);
                    }
                }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroud = new javax.swing.JPanel();
        labelBrand = new javax.swing.JLabel();
        textFieldBrand = new javax.swing.JTextField();
        buttonAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelBrand.setText("Marca");

        buttonAdd.setText("Agregar");

        javax.swing.GroupLayout backgroudLayout = new javax.swing.GroupLayout(backgroud);
        backgroud.setLayout(backgroudLayout);
        backgroudLayout.setHorizontalGroup(
            backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroudLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldBrand)
                    .addGroup(backgroudLayout.createSequentialGroup()
                        .addGroup(backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBrand)
                            .addComponent(buttonAdd))
                        .addGap(0, 215, Short.MAX_VALUE)))
                .addContainerGap())
        );
        backgroudLayout.setVerticalGroup(
            backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroudLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelBrand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonAdd)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroud;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JLabel labelBrand;
    private javax.swing.JTextField textFieldBrand;
    // End of variables declaration//GEN-END:variables
}
