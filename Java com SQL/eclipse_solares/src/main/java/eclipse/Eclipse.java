package eclipse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class Eclipse {
    private static final String host = "localhost";
    private static final String database = "exercicio";
    private static final String usuario = "root";
    private static final String senha = "";

    public static void main(String[] args) {
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" 
        + host + ":3306/" + database, usuario, senha)) {

            String data = "2023-11-07";
            String tipo = "Anular";

            String sql = "INSERT INTO eclipses_solares (data, tipo) VALUES (?, ?)";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, data);
            stmt.setString(2, tipo);

            int LinhasAfetadas = stmt.executeUpdate();

            if (LinhasAfetadas > 0) {
                System.out.println("Produto inserido com sucesso!");
            } else {
                System.out.println("Não foi possivel inserir o produto");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de Dados: " + 
            e.getMessage()) ; 
        }

    }
}
