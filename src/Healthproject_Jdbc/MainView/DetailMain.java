package Healthproject_Jdbc.MainView;

import Healthproject_Jdbc.Challenge.ChallengeMain;
import Healthproject_Jdbc.Food.FoodMain;
import Healthproject_Jdbc.Login.HealthLoginMain;
import Healthproject_Jdbc.TotalContrl.TotalControlMain;
import Healthproject_Jdbc.Workout.WorkoutMain;

import java.util.Scanner;

public class DetailMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("==========당신의 운동 비서==========");
            System.out.println("원하는 작업을 선택하세요 (1/2/3/4/5):  ");
            System.out.println("[1] 식단 현황 관리:  ");
            System.out.println("[2] 운동 현황 관리:  ");
            System.out.println("[3] 지출 내역 관리 ");
            System.out.println("[4] 메인 메뉴로 돌아가기 ");
            System.out.println("[5] 로그아웃 ");


            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    FoodMain.main(args);
                    break;
                case 2:
                    WorkoutMain.main(args);
                    break;
                case 3:
                    ChallengeMain.main(args);
                    return;

                case 4:
                    MainViewMain.main(args);
                    return;

                case 5:
                    System.out.println("로그아웃 되었습니다.");
                    HealthLoginMain.main(args);
                    return;

                default:
                    System.out.println("선택하신 사항이 올바르지 않습니다. 다시 고르세요.");
                    break;
            }
        }
    }
}


