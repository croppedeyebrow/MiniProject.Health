package Healthproject_Jdbc.Challenge;

import Healthproject_Jdbc.Food.FoodDao;
import Healthproject_Jdbc.MainView.MainViewMain;
import Healthproject_Jdbc.Workout.WorkoutDAO;
import Healthproject_Jdbc.common.Common;

import java.sql.Connection;

import java.util.Scanner;

public class ChallengeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conn = Common.getConnection(); // 데이터베이스 연결을 얻어오는 메서드 호출

        WorkoutDAO workoutDao = new WorkoutDAO(conn);
        FoodDao foodDao = new FoodDao(conn);
        ChallengeDao challengeDao = new ChallengeDao(conn, workoutDao, foodDao);

        while (true) {
            System.out.println("==========당신의 성적을 확인하세요==========");
            System.out.println("[1] 누적 점수 : 이번달 동안 내가 쌓은 점수는?");
            System.out.println("[2] 평균 점수 : 관리에 진심인 사람들의 이번달 평균점수는?");
            System.out.println("[3] 순위 : 나의 순위는?");
            System.out.println("[4] 메인 메뉴로 나가기");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("누적점수를 보려면 당신의 ID를 입력해 주세요: ");
                    int RANKTbId1 = scanner.nextInt();
                    // 누적 점수 확인 메서드 호출
                    int accumulatedScore = challengeDao.getAccumulatedScore(RANKTbId1);
                    System.out.println("누적 점수는 : " + accumulatedScore);
                    break;

                case 2:
                    System.out.println("평균점수를 보려면 당신의 ID를 입력해 주세요: ");
                    int RANKTbId2 = scanner.nextInt();
                    // 평균 점수 확인 메서드 호출
                    double averageScore = challengeDao.getAverageScore(RANKTbId2);
                    System.out.println("건강을 관리하고 있는 사람들의 평균 점수는 : " + averageScore);
                    break;

                case 3:
                    System.out.println("당신의 순위를 보고 싶다면, ID를 입력해 주세요: ");
                    int RANKTbId3 = scanner.nextInt();
                    // 순위 확인 메서드 호출
                    int rank = challengeDao.getRank(RANKTbId3);
                    System.out.println("현재까지 나의 관리 순위는 : " + rank);
                    break;

                case 4:
                    System.out.println("메인 메뉴로 돌아갑니다.");
                    MainViewMain.main(args);
                    return;

                default:
                    System.out.println("잘못된 선택입니다. 다시 선택하세요.");
                    break;
            }
        }
    }
}



