package exam_advance_2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số ISBN (10 chữ số): ");
        String isbnInput = scanner.nextLine();

        if (isISBNValid(isbnInput)) {
            System.out.println("Số ISBN là hợp lệ.");
        } else {
            System.out.println("Số ISBN không hợp lệ.");
        }
    }

    public static boolean isISBNValid(String isbn) {
        // Bước 2: Kiểm tra xem người dùng có nhập số có mười chữ số hay không
        if (isbn.length() != 10) {
            return false;
        }

        // Bước 3: Sử dụng Stack để lưu trữ các chữ số và thực hiện tính tổng theo công thức
        Stack<Integer> digits = new Stack<>();
        int sum = 0;
        for (int i = 0; i < isbn.length(); i++) {
            int digit = Character.getNumericValue(isbn.charAt(i));
            digits.push(digit);
            sum += (i + 1) * digit;
        }

        // Bước 4: Kiểm tra điều kiện và đưa ra kết luận
        return sum % 11 == 0;
    }
}
