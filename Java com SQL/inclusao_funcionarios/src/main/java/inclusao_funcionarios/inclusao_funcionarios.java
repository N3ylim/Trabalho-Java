// Neylor
package inclusao_funcionarios;

import java.sql.*;

public class inclusao_funcionarios {

    private static final String URL = "jdbc:mysql://localhost:3306/inclusao_funcionarios";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static void main(String[] args) throws SQLException {
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

        conexao.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS funcionarios (id_funcionario INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255), cargo VARCHAR(255))");

        conexao.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS departamentos (id_departamento INT AUTO_INCREMENT PRIMARY KEY, nome_departamento VARCHAR(255))");

        conexao.createStatement().executeUpdate("INSERT INTO funcionarios (nome, cargo) VALUES ('Neylor', 'Desenvolvedor')");
        conexao.createStatement().executeUpdate("INSERT INTO funcionarios (nome, cargo) VALUES ('Medina', 'Gerente')");

        conexao.createStatement().executeUpdate("INSERT INTO departamentos (nome_departamento) VALUES ('TI')");
        conexao.createStatement().executeUpdate("INSERT INTO departamentos (nome_departamento) VALUES ('RH')");

        conexao.createStatement().executeUpdate("INSERT INTO funcionarios_departamentos (id_funcionario, id_departamento) VALUES (1, 1)");
        conexao.createStatement().executeUpdate("INSERT INTO funcionarios_departamentos (id_funcionario, id_departamento) VALUES (2, 2)");

        conexao.close();
    }
}
