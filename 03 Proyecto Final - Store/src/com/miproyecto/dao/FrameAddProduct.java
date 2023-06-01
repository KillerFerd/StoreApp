package com.miproyecto.dao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.miproyecto.db.DBConnection;

public class FrameAddProduct extends javax.swing.JFrame {

    public FrameAddProduct(FrameMenuPrincipal menuPrincipal) {
        //Inicializar Componentes         
        initComponents();

        //Preconfiguraciones
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //Cerrar este JFRAME
        setTitle("Agregar Producto");                       //Título de la ventana
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

        //Acción: Agregar productos
        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                //Obtener selección del comboBoxBrand
                String brandSelection = comboBoxBrand.getSelectedItem().toString();
                int indexBrandSeparator = brandSelection.indexOf(".");
                int idBrand = Integer.parseInt(brandSelection.substring(0, indexBrandSeparator).trim());

                //Obtener selección del comboBoxCategory
                String categorySelection = comboBoxCategory.getSelectedItem().toString();
                int indexCategorySeparator = categorySelection.indexOf(".");
                int idCategory = Integer.parseInt(categorySelection.substring(0, indexCategorySeparator).trim());

                //Obtener valores de los textField
                String productName = textFieldProduct.getText();
                String saleValue = textFieldSaleValue.getText();
                String costValue = textFieldCostValue.getText();

                //Validar el nombre del producto
                if (productName.isEmpty()) {
                    JOptionPane.showMessageDialog(FrameAddProduct.this, "Nombre de producto inválido");
                    return; // Salir del ActionListener
                }

                //Validar la existencia del producto
                boolean productExists = ExecProcedures.checkProductExists(productName);
                if (productExists) {
                    JOptionPane.showMessageDialog(FrameAddProduct.this, "El producto ya existe, favor agregar uno válido");
                    return; // Salir del ActionListener
                }

                //Validar el valor de venta
                double saleDouble;
                try {
                    saleDouble = Double.parseDouble(saleValue);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(FrameAddProduct.this, "Valor de venta inválido");
                    return; // Salir del ActionListener
                }

                //Validar el valor de costo
                double costDouble;
                try {
                    costDouble = Double.parseDouble(costValue);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(FrameAddProduct.this, "Valor de costo inválido");
                    return; // Salir del ActionListener
                }
                
                ExecProcedures.addProduct(idBrand, idCategory, productName, saleDouble, costDouble);
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelBrand = new javax.swing.JLabel();
        labelCategory = new javax.swing.JLabel();
        comboBoxBrand = new javax.swing.JComboBox<>();
        comboBoxCategory = new javax.swing.JComboBox<>();
        labelProduct = new javax.swing.JLabel();
        textFieldProduct = new javax.swing.JTextField();
        labelPriceValue = new javax.swing.JLabel();
        labelCostValue = new javax.swing.JLabel();
        textFieldSaleValue = new javax.swing.JTextField();
        textFieldCostValue = new javax.swing.JTextField();
        buttonAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelBrand.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelBrand.setText("Marca");

        labelCategory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCategory.setText("Categoria");

        comboBoxBrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelProduct.setText("Producto");

        labelPriceValue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPriceValue.setText("Valor de Venta");

        labelCostValue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCostValue.setText("Valor de Costo");

        buttonAdd.setText("Agregar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldProduct)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textFieldSaleValue, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldCostValue))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelBrand)
                                    .addComponent(comboBoxBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(labelCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(labelProduct)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelPriceValue)
                                .addGap(65, 65, 65)
                                .addComponent(labelCostValue))
                            .addComponent(buttonAdd))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBrand)
                    .addComponent(labelCategory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPriceValue)
                    .addComponent(labelCostValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldSaleValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldCostValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonAdd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodo: Inicializa combo box de marcas
    public void insertBrandsIntoComboBox() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String query = "SELECT idBrand, name FROM brands";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            comboBoxBrand.removeAllItems(); // Limpiar items existentes en el JComboBox

            while (resultSet.next()) {
                int idBrand = resultSet.getInt("idBrand");
                String name = resultSet.getString("name");
                String brandEntry = idBrand + ". " + name;
                comboBoxBrand.addItem(brandEntry); // Agregar cada entrada al JComboBox
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta");
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // No cerrar la conexión aquí
        }
    }

    //Inicializar combo box de categorias
    public void insertCategoriesIntoComboBox() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String query = "SELECT idCategory, name FROM categories";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            comboBoxCategory.removeAllItems(); // Limpiar items existentes en el JComboBox

            while (resultSet.next()) {
                int idCategory = resultSet.getInt("idCategory");
                String name = resultSet.getString("name");
                String categoryEntry = idCategory + ". " + name;
                comboBoxCategory.addItem(categoryEntry); // Agregar cada entrada al JComboBox
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta");
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // No cerrar la conexión aquí
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JComboBox<String> comboBoxBrand;
    private javax.swing.JComboBox<String> comboBoxCategory;
    private javax.swing.JLabel labelBrand;
    private javax.swing.JLabel labelCategory;
    private javax.swing.JLabel labelCostValue;
    private javax.swing.JLabel labelPriceValue;
    private javax.swing.JLabel labelProduct;
    private javax.swing.JTextField textFieldCostValue;
    private javax.swing.JTextField textFieldProduct;
    private javax.swing.JTextField textFieldSaleValue;
    // End of variables declaration//GEN-END:variables
}
