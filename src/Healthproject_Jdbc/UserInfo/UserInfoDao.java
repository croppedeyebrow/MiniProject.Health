package Healthproject_Jdbc.UserInfo;

import Healthproject_Jdbc.common.Common;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UserInfoDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // 회원 정보 조회.(Read)
    public UserInfoVO getUserInfo(String user_id) {
        UserInfoVO userInfo = null;
        try {
            conn = Common.getConnection();
            String sql = "SELECT * FROM USER_INFO WHERE USER_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(user_id));
            rs = pstmt.executeQuery();

            if (rs.next()) { // 회원 한명분만 조회해 오니가 if문 사용.
                userInfo = new UserInfoVO();
                userInfo.setUser_id(rs.getString("USER_ID"));
                userInfo.setUser_pw(rs.getString("USER_PW"));
                userInfo.setUser_name(rs.getString("USER_NAME"));
                userInfo.setUser_birth(rs.getInt("USER_BIRTH"));
                userInfo.setUser_height(rs.getDouble("USER_HEIGHT"));
                userInfo.setUser_weight(rs.getDouble("USER_WEIGHT"));
                userInfo.setUser_goal_weight(rs.getDouble("USER_GOAL_WEIGHT"));
                userInfo.setUser_created_on(rs.getTimestamp("USER_CREATED_ON"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Common.close(rs);
        Common.close(pstmt);
        Common.close(conn);

        return userInfo;
    }

    //회원 정보 수정(update)
    public boolean updateUser(UserInfoVO userInfo) throws SQLException {
        try {
            conn = Common.getConnection();
            String sql = "WHERE USER_ID = ?, UPDATE USER_INFO SET USER_PW = ?, USER_NAME = ?, USER_BIRTH = ?, USER_HEIGHT = ?, " +
                    "USER_WEIGHT = ?, USER_GOAL_WEIGHT = ? USER_CREATED_ON = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userInfo.getUser_id());
            pstmt.setString(2, userInfo.getUser_pw());
            pstmt.setString(3, userInfo.getUser_name());
            pstmt.setInt(4, userInfo.getUser_birth());
            pstmt.setDouble(5, userInfo.getUser_height());
            pstmt.setDouble(6, userInfo.getUser_weight());
            pstmt.setDouble(7, userInfo.getUser_goal_weight());
            pstmt.setObject(8, userInfo.getUser_created_on());

            //데이터베이스에서 기존 레코드를 수정할 때, UPDATE 쿼리가 성공하면 rowsAffected는 수정된 행의 수
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;





        }
    }


    // 회원 탈퇴 (delete)
    public boolean Deleteuser (String user_id){
        try {
            conn = Common.getConnection();
            String sql = "DELETE FROM USER_INFO WHERE USER_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user_id);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Common.close(pstmt);
            Common.close(conn);
        }
    }
}
























