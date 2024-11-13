package Example1;

import java.util.Scanner;

class Post {
    private String content; // 내용
    private String writer;  // 작성자
    private int password;   // 비밀번호

    public Post(String content, String author, int password) {
        this.content = content;
        this.writer = writer;
        this.password = password;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
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
    private Post[] posts;
    private int count;

    public BoardService() {
        posts = new Post[100];
        count = 0;
    }

    public void addPost(String content, String writer, int password) {
        if (count < 100) {
            posts[count] = new Post(content, writer, password);
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
            System.out.println(posts[i]);
        }
    }
}

public class BoardServiceTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BoardService boardService = new BoardService();

        while (true) {
            System.out.println("1. 게시물 추가");
            System.out.println("2. 게시물 출력");
            System.out.println("3. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("내용: ");
                String content = scanner.nextLine();
                System.out.print("작성자: ");
                String author = scanner.nextLine();
                System.out.print("비밀번호: ");
                int password = scanner.nextInt();
                boardService.addPost(content, author, password);
            } else if (choice == 2) {
                boardService.printPosts();
            } else if (choice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }

        scanner.close();
    }
}
