-- DDL
create DATABASE gongcheck DEFAULT CHARACTER SET = 'utf8mb4';
use gongcheck;

-- 회원
create table members(
    member_idx              int AUTO_INCREMENT  not null comment '회원 index',
    member_id               varchar(30) unique  not null comment '회원 id',
    member_nickname         varchar(30) unique  not null comment '회원 닉네임',
    member_regdate          date DEFAULT now()           comment '회원가입 날짜',
    member_email            varchar(50)         not null comment '회원 이메일',
    member_image_path       varchar(255)        null     comment '회원 프로필 사진',
    member_zonecode         varchar(30)         not null comment '우편번호',
    member_address          text                not null comment '도로명 주소',
    member_address_detailed text                not null comment '상세 주소',
    PRIMARY KEY (member_idx)
);

-- 회원 비밀번호
create table password_members(
    password_member_idx int             not null AUTO_INCREMENT COMMENT '회원 비밀번호 index',
    member_idx          int             not null                COMMENT '회원 index',
    password_member     varchar(128)    not null                COMMENT '비밀번호',
    PRIMARY KEY (password_member_idx),
    FOREIGN KEY (member_idx) REFERENCES members (member_idx) on delete cascade on update cascade
);

-- 관리자
CREATE TABLE admins (
    admin_idx   INT                 NOT NULL AUTO_INCREMENT COMMENT '관리자 index',
    admin_id    VARCHAR(12) UNIQUE  NOT NULL                COMMENT '관리자 id',
    PRIMARY KEY (admin_idx)
);

-- 관리자 비밀번호
CREATE TABLE password_admins (
    password_admin_idx  INT             NOT NULL AUTO_INCREMENT COMMENT '관리자 비밀번호 index',
    admin_idx           INT             NOT NULL                COMMENT '관리자 index',
    password_admin      VARCHAR(128)    NOT NULL                COMMENT '비밀번호',
    PRIMARY KEY (password_admin_idx),
    FOREIGN KEY (admin_idx) REFERENCES admins(admin_idx) on update CASCADE on delete CASCADE
);

-- 게시판
create table boards(
    board_idx           INT NOT NULL AUTO_INCREMENT COMMENT '게시판 index',
    board_description   varchar(100)                COMMENT '게시판 설명',
    PRIMARY KEY (board_idx)
);

-- 공부 인증 게시판의 게시물
CREATE TABLE posts (
    post_idx            INT             NOT NULL AUTO_INCREMENT COMMENT '공부인증 게시물 index',
    board_idx           INT             NOT NULL COMMENT '게시판 index',
    post_title          VARCHAR(100)    NOT NULL COMMENT '제목',
    post_content        TEXT            NOT NULL COMMENT '내용',
    member_idx          INT             NOT NULL COMMENT '작성자 회원 index',
    post_likecount      INT DEFAULT 0           COMMENT '좋아요 수',
    post_write_date     DATE DEFAULT NOW()      COMMENT '작성일시',
    post_update_date    DATE            NULL    COMMENT '수정일시',
    post_visitcount     INT DEFAULT 0           COMMENT '조회수',
    PRIMARY KEY (post_idx),
    FOREIGN KEY (board_idx)     REFERENCES boards(board_idx)    on update CASCADE on delete CASCADE,
    FOREIGN KEY (member_idx)    REFERENCES members(member_idx)  on update CASCADE on delete CASCADE
);

-- 공지 게시판의 게시물
Create TABLE notices (
    notice_idx          INT             NOT NULL AUTO_INCREMENT COMMENT '공지 게시물 index',
    board_idx           INT             NOT NULL COMMENT '게시판 index',
    notice_title        VARCHAR(100)    NOT NULL COMMENT '제목',
    notice_content      TEXT            NOT NULL COMMENT '내용',
    admin_idx           INT             NOT NULL COMMENT '작성자 관리자 index',
    notice_write_date   DATE DEFAULT NOW()       COMMENT '작성일시',
    notice_update_date  DATE            NULL     COMMENT '수정일시',
    notice_visitcount   INT  DEFAULT 0           COMMENT '조회수',
    PRIMARY KEY (notice_idx),
    FOREIGN KEY (board_idx) REFERENCES boards(board_idx) on update CASCADE on delete CASCADE,
    FOREIGN KEY (admin_idx) REFERENCES admins(admin_idx) on update CASCADE on delete CASCADE
);

-- 공부 인증 게시판 게시물에 첨부되는 이미지
create table post_images(
    post_image_idx      int     NOT NULL    AUTO_INCREMENT  comment '이미지 index',
    post_idx            int     not null                    comment '게시물 index',
    post_image_path     text    not null                    comment '이미지 저장 경로',
    post_t_image_path   text                                comment '썸네일 이미지 저장 경로',
    PRIMARY KEY (post_image_idx),
    FOREIGN KEY (post_idx) REFERENCES posts(post_idx) on delete cascade on update cascade
);

-- 공부 인증 게시판 게시물의 댓글
CREATE TABLE replies (
    reply_idx               INT     AUTO_INCREMENT      COMMENT '댓글 인덱스번호',
    post_idx                INT     NOT NULL            COMMENT '게시물 index',
    reply_content           TEXT    NOT NULL            COMMENT '댓글 내용',
    member_idx              INT     NOT NULL            COMMENT '작성자 index',
    reply_write_date        DATE    DEFAULT now()       COMMENT '댓글 작성일시',
    reply_update_date       DATE    NULL                COMMENT '댓글 수정일시',
    reply_parent_no         INT     NOT NULL DEFAULT 0  COMMENT '댓글 부모번호(원댓글)',
    reply_depth_no          INT     NOT NULL DEFAULT 0  COMMENT '계층',
    reply_orderid           INT     NOT NULL            COMMENT '같은 그룹 정렬',
    PRIMARY KEY (reply_idx),
    FOREIGN KEY (post_idx)      REFERENCES posts(post_idx)      on delete cascade on update cascade,
    FOREIGN KEY (member_idx)    REFERENCES members(member_idx)  on delete cascade on update cascade
);

CREATE TABLE likes(
    post_idx	INT	 NOT NULL	 COMMENT '게시글IDX',
    member_idx	INT	 NOT NULL	 COMMENT '회원IDX',
    CONSTRAINT likes_PK PRIMARY KEY (post_idx, member_idx)
);


ALTER TABLE likes
ADD CONSTRAINT FK_post_idx FOREIGN KEY (post_idx) REFERENCES posts(post_idx) on delete cascade on update cascade;
ALTER TABLE likes
ADD CONSTRAINT FK_member_idx FOREIGN KEY (member_idx) REFERENCES members(member_idx) on delete cascade on update cascade;

-- drop TABLE
/*
drop table likes;
drop table replies;
drop table post_images;
drop table notices;
drop table posts;
drop table boards;
drop table password_admins;
drop table admins;
drop table password_members;
drop table members;
*/
