package produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Estoque {
    private static final String host = "localhost";
    private static final String database = "exercicio";
    private static final String usuario = "root";
    private static final String senha = "";

    public static void main(String[] args) {
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" 
        + host + ":3306/" + database, usuario, senha)) {

            String nome = "Sneaker Plataforma";
            int quantidade = 64;
            double valor = 44.99;
            String data = "2023-11-15";

            String sql = "INSERT INTO estoque (nome, quantidade, valor, data_compra) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setInt(2, quantidade);
            stmt.setDouble(3, valor);
            stmt.setString(4, data);



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
