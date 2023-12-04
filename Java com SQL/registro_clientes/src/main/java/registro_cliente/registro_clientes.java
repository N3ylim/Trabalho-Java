// Neylor
package registro_cliente;

import java.sql.*;

public class registro_clientes {

    private static final String URL = "jdbc:mysql://localhost:3306/registro_clientes";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static void main(String[] args) throws SQLException {
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

        conexao.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS clientes (id_cliente INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255), email VARCHAR(255))");

        conexao.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS vendas (id_venda INT AUTO_INCREMENT PRIMARY KEY, id_cliente INT, produto_vendido VARCHAR(255), valor DECIMAL(10,2))");

        conexao.createStatement().executeUpdate("INSERT INTO clientes (nome, email) VALUES ('Cliente A', 'clienteA@email.com')");
        conexao.createStatement().executeUpdate("INSERT INTO clientes (nome, email) VALUES ('Cliente B', 'clienteB@email.com')");

        conexao.createStatement().executeUpdate("INSERT INTO vendas (id_cliente, produto_vendido, valor) VALUES (1, 'Produto X', 50.00)");
        conexao.createStatement().executeUpdate("INSERT INTO vendas (id_cliente, produto_vendido, valor) VALUES (2, 'Produto Y', 75.50)");

        conexao.close();
    }
}
