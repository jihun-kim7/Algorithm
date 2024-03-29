-- 코드를 입력하세요

SELECT MEMBER_NAME,REVIEW_TEXT,TO_CHAR(REVIEW_DATE,'yyyy-mm-dd') REVIEW_DATE
FROM MEMBER_PROFILE A INNER JOIN REST_REVIEW B
ON A.MEMBER_ID = B.MEMBER_ID WHERE A.MEMBER_ID IN (SELECT MEMBER_ID FROM REST_REVIEW GROUP BY MEMBER_ID
                                 HAVING COUNT(*) =  (SELECT MAX(COUNT(*)) FROM REST_REVIEW GROUP BY MEMBER_ID))
ORDER BY REVIEW_DATE,REVIEW_TEXT;