---

## 3. Cyclomatic Complexity

Cyclomatic Complexity được tính theo công thức:

```text
CC = số node quyết định + 1
```

Trong phương thức `classify`, có 4 node quyết định:

1. `if (a <= 0 || b <= 0 || c <= 0)`
2. `if (a + b <= c || a + c <= b || b + c <= a)`
3. `if (a == b && b == c)`
4. `else if (a == b || b == c || a == c)`

Vậy:

```text
CC = 4 + 1 = 5
```

Kết luận:

```text
Cyclomatic Complexity = 5
```

Điều này có nghĩa chương trình có tối thiểu 5 đường đi độc lập cần kiểm thử.

---

## 4. Các đường đi độc lập

Dựa trên Cyclomatic Complexity bằng 5, chương trình có 5 đường đi độc lập chính.

### Path 1: Invalid

```text
Start → N1(True) → N2
```

Ví dụ:

```text
classify(0, 3, 4) → Invalid
```

---

### Path 2: Not a triangle

```text
Start → N1(False) → N3(True) → N4
```

Ví dụ:

```text
classify(1, 2, 3) → Not a triangle
```

---

### Path 3: Equilateral

```text
Start → N1(False) → N3(False) → N5(True) → N6
```

Ví dụ:

```text
classify(3, 3, 3) → Equilateral
```

---

### Path 4: Isosceles

```text
Start → N1(False) → N3(False) → N5(False) → N7(True) → N8
```

Ví dụ:

```text
classify(3, 3, 2) → Isosceles
```

---

### Path 5: Scalene

```text
Start → N1(False) → N3(False) → N5(False) → N7(False) → N10
```

Ví dụ:

```text
classify(3, 4, 5) → Scalene
```

---

## 5. Thiết kế test case đạt 100% Statement Coverage

Statement Coverage yêu cầu mọi câu lệnh trong chương trình phải được thực thi ít nhất một lần.

Bộ test case chính:

| Test case | Input               | Expected output  | Mục đích                               |
| --------- | ------------------- | ---------------- | -------------------------------------- |
| TC1       | `classify(0, 3, 4)` | `Invalid`        | Phủ câu lệnh `return "Invalid"`        |
| TC2       | `classify(1, 2, 3)` | `Not a triangle` | Phủ câu lệnh `return "Not a triangle"` |
| TC3       | `classify(3, 3, 3)` | `Equilateral`    | Phủ câu lệnh `return "Equilateral"`    |
| TC4       | `classify(3, 3, 2)` | `Isosceles`      | Phủ câu lệnh `return "Isosceles"`      |
| TC5       | `classify(3, 4, 5)` | `Scalene`        | Phủ câu lệnh `return "Scalene"`        |

Kết luận:

```text
Bộ test case trên đạt 100% Statement Coverage vì tất cả các câu lệnh return đều được thực thi.
```

---

## 6. Thiết kế test case đạt 100% Branch Coverage

Branch Coverage yêu cầu mỗi nhánh rẽ của chương trình được kiểm tra cả hai hướng: True và False.

Các điều kiện cần phủ:

| Điều kiện          | True | False      |
| ------------------ | ---- | ---------- | --- | ----------- | --- | --- |
| `a <= 0            |      | b <= 0     |     | c <= 0`     | Có  | Có  |
| `a + b <= c        |      | a + c <= b |     | b + c <= a` | Có  | Có  |
| `a == b && b == c` | Có   | Có         |
| `a == b            |      | b == c     |     | a == c`     | Có  | Có  |

Bộ test case chính:

| Test case | Input               | Expected output  | Nhánh được phủ                          |
| --------- | ------------------- | ---------------- | --------------------------------------- |
| TC1       | `classify(0, 3, 4)` | `Invalid`        | Điều kiện 1 = True                      |
| TC2       | `classify(1, 2, 3)` | `Not a triangle` | Điều kiện 1 = False, điều kiện 2 = True |
| TC3       | `classify(3, 3, 3)` | `Equilateral`    | Điều kiện 2 = False, điều kiện 3 = True |
| TC4       | `classify(3, 3, 2)` | `Isosceles`      | Điều kiện 3 = False, điều kiện 4 = True |
| TC5       | `classify(3, 4, 5)` | `Scalene`        | Điều kiện 4 = False                     |

Ngoài 5 test case chính, bộ test được mở rộng thêm để bao phủ đầy đủ các điều kiện con trong các biểu thức logic `||` và `&&` theo công cụ JaCoCo.

Các test case mở rộng gồm:

| Test case | Input               | Expected output  | Mục đích                       |
| --------- | ------------------- | ---------------- | ------------------------------ |
| TC6       | `classify(3, 0, 4)` | `Invalid`        | Phủ điều kiện con `b <= 0`     |
| TC7       | `classify(3, 4, 0)` | `Invalid`        | Phủ điều kiện con `c <= 0`     |
| TC8       | `classify(1, 3, 1)` | `Not a triangle` | Phủ điều kiện con `a + c <= b` |
| TC9       | `classify(3, 1, 1)` | `Not a triangle` | Phủ điều kiện con `b + c <= a` |
| TC10      | `classify(2, 3, 3)` | `Isosceles`      | Phủ trường hợp `b == c`        |
| TC11      | `classify(3, 2, 3)` | `Isosceles`      | Phủ trường hợp `a == c`        |

Kết luận:

```text
Bộ test case đã bao phủ đầy đủ các nhánh rẽ và các điều kiện con trong chương trình, đạt 100% Branch Coverage.
```

---

## 7. Kết quả kiểm thử bằng JUnit và JaCoCo

Chương trình được kiểm thử bằng JUnit 5 và đo coverage bằng JaCoCo.

Kết quả chạy test bằng Maven:

```text
Tests run: 12, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

Kết quả JaCoCo:

| Loại coverage        | Kết quả |
| -------------------- | ------- |
| Instruction Coverage | 100%    |
| Branch Coverage      | 100%    |
| Line Coverage        | 100%    |
| Method Coverage      | 100%    |
| Class Coverage       | 100%    |

Cụ thể:

```text
Missed Instructions: 0 of 49
Missed Branches: 0 of 22
Missed Lines: 0 of 10
Missed Methods: 0 of 2
Missed Classes: 0 of 1
```

---

## 8. Kết luận

Phương thức `classify` có Cyclomatic Complexity bằng 5, tương ứng với 5 đường đi độc lập chính.

Bộ test case đã kiểm thử đầy đủ các trường hợp:

- Dữ liệu không hợp lệ.
- Không phải tam giác.
- Tam giác đều.
- Tam giác cân.
- Tam giác thường.

Kết quả kiểm thử bằng JUnit cho thấy toàn bộ test case đều chạy thành công. Kết quả JaCoCo cho thấy chương trình đạt 100% Statement Coverage và 100% Branch Coverage. Vì vậy, bài kiểm thử đáp ứng đầy đủ yêu cầu đề bài.
