# 基于spring-boot的选择题题库管理系统

### 功能设计：

用户：

admin、teacher、student

admin：管理学生，管理教师

teacher：管理题目，管理题库

student：加入题库，题目联系

### 数据库设计：

admin表、teacher表、student表、题目表、题库表

题目-题库表、student-题库表、教师-题库表

```sql
-- admin
CREATE TABLE admin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- teacher
CREATE TABLE teacher (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- student
CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- question
CREATE TABLE question (
    id INT AUTO_INCREMENT PRIMARY KEY,
    statement TEXT NOT NULL,
    'option' TEXT NOT NULL,
    answer VARCHAR(100) NOT NULL
);

-- bank
CREATE TABLE bank (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    created_by INT NOT NULL,
    FOREIGN KEY (created_by) REFERENCES teacher(id) ON DELETE CASCADE
);

-- bank - question
CREATE TABLE bank_question (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bank_id INT NOT NULL,
    question_id INT NOT NULL,
    order_number INT NOT NULL,
    FOREIGN KEY (question_id) REFERENCES question(id) ON DELETE CASCADE,
    FOREIGN KEY (bank_id) REFERENCES bank(id) ON DELETE CASCADE,
    UNIQUE (bank_id, question_id)
);

CREATE TABLE student_bank (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    bank_id INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE,
    FOREIGN KEY (bank_id) REFERENCES bank(id) ON DELETE CASCADE,
    UNIQUE (student_id, bank_id)
);

CREATE TABLE teacher_bank (
    id INT AUTO_INCREMENT PRIMARY KEY,
    teacher_id INT NOT NULL,
    bank_id INT NOT NULL,
    FOREIGN KEY (teacher_id) REFERENCES teacher(id) ON DELETE CASCADE,
    FOREIGN KEY (bank_id) REFERENCES bank(id) ON DELETE CASCADE,
    UNIQUE (teacher_id, bank_id)
);
```


#### student
申请题库: 依据数据库中的密码进行核对申请

对已经通过申请的题库，student 可以 进行查询和删除操作

刷题部分: student 点击某个题库进入该题库的主页面，题目按分页进行显示，学是可以点击
某个题目开始进行刷题，也可以点击特定按钮从该题库上一次结束的位置进行开始，若上次该学生将该题库中的所有
题目刷完，则从第一个题目开始
刷题期间: 当学生进入题目页面，学生可以进行作答并比较答案,题目界面有三个按钮,分别可以返回
上一层页面，跳转到下一题和跳转到上一题