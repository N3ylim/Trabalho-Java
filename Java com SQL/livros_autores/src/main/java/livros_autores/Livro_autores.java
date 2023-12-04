// Neylor
package livros_autores;

import java.sql.*;

public class Livro_autores {

    private static final String URL = "jdbc:mysql://localhost:3306/livro_autores";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static void main(String[] args) throws SQLException {
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

        conexao.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS livros (id_livro INT AUTO_INCREMENT PRIMARY KEY, titulo VARCHAR(255), ano_publicacao INT)");

        conexao.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS autores (id_autor INT AUTO_INCREMENT PRIMARY KEY, nome_autor VARCHAR(255))");

        conexao.createStatement().executeUpdate("INSERT INTO livros (titulo, ano_publicacao) VALUES ('Livro A', 2020)");
        conexao.createStatement().executeUpdate("INSERT INTO livros (titulo, ano_publicacao) VALUES ('Livro B', 2018)");

        conexao.createStatement().executeUpdate("INSERT INTO autores (nome_autor) VALUES ('Autor X')");
        conexao.createStatement().executeUpdate("INSERT INTO autores (nome_autor) VALUES ('Autor Y')");

        conexao.createStatement().executeUpdate("INSERT INTO livros_autores (id_livro, id_autor) VALUES (1, 1)");
        conexao.createStatement().executeUpdate("INSERT INTO livros_autores (id_livro, id_autor) VALUES (2, 2)");

        conexao.close();
    }
}
