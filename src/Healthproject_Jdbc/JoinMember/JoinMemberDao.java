package Healthproject_Jdbc.JoinMember;


import Healthproject_Jdbc.Login.HealthLoginMain;
import Healthproject_Jdbc.common.Common;

import java.sql.*;


public class JoinMemberDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // 회원 가입 정보를 DB에 저장하는 메서드
//    public boolean insertMember(String userId, String password, String name, int birthYear, double height, double weight, double goalWeight, Timestamp created_on) {
//        try {
//            conn = Common.getConnection();
  public boolean insertMember(JoinMemberVo member) {
       try {
           conn = Common.getConnection();

            // 아이디 중복 확인
            String checkIdSql = "SELECT USER_ID FROM USER_INFO WHERE USER_ID = ?";
            pstmt = conn.prepareStatement(checkIdSql);
            pstmt.setString(1, member.getUser_id());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // 이미 해당 아이디가 존재하는 경우
                System.out.println("이미 존재하는 아이디입니다.");
                return false;
            }

            // 비밀번호 중복 확인
            String checkPasswordSql = "SELECT USER_PW FROM USER_INFO WHERE USER_PW = ?";
            pstmt = conn.prepareStatement(checkPasswordSql);
            pstmt.setString(1, member.getUser_pw());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // 이미 해당 비밀번호가 존재하는 경우
                System.out.println("이미 존재하는 비밀번호입니다.");
                return false;
            }

            // 중복이 없는 경우 회원 정보를 저장
            String insertSql = "INSERT INTO USERS (USER_ID, PASSWORD, NAME, USER_BIRTH, USER_HEIGHT, USER_WEIGHT, USER_GOAL_WEIGHT, USER_CREATED_ON) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, sysdate)";
            pstmt = conn.prepareStatement(insertSql);
            pstmt.setString(1, member.getUser_id());
            pstmt.setString(2, member.getUser_pw());
            pstmt.setString(3, member.getUser_name());
            pstmt.setInt(4, member.getUser_birth());
            pstmt.setDouble(5, member.getUser_height());
            pstmt.setDouble(6, member.getUser_weight());
            pstmt.setDouble(7, member.getUser_goal_weight());
            pstmt.setTimestamp(8, member.getUser_created_on());

            int rowsAffected = pstmt.executeUpdate();


            // 회원가입이 완료되면, Login 클래스 호출.
            if(rowsAffected > 0) {
                System.out.println("저희 서비스에 함께 하시게 된 것을 환영합니다.");
                HealthLoginMain.main(null);
            }else {
                System.out.println("저희와 함께하는데에 어려움이 있는 것 같아요. 다시 확인해주세요");

            }

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {

            Common.close(rs);
            Common.close(pstmt);
            Common.close(conn);

        }
    }

}




