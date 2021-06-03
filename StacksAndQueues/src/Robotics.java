import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokensRobots = scanner.nextLine().split(";");

        LinkedHashMap<String, Integer> robots = putRobots(tokensRobots);
        LinkedHashMap<String, Integer> robotsWorkingTime = workingTimeRobots(tokensRobots);

        String startTime = scanner.nextLine();

        int startTimeInSeconds = startTimeInSeconds(startTime);

        ArrayDeque<String> products = new ArrayDeque<>();
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            products.offer(command);
            command = scanner.nextLine();
        }

        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            startTimeInSeconds++;
            decreaseWorkingTime(robotsWorkingTime);
            boolean isTaken = false;

            for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
                if (robot.getValue() == 0) {
                    System.out.println(robot.getKey() + " - " + currentProduct + " " + "[" +getStartTime(startTimeInSeconds) + "]");
                    robotsWorkingTime.put(robot.getKey(), robots.get(robot.getKey()));
                    isTaken = true;
                    break;
                }
            }
            if (!isTaken){
                products.offer(currentProduct);
            }
        }
    }

    private static void decreaseWorkingTime(LinkedHashMap<String, Integer> robotsWorkingTime) {
        for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()){
            if(robot.getValue() > 0) {
                robotsWorkingTime.put(robot.getKey(), robot.getValue() - 1);
            }
        }
    }

    private static int startTimeInSeconds(String startTime) {
        String[] splitTime = startTime.split(":");

        int hours = Integer.parseInt(splitTime[0]);
        int minutes = Integer.parseInt(splitTime[1]);
        int seconds = Integer.parseInt(splitTime[2]);

        int startTimeSeconds = hours * 3600 + minutes * 60 + seconds;
        return startTimeSeconds;
    }

    private static LinkedHashMap<String, Integer> putRobots(String[] tokensRobots) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();

        for (String robot : tokensRobots) {
            String[] splitRobot = robot.split("-");
            String robotName = splitRobot[0];
            int robotTime = Integer.parseInt(splitRobot[1]);
            robots.put(robotName, robotTime);
        }
        return robots;
    }

    private static LinkedHashMap<String, Integer> workingTimeRobots(String[] tokensRobots) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();

        for (String robot : tokensRobots) {
            String[] splitRobot = robot.split("-");
            String robotName = splitRobot[0];
            robots.put(robotName, 0);
        }
        return robots;
    }

    private static String getStartTime(int startTimeInSeconds) {
        int hours = (startTimeInSeconds / 3600) % 24;
        int minutes = startTimeInSeconds % 3600 / 60;
        int seconds = startTimeInSeconds % 60;
        return String.format("%02d:%02d:%02d",hours, minutes, seconds);
    }
}
