# Triangle Testing

## Mục tiêu

Repository này thực hiện kiểm thử chương trình Java `Triangle`, tập trung vào phương thức:

```java
classify(int a, int b, int c)
```

Bài làm gồm hai phần:

| Lab   | Nội dung                                                                                                                   |
| ----- | -------------------------------------------------------------------------------------------------------------------------- |
| Lab 4 | Vẽ Control Flow Graph, tính Cyclomatic Complexity, liệt kê independent paths và thiết kế test case                         |
| Lab 5 | Viết unit test bằng JUnit, chạy kiểm thử, đo Statement Coverage và Branch Coverage bằng JaCoCo, phân tích kết quả coverage |

---

## Cấu trúc thư mục

Project được xây dựng theo cấu trúc Maven:

```text
TriangleTesting/
│
├── pom.xml
├── README.md
├── Report_Lab04_Triangle_CFG_CC_Testing.md
├── Report_Lab05_UnitTest_Coverage.md
│
└── src/
    ├── main/
    │   └── java/
    │       └── Triangle.java
    │
    └── test/
        └── java/
            └── TriangleTest.java
```

---

## Mô tả chương trình

Phương thức `classify(int a, int b, int c)` nhận vào ba số nguyên đại diện cho ba cạnh của một tam giác.

Chương trình trả về một trong năm kết quả:

| Kết quả          | Ý nghĩa                                       |
| ---------------- | --------------------------------------------- |
| `Invalid`        | Có ít nhất một cạnh nhỏ hơn hoặc bằng 0       |
| `Not a triangle` | Ba cạnh không thỏa mãn bất đẳng thức tam giác |
| `Equilateral`    | Tam giác đều                                  |
| `Isosceles`      | Tam giác cân                                  |
| `Scalene`        | Tam giác thường                               |

---

## Công nghệ sử dụng

| Công nghệ | Mục đích                                 |
| --------- | ---------------------------------------- |
| Java      | Viết chương trình chính                  |
| Maven     | Quản lý project và chạy kiểm thử         |
| JUnit 5   | Viết unit test                           |
| JaCoCo    | Đo Statement Coverage và Branch Coverage |

---

## Nội dung Lab 4

Lab 4 gồm các yêu cầu:

1. Vẽ Control Flow Graph (CFG) cho phương thức `classify`.
2. Tính Cyclomatic Complexity (CC).
3. Liệt kê các đường đi độc lập.
4. Thiết kế bộ test case để đạt:
   - 100% Statement Coverage
   - 100% Branch Coverage

Báo cáo Lab 4 nằm trong file:

```text
Report_Lab04_Triangle_CFG_CC_Testing.md
```

---

## Nội dung Lab 5

Lab 5 sử dụng bộ test case đã thiết kế ở Lab 4 để:

1. Viết unit test cho phương thức `classify`.
2. Chạy kiểm thử bằng JUnit.
3. Đo Statement Coverage.
4. Đo Branch Coverage.
5. Phân tích kết quả coverage.
6. Giải thích vì sao bộ test đạt hoặc chưa đạt 100% coverage.
7. Đề xuất bổ sung test case nếu coverage chưa đầy đủ.

Báo cáo Lab 5 nằm trong file:

```text
Report_Lab05_UnitTest_Coverage.md
```

---

## Kết luận

Repository này hoàn thành cả Lab 4 và Lab 5 cho chương trình Java `Triangle`.

- Lab 4 hoàn thành phần phân tích CFG, Cyclomatic Complexity, independent paths và thiết kế test case.
- Lab 5 hoàn thành phần viết unit test, chạy kiểm thử, đo Statement Coverage và Branch Coverage bằng JaCoCo.

Kết quả kiểm thử cho thấy bộ test case đạt 100% Statement Coverage và 100% Branch Coverage.
