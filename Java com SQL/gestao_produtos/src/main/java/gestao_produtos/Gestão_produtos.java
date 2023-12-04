// Neylor
package gestao_produtos;

import java.sql.*;

public class Gestão_produtos {

    private static final String URL = "jdbc:mysql://localhost:3306/gestão_produtos";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static void main(String[] args) throws SQLException {
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

        conexao.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS produtos (id_produto INT AUTO_INCREMENT PRIMARY KEY, nome_produto VARCHAR(255), preco DECIMAL(10,2))");

        conexao.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS categorias (id_categoria INT AUTO_INCREMENT PRIMARY KEY, nome_categoria VARCHAR(255))");

        conexao.createStatement().executeUpdate("INSERT INTO produtos (nome_produto, preco) VALUES ('Produto A', 10.50)");
        conexao.createStatement().executeUpdate("INSERT INTO produtos (nome_produto, preco) VALUES ('Produto B', 20.75)");
        
        conexao.createStatement().executeUpdate("INSERT INTO categorias (nome_categoria) VALUES ('Categoria X')");
        conexao.createStatement().executeUpdate("INSERT INTO categorias (nome_categoria) VALUES ('Categoria Y')");

        conexao.createStatement().executeUpdate("INSERT INTO produtos_categorias (id_produto, id_categoria) VALUES (1, 1)");
        conexao.createStatement().executeUpdate("INSERT INTO produtos_categorias (id_produto, id_categoria) VALUES (2, 2)");

        conexao.close();
    }
}
