package Healthproject_Jdbc.Workout;

public class WorkoutVO {
    private int workoutId;
    private int workoutType;
    private int workoutTime;
    private int burnedCal;
    private int gymPrice;

    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    public int getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(int workoutType) {
        this.workoutType = workoutType;
    }

    public int getWorkoutTime() {
        return workoutTime;
    }

    public void setWorkoutTime(int workoutTime) {
        this.workoutTime = workoutTime;
    }

    public int getBurnedCal() {
        return burnedCal;
    }

    public void setBurnedCal(int burnedCal) {
        this.burnedCal = burnedCal;
    }

    public int getGymPrice() {
        return gymPrice;
    }

    public void setGymPrice(int gymPrice) {
        this.gymPrice = gymPrice;
    }

    public WorkoutVO(int workoutId, int workoutType, int workoutTime, int burnedCal, int gymPrice) {
        this.workoutId = workoutId;
        this.workoutType = workoutType;
        this.workoutTime = workoutTime;
        this.burnedCal = burnedCal;
        this.gymPrice = gymPrice;
    }
}

