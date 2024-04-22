package daos;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.GCUTour;
import model.Destination;

/**
 * A SQL Data Access Object class
 * to implement methods to access/update
 * an SQL database.
 */
public class SQLDAO extends DAO {
    static private final String userName = "root";
    static private final String password = "";
    static private final String url = "jdbc:mysql://localhost:3306/gcutours";
    static private Connection connection = null;
        
    public SQLDAO() {
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected to database");            
        } catch (SQLException ex) { System.out.println(ex.getMessage());}
    }

    /**
     * A method to return the anniversaries list through
     * querying the database.
     * Note the query can be hard coded but better to use a
     * stored procedure held in the database.
     */
    @Override
    public List<GCUTour> getGCUTours() {
        List<GCUTour> GCUToursList = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            String queryString = "CALL GETGCUTOURS()";
            ResultSet rs = stmt.executeQuery(queryString);
            
            while (rs.next()) {
                int GCUTourId = rs.getInt("GCUTOURID");
                String tourDate = rs.getString("TOURDATE");
                String tourDuration = rs.getString("TOURDURATION");
                List<Destination> placesVisitedList = getGCUTourPlaces(GCUTourId);
                GCUTour GCUTour = new GCUTour(GCUTourId, tourDate, Integer.parseInt(tourDuration), placesVisitedList);
                GCUToursList.add(GCUTour);
            }            
        } catch (SQLException ex) { System.out.println(ex.getMessage());}
        return GCUToursList;
    }

    /**
     * A method to return the places visited list associated with
     * a specified anniversary through querying the database.
     * Note the query can be hard coded but better to use a
     * stored procedure held in the database.
     */
    private List<Destination> getGCUTourPlaces(int GCUTourId) throws SQLException {
        List<Destination> placesVisitedList = new ArrayList<>();
        String queryString = "CALL GETGCUTOURSPLACES(" + Integer.toString(GCUTourId) + ")";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(queryString);
        while (rs.next()) {
            String placeName = rs.getString("DESTINATIONNAME");
            String country = rs.getString("COUNTRY");
            Destination destination = new Destination(placeName, country, GCUTourId);
            placesVisitedList.add(destination);
        }
        return placesVisitedList;
    }

    /**
     * A method to return the specified anniversary through
     * querying the database.
     * Note the query can be hard coded but better to use a
     * stored procedure held in the database.
     */
    @Override
    public GCUTour getGCUTour(int GCUTourId) {
        try {
            Statement stmt = connection.createStatement();
            String queryString = "CALL GETGCUTOUR(" + Integer.toString(GCUTourId) + ")";
            ResultSet rs = stmt.executeQuery(queryString);
            
            if (rs.next()) {
                String tourDate = rs.getString("TOURDATE");
                String tourDuration = rs.getString("TOURDURATION");
                List<Destination> placesVisitedList = getGCUTourPlaces(GCUTourId);
                GCUTour GCUTour = new GCUTour(GCUTourId, tourDate, Integer.parseInt(tourDuration), placesVisitedList);
                return GCUTour;
            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());}
        return null;
    }

    /**
     * A method to add the supplied GCUTour to the database.
     * Note the query can be hard coded but better to use a
     * stored procedure held in the database.
     */
    @Override
    public void addGCUTour(GCUTour GCUTour) {
        try {
            Statement stmt = connection.createStatement();
            String queryString = "CALL ADDGCUTOUR('";
            queryString += GCUTour.getTourDate() + "', '";
            queryString += GCUTour.getTourDuration() + "')";
            stmt.executeUpdate(queryString);
        } catch (SQLException ex) { System.out.println(ex.getMessage());}
    }

    /**
     * A method to add the supplied destination visited to the database.
     * Note the query can be hard coded but better to use a
     * stored procedure held in the database.
     */
    @Override
    public void addPlace(Destination destination) {
        try {
            Statement stmt = connection.createStatement();
            String queryString = "CALL ADDPLACE('";
            queryString += destination.getPlaceName() + "', '";
            queryString += destination.getCountry() + "', ";
            queryString += destination.getGCUTourId() + ")";
            stmt.executeUpdate(queryString);
        } catch (SQLException ex) {System.out.println(ex.getMessage());}
	}
}	
