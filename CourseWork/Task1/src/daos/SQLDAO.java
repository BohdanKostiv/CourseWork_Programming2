package daos;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.RunningComp;

public class SQLDAO extends DAO {
    private static final String userName = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/RunningComps";
    private static Connection connection = null;

    public SQLDAO() {
        connect();
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected to database.");
        } catch (SQLException ex) {System.out.println(ex.getMessage());}
    }

    @Override
    public void addRunningComp(RunningComp runningComp) {
        String queryString = "CALL ADDRUNNINGCOMP('";
            queryString += runningComp.getSeason() + "', '";
            queryString += runningComp.getCompetition() + "', '";
            queryString += runningComp.getVenue() + "', ";
            queryString += runningComp.getRank() + ")";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(queryString);
            System.out.println("Running Competition added successfully.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addRunner(RunningComp.Runner runner) {
        String queryString = "CALL ADDRUNNER('";
        queryString += runner.getRunnerName() + "', ";
        queryString += runner.getRunningCompId() + ", '";
        queryString += runner.getGender() + "')";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(queryString);
            System.out.println("Runner added successfully.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public RunningComp getRunningComp(int runningCompId) {
        return null;
    }

    public List<RunningComp> getRunningComps() {
        List<RunningComp> runningComps = new ArrayList<>();
        String query = "CALL GETRUNNERCOMPS";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("runningCompId");
                String season = resultSet.getString("season");
                String competition = resultSet.getString("competition");
                String venue = resultSet.getString("venue");
                int rank = resultSet.getInt("rank");

                RunningComp runningComp = new RunningComp(id, season, competition, venue, rank);
                runningComps.add(runningComp);
            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());}

        return runningComps;
    }

    public List<RunningComp.Runner> getRunningCompRunners(int runningCompId) {
        List<RunningComp.Runner> runners = new ArrayList<>();
        String query = "CALL GETRUNNINGCOMPRUNNERS";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, runningCompId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int runnerNumber = resultSet.getInt("runnerNumber");
                String runnerName = resultSet.getString("runnerName");
                String gender = resultSet.getString("gender");

                RunningComp.Runner runner = new RunningComp.Runner(runnerNumber, runnerName, runningCompId, gender);
                runners.add(runner);
            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());}

        return runners;
    }
}

