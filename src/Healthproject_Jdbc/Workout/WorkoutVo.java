package Healthproject_Jdbc.Workout;

public class WorkoutVo {
    private int workoutId;
    private int workoutType;
    private int burnedCal;
    private int workoutTime;
    private int gymPrice;

    public WorkoutVo(int workoutId, int workoutType, int burnedCal, int workoutTime, int gymPrice) {
        this.workoutId = workoutId;
        this.workoutType = workoutType;
        this.burnedCal = burnedCal;
        this.workoutTime = workoutTime;
        this.gymPrice = gymPrice;
    }

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

    public int getBurnedCal() {
        return burnedCal;
    }

    public void setBurnedCal(int burnedCal) {
        this.burnedCal = burnedCal;
    }

    public int getWorkoutTime() {
        return workoutTime;
    }

    public void setWorkoutTime(int workoutTime) {
        this.workoutTime = workoutTime;
    }

    public int getGymPrice() {
        return gymPrice;
    }

    public void setGymPrice(int gymPrice) {
        this.gymPrice = gymPrice;
    }
}

