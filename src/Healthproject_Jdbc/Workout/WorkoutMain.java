package Healthproject_Jdbc.Workout;

import Healthproject_Jdbc.Challenge.ChallengeDao;
import Healthproject_Jdbc.Food.FoodDao;
import Healthproject_Jdbc.Workout.WorkoutDAO;
import Healthproject_Jdbc.Workout.WorkoutVO;
import Healthproject_Jdbc.common.Common;


import java.sql.Connection;
import java.util.Scanner;



public class WorkoutMain {
    private static Connection conn;

    public static void main(String[] args) {
        workoutList();
    }

    public static void workoutList() {
        Scanner sc = new Scanner(System.in);
        conn = Common.getConnection(); // static 변수 초기화

        WorkoutDAO workoutDao = new WorkoutDAO(conn);
        FoodDao foodDao = new FoodDao(conn);
        ChallengeDao challengeDao = new ChallengeDao(conn, workoutDao, foodDao);

        int workoutTypeSel = 0; // 운동 종류를 저장할 변수
        int hours = 0; // 시간 저장
        int minutes = 0; // 분 저장
        double caloriesBurned = 0.0;
        int workoutGymPrice = 0;


        while (true) {
            System.out.println("=".repeat(5) + "운동 정보" + "=".repeat(5));
            System.out.println("[1]운동 종류 : ");
            System.out.println("[2]운동 시간 : ");
            System.out.println("[3]소모 칼로리 : ");
            System.out.println("[4]헬스 관련 지출 내역 : ");
            System.out.println("[5]뒤로가기 : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("운동 종류를 선택하세요. [1] 유산소 [2] 웨이트 : ");
                    workoutTypeSel = sc.nextInt();
                    WorkoutVO workout = new WorkoutVO(0, workoutTypeSel,0, 0, 0);
                    switch (workoutTypeSel) {
                        case 1:
                            // 유산소 선택 시 칼로리 정보 표시
                            System.out.println("유산소 1시간에 200칼로리 소모");

                            break;
                        case 2:
                            // 웨이트 선택 시 칼로리 정보 표시
                            System.out.println("웨이트 1시간에 100칼로리 소모");
                            break;
                        default:
                            System.out.println("잘못된 선택입니다.");
                            break;
                    }
                    dao.insertWorkout(workout);
                    break;
                case 2:
                    int workoutTimeInMinutes = hours * 60 + minutes;
                    WorkoutVO workout2 = new WorkoutVO(0, 0, workoutTimeInMinutes, 0, 0);
                    System.out.print("운동 시간 : ");
                    hours = sc.nextInt();
                    System.out.print("운동 분 : ");
                    minutes = sc.nextInt();
                    dao.insertWorkout(workout2);
                    break;
                case 3:
                    if (workoutTypeSel == 1 || workoutTypeSel == 2) {
                        if (workoutTypeSel == 1) {
                            // 유산소 운동의 칼로리 계산
                            caloriesBurned = (hours * 60 + minutes) * 200.0 / 60.0; // 1시간에 200칼로리 소모
                            System.out.println("유산소 운동 " + hours + "시간" + minutes + "분은 약 " + caloriesBurned + "칼로리를 소모합니다.");
                        } else if (workoutTypeSel == 2) {
                            // 웨이트 운동의 칼로리 계산
                            caloriesBurned = (hours * 60 + minutes) * 100.0 / 60.0; // 1시간에 100칼로리 소모
                            System.out.println("웨이트 운동 " + hours + "시간" + minutes + "분은 약 " + caloriesBurned + "칼로리를 소모합니다.");
                        }
                        WorkoutVO workout3 = new WorkoutVO(0, 0, 0, (int) caloriesBurned, 0);
                        dao.insertWorkout(workout3);
                    } else {
                        System.out.println("운동 종류를 다시 선택하세요.");
                    }
                    // 여기서 workoutTypeSel을 초기화합니다.
                    workoutTypeSel = 0;
                    break;
                case 4:
                    WorkoutVO workout4 = new WorkoutVO(0, 0, 0, 0, workoutGymPrice);
                    dao.insertWorkout(workout4);
                    System.out.print("등록하신 헬스장 개월 수를 입력하세요 : ");
                    int workoutGymMonth = sc.nextInt();
                    workoutGymPrice = workoutGymMonth * 90000;
                    System.out.println("월 헬스장 이용료는 : " + workoutGymPrice + "원 입니다.");
                    break;
                case 5:
                    System.out.println("메뉴를 종료 합니다.");
                    return;
            }
        }
    }
}







