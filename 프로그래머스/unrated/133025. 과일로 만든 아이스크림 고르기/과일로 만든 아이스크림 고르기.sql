-- 코드를 입력하세요
SELECT F.FLAVOR FROM FIRST_HALF F,ICECREAM_INFO I WHERE F.FLAVOR = I.FLAVOR AND F.TOTAL_ORDER >= 3000 AND I.INGREDIENT_TYPE = "fruit_based" ORDER BY F.TOTAL_ORDER DESC; 