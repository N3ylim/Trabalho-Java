package numeros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class Numero_aleatorio {
    private static final String host = "localhost";
    private static final String database = "exercicio";
    private static final String usuario = "root";
    private static final String senha = "";

    public static void main(String[] args) {
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" 
        + host + ":3306/" + database, usuario, senha)) {

            double aleatorio = Math.random() * 1000;

            String sql = "INSERT INTO numeros_aleatorios (numero) VALUES (?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, aleatorio);

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
