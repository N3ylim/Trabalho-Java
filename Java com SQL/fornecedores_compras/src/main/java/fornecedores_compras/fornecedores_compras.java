// Neylor
package fornecedores_compras;

import java.sql.*;

public class fornecedores_compras {

    private static final String URL = "jdbc:mysql://localhost:3306/fornecedores_compras";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static void main(String[] args) throws SQLException {
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

        conexao.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS fornecedores (id_fornecedor INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255), contato VARCHAR(255))");

        conexao.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS compras (id_compra INT AUTO_INCREMENT PRIMARY KEY, id_fornecedor INT, produto_comprado VARCHAR(255), quantidade INT)");

        conexao.createStatement().executeUpdate("INSERT INTO fornecedores (nome, contato) VALUES ('Fornecedor A', 'Contato A')");
        conexao.createStatement().executeUpdate("INSERT INTO fornecedores (nome, contato) VALUES ('Fornecedor B', 'Contato B')");

        conexao.createStatement().executeUpdate("INSERT INTO compras (id_fornecedor, produto_comprado, quantidade) VALUES (1, 'Produto X', 100)");
        conexao.createStatement().executeUpdate("INSERT INTO compras (id_fornecedor, produto_comprado, quantidade) VALUES (2, 'Produto Y', 50)");

        conexao.close();
    }
}
