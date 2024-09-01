package lecture.pkg6;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class ex {
    public static ArrayList<Integer> EnterData(ArrayList<Integer> numbers){
        Scanner scanner = new Scanner(System.in);
        System.out.println("so luong phan tu cua mang: ");
        int size = scanner.nextInt();
        for (int i = 0; i <size; i++) {
            System.out.println("numbers[" + i + "]=");
            int value = scanner.nextInt();
            numbers.add(value);
        }
        return numbers;
    }
public static void DisplayData(ArrayList<Integer>numbers) {
    System.out.println("numbers[]=" +Arrays.toString(numbers.toArray()));
} 

    public static Integer findSecondMax(ArrayList<Integer> numbers) {
        if (numbers == null || numbers.size() < 2) {
            // Danh sách rỗng hoặc không đủ phần tử để tìm giá trị lớn thứ hai
            return null;
        }

        Integer max1 = Integer.MIN_VALUE; // Giá trị lớn nhất hiện tại
        Integer max2 = Integer.MIN_VALUE; // Giá trị lớn thứ hai hiện tại

        for (int number : numbers) {
            if (number > max1) {
                // Cập nhật giá trị lớn nhất và giá trị lớn thứ hai
                max2 = max1;
                max1 = number;
            } else if (number > max2 && number < max1) {
                // Cập nhật giá trị lớn thứ hai
                max2 = number;
            }
        }
        // Kiểm tra xem có giá trị lớn thứ hai hợp lệ không
        if (max2 == Integer.MIN_VALUE) {
            return null; // Không có giá trị lớn thứ hai
        }

        return max2;
    }
    
    public static void removeOddNumbers(ArrayList<Integer> numbers) {
        // Sử dụng phương pháp removeIf để xóa các phần tử lẻ
        numbers.removeIf(number -> number % 2 != 0);
    }
    
        public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String check ;
        do {
            System.out.println("Menu: Nhap data (phim 1), xuat data (phim 2)");
            int choosion = Integer.parseInt(scanner.nextLine());
            switch (choosion) {
                case 1:
                    numbers = ex.EnterData(numbers);
                    break;
                case 2:
                    ex.DisplayData(numbers);
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
            System.out.println("Nhap yes de tiep tuc chuong trinh");
            check = scanner.nextLine();
                    }
        while (check.equals("yes"));
        {              
        Integer secondMax = findSecondMax(numbers);
        if (secondMax != null) {
            System.out.println("Giá trị lớn thứ hai là: " + secondMax);
        } else {
            System.out.println("Danh sách không đủ phần tử hoặc không có giá trị lớn thứ hai.");
            }
        }
        System.out.println("Danh sách trước khi xóa số lẻ: " + numbers);
        // Gọi phương pháp để xóa các số lẻ
        removeOddNumbers(numbers);
        // In danh sách sau khi xóa các số lẻ
        System.out.println("Danh sách sau khi xóa số lẻ: " + numbers);
    }
}
