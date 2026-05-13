# BÁO CÁO LAB 5 - UNIT TEST VÀ COVERAGE CHO CHƯƠNG TRÌNH TRIANGLE

## 1. Mục tiêu

Lab 5 sử dụng chương trình Java `Triangle` từ Lab 4 và bộ test case đã thiết kế trước đó để thực hiện kiểm thử đơn vị cho phương thức:

```java
classify(int a, int b, int c)
```

Mục tiêu của Lab 5 gồm:

1. Viết unit test cho phương thức `classify`.
2. Chạy kiểm thử bằng JUnit.
3. Đo Statement Coverage và Branch Coverage bằng JaCoCo.
4. Phân tích kết quả coverage thu được.
5. Giải thích vì sao bộ test đạt hoặc chưa đạt 100% Statement Coverage và 100% Branch Coverage.
6. Đề xuất bổ sung test case nếu coverage chưa đầy đủ.

---

## 2. Chương trình được kiểm thử

Lớp `Triangle` có phương thức `classify(int a, int b, int c)` dùng để phân loại ba cạnh đầu vào.

Chương trình trả về một trong năm kết quả:

| Kết quả | Ý nghĩa |
|---|---|
| `Invalid` | Có ít nhất một cạnh nhỏ hơn hoặc bằng 0 |
| `Not a triangle` | Ba cạnh không thỏa mãn bất đẳng thức tam giác |
| `Equilateral` | Tam giác đều |
| `Isosceles` | Tam giác cân |
| `Scalene` | Tam giác thường |

---

## 3. Công cụ sử dụng

Lab 5 sử dụng các công cụ sau:

| Công cụ | Mục đích |
|---|---|
| Java | Ngôn ngữ lập trình |
| Maven | Quản lý project và chạy test |
| JUnit 5 | Viết và thực thi unit test |
| JaCoCo | Đo Statement Coverage và Branch Coverage |

---

## 4. Bộ test case sử dụng

Bộ test case được kế thừa từ Lab 4 và được mở rộng để đảm bảo đạt 100% Branch Coverage theo JaCoCo.

| Test case | Input | Expected output | Mục đích |
|---|---|---|---|
| TC1 | `classify(0, 3, 4)` | `Invalid` | Phủ trường hợp `a <= 0` |
| TC2 | `classify(3, 0, 4)` | `Invalid` | Phủ trường hợp `b <= 0` |
| TC3 | `classify(3, 4, 0)` | `Invalid` | Phủ trường hợp `c <= 0` |
| TC4 | `classify(1, 2, 3)` | `Not a triangle` | Phủ trường hợp `a + b <= c` |
| TC5 | `classify(1, 3, 1)` | `Not a triangle` | Phủ trường hợp `a + c <= b` |
| TC6 | `classify(3, 1, 1)` | `Not a triangle` | Phủ trường hợp `b + c <= a` |
| TC7 | `classify(3, 3, 3)` | `Equilateral` | Phủ tam giác đều |
| TC8 | `classify(3, 3, 2)` | `Isosceles` | Phủ tam giác cân với `a == b` |
| TC9 | `classify(2, 3, 3)` | `Isosceles` | Phủ tam giác cân với `b == c` |
| TC10 | `classify(3, 2, 3)` | `Isosceles` | Phủ tam giác cân với `a == c` |
| TC11 | `classify(3, 4, 5)` | `Scalene` | Phủ tam giác thường |
| TC12 | `new Triangle()` | Constructor | Phủ constructor mặc định của lớp `Triangle` |

---

## 5. Cài đặt unit test bằng JUnit

Unit test được viết trong file:

```text
src/test/java/TriangleTest.java
```

Các test case sử dụng `assertEquals` của JUnit 5 để so sánh kết quả thực tế với kết quả mong đợi.

Ví dụ:

```java
@Test
public void testInvalidWhenAIsZero() {
    assertEquals("Invalid", Triangle.classify(0, 3, 4));
}
```

Unit test trên kiểm tra trường hợp cạnh `a` bằng 0. Kết quả mong đợi là `"Invalid"`.

---

## 6. Chạy kiểm thử

Lệnh chạy kiểm thử:

```powershell
mvn clean test
```

Kết quả chạy kiểm thử:

```text
Tests run: 12, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

Kết quả này cho thấy toàn bộ 12 test case đều chạy thành công, không có test case nào bị lỗi, thất bại hoặc bị bỏ qua.

---

## 7. Đo Statement Coverage và Branch Coverage

Coverage được đo bằng công cụ JaCoCo. Sau khi chạy lệnh:

```powershell
mvn clean test
```

báo cáo JaCoCo được sinh tại:

```text
target/site/jacoco/index.html
```

Kết quả coverage thu được:

| Loại coverage | Kết quả |
|---|---|
| Instruction Coverage | 100% |
| Branch Coverage | 100% |
| Line Coverage | 100% |
| Method Coverage | 100% |
| Class Coverage | 100% |

Chi tiết:

```text
Missed Instructions: 0 of 49
Missed Branches: 0 of 22
Missed Lines: 0 of 10
Missed Methods: 0 of 2
Missed Classes: 0 of 1
```

Trong báo cáo này, Instruction Coverage của JaCoCo được dùng để phản ánh mức độ bao phủ các câu lệnh/thao tác thực thi trong chương trình. Branch Coverage phản ánh mức độ bao phủ các nhánh điều kiện.

---

## 8. Phân tích kết quả Statement Coverage

Bộ test đạt 100% Statement Coverage vì tất cả các câu lệnh trong phương thức `classify` đều được thực thi ít nhất một lần.

Cụ thể, các câu lệnh `return` sau đều đã được kiểm thử:

| Câu lệnh | Test case phủ |
|---|---|
| `return "Invalid"` | TC1, TC2, TC3 |
| `return "Not a triangle"` | TC4, TC5, TC6 |
| `return "Equilateral"` | TC7 |
| `return "Isosceles"` | TC8, TC9, TC10 |
| `return "Scalene"` | TC11 |

Do không có câu lệnh nào bị bỏ qua, Statement Coverage đạt 100%.

---

## 9. Phân tích kết quả Branch Coverage

Bộ test đạt 100% Branch Coverage vì tất cả các nhánh True và False của các điều kiện trong chương trình đều được kiểm thử.

Các điều kiện chính gồm:

| Điều kiện | Nhánh True | Nhánh False |
|---|---|---|
| `a <= 0 \|\| b <= 0 \|\| c <= 0` | Có | Có |
| `a + b <= c \|\| a + c <= b \|\| b + c <= a` | Có | Có |
| `a == b && b == c` | Có | Có |
| `a == b \|\| b == c \|\| a == c` | Có | Có |

Ngoài các nhánh chính, JaCoCo còn tính các điều kiện con trong biểu thức logic `||` và `&&`. Vì vậy, bộ test đã bổ sung các trường hợp riêng để phủ:

| Điều kiện con | Test case phủ |
|---|---|
| `a <= 0` | TC1 |
| `b <= 0` | TC2 |
| `c <= 0` | TC3 |
| `a + b <= c` | TC4 |
| `a + c <= b` | TC5 |
| `b + c <= a` | TC6 |
| `a == b && b == c` | TC7 |
| `a == b` | TC8 |
| `b == c` | TC9 |
| `a == c` | TC10 |
| Không có cạnh nào bằng nhau | TC11 |

Nhờ đó, Branch Coverage đạt 100%.

---

## 10. Giải thích vì sao bộ test đạt 100% coverage

Bộ test đạt 100% Statement Coverage vì đã thực thi đầy đủ tất cả các câu lệnh trả về kết quả của phương thức `classify`.

Bộ test đạt 100% Branch Coverage vì đã bao phủ đầy đủ:

1. Trường hợp dữ liệu không hợp lệ.
2. Trường hợp không phải tam giác.
3. Trường hợp tam giác đều.
4. Trường hợp tam giác cân.
5. Trường hợp tam giác thường.
6. Các nhánh True/False của từng câu lệnh điều kiện.
7. Các điều kiện con trong biểu thức logic `||` và `&&`.

Vì vậy, kết quả JaCoCo cho thấy:

```text
Statement/Instruction Coverage = 100%
Branch Coverage = 100%
```

---

## 11. Đề xuất bổ sung test case

Với bộ test hiện tại, kết quả JaCoCo cho thấy Statement Coverage và Branch Coverage đều đạt 100%, do đó không cần bổ sung thêm test case để cải thiện coverage.

Tuy nhiên, nếu chỉ dùng 5 test case chính từ Lab 4, Branch Coverage theo JaCoCo có thể chưa đạt 100% vì chưa bao phủ đầy đủ các điều kiện con trong các biểu thức logic `||` và `&&`.

Do đó, các test case bổ sung đã được thêm vào:

| Test case bổ sung | Input | Expected output | Lý do bổ sung |
|---|---|---|---|
| TC2 | `classify(3, 0, 4)` | `Invalid` | Phủ điều kiện con `b <= 0` |
| TC3 | `classify(3, 4, 0)` | `Invalid` | Phủ điều kiện con `c <= 0` |
| TC5 | `classify(1, 3, 1)` | `Not a triangle` | Phủ điều kiện con `a + c <= b` |
| TC6 | `classify(3, 1, 1)` | `Not a triangle` | Phủ điều kiện con `b + c <= a` |
| TC9 | `classify(2, 3, 3)` | `Isosceles` | Phủ trường hợp `b == c` |
| TC10 | `classify(3, 2, 3)` | `Isosceles` | Phủ trường hợp `a == c` |

Sau khi bổ sung các test case trên, bộ test đạt đầy đủ 100% Statement Coverage và 100% Branch Coverage.

---

## 12. Minh chứng kết quả kiểm thử

### Hình 1. Kết quả chạy test bằng Maven/JUnit

![Kết quả Maven test](images/maven-test-success.png)

### Hình 2. Báo cáo JaCoCo đạt 100% coverage

![Báo cáo JaCoCo 100% Coverage](images/jacoco-coverage.png)

---

## 13. Kết luận

Lab 5 đã thực hiện unit test cho phương thức `classify` của chương trình Java `Triangle` bằng JUnit 5.

Kết quả chạy kiểm thử cho thấy toàn bộ 12 test case đều thành công. Kết quả đo coverage bằng JaCoCo cho thấy chương trình đạt:

- 100% Statement Coverage.
- 100% Branch Coverage.
- 100% Line Coverage.
- 100% Method Coverage.
- 100% Class Coverage.

Vì vậy, bộ test case đáp ứng đầy đủ yêu cầu của Lab 5.