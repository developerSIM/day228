/*
BoardService3
    - 내용 [String타입] 과 작성자 [String타입] 과 비밀번호 [int타입]으로 게시물 클래스를 설계
    - 게시물 객체 최대 100개 까지 저장하는 서비스 구축
        - 조건 : main함수 1개 와 배열은 최대1까지 사용하여 구현
        - 구축 : 게시물 쓰기 와 게시물 출력 기능 구현

        타입 : 데이터 형태를 분류한거
            대분류 : - 기본타입(byte,int,short,long,float,double,char,boolean)8개 ---> 기본값: 정수0, 실수0.0, 논리false
                    - 참조타입 ( []배열, 클래스 , 인터페이스 , 열거타입 ) 등등 ---> 기본값:null
        클래스 : 타입 만들기 - 멤버변수(필드) , 생성자 , 메소드(멤버함수) 로 구성된 새로운 타입 만들기
            - 객체지향 프로그래밍 매우 중요한 문법
        객체 : 하나의 자료(여러개 자료들을 주소값)을 저장하는 메모리 공간( JVM 힙영역 )
            - (참조)클래스 타입으로 생성된 메모리 공간
        변수 : 하나의 자료(실제값,주소값)를 저장하는 메모리 공간 ( JVM 스택 영역 )
            - 기본/참조 타입으로 생성된 메모리 공간














 */






/*
BoardService3
    - 내용[String타입] 과 작성자[String타입] 과 비밀번호[int타입] 로 구성된 게시물 클래스를 설계
    - 게시물 객체 최대 100개 까지 저장하는 서비스 구축
      - 조건 : main함수 1개 와 배열은 최대1까지 사용 하여 구현
      - 구축 : 게시물 쓰기 와 게시물 출력 기능 구현

    타입 : 데이터 형태 를 분류
        대분류 : - 기본타입(byte,short,int,long,float,double,char,boolean)8개 ---> 기본값: 정수0 , 실수0.0 , 논리false
                - 참조타입( []배열, 클래스 , 인터페이스 , 열거타입 )등등 ---> 기본값: null
    클래스 : 멤버변수(필드) , 생성자 , 메소드(멤버함수) 로 구성된 새로운 타입 만들기
    객체 : 참조 타입으로 생성된 메모리 공간
    변수 : 기본/참조 타입으로 생성된 메모리 공간
*/
package day22;

import java.util.Scanner;

public class BoardService3 { /* 실행클래스 */
    public static void main(String[] args) {
        // -입력객체
        Scanner scan = new Scanner(System.in);
        // - 고정길이 - Board 객체 100개를 저장할수 있는 배열 선언
        Board[] boardList = null; //변수는 그대로
        int count = 0;
        while (true){
            System.out.print("1.글쓰기 2.글출력 : ");
            int choose = scan.nextInt();
            if( choose == 1 ){
                // [1] 사용자로 저장할 데이터 입력 받는다.
                scan.nextLine(); // 의미 없는 nextLine() 코드 작성한다.
                System.out.print("내용 : ");      String content = scan.nextLine();
                // .next() 문자열(공백x) 입력 , .nextLine() 문자열(공백/띄어쓰기 포함) 입력
                // .nextLine() 사용시 주의할점 : .nextLine() 앞에 또 다른 .nextXX() 존재하면 의미없는 .nextLine() 작성해준다.
                System.out.print("작성자 : ");     String writer = scan.next();
                System.out.print("비밀번호 : ");    int pwd = scan.nextInt();

                // [2] 입력받은 데이터로 게시물 객체 생성
                Board board = new Board();
                board.content = content; board.writer = writer; board.pwd = pwd;

                // [3]

                count++;
                Board[] newboardList = new Board[ count];
                if ( count != 1){
                    for( int index = 0 ; index <= boardList.length-1 ;  index++){
                        newboardList[index] = boardList[index];
                    }
                }
                newboardList[newboardList.length-1 ] = board;
                boardList = newboardList;




                // 배열내 존재하는 게시물 모두 출력하기
                for( int index = 0 ; index <= boardList.length-1 ; index++ ){
                    if( boardList[index] != null ){ // 게시물이 존재하면
                        System.out.printf("작성자 : %s , 내용 : %s \n" ,
                                boardList[index].writer , boardList[index].content );
                    }
                } // for end
            }
        } // w end
    } // m end
} // c end













