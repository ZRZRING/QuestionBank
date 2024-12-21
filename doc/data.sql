-- admin
-- 管理员
CREATE TABLE admin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- teacher
-- 老师
CREATE TABLE teacher (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- student
-- 学生
CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- question
-- 题目
CREATE TABLE question (
    id INT AUTO_INCREMENT PRIMARY KEY,
    statement TEXT NOT NULL,
    options TEXT NOT NULL,
    answers VARCHAR(100) NOT NULL,
    created_by INT NOT NULL,
    FOREIGN KEY (created_by) REFERENCES teacher(id) ON DELETE CASCADE
);

-- bank
-- 题库
CREATE TABLE bank (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    description TEXT,
    created_by INT NOT NULL,
    FOREIGN KEY (created_by) REFERENCES teacher(id) ON DELETE CASCADE
);

-- bank question
-- 题库具有的题目
CREATE TABLE bank_question (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bank_id INT NOT NULL,
    question_id INT NOT NULL,
    FOREIGN KEY (bank_id) REFERENCES bank(id) ON DELETE CASCADE,
    FOREIGN KEY (question_id) REFERENCES question(id) ON DELETE CASCADE
);

-- student bank
-- 学生拥有的题库
CREATE TABLE student_bank (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    bank_id INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE,
    FOREIGN KEY (bank_id) REFERENCES bank(id) ON DELETE CASCADE,
    UNIQUE (student_id, bank_id)
);