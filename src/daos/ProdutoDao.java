package daos;

import entities.Categoria;
import entities.Produto;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url = "";
    private String user = "";
    private String pass = "";

    public List<Produto> findByCategoria(Categoria categoria) throws DaoException {
        List<Produto> produtos = new ArrayList<Produto>();

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "select * from Produto order by nomeProduto";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("idProduto");
                String nome = rs.getString("nomeProduto");
                BigDecimal preco = rs.getBigDecimal("precProduto");
                Produto produto = new Produto(id, nome, preco, categoria);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }

        return produtos;
    }

}
