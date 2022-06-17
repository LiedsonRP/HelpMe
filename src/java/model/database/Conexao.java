package model.database;
//Classes necessárias para uso de Banco de dados //

import java.sql.*;

//Início da classe de conexão//
public class Conexao {

    public static String status = "Não conectou...";

//Método Construtor da Classe//
//Método de Conexão//
    private Connection connection;
    private Statement statement;

    public Conexao() {
        try {            
            connection = DriverManager.getConnection("jdbc:mysql://localhost" + "/helpmedb", "root", "1234");
            System.out.println("conectou!");                    
        } catch (SQLException ex) {
            System.out.println("Nao foi poss´ıvel conectar ao servidor" + ex);
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println("Nao foi possıvel criar a statement" + ex);
        }
    }

    /**
     * * Executa um update na base de dados * @param update String SQL a ser
     * executado * @throws SQLException se n~ao for poss´ıvel executar
     *
     * o update (Erro de SQL).
     */
    public synchronized void executeUpdate(String update) throws SQLException {
        try {
            statement.executeUpdate(update);
        } catch (SQLException ex) {
            System.out.println("Nao foi possıvel executar o update" + ex);
            throw ex;
        }
    }

    /**
     * * Executa uma consulta na base de dados * @param query String SQL a ser
     * executado * @return Um objeto do tipo ResultSet contendo o * resultado da
     * query * @throws SQLException se n~ao for poss´ıvel executar a query *
     * (Erro de SQL).
     */
    public synchronized ResultSet executeQuery(String query) throws SQLException {
        try {
            return statement.executeQuery(query);
        } catch (SQLException ex) {

            System.out.println("Nao foi possıvel executar a query" + ex);
            return null;
            // throw ex; 

        }
    }

    /**
     * * Fecha a conexao com a base de dados.
     */
    public void fecharConexao() {
        try {
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * * Retorna o maior n´umero de um campo da tabela se ele * for um inteiro.
     * Assim, n~ao teremos nenhum ID igual a outro.
     */
    public int retornaIDMax(String tabela) {
        try {
            String sql = "SELECT max(ID) as contador FROM " + tabela;
            ResultSet rs = this.executeQuery(sql);
            rs.next();
            return rs.getInt("contador") + 1;
        } catch (SQLException e) {
            System.out.println("Erro na selecao do ID Maximo" + e);
            e.printStackTrace();

            return 0;
        }
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        Conexao.status = status;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    
    
}