-- DML
use gongcheck;


-- members
select * from members;
insert into members(member_id, member_nickname, member_email, member_zonecode, member_address, member_address_detailed)
    VALUE('test', 'testNick', 'test@test.com', '08513', '서울 금천구 가산로9길 54', '1층');


-- password_members
select * from password_members;
insert into password_members(member_idx, password_member)
    VALUE(1, 'test');
update password_members set password_member = '2131c65705b65668c2fcfc356276d230d8deda4a6590c72c62d58ac4eb05cdfe'
where member_idx = 1;


-- admins
select * from admins;
insert into admins(admin_id) VALUE ('admin');


-- password_admins
select * from password_admins;
insert into password_admins(admin_idx, password_admin)
    VALUE (1, 'admin');


-- boards
select * from boards;
insert into boards(board_idx, board_description)
    VALUE (1, '공부 인증 게시판');
insert into boards(board_idx, board_description)
    VALUE (2, '공지 게시판');


-- posts
select * from posts;
insert into posts(board_idx, post_title, post_content, member_idx)
    VALUE (1, '공부 인증 게시물 1 제목', '공부 인증 게시물 1 내용', 1);
insert into posts(board_idx, post_title, post_content, member_idx)
    VALUE (1, '공부 인증 게시물 2 제목', '공부 인증 게시물 2 내용', 1);


-- notices
select * from notices;
insert into notices(board_idx, notice_title, notice_content, admin_idx)
    VALUE (2, '공지 게시물 1 제목', '공지 게시물 1 내용', 1);
insert into notices(board_idx, notice_title, notice_content, admin_idx)
    VALUE (2, '공지 게시물 2 제목', '공지 게시물 2 내용', 1);

-- post_images
select * from post_images;



-- replies
select * from replies;
insert into replies(post_idx, reply_content, member_idx, reply_orderid)
    value(1, '댓글 1 내용', 1, 0);


-- likes
select * from likes;
insert into likes(post_idx, member_idx) value (1, 1);