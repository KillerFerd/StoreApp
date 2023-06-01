package com.miproyecto.dao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameAddCategory extends javax.swing.JFrame {

    public FrameAddCategory(FrameMenuPrincipal menuPrincipal) {
        //Inicializar Componentes        
        initComponents();

        //Preconfiguraciones
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //Cerrar este JFRAME
        setTitle("Agregar Categoria");                      //Título de la ventana
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
                String categoryName = textFieldCategory.getText();
                if (categoryName.isEmpty()) {
                    JOptionPane.showMessageDialog(FrameAddCategory.this, "Favor agregar una marca válida");
                } else {
                    boolean brandExists = ExecProcedures.checkCategoryExists(categoryName);
                    if (brandExists) {
                        JOptionPane.showMessageDialog(FrameAddCategory.this, "La categoria ya existe, favor agregar una válida");
                    } else {
                        ExecProcedures.addCategory(categoryName);
                    }
                }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroud = new javax.swing.JPanel();
        labelCategory = new javax.swing.JLabel();
        textFieldCategory = new javax.swing.JTextField();
        buttonAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelCategory.setText("Categoria");

        buttonAdd.setText("Agregar");

        javax.swing.GroupLayout backgroudLayout = new javax.swing.GroupLayout(backgroud);
        backgroud.setLayout(backgroudLayout);
        backgroudLayout.setHorizontalGroup(
            backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroudLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldCategory)
                    .addGroup(backgroudLayout.createSequentialGroup()
                        .addGroup(backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCategory)
                            .addComponent(buttonAdd))
                        .addGap(0, 215, Short.MAX_VALUE)))
                .addContainerGap())
        );
        backgroudLayout.setVerticalGroup(
            backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroudLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(labelCategory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backgroud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroud;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JLabel labelCategory;
    private javax.swing.JTextField textFieldCategory;
    // End of variables declaration//GEN-END:variables
}
