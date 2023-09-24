package Healthproject_Jdbc.UserInfo;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInfoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInfoDao userInfoDao = new UserInfoDao();

        while (true) {
            System.out.println("========회원 정보 관리======== ");
            System.out.println("[1]. 회원 정보 조회 ");
            System.out.println("[2]. 회원 정보 수정 ");
            System.out.println("[3]. 회원 탈퇴하기 ");
            System.out.println("[4]. 메인 메뉴로 나가기 ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Enter 키 입력 제거

            switch (choice) {
                case 1:
                    // 회원 정보 조회
                    System.out.print("조회할 회원의 ID를 입력해주세요: ");
                    String userIdSearch = scanner.nextLine();

                    UserInfoVO searchUserID = userInfoDao.getUserInfo(userIdSearch);
                    if (searchUserID != null) {
                        System.out.println("찾은 회원 정보: ");
                        System.out.println(searchUserID);
                    } else {
                        System.out.println("찾으시는 회원은 존재하지 않습니다.");
                    }
                    break;

                case 2:
                    // 회원 정보 수정
                    System.out.print("수정하실 회원의 ID를 입력해주세요: ");
                    String userIdToUpdate = scanner.nextLine();

                    UserInfoVO updateuserId = userInfoDao.getUserInfo(userIdToUpdate);
                    if (updateuserId != null) {
                        UserInfoVO UserupdatedInfo = readUserInfoFromConsole(scanner);
                        UserupdatedInfo.setUser_id(updateuserId.getUser_id());

                      try{
                         boolean updateUserResult = userInfoDao.updateUser(UserupdatedInfo);
                         if (updateUserResult) {
                            System.out.println("회원 정보가 성공적으로 수정되었습니다.");
                         } else {
                            System.out.println("회원 정보 수정에 실패했습니다.");
                         }
                      } catch (SQLException e) {
                          e.printStackTrace(); // 오류 메시지 출력 또는 로깅
                          System.out.println("데이터베이스 오류: 회원 정보 수정에 실패했습니다.");
                      }
                     } else {
                        System.out.println("선택한 회원은 존재하지 않습니다.");
                     }
                     break;


                case 3:
                    //탈퇴하기.
                    System.out.print("탈퇴를 진행하시겠습니까?: yes/no :  ");
                    String confirm = scanner.nextLine();


                    if(confirm.equalsIgnoreCase("y")) {
                        System.out.print("사용자 ID를 입력하세요 : ");
                        String userIdDelete = scanner.nextLine();

                        UserInfoVO DeleteuserId = userInfoDao.getUserInfo(userIdDelete);

                        if (DeleteuserId != null) {
                            boolean success = userInfoDao.Deleteuser(userIdDelete);

                            if (success) {
                                System.out.println("탈퇴완료: 당신과 함께해서 즐거웠습니다.");
                            } else {
                                System.out.println("탈퇴에 실패했습니다.");
                            }
                        } else {
                            System.out.println("사용자 정보를 찾을 수 없습니다.");
                        }
                    }else {
                        System.out.println("탈퇴를 취소합니다.");
                    }
                    break;






                case 4:
                    // 메인 메뉴로 나가기
                    return;

                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                    break;
            }
        }
    }

    public static UserInfoVO readUserInfoFromConsole(Scanner scanner) {
        System.out.print("사용자 아이디: ");
        String userId = scanner.nextLine();

        System.out.print("비밀번호: ");
        String password = scanner.nextLine();

        System.out.print("사용자 이름: ");
        String userName = scanner.nextLine();

        System.out.print("생년월일: ");
        int birthYear = scanner.nextInt();
        scanner.nextLine(); // Enter 키 입력 제거

        System.out.print("키: ");
        double height = scanner.nextDouble();

        System.out.print("몸무게: ");
        double weight = scanner.nextDouble();

        System.out.print("목표 체중: ");
        double goalWeight = scanner.nextDouble();
        scanner.nextLine(); // Enter 키 입력 제거

        UserInfoVO userInfo = new UserInfoVO();
        userInfo.setUser_id(userId);
        userInfo.setUser_pw(password);
        userInfo.setUser_name(userName);
        userInfo.setUser_birth(birthYear);
        userInfo.setUser_height(height);
        userInfo.setUser_weight(weight);
        userInfo.setUser_goal_weight(goalWeight);

        return userInfo;
    }
}
