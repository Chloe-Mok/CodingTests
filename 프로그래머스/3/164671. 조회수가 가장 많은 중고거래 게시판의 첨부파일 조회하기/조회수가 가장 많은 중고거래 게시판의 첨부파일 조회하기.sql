-- 코드를 입력하세요
-- 조회수가 가장 많은 게시글 BOARD_ID
-- SELECT BOARD_ID
--   FROM
--         (
--         SELECT
--                BOARD_ID
--           FROM
--                USED_GOODS_BOARD B
--          ORDER
--             BY
--                VIEWS DESC
--         )
-- WHERE ROWNUM = 1;

SELECT
       '/home/grep/src/' || BOARD_ID || '/' || FILE_ID || FILE_NAME || FILE_EXT AS "FILE_PATH"
  FROM
       USED_GOODS_FILE
 WHERE
       BOARD_ID = (
                  SELECT BOARD_ID
                    FROM
                         (
                         SELECT
                                BOARD_ID
                           FROM
                                USED_GOODS_BOARD B
                          ORDER
                             BY
                                VIEWS DESC
                         )
                   WHERE ROWNUM = 1
                  )
 ORDER
    BY
       FILE_ID DESC;