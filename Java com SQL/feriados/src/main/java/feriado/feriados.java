package feriado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class feriados {
    private static final String host = "localhost";
    private static final String database = "exercicio";
    private static final String usuario = "root";
    private static final String senha = "";

    public static void main(String[] args) {
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" 
        + host + ":3306/" + database, usuario, senha)) {

            String data = "2023-12-25";
            String descricao = "Natal";

            String sql = "INSERT INTO feriados_nacionais (data, descricao) VALUES (?, ?)";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, data);
            stmt.setString(2, descricao);

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
