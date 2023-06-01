package com.miproyecto.dao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameMenuPrincipal extends javax.swing.JFrame {

    public FrameMenuPrincipal() {
        //Inicializar componentes
        initComponents();

        //Preconfiguraciones
        setLocationRelativeTo(null);        //Centrar ventana  
        setResizable(false);                //No redimensionable           

        //Acción: Confirmar salida 1
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Main.confirmExit(FrameMenuPrincipal.this);
            }
        });

        //Acción: Confirmar salida 2
        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.confirmExit(FrameMenuPrincipal.this);
            }
        });

        //Acción: Agregar marca
        buttonAddBrand.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setMenuEnabled(false); // deshabilitar menu
                javax.swing.SwingUtilities.invokeLater(() -> {
                    FrameAddBrand FrameAddBrand = new FrameAddBrand(FrameMenuPrincipal.this);
                    FrameAddBrand.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            setMenuEnabled(true); // Habilitar menu
                        }
                    });
                });
            }
        });

        //Acción: Agregar categoria
        buttonAddCategory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setMenuEnabled(false); // deshabilitar menu
                javax.swing.SwingUtilities.invokeLater(() -> {
                    FrameAddCategory FrameAddCategory = new FrameAddCategory(FrameMenuPrincipal.this);
                    FrameAddCategory.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            setMenuEnabled(true); // Habilitar menu
                        }
                    });
                });
            }
        });

        //Acción: Agregar producto
        buttonAddProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setMenuEnabled(false); // deshabilitar menu
                javax.swing.SwingUtilities.invokeLater(() -> {
                    FrameAddProduct FrameAddProduct = new FrameAddProduct(FrameMenuPrincipal.this);
                    FrameAddProduct.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            setMenuEnabled(true); // Habilitar menu
                        }
                    });
                    FrameAddProduct.insertBrandsIntoComboBox();
                    FrameAddProduct.insertCategoriesIntoComboBox();
                });
            }
        });

        //Acción: Agregar venta
        buttonAddSale.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setMenuEnabled(false); // deshabilitar menu
                javax.swing.SwingUtilities.invokeLater(() -> {
                    FrameAddSale FrameAddSale = new FrameAddSale(FrameMenuPrincipal.this);
                    FrameAddSale.addWindowListener(new WindowAdapter() {
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

        backgraoud = new javax.swing.JPanel();
        buttonExit = new javax.swing.JButton();
        buttonAddBrand = new javax.swing.JButton();
        buttonAddCategory = new javax.swing.JButton();
        buttonAddProduct = new javax.swing.JButton();
        buttonAddSale = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonExit.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        buttonExit.setText("Salir");

        buttonAddBrand.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        buttonAddBrand.setText("Agregar Marca");

        buttonAddCategory.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        buttonAddCategory.setText("Agregar Categoría");

        buttonAddProduct.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        buttonAddProduct.setText("Agregar Producto");

        buttonAddSale.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        buttonAddSale.setText("Agregar Venta");

        javax.swing.GroupLayout backgraoudLayout = new javax.swing.GroupLayout(backgraoud);
        backgraoud.setLayout(backgraoudLayout);
        backgraoudLayout.setHorizontalGroup(
            backgraoudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgraoudLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(backgraoudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgraoudLayout.createSequentialGroup()
                        .addGroup(backgraoudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonAddBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAddSale, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgraoudLayout.createSequentialGroup()
                        .addComponent(buttonExit)
                        .addGap(120, 120, 120))))
        );
        backgraoudLayout.setVerticalGroup(
            backgraoudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgraoudLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonAddBrand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonAddCategory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonAddProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonAddSale)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(buttonExit)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgraoud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgraoud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMenuPrincipal().setVisible(true);
            }
        });
    }

    //Metodo: Deshabilitar menú principal
    public void setMenuEnabled(boolean enabled) {
        setEnabled(enabled);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgraoud;
    private javax.swing.JButton buttonAddBrand;
    private javax.swing.JButton buttonAddCategory;
    private javax.swing.JButton buttonAddProduct;
    private javax.swing.JButton buttonAddSale;
    private javax.swing.JButton buttonExit;
    // End of variables declaration//GEN-END:variables
}
