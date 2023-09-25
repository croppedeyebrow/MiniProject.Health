package Healthproject_Jdbc.Workout;




import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class WorkoutMain {
    private static Connection conn;

    public static void main(String[] args) {
        workoutList();
    }

    public static void workoutList() {
        Scanner sc = new Scanner(System.in);
        WorkoutDao dao = new WorkoutDao(conn);

        int workoutTypeSel = 0; // 운동 종류를 저장할 변수
        int hours = 0;
        int minutes = 0;
        int workoutGymMonth = 0;
        while (true) {
            System.out.println("=".repeat(5) + "Workout Calculator" + "=".repeat(5));
            System.out.print("운동 정보를 선택 하세요. [1]WorkoutType, [2]WorkoutTime, [3]BurnedCal, [4]GymPrice, [5]Exit : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("운동 종류를 선택하세요. [1] 유산소 [2] 웨이트 : ");
                    workoutTypeSel = sc.nextInt();
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
                    break;
                case 2:
                    System.out.print("운동 시간 : ");
                    hours = sc.nextInt();
                    System.out.print("운동 분 : ");
                    minutes = sc.nextInt();
                    break;
                case 3:
                    // 여기에서 소모된 칼로리 계산
                    if (workoutTypeSel == 1 || workoutTypeSel == 2) {
                        if (workoutTypeSel == 1) {
                            // 유산소 운동의 칼로리 계산
                            double caloriesBurned = (hours * 60 + minutes) * 200.0 / 60.0; // 1시간에 200칼로리 소모
                            System.out.println("유산소 운동 " + hours + "시간" + minutes + "분은 약 " + caloriesBurned + "칼로리를 소모합니다.");
                        } else if (workoutTypeSel == 2) {
                            // 웨이트 운동의 칼로리 계산
                            double caloriesBurned = (hours * 60 + minutes) * 100.0 / 60.0; // 1시간에 100칼로리 소모
                            System.out.println("웨이트 운동 " + hours + "시간" + minutes + "분은 약 " + caloriesBurned + "칼로리를 소모합니다.");
                        }
                    } else {
                        System.out.println("운동 종류를 다시 선택하세요.");
                    }
                    // 여기서 workoutTypeSel을 초기화합니다.
                    workoutTypeSel = 0;
                    break;
                case 4:
                    System.out.print("등록하신 헬스장 개월 수를 입력하세요 : ");
                    workoutGymMonth = sc.nextInt();
                    int workoutGymPrice = workoutGymMonth * 90000;
                    System.out.println("월 헬스장 이용료는 : " + workoutGymPrice + "원 입니다.");
                    break;
                case 5:
                    System.out.println("메뉴를 종료 합니다.");
                    return;
            }
        }
    }
}







