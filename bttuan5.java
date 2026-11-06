import java.util.Scanner;

public class QuanLyThuVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = 0;
        String[] maSach = null;
        String[] tenSach = null;
        int[] soLuong = null;
        double[] giaTien = null;

        int choice;
        do {
            // Hiển thị Menu (Bài 3)
            System.out.println("\n========== QUẢN LÝ THƯ VIỆN ==========");
            System.out.println("1. Bài 1: Nhập danh sách n cuốn sách");
            System.out.println("2. Bài 2: Tính tổng số lượng và tổng giá trị sách");
            System.out.println("3. Bài 4: Tìm kiếm sách theo mã");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn chức năng (0-3): ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng thừa

            switch (choice) {
                case 1:
                    // Bài 1: Nhập n sách bằng vòng lặp
                    System.out.print("Nhập số lượng sách (n): ");
                    n = scanner.nextInt();
                    scanner.nextLine();

                    maSach = new String[n];
                    tenSach = new String[n];
                    soLuong = new int[n];
                    giaTien = new double[n];

                    for (int i = 0; i < n; i++) {
                        System.out.println("\n--- Nhập thông tin cuốn sách thứ " + (i + 1) + " ---");
                        System.out.print("Mã sách: ");
                        maSach[i] = scanner.nextLine();
                        System.out.print("Tên sách: ");
                        tenSach[i] = scanner.nextLine();
                        System.out.print("Số lượng: ");
                        soLuong[i] = scanner.nextInt();
                        System.out.print("Giá tiền (VNĐ): ");
                        giaTien[i] = scanner.nextDouble();
                        scanner.nextLine(); // Đọc bỏ dòng thừa
                    }
                    System.out.println("Đã nhập thành công " + n + " cuốn sách!");
                    break;

                case 2:
                    // Bài 2: Tính tổng số lượng và tổng giá trị sách
                    if (n == 0) {
                        System.out.println("Chưa có dữ liệu sách trong thư viện. Vui lòng nhập dữ liệu ở Bài 1!");
                        break;
                    }

                    int tongSoLuong = 0;
                    double tongGiaTri = 0;

                    for (int i = 0; i < n; i++) {
                        tongSoLuong += soLuong[i];
                        tongGiaTri += soLuong[i] * giaTien[i];
                    }

                    System.out.println("\n--- THỐNG KÊ THƯ VIỆN ---");
                    System.out.println("Tổng số lượng sách: " + tongSoLuong);
                    System.out.println("Tổng giá trị sách: " + tongGiaTri + " VNĐ");
                    break;

                case 3:
                    // Bài 4: Tìm sách theo mã
                    if (n == 0) {
                        System.out.println("Chưa có dữ liệu sách trong thư viện. Vui lòng nhập dữ liệu ở Bài 1!");
                        break;
                    }

                    System.out.print("Nhập mã sách cần tìm: ");
                    String maTimKiem = scanner.nextLine();
                    boolean found = false;

                    for (int i = 0; i < n; i++) {
                        if (maSach[i].equalsIgnoreCase(maTimKiem)) {
                            System.out.println("\nĐã tìm thấy sách!");
                            System.out.println("Mã sách: " + maSach[i]);
                            System.out.println("Tên sách: " + tenSach[i]);
                            System.out.println("Số lượng: " + soLuong[i]);
                            System.out.println("Giá tiền: " + giaTien[i] + " VNĐ");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy cuốn sách có mã: " + maTimKiem);
                    }
                    break;

                case 0:
                    System.out.println("Đang thoát chương trình... Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 0 đến 3.");
            }
        } while (choice != 0); // Vòng lặp chạy cho đến khi chọn Thoát

        scanner.close();
    }
}