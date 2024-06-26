package seedu.duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Record {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private LocalDateTime dateTime;

    private double speed;

    private double accuracy;

    private final ArrayList<Problem> probSet = new ArrayList<>();

    private int psIndex;
    private String problemSetType;

    public Record(LocalDateTime dateTime,
                  double speed,
                  double accuracy,
                  ArrayList<Problem> probSet,
                  String problemSetType) {
        setSpeed(speed);
        setAccuracy(accuracy);
        setDateTime(dateTime);
        setProbSet(probSet);
        setProblemSetType(problemSetType);
        psIndex = probSet.hashCode();

    }

    public Record(LocalDateTime dateTime,
                  double speed,
                  double accuracy,
                  ArrayList<Problem> probSet,
                  int psIndex,
                  String problemSetType) {
        setSpeed(speed);
        setAccuracy(accuracy);
        setDateTime(dateTime);
        setProbSet(probSet);
        setPsIndex(psIndex);
        setProblemSetType(problemSetType);
    }


    public void print(boolean showProbDetails) {
        if (getSpeed() <= 0.0) {
            System.out.println("--User DIY Problem Set--");
            System.out.println("ProblemSet ID: " + getPsIndex());
            if (showProbDetails) {
                for (Problem problem : probSet) {
                    System.out.println("    " + problem.getDescription());
                }
            }
        } else {
            System.out.println("--User Attempt Record--");
            System.out.println("Date Time: " + getDateTime().format(formatter));
            System.out.println("ProblemSet ID: " + getPsIndex());
            if (showProbDetails) {
                for (Problem problem : probSet) {
                    System.out.println("    " + problem.getDescription());
                }
            }
            System.out.println("Speed: " + getSpeed() + " problems per minute");
            System.out.println("Accuracy: " + getAccuracy() * 100 + "%");
            System.out.println("Problem Set type: " + getProblemSetType());
        }
    }

    public String writeLine() {
        StringBuilder probStr = new StringBuilder();
        for (Problem problem : probSet) {
            probStr.append(problem.getDescription()).append(",").append(problem.getAnswer());
            probStr.append(" ");
        }

        return getDateTime().format(formatter) + " " + getSpeed() + " " +
                getAccuracy() + " " + getPsIndex() + " " + getProblemSetType() + " " + probStr;
    }

    public int getPsIndex() {
        return psIndex;
    }

    public void setPsIndex(int psIndex) {
        this.psIndex = psIndex;
    }

    public ArrayList<Problem> getProbSet() {
        return probSet;
    }

    public void setProbSet(ArrayList<Problem> probSet) {
        this.probSet.addAll(probSet);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setProblemSetType(String problemSetType) {
        this.problemSetType = problemSetType;
    }

    public String getProblemSetType() {
        return problemSetType;
    }

}
