-- 코드를 입력하세요
-- 여러개 사면 n번 장바구니에 vege, vege처럼 2행 데이터 들어감(수량 컬럼 x)
-- 286 448 578 977 1048
SELECT
       CART_ID
  FROM
       CART_PRODUCTS
 WHERE
       NAME IN ('Milk', 'Yogurt')
 GROUP
    BY
       CART_ID
HAVING
       1 < COUNT(DISTINCT(NAME))
ORDER
  BY
     CART_ID ASC;


