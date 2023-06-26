package Model;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    public static Connection getConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String jdbcUrl = "jdbc:mysql://localhost:3306/aluguesports";
        String username = "root";
        String password = "";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            // Lidar com exceções de conexão aqui
        }
        return connection;
    }
    public static void update(String tabela, String coluna, String valor, String codigo ,String codigoColuna) throws ClassNotFoundException {
        Connection connection = getConnection();
        try {
            String sql = "UPDATE ? SET ? = ? WHERE ? = ?";
            connection.prepareStatement(sql);
            connection.createStatement().executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados no banco de dados.");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Erro ao fechar conexão com o banco de dados.");
            }
        }
    }
    public static void delete(String tabela, String codigo, String codigoColuna) throws ClassNotFoundException {
        Connection connection = getConnection();
        try {
            String sql = "DELETE FROM ? WHERE ? = ?";
            connection.prepareStatement(sql);
            connection.createStatement().executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Dados deletados com sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar dados no banco de dados.");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Erro ao fechar conexão com o banco de dados.");
            }
        }
    }

    public static void insert(String tabela, String colunas, String valores) throws ClassNotFoundException {
        Connection connection = getConnection();
        try {
            String sql = "INSERT INTO ? (?) VALUES (?)";
            connection.prepareStatement(sql);
            connection.createStatement().executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados no banco de dados.");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Erro ao fechar conexão com o banco de dados.");
            }
        }
    }
}