package Healthproject_Jdbc.Workout;


import Healthproject_Jdbc.common.Common;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class WorkoutDao {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public List<WorkoutVo> WorkoutSelect() {
        List<WorkoutVo> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM WORK_OUT";
            rs = stmt.executeQuery(sql); // executeQuery SELECT 문에서 사용

            while (rs.next()) { // 결과에서 읽은 내용이 있으면 True
                int WorkoutId = rs.getInt("WorkoutId");
                int WorkoutType = rs.getInt("WorkoutType");
                int BurnedCal = rs.getInt("BurnedCal");
                int WorkoutTime = rs.getInt("WorkoutTime");
                int GymPrice = rs.getInt("GymPrice");
                list.add(new WorkoutVo(WorkoutId, WorkoutType, BurnedCal, WorkoutTime, GymPrice));
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 운동 정보 삽입 (Create)
    public void insertWorkout(WorkoutVo workout) {
        String sql = "INSERT INTO WORK_OUT (WORK_OUT_ID, WORK_OUT_TYPE, BURNED_CAL, WORK_OUT_TIME, GYM_PRICE) VALUES (?, ?, ?, ?, ?)";
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, workout.getWorkoutId());
            pstmt.setInt(2, workout.getWorkoutType());
            pstmt.setInt(3, workout.getBurnedCal());
            pstmt.setInt(4, workout.getWorkoutTime());
            pstmt.setInt(5, workout.getGymPrice());
            int result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }
}
