// Neylor
package gestao_resultado;

import java.sql.*;

public class  gestão_resultados{

    private static final String URL = "jdbc:mysql://localhost:3306/gestão_resultados";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static void main(String[] args) throws SQLException {
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

        conexao.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS resultado_exames (id_resultado INT AUTO_INCREMENT PRIMARY KEY, tipo_exame VARCHAR(255), resultado VARCHAR(255))");

        conexao.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS pacientes (id_paciente INT AUTO_INCREMENT PRIMARY KEY, nome_paciente VARCHAR(255), data_nascimento DATETIME)");

        conexao.createStatement().executeUpdate("INSERT INTO resultado_exames (tipo_exame, resultado) VALUES ('Próstata', 'Positivo')");
        conexao.createStatement().executeUpdate("INSERT INTO resultado_exames (tipo_exame, resultado) VALUES ('Colonoscopía', 'Negativo')");
        
        conexao.createStatement().executeUpdate("INSERT INTO pacientes (nome_paciente, data_nascimento) VALUES ('Medina', '2006-12-04')");
        conexao.createStatement().executeUpdate("INSERT INTO pacientes (nome_paciente, data_nascimento) VALUES ('Neylor', '2005-08-24')");

        conexao.close();
    }
}
