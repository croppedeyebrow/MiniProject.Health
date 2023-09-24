package Healthproject_Jdbc.JoinMember;


import java.sql.Timestamp;
import java.util.Scanner;
import java.util.regex.Pattern;


public class JoinMemberMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("=====회원가입====");

        while (true) {
            System.out.print("저희 서비스와 함게하시겠습니까? : [1] 회원가입 [2]나가기");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("아이디: ");
                String userId = scanner.nextLine();

                //String specialCharPattern = ".*[^a-zA-Z0-9].*"; 이 코드는 정규 표현식(Regular Expression)을 사용하여 문자열에서 특수문자를 검사하기 위한 패턴을 정의하는 부분
                // .*: .*은 임의의 문자(0개 이상)를 의미합니다. 즉, 어떤 문자열이든 0개 이상의 문자로 시작할 수 있음을 나타냅니다.
                //[^a-zA-Z0-9]: [...]는 문자 집합(Character Class)을 나타냅니다. ^는 부정(negation)을 나타내며,
                // 여기서는 a부터 z까지 소문자, A부터 Z까지 대문자, 그리고 0부터 9까지 숫자를 제외한 다른 어떤 문자도 매치하라는 것을 의미

                String specialCharPattern = ".*[^a-zA-Z0-9].*";

                if(Pattern.matches(specialCharPattern, userId)) {
                    System.out.println("아이디에는 대소문자,숫자 이외에는 포함할 수 없습니다");
                    continue;
                }

                System.out.print("비밀번호: ");
                String password = scanner.nextLine();

                if(Pattern.matches(specialCharPattern, password)) {
                    System.out.println("패스워드에는 대소문자,숫자 이외에는 포함할 수 없습니다");
                    continue;
                }

                System.out.print("이름: ");
                String name = scanner.nextLine();

                System.out.print("생년월일: ");
                int birthYear = scanner.nextInt();
                scanner.nextLine(); // Enter 키 입력 제거

                System.out.print("키: ");
                double height = scanner.nextDouble();

                System.out.print("몸무게: ");
                double weight = scanner.nextDouble();

                System.out.print("목표 체중: ");
                double goalWeight = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("최초 가입일(yyyyMMdd): ");
                String createdOnStr = scanner.nextLine();

                // JoinMemberVo 객체 생성
                JoinMemberVo member = new JoinMemberVo();
                member.setUser_id(userId);
                member.setUser_pw(password);
                member.setUser_name(name);
                member.setUser_birth(birthYear);
                member.setUser_height(height);
                member.setUser_weight(weight);
                member.setUser_goal_weight(goalWeight);
                member.setUser_created_on(Timestamp.valueOf(createdOnStr + " 00:00:00"));

                // JoinMemberDao를 사용하여 회원 정보 저장
                JoinMemberDao memberDao = new JoinMemberDao();


                boolean success = memberDao.insertMember(member);


                if (success) {
                    System.out.println("회원 가입이 완료되었습니다.");
                } else {
                    System.out.println("회원 가입에 실패했습니다.");
                }
            } else if (choice == 2) {
                System.out.println("회원 가입을 종료합니다.");
                break;
            } else {
                System.out.println("입력한 내용이 올바르지 않습니다. 다시 작성해주세요!");
            }
        }
    }
}









