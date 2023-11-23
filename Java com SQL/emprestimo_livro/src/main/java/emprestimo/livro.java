package emprestimo;

import java.sql.*;
import java.util.Scanner;

public class livro {

   public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Biblioteca", "root", "");

            Statement statement = connection.createStatement();

            // Criação das tabelas
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Cliente (id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(50), email VARCHAR(50), sexo VARCHAR(10))");

            //crie as tabelas livros e emprestimos.
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Livro (id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(50), status VARCHAR(20))");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Emprestimo (id INT AUTO_INCREMENT PRIMARY KEY, id_cliente INT, id_livro INT, data_emprestimo DATE, data_devolucao DATE, FOREIGN KEY (id_cliente) REFERENCES Cliente(id), FOREIGN KEY (id_livro) REFERENCES Livro(id))");

            // Trigger Atualização do Status do Livro para "emprestado" ao fazer um empréstimo
            statement.executeUpdate("CREATE TRIGGER atualizaStatusEmprestimo AFTER INSERT ON Emprestimo FOR EACH ROW " +
                    "BEGIN " +
                    "UPDATE Livro SET status = 'Emprestado' WHERE id = NEW.id_livro; " +
                    "END");

            // crie o Trigger Atualização do Status do Livro para "disponível" ao devolver um livro
            statement.executeUpdate("CREATE TRIGGER atualizaStatusDevolucao AFTER DELETE ON Emprestimo FOR EACH ROW " +
                    "BEGIN " +
                    "UPDATE Livro SET status = 'Disponível' WHERE id = OLD.id_livro; " +
                     "END");

            Scanner scanner = new Scanner(System.in);

            // Inserção de dados para a tabela Cliente
            System.out.println("\nInserir novo cliente:");
            System.out.print("Nome do cliente: ");
            String nomeCliente = scanner.nextLine();
            System.out.print("Email do cliente: ");
            String emailCliente = scanner.nextLine();
            System.out.print("Sexo do cliente: ");
            String sexoCliente = scanner.nextLine();

            String inserirClienteQuery = "INSERT INTO Cliente (nome, email, sexo) VALUES (?, ?, ?)";
            PreparedStatement inserirCliente = connection.prepareStatement(inserirClienteQuery);
            inserirCliente.setString(1, nomeCliente);
            inserirCliente.setString(2, emailCliente);
            inserirCliente.setString(3, sexoCliente);
            inserirCliente.executeUpdate();

            // Inserção de dados para a tabela Livro e Empréstimo
            // Inserção de dados para a tabela Livro
            System.out.println("\nInserir novo livro:");
            System.out.print("Nome do livro: ");
            String nomeLivro = scanner.nextLine();

            String inserirLivroQuery = "INSERT INTO Livro (nome, status) VALUES (?, ?)";
            PreparedStatement inserirLivro = connection.prepareStatement(inserirLivroQuery);
            inserirLivro.setString(1, nomeLivro);
            inserirLivro.setString(2, "Disponível"); // Status inicial: Disponível
            inserirLivro.executeUpdate();

            // Inserção de dados para a tabela Empréstimo
            // Aqui você pode pedir informações como ID do cliente, ID do livro, datas, etc., e inserir na tabela Empréstimo.
            // Utilize PreparedStatements semelhantes ao utilizado para a tabela Cliente.

            // Consulta de Livros
            ResultSet resultSetLivros = statement.executeQuery("SELECT * FROM Livro");
            while (resultSetLivros.next()) {
                System.out.println("Livro ID: " + resultSetLivros.getInt("id") + ", Nome: " + resultSetLivros.getString("nome") + ", Status: " + resultSetLivros.getString("status"));
            }

            resultSetLivros.close();
            inserirCliente.close();
            statement.close();
            connection.close();

            System.out.println("Operações concluídas com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
   }
}