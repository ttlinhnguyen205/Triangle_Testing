# BÁO CÁO KIỂM THỬ CHƯƠNG TRÌNH TRIANGLE

## 1. Mô tả chương trình

Chương trình `Triangle.classify(int a, int b, int c)` nhận vào ba số nguyên đại diện cho ba cạnh của một tam giác.

Chương trình trả về một trong năm kết quả:

- `Invalid`: nếu có cạnh nhỏ hơn hoặc bằng 0.
- `Not a triangle`: nếu ba cạnh không thỏa mãn bất đẳng thức tam giác.
- `Equilateral`: nếu ba cạnh bằng nhau.
- `Isosceles`: nếu có đúng hai cạnh bằng nhau.
- `Scalene`: nếu ba cạnh khác nhau.

---

## 2. Control Flow Graph — CFG

Đánh số các node trong chương trình:

- N1: Kiểm tra cạnh không hợp lệ  
  `a <= 0 || b <= 0 || c <= 0`

- N2: Trả về `"Invalid"`

- N3: Kiểm tra điều kiện không phải tam giác  
  `a + b <= c || a + c <= b || b + c <= a`

- N4: Trả về `"Not a triangle"`

- N5: Kiểm tra tam giác đều  
  `a == b && b == c`

- N6: Trả về `"Equilateral"`

- N7: Kiểm tra tam giác cân  
  `a == b || b == c || a == c`

- N8: Trả về `"Isosceles"`

- N9: Trường hợp còn lại

- N10: Trả về `"Scalene"`

CFG dạng text:

```text
        Start
          |
          v
   N1: a<=0 || b<=0 || c<=0 ?
       /                      \
    True                      False
     |                          |
     v                          v
N2: return Invalid       N3: a+b<=c || a+c<=b || b+c<=a ?
                              /                         \
                           True                         False
                            |                             |
                            v                             v
             N4: return Not a triangle        N5: a==b && b==c ?
                                                  /              \
                                               True              False
                                                |                  |
                                                v                  v
                              N6: return Equilateral     N7: a==b || b==c || a==c ?
                                                            /              \
                                                         True              False
                                                          |                  |
                                                          v                  v
                                          N8: return Isosceles     N10: return Scalene