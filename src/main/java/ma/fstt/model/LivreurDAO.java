//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


package ma.fstt.model;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LivreurDAO extends BaseDAO<Livreur> {
    public LivreurDAO() throws SQLException {
    }


    public void save(Livreur object) throws SQLException {
        String request = "insert into livreur (nom , telephone, vehicule) values (? , ?, ?)";
        this.preparedStatement = this.connection.prepareStatement(request);
        this.preparedStatement.setString(1, object.getNom());
        this.preparedStatement.setString(2, object.getTelephone());
        this.preparedStatement.setString(3, object.getVehicule());
        this.preparedStatement.execute();
    }


    public void update(Livreur object) throws SQLException {
    }


    public void delete(Livreur object) throws SQLException {
    }


    public List<Livreur> getAll() throws SQLException {
        List<Livreur> mylist = new ArrayList();
        String request = "select * from livreur ";
        this.statement = this.connection.createStatement();
        this.resultSet = this.statement.executeQuery(request);


        while(this.resultSet.next()) {
            mylist.add(new Livreur(this.resultSet.getLong(1), this.resultSet.getString(2), this.resultSet.getString(3), this.resultSet.getString(4)));
        }


        return mylist;
    }


    public Livreur getOne(Long id) throws SQLException {
        return null;
    }
}
