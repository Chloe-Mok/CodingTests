-- 코드를 입력하세요
SELECT FLAVOR
  FROM
       (
       SELECT
              JUL.FLAVOR FLAVOR,
              RANK() OVER(ORDER BY (HF.TOTAL_ORDER + SUM(JUL.TOTAL_ORDER)) DESC) RANK
         FROM
              JULY JUL
         JOIN
              FIRST_HALF HF ON (JUL.FLAVOR = HF.FLAVOR)
        GROUP
           BY
              JUL.FLAVOR, HF.TOTAL_ORDER
       )
 WHERE
       RANK < 4
 ORDER
    BY
       RANK ASC
;
