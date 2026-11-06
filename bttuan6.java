import java.util.ArrayList;
import java.util.Scanner;

// Lớp Sach đại diện cho thông tin một cuốn sách trong thư viện (Yêu cầu Tuần 6)
class Sach {
    private String maSach;
    private String tenSach;
    private int soLuong;
    private double giaTien;

    // Constructor khởi tạo thông tin sách
    public Sach(String maSach, String tenSach, int soLuong, double giaTien) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    // Các phương thức Get/Set
    public String getMaSach() { return maSach; }
    public void setMaSach(String maSach) { this.maSach = maSach; }

    public String getTenSach() { return tenSach; }
    public void setTenSach(String tenSach) { this.tenSach = tenSach; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    public double getGiaTien() { return giaTien; }
    public void setGiaTien(double giaTien) { this.giaTien = giaTien; }

    // Phương thức hiển thị thông tin sách
    public void hienThiThongTin() {
        System.out.printf("Mã sách: %-10s | Tên sách: %-20s | Số lượng: %-5d | Giá tiền: %.2f VNĐ\n", 
                          maSach, tenSach, soLuong, giaTien);
    }
}

public class QuanLyThuVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Sử dụng ArrayList để lưu trữ danh sách sách với số lượng thay đổi linh hoạt (Tuần 6)
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        int choice;

        // Vòng lặp do-while kết hợp menu hoạt động liên tục (Kế thừa yêu cầu Tuần 5 & Tuần 6)[cite: 1, 2]
        do {
            System.out.println("\n================ QUẢN LÝ THƯ VIỆN ================");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị danh sách sách");
            System.out.println("3. Tìm sách theo mã");
            System.out.println("4. Xóa sách theo mã");
            System.out.println("5. Sửa thông tin sách");
            System.out.println("6. Tính tổng số lượng sách");
            System.out.println("7. Tính tổng giá trị sách");
            System.out.println("8. Thoát chương trình");
            System.out.print("Chọn chức năng (1-8): ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự xuống dòng thừa

            switch (choice) {
                case 1: // Thêm sách
                    System.out.println("\n--- THÊM SÁCH MỚI ---");
                    System.out.print("Nhập mã sách: ");
                    String ma = scanner.nextLine();
                    System.out.print("Nhập tên sách: ");
                    String ten = scanner.nextLine();
                    System.out.print("Nhập số lượng: ");
                    int sl = scanner.nextInt();
                    System.out.print("Nhập giá tiền: ");
                    double gia = scanner.nextDouble();
                    scanner.nextLine();

                    danhSachSach.add(new Sach(ma, ten, sl, gia));
                    System.out.println("=> Thêm sách vào thư viện thành công!");
                    break;

                case 2: // Hiển thị sách
                    if (danhSachSach.isEmpty()) {
                        System.out.println("=> Thư viện hiện chưa có cuốn sách nào!");
                    } else {
                        System.out.println("\n--- DANH SÁCH SÁCH TRONG THƯ VIỆN ---");
                        for (int i = 0; i < danhSachSach.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            danhSachSach.get(i).hienThiThongTin();
                        }
                    }
                    break;

                case 3: // Tìm sách theo mã (Nâng cấp từ Tuần 5)
                    if (danhSachSach.isEmpty()) {
                        System.out.println("=> Thư viện chưa có dữ liệu để tìm kiếm!");
                        break;
                    }
                    System.out.print("Nhập mã sách cần tìm: ");
                    String maTim = scanner.nextLine();
                    boolean found = false;

                    for (Sach s : danhSachSach) {
                        if (s.getMaSach().equalsIgnoreCase(maTim)) {
                            System.out.println("=> Đã tìm thấy sách:");
                            s.hienThiThongTin();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("=> Không tìm thấy cuốn sách có mã: " + maTim);
                    }
                    break;

                case 4: // Xóa sách theo mã
                    if (danhSachSach.isEmpty()) {
                        System.*out*.println("=> Thư viện trống, không thể xóa!");
                        break;
                    }
                    System.out.print("Nhập mã sách cần xóa: ");
                    String maXoa = scanner.nextLine();
                    boolean removed = false;

                    for (int i = 0; i < danhSachSach.size(); i++) {
                        if (danhSachSach.get(i).getMaSach().equalsIgnoreCase(maXoa)) {
                            danhSachSach.remove(i);
                            System.out.println("=> Đã xóa sách thành công!");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("=> Không tìm thấy mã sách cần xóa.");
                    }
                    break;

                case 5: // Sửa thông tin sách theo mã
                    if (danhSachSach.isEmpty()) {
                        System.out.println("=> Thư viện chưa có dữ liệu để sửa!");
                        break;
                    }
                    System.out.print("Nhập mã sách cần sửa: ");
                    String maSua = scanner.nextLine();
                    boolean updated = false;

                    for (Sach s : danhSachSach) {
                        if (s.getMaSach().equalsIgnoreCase(maSua)) {
                            System.out.print("Nhập tên sách mới: ");
                            s.setTenSach(scanner.nextLine());
                            System.out.print("Nhập số lượng mới: ");
                            s.setSoLuong(scanner.nextInt());
                            System.out.print("Nhập giá tiền mới: ");
                            s.setGiaTien(scanner.nextDouble());
                            scanner.nextLine();

                            System.out.println("=> Cập nhật thông tin sách thành công!");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("=> Không tìm thấy mã sách cần sửa.");
                    }
                    break;

                case 6: // Tính tổng số lượng sách (Kế thừa Tuần 5)[cite: 1]
                    int tongSoLuong = 0;
                    for (Sach s : danhSachSach) {
                        tongSoLuong += s.getSoLuong();
                    }
                    System.out.println("=> Tổng số lượng sách trong thư viện: " + tongSoLuong);
                    break;

                case 7: // Tính tổng giá trị sách (Kế thừa Tuần 5)[cite: 1]
                    double tongGiaTri = 0;
                    for (Sach s : danhSachSach) {
                        tongGiaTri += (s.getSoLuong() * s.getGiaTien());
                    }
                    System.out.println("=> Tổng giá trị tài sản sách trong thư viện: " + tongGiaTri + " VNĐ");
                    break;

                case 8: // Thoát chương trình (Kế thừa menu lặp Tuần 5)[cite: 1]
                    System.out.println("=> Đang thoát chương trình quản lý thư viện. Tạm biệt!");
                    break;

                default:
                    System.out.println("=> Lựa chọn không hợp lệ! Vui lòng chọn từ 1 đến 8.");
            }
        } while (choice != 8);

        scanner.close();
    }
}