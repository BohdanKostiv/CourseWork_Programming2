package controllers;

import helpers.InputHelper;
import model.RunningComp;
import repositories.Repository;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Controller {
    private Repository repository;

    public Controller() {
        repository = new Repository();
    }

    public void run() {
        boolean finished = false;
        InputHelper inputHelper = new InputHelper();

        do {
            System.out.println("\n1. Add Running Competition");
            System.out.println("\n2. Add Runner");
            System.out.println("\n3. List Running Competitions");
            System.out.println("\n4. Find Running Competition");
            System.out.println("\n5. Export Runners to CSV");
            System.out.println("\n6. Quit\n");
            int choice = inputHelper.readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    addRunningComp();
                    break;
                case 2:
                    addRunner();
                    break;
                case 3:
                    listRunningComps();
                    break;
                case 4:
                    findRunningComp();
                    break;
                case 5:
                    exportRunnersToCSV();
                    break;
                case 6:
                    finished = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        } while (!finished);
    }

    private void listRunningComps() {
        System.out.println("List Running Competitions");
        System.out.println("=========================");
        List<RunningComp> runningComps = repository.getRunningComps();
        if (runningComps.isEmpty()) {
            System.out.println("Running Competitions Not Found.");
        } else {
            for (RunningComp runningComp : runningComps) {
                System.out.println(runningComp);
            }
        }
    }

    private void addRunningComp() {
        System.out.println("Add Running Competition");
        System.out.println("=======================");
        InputHelper inputHelper = new InputHelper();
        int competitionId = inputHelper.readInt("Enter competition ID: ");
        String season = inputHelper.readString("Enter season: ");
        String competition = inputHelper.readString("Enter competition: ");
        String venue = inputHelper.readString("Enter venue: ");
        int rank = inputHelper.readInt("Enter rank: ");
        RunningComp runningComp = new RunningComp(competitionId, season, competition, venue, rank);
        repository.addRunningComp(runningComp);
    }

    private void addRunner() {
        System.out.println("Add Runner");
        System.out.println("==========");
        InputHelper inputHelper = new InputHelper();
        int runnerNumber = inputHelper.readInt("Enter runner number: ");
        String runnerName = inputHelper.readString("Enter runner's name: ");
        int runningCompId = inputHelper.readInt("Enter running competition ID: ");
        String gender = inputHelper.readString("Enter gender: ");
        RunningComp.Runner runner = new RunningComp.Runner(runnerNumber, runnerName, runningCompId, gender);
        repository.addRunner(runner);
    }

    private void findRunningComp() {
        InputHelper inputHelper = new InputHelper();
        RunningComp requiredRunningComp;
        int runningCompId;
        do {
            runningCompId = inputHelper.readInt("Enter Running Competition Id (0 to Quit)");
            if (runningCompId != 0) {
                requiredRunningComp = repository.getRunningCompId(runningCompId);
                if (requiredRunningComp != null)
                    return;
                else
                    System.out.println("Running Competition Not Found");
            }
        } while (runningCompId != 0);
    }

    private void exportRunnersToCSV() {
        System.out.println("Exporting Runners to CSV");
        System.out.println("========================");
        InputHelper inputHelper = new InputHelper();
        List<RunningComp> runningComps = repository.getRunningComps();
        System.out.println("Select a competition to export runners:");
        for (int i = 0; i < runningComps.size(); i++) {
            System.out.println((i + 1) + ". " + runningComps.get(i).getCompetition());
        }
        int choice = inputHelper.readInt("Enter the index of the competition: ", 5, runningComps.size());
        RunningComp selectedComp = runningComps.get(choice);
        String filename = selectedComp.getCompetition() + "_Runners.csv";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Runner Number,Runner Name,Gender\n");
            for (RunningComp.Runner runner : selectedComp.getRunners()) {
                writer.write(runner.getRunnerNumber() + "," + runner.getRunnerName() + "," + runner.getGender() + "\n");
            }
            System.out.println("Runners exported to " + filename);
        } catch (IOException e) {
            System.out.println("Error exporting runners to CSV: " + e.getMessage());
        }
    }

}
