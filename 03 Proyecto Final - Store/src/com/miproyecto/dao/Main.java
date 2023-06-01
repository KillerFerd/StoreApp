package com.miproyecto.dao;

import com.miproyecto.db.DBConnection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

    private static FrameMenuPrincipal MenuPrincipal;

    public static void main(String[] args) {
        MenuPrincipal = new FrameMenuPrincipal();
        MenuPrincipal.setVisible(true);
    }

    //Metodo: Confirmar Salida
    public static void confirmExit(JFrame windowNoExit) {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir del aplicativo?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            //Cierra la conexión a la base de datos
            DBConnection.closeConnection(); 

            //Finaliza por completo el programa
            System.exit(0);
        } else {
            //Evita el cierre del menú principal
            windowNoExit.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }
}
