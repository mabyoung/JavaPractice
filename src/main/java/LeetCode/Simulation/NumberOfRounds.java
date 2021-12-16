package LeetCode.Simulation;

public class NumberOfRounds {
    public int numberOfRounds(String startTime, String finishTime) {
        String[] startTimeSplit = startTime.split(":");
        String[] finishTimeSplit = finishTime.split(":");
        int startTimeHour = Integer.parseInt(startTimeSplit[0]);
        int startTimeMinute = Integer.parseInt(startTimeSplit[1]);
        int finishTimeHour = Integer.parseInt(finishTimeSplit[0]);
        int finishTimeMinute = Integer.parseInt(finishTimeSplit[1]);
        if (finishTimeHour < startTimeHour || (finishTimeHour == startTimeHour && finishTimeMinute < startTimeMinute)) {
            finishTimeHour += 24;
        }
        if (startTimeMinute > 0 && startTimeMinute < 15) {
            startTimeMinute = 15;
        }
        if (startTimeMinute > 15 && startTimeMinute < 30) {
            startTimeMinute = 30;
        }
        if (startTimeMinute > 30 && startTimeMinute < 45) {
            startTimeMinute = 45;
        }
        if (startTimeMinute > 45 && startTimeMinute <= 59) {
            startTimeHour++;
            startTimeMinute = 0;
        }
        if (finishTimeMinute > 0 && finishTimeMinute < 15) {
            finishTimeMinute = 0;
        }
        if (finishTimeMinute > 15 && finishTimeMinute < 30) {
            finishTimeMinute = 15;
        }
        if (finishTimeMinute > 30 && finishTimeMinute < 45) {
            finishTimeMinute = 30;
        }
        if (finishTimeMinute > 45 && finishTimeMinute <= 59) {
            finishTimeMinute = 45;
        }

        return (finishTimeHour - startTimeHour) * 4 + (finishTimeMinute - startTimeMinute) / 15;
    }
}
