package gpacalc;
import static camp.nextstep.edu.missionutils.Console.readLine;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Operations op = new Operations();
        ArrayList<Subject> major = new ArrayList<>(); // 전공과목
        ArrayList<Subject> general = new ArrayList<>(); // 교양과목
        double gpa = 0;
        double totalWeightSG = 0;

        //데이터 입력부분
        System.out.println("전공 과목명과 이수학점, 평점을 입력해주세요(예시: 프로그래밍언어론-3-A+,소프트웨어공학-3-B+):");
        String input = Console.readLine();
        major = op.MakeSubjects(input);
        System.out.println("\n교양 과목명과 이수학점, 평점을 입력해주세요(예시: 선형대수학-3-C0,인간관계와자기성장-3-P):");
        input = Console.readLine();
        general = op.MakeSubjects(input);

        //프로그램 출력부분
        op.printSubjects(major, general);

        //취득학점 출력
        System.out.println("\n<취득학점>");
        System.out.println(op.CalTakenCredits(major, general)+"학점\n");

        //평점평균(전공, 교양 과목 모두 포함)
        System.out.println("<평점평균>");
        System.out.println(op.CalGPA(major, general)+" / 4.5\n");

        //전공 평점평균(전공 과목만 포함)
        System.out.println("<전공 평점평균>");
        System.out.println(op.CalGPA_M(major)+" / 4.5\n");
    }
}
