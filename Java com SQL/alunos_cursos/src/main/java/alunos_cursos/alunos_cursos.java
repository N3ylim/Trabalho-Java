// Neylor
package alunos_cursos;

import java.sql.*;

public class alunos_cursos {

    private static final String URL = "jdbc:mysql://localhost:3306/alunos_cursos";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static void main(String[] args) throws SQLException {
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

        conexao.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS alunos (id_aluno INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255), turma VARCHAR(255))");

        conexao.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS cursos (id_curso INT AUTO_INCREMENT PRIMARY KEY, nome_curso VARCHAR(255), instrutor VARCHAR(255))");

        conexao.createStatement().executeUpdate("INSERT INTO alunos (nome, turma) VALUES ('Neylor', 'Turma A')");
        conexao.createStatement().executeUpdate("INSERT INTO alunos (nome, turma) VALUES ('Medina', 'Turma B')");

        conexao.createStatement().executeUpdate("INSERT INTO cursos (nome_curso, instrutor) VALUES ('Curso de Java', 'Instrutor A')");
        conexao.createStatement().executeUpdate("INSERT INTO cursos (nome_curso, instrutor) VALUES ('Curso de Python', 'Instrutor B')");

        conexao.createStatement().executeUpdate("INSERT INTO alunos_cursos (id_aluno, id_curso) VALUES (1, 1)");
        conexao.createStatement().executeUpdate("INSERT INTO alunos_cursos (id_aluno, id_curso) VALUES (2, 2)");

        conexao.close();
    }
}
