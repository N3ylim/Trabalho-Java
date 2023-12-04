// Neylor
package cadastro;

import java.sql.*;

public class Cadastro_pessoas {

    private static final String URL = "jdbc:mysql://localhost:3306/cadastro";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static void main(String[] args) throws SQLException {
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

        conexao.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS usuarios (id_usuario INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255), email VARCHAR(255))");

        conexao.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS pedidos (id_pedido INT AUTO_INCREMENT PRIMARY KEY, id_usuario INT, produto VARCHAR(255), quantidade INT)");

        conexao.createStatement().executeUpdate("ALTER TABLE pedidos ADD CONSTRAINT fk_id_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);");

        conexao.createStatement().executeUpdate("INSERT INTO usuarios (nome, email) VALUES ('Neylor Henrique', 'neylor@henrique.com.br')");

        conexao.createStatement().executeUpdate("INSERT INTO pedidos (id_usuario, produto, quantidade) VALUES (LAST_INSERT_ID(), 'Livro Java', 1)");

        conexao.close();
    }
}
