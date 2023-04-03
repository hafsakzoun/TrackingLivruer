package ma.fstt.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProduitDAO extends BaseDAO<Produit> {
    public ProduitDAO() throws SQLException {
    }


    public void save(Produit object) throws SQLException {
        String request = "insert into Produit (lib , prix_uni, desc) values (? , ?, ?)";
        this.preparedStatement = this.connection.prepareStatement(request);
        this.preparedStatement.setString(1, object.getLib());
        this.preparedStatement.setFloat(2, object.getprix_uni());
        this.preparedStatement.setString(3, object.getDesc());
        this.preparedStatement.execute();
    }


    public void update(Produit object) throws SQLException {
    }


    public void delete(Produit object) throws SQLException {
    }


    public List<Produit> getAll() throws SQLException {
        List<Produit> mylist = new ArrayList();
        String request = "select * from Produit ";
        this.statement = this.connection.createStatement();
        this.resultSet = this.statement.executeQuery(request);


        while(this.resultSet.next()) {
            mylist.add(new Produit(this.resultSet.getLong(1), this.resultSet.getString(2), this.resultSet.getFloat(3), this.resultSet.getString(4)));
        }


        return mylist;
    }


    public Produit getOne(Long id) throws SQLException {
        return null;
    }
}
