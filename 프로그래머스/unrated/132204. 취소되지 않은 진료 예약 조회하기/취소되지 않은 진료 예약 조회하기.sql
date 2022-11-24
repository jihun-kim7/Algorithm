-- 코드를 입력하세요
-- SELECT APNT_NO,PT_NAME,qcsj_c000000000500000 AS PT_NO,C.MCDP_CD,DR_NAME,TO_CHAR(APNT_YMD,'yyyy-mm-dd hh24:mi:ss.FF6') APNT_YMD FROM (SELECT * FROM (SELECT * FROM APPOINTMENT  WHERE TO_CHAR(APNT_YMD,'yyyy-mm-dd') LIKE '2022-04-13%' AND APNT_CNCL_YN = 'N') A
-- INNER JOIN PATIENT B ON A.PT_NO = B.PT_NO) C INNER JOIN DOCTOR D ON C.MDDR_ID = D.DR_ID
-- ORDER BY APNT_YMD;

SELECT APNT_NO,PT_NAME,C.PT_NO,C.MCDP_CD,B.DR_NAME,APNT_YMD
  FROM PATIENT A, DOCTOR B, APPOINTMENT C
 WHERE A.PT_NO = C.PT_NO
   AND B.DR_ID = C.MDDR_ID
   AND C.APNT_CNCL_YN ='N'
   AND C.MCDP_CD = 'CS'
   AND TO_CHAR(C.APNT_YMD,'YYYYMMDD') = '20220413'
   ORDER BY APNT_YMD