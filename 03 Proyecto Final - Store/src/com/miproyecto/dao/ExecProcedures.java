package com.miproyecto.dao;

import javax.swing.JOptionPane;
import com.miproyecto.db.DBConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExecProcedures {

    //Metodo: Agrega Marca
    public static void addBrand(String brandName) {
        Connection connection = null;
        CallableStatement statement = null;

        try {
            connection = DBConnection.getConnection();
            String AddBrand = "{CALL AddBrand(?)}";
            statement = connection.prepareCall(AddBrand);
            statement.setString(1, brandName);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Marca agregada");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos");
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Método: Verificar que no exista la marca
    public static boolean checkBrandExists(String brandName) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String query = "SELECT COUNT(*) FROM brands WHERE name = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, brandName);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Devuelve true si existe al menos una fila con el nombre de marca
            }
        } catch (SQLException e) {
            System.out.println("System: Error al ejecutar la consulta");
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
        }
        return false;
    }

    //Metodo: Agrega Categoría
    public static void addCategory(String categoryName) {
        Connection connection = null;
        CallableStatement statement = null;

        try {
            connection = DBConnection.getConnection();
            String addCategory = "{CALL AddCategory(?)}";
            statement = connection.prepareCall(addCategory);
            statement.setString(1, categoryName);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoría agregada");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos");
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Método: Verificar que no exista la categoría
    public static boolean checkCategoryExists(String categoryName) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String query = "SELECT COUNT(*) FROM categories WHERE name = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, categoryName);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Devuelve true si existe al menos una fila con el nombre de categoría
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
        }
        return false; // Si ocurre alguna excepción, devuelve false por defecto
    }

    //Metodo: Agregar Producto
    public static void addProduct(int brandId, int categoryId, String productName, double saleValue, double costValue) {
        Connection connection = null;
        CallableStatement statement = null;

        try {
            connection = DBConnection.getConnection();
            String addProduct = "{CALL AddProduct(?, ?, ?, ?, ?)}";
            statement = connection.prepareCall(addProduct);
            statement.setInt(1, brandId);
            statement.setInt(2, categoryId);
            statement.setString(3, productName);
            statement.setDouble(4, saleValue);
            statement.setDouble(5, costValue);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto agregado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos");
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Método: Verificar si el producto existe
    public static boolean checkProductExists(String productName) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean productExists = false;

        try {
            connection = DBConnection.getConnection();
            String query = "SELECT COUNT(*) FROM products WHERE name = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, productName);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                productExists = count > 0; // Devuelve true si existe al menos una fila con el nombre del producto
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta");
            e.printStackTrace();
        } finally {
            // No cerrar la conexión aquí para que pueda ser utilizada externamente
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
        }
        return productExists;
    }

}
