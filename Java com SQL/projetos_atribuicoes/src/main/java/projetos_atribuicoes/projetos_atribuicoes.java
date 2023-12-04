package projetos_atribuicoes;

import java.sql.*;

public class projetos_atribuicoes {

    private static final String URL = "jdbc:mysql://localhost:3306/projetos_atribuicoes";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static void main(String[] args) throws SQLException {
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

        conexao.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS projetos (id_projeto INT AUTO_INCREMENT PRIMARY KEY, nome_projeto VARCHAR(255), descricao VARCHAR(255))");

        conexao.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS atribuicoes (id_atribuicao INT AUTO_INCREMENT PRIMARY KEY, id_projeto INT, id_funcionario INT)");

        conexao.createStatement().executeUpdate("INSERT INTO projetos (nome_projeto, descricao) VALUES ('Projeto A', 'Descrição do Projeto A')");
        conexao.createStatement().executeUpdate("INSERT INTO projetos (nome_projeto, descricao) VALUES ('Projeto B', 'Descrição do Projeto B')");

        conexao.createStatement().executeUpdate("INSERT INTO atribuicoes (id_projeto, id_funcionario) VALUES (1, 1)");
        conexao.createStatement().executeUpdate("INSERT INTO atribuicoes (id_projeto, id_funcionario) VALUES (2, 2)");

        conexao.close();
    }
}
