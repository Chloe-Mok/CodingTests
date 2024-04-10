-- 정확한 수치가 필요할 경우 인라인뷰
--       SELECT
--              HF.FLAVOR,
--              HF.TOTAL_ORDER + SUM(JUL.TOTAL_ORDER) "TOTAL_ORDER"
--         FROM
--              FIRST_HALF HF
--         JOIN
--              JULY JUL ON (HF.FLAVOR = JUL.FLAVOR)
--        GROUP
--           BY
--              HF.FLAVOR,
--              HF.TOTAL_ORDER;


-- 정확한 TOTAL_ORDER일 필요 없음
-- => HF.TOTAL_ORDER 중복되어 더해져도 순위만 확인하면 됨
-- SELECT FLAVOR
--   FROM
--        (
--        SELECT
--               HF.FLAVOR,
--               RANK() OVER (ORDER BY (SUM(HF.TOTAL_ORDER + JUL.TOTAL_ORDER)) DESC) RANK
--          FROM
--               FIRST_HALF HF
--          JOIN
--               JULY JUL ON (HF.FLAVOR = JUL.FLAVOR)
--         GROUP
--            BY
--               HF.FLAVOR
--        )
--  WHERE
--        RANK < 4
--  ORDER
--     BY
--        RANK ASC;


-- 오라클 12c부터 FETCH문법
-- ORDER BY한 결과에서 데이터를 선택해 가져옴(오프셋도 설정 가능)
SELECT
      HF.FLAVOR
 FROM
      FIRST_HALF HF
 JOIN
      JULY JUL ON (HF.FLAVOR = JUL.FLAVOR)
GROUP
   BY
      HF.FLAVOR
ORDER
   BY
      SUM(HF.TOTAL_ORDER + JUL.TOTAL_ORDER) DESC
FETCH
      FIRST 3 ROWS ONLY;
