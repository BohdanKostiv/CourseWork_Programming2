package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Models RunningComp entities
 *
 * @author Martin Gallacher
 * @author Bobby Law
 */
public class RunningComp {
    private int id;
    private String season;
    private String competition;
    private String venue;
    private int rank;
    private List<Runner> runners;

    /**
     * The default RunningComp constructor
     */
    public RunningComp() {
        this.id = 0;
        this.season = null;
        this.competition = null;
        this.venue = null;
        this.rank = 0;
        this.runners = new ArrayList<>();
    }

    /**
     * A constructor which accepts season, competition and venue values
     */
    public RunningComp(String season, String competition, String venue) {
        this.id = 0;
        this.season = season;
        this.competition = competition;
        this.venue = venue;
        this.rank = 0;
        this.runners = new ArrayList<>();
    }

    /**
     * A constructor which accepts id, season, competition, venue, and rank values
     */
    public RunningComp(int id, String season, String competition, String venue, int rank) {
        this.id = id;
        this.season = season;
        this.competition = competition;
        this.venue = venue;
        this.rank = rank;
        this.runners = new ArrayList<>();
    }

    /**
     * Models Runner entities
     *
     * @author Martin Gallacher
     * @author Bobby Law
     */
    public static class Runner {

        private final int runnerNumber;
        private String runnerName;
        private int runningCompId;
        private String gender;

        /**
         * A constructor which accepts runner number, name, running competition id, and gender values
         */
        public Runner(int runnerNumber, String runnerName, int runningCompId, String gender) {
            this.runnerNumber = runnerNumber;
            this.runnerName = runnerName;
            this.runningCompId = runningCompId;
            this.gender = gender;
        }

        /**
         * A getter for runner number values
         */
        public int getRunnerNumber() {
            return runnerNumber;
        }

        /**
         * A getter for name values
         */
        public String getRunnerName() {
            return runnerName;
        }

        /**
         * A setter method for name values
         */
        public void setRunnerName(String runnerName) {
            this.runnerName = runnerName;
        }

        /**
         * A getter for Running Comp id values
         */
        public int getRunningCompId() {
            return runningCompId;
        }

        /**
         * A setter method for Running Comp id values
         */
        public void setRunningCompId(int runningCompId) {
            this.runningCompId = runningCompId;
        }

        /**
         * A getter for Runner Gender values
         */
        public String getGender() {
            return gender;
        }

        /**
         * A setter method for runner gender values
         */
        public void setGender(String gender) {
            this.gender = gender;
        }

        /**
         * Constructs and returns a String representing the state of the object
         */
        @Override
        public String toString() {
            return "Runner{" +
                    "runnerNumber=" + runnerNumber +
                    ", runnerName='" + runnerName + '\'' +
                    ", runningCompId=" + runningCompId +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }

    /**
     * A getter for id values
     */
    public int getId() {
        return id;
    }

    /**
     * A setter method for id values
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * A getter for season values
     */
    public String getSeason() {
        return season;
    }

    /**
     * A setter method for season values
     */
    public void setSeason(String season) {
        this.season = season;
    }

    /**
     * A getter for competition values
     */
    public String getCompetition() {
        return competition;
    }

    /**
     * A setter method for competition values
     */
    public void setCompetition(String competition) {
        this.competition = competition;
    }

    /**
     * A getter for venue values
     */
    public String getVenue() {
        return venue;
    }

    /**
     * A setter method for venue values
     */
    public void setVenue(String venue) {
        this.venue = venue;
    }

    /**
     * A getter for rank values
     */
    public int getRank() {
        return rank;
    }

    /**
     * A setter method for rank values
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * A getter for runners values
     */
    public List<Runner> getRunners() {
        return runners;
    }

    /**
     * A setter method for runners values
     */
    public void setRunners(List<Runner> runners) {
        this.runners = runners;
    }

    /**
     * Adds a supplied Runner object to the runners attribute
     */
    public void addRunnerToComp(Runner runner) {
        this.runners.add(runner);
    }

    /**
     * Constructs and returns a String representing the state of the object
     */
    @Override
    public String toString() {
        return "RunningComp{" +
                "id=" + id +
                ", season='" + season + '\'' +
                ", competition='" + competition + '\'' +
                ", venue='" + venue + '\'' +
                ", rank=" + rank +
                ", runners=" + runners +
                '}';
    }
}
