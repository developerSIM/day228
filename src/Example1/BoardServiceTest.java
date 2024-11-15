package Example1;

import java.util.Scanner;

class Post {
    private String content; // 내용
    private String writer;  // 작성자
    private int password;   // 비밀번호

    public Post(String content, String writer, int password) {
        this.content = content;
        this.writer = writer;
        this.password = password;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public int getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "작성자: " + writer + ", 내용: " + content;
    }
}

class BoardService {
    private Post[] post;
    private int count;

    public BoardService() {
        post = new Post[100];
        count = 0;
    }

    public void Post(String content, String writer, int password) {
        if (count < 100) {
            post[count] = new Post(content, writer, password);
            count++;
            System.out.println("게시물이 추가되었습니다.");
        } else {
            System.out.println("게시물 저장소가 가득 찼습니다.");
        }
    }

    public void printPosts() {
        if (count == 0) {
            System.out.println("저장된 게시물이 없습니다.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(post[i]);
        }
    }
}

public class BoardServiceTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BoardService boardService = new BoardService();

        while (true) {
            System.out.println("1. 게시물 추가하기");
            System.out.println("2. 게시물 출력하기");
            System.out.println("3. 종료하기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("내용 : ");
                String content = scanner.nextLine();
                System.out.print("작성자 : ");
                String writer = scanner.nextLine();
                System.out.print("비밀번호를 입력하시오. : ");
                int password = scanner.nextInt();
                boardService.Post(content, writer, password);
            } else if (choice == 2) {
                boardService.printPosts();
            } else if (choice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못됬습니다. 다시 시도하세요.");
            }
        }

        scanner.close();
    }
}
