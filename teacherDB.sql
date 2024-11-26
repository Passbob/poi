use teacher;

DROP TABLE IF EXISTS TEACHER CASCADE;

CREATE TABLE IF NOT EXISTS teacher
(
    TEACHER_NO    INT AUTO_INCREMENT PRIMARY KEY COMMENT '번호',
    TEACHER_NAME    VARCHAR(255) NOT NULL UNIQUE COMMENT '이름',
    TEACHER_PRICE    INT NOT NULL COMMENT '가격',
    CLASS_NAME    VARCHAR(50) NOT NULL COMMENT '클래스명'
    
    )ENGINE=INNODB COMMENT = '선생님';

insert into teacher values
	(1, "조형석", 20000, "건강한 몸 만들기"),
	(2, "류한솔", 30000, "귀여운 햄찌 그리기"),
	(3, "나정원", 25000, "범죄심리학"),
	(4, "정재성", 15000, "보험 설계의 끝"),
	(5, "송원호", 35000, "마음의 상처를 치유하는 법");