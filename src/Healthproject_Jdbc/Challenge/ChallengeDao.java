package Healthproject_Jdbc.Challenge;


import Healthproject_Jdbc.Food.FoodDao;
import Healthproject_Jdbc.Workout.WorkoutDAO;
import Healthproject_Jdbc.common.Common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChallengeDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private WorkoutDAO workoutDao;
    private FoodDao foodDao;

    public ChallengeDao(Connection conn, WorkoutDAO workoutDao, FoodDao foodDao) {
        this.conn =conn;
        this.workoutDao = workoutDao;
        this.foodDao = foodDao;

    }

    public static boolean UpdateTotalScore(int rankTbId, int breakfast, int lunch, int dinner, int i) {
        return false;
    }


    // 순위 데이터 추가
    public boolean AddChallenge(ChallengeVo challengeVo) {
        try{
            String sql = "INSERT INTO RANK_TB(TOTAL_SCORE, AVG_sCORE, RANK) VALUES(?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, challengeVo.getTOTAL_SCORE()); // Assume getTotal_score() returns an int
            pstmt.setInt(2, challengeVo.getAVG_SCORE());   // Assume getAvg_score() returns an int
            pstmt.setInt(3, challengeVo.getRank());        // Assume getRank() returns an int

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //순위 반영 값 받아오기

    //누적 점수 조회
    public int getAccumulatedScore(int RANKTbId ) {
        try {
            String sql = "SELECT TOTAL_SCORE FROM RANK_TB WHERE RANK_TB_ID";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, RANKTbId);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                return rs.getInt("TOTAL_SCORE");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }

    //평균 점수 조회
    public int getAverageScore(int RANKTbId) {
        try {
            String sql = "SELECT AVG_SCORE FROM RANK_TB WHERE RANK_TB_ID ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, RANKTbId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("AVG_SCORE");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //순위 조회

    public  int getRank(int RANKTbId ) {
        try {
            String sql = "SELECT RANK FROM RAMK_TB WHERE RANK_TB_ID";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,RANKTbId);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                return rs.getInt("RANK");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }







    // 데이터 조회.
    public List<ChallengeVo>getAllChallenges() {
        List<ChallengeVo> challengeVoList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM PM1234.RANK_TB";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                int RANKTbId = rs.getInt("RANK_TB_ID");
                int TotalScore = rs.getInt("TOTAL_SCORE");
                int AvgScore = rs.getInt("AVG_SCORE");
                int Rank = rs.getInt("RANK");

                ChallengeVo challengeVo = new ChallengeVo(RANKTbId, TotalScore, AvgScore,Rank);
                challengeVoList.add(challengeVo);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
            return  challengeVoList;
    }


    // 데이터 수정
    public boolean Updatechallenge (ChallengeVo challengeVo) {
        try {
            String sql = "UPDATE PM1234.RANK_TB SET TOTAL_SORE =?, AVG_SCORE =?, RANK =? WHERE RANK_TB_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, challengeVo.getTOTAL_SCORE());
            pstmt.setInt(2, challengeVo.getAVG_SCORE());
            pstmt.setInt(3, challengeVo.getRank());
            pstmt.setInt(4, challengeVo.getRANK_TB_ID());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated >0;

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 식단 점수 추가
    public boolean UpdateTotalScore(int RANKTbId, int breakfast, int lunch, int dinner) {
        int additionalScore = 0;


          if(breakfast ==1 && lunch ==1 && dinner ==1) {
              additionalScore += 5;
          }
          try {
                String sql = "UPDATE RANK_TB SET TOTAL_SCORE = TOTAL_SCORE + ? WHERE RANK_TB_ID = ? ";
              pstmt = conn.prepareStatement(sql);
              pstmt.setInt(1, additionalScore);
              pstmt.setInt(2, RANKTbId);

              int rowsUpdated = pstmt.executeUpdate();
              return rowsUpdated > 0;

          } catch (SQLException e) {
              e.printStackTrace();
              return false;
          }

    }





    //데이터 삭제

    public boolean DeleteChallenge(int RANKTbId ){
        try {
            String sql = "DELETE FROM PM1234.RANK_TB WHERE RANK_TB_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,RANKTbId);

            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void close() {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}








