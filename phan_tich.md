

1. Vì sao dùng @annotations mạnh hơn execution()

- execution() chỉ match method dựa trên tên và kiểu tham số, không thể match dựa trên annotation

-> Security Aspect bị bỏ qua nếu method không có annotation @Secured
- @annotation có thể match method dựa trên annotation, đảm bảo tất cả method cần bảo vệ đều được áp dụng Security Aspect
- Giúp tránh lỗi do quên thêm annotation, tăng tính bảo mật cho hệ thống
- Giúp code rõ ràng hơn, dễ hiểu hơn về mục đích của Aspect khi sử dụng annotation để đánh



- Không phụ thuộc tên hàm.

- Chỉ cần method còn gắn annotation:

  -> Security vẫn hoạt động chính xác.

 2. Lợi ích của Custom Annotation

- Tăng tính đóng gói (Encapsulation).

- Tách biệt business logic và security logic.

- Dễ mở rộng cho Microservice.

- Tránh duplicate code.

3. Vì sao phải dùng @Pattern cho transactionCode

Ngăn:

- SQL Injection

- XSS

- dữ liệu độc hại

Ví dụ payload nguy hiểm:

TXN999' OR '1'='1

Regex validation giúp chặn ngay từ tầng API.