package ma.fstt.model;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CommandeDAO extends BaseDAO<Commande> {
    public CommandeDAO() throws SQLException {
    }


    public void save(Commande object) throws SQLException {
        String request = "insert into commande (date_deb, date_fin,km,etat) values (?,?,?,?)";
        this.preparedStatement = this.connection.prepareStatement(request);
        this.preparedStatement.setDate(1, (Date) object.getDate_deb());
        this.preparedStatement.setDate(2, (Date) object.getDate_fin());
        this.preparedStatement.setFloat(3,object.getKm());
        this.preparedStatement.setString(4,object.getEtat());
        this.preparedStatement.execute();
    }


    public void update(Commande object) throws SQLException {
    }


    public void delete(Commande object) throws SQLException {
    }


    public List<Commande> getAll() throws SQLException {
        List<Commande> mylist = new ArrayList();
        String request = "select * from commande ";
        this.statement = this.connection.createStatement();
        this.resultSet = this.statement.executeQuery(request);


        while(this.resultSet.next()) {
            mylist.add(new Commande(this.resultSet.getLong(1), this.resultSet.getDate(2), this.resultSet.getDate(3), this.resultSet.getFloat(4),this.resultSet.getString(5)));
        }


        return mylist;
    }


    public Commande getOne(Long id) throws SQLException {
        return null;
    }
}
