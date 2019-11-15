create table User
(
    id       int auto_increment
        primary key,
    username varchar(20)  null,
    password varchar(100) null,
    role_id  int          null
);

INSERT INTO blog.User (id, username, password, role_id) VALUES (1, 'zhangsan', '123456', null);
create table article
(
    id            int auto_increment
        primary key,
    title         varchar(100) null,
    crt_date      datetime     null,
    source_name   varchar(50)  null,
    source_url    varchar(100) null,
    view_count    int          null,
    body          text         null,
    short_text    text         null,
    comment_count int          null,
    cover_img     varchar(100) null
);

INSERT INTO blog.article (id, title, crt_date, source_name, source_url, view_count, body, short_text, comment_count, cover_img) VALUES (1, '1', '2019-11-05 19:01:38', 'asds', 'sadasd', 1, 'asdsad', 'asdasdsa', 1, 'asdsad');
INSERT INTO blog.article (id, title, crt_date, source_name, source_url, view_count, body, short_text, comment_count, cover_img) VALUES (2, '2', null, null, null, null, null, null, null, null);
INSERT INTO blog.article (id, title, crt_date, source_name, source_url, view_count, body, short_text, comment_count, cover_img) VALUES (3, '3', null, null, null, null, null, null, null, null);
INSERT INTO blog.article (id, title, crt_date, source_name, source_url, view_count, body, short_text, comment_count, cover_img) VALUES (4, '4', null, null, null, null, null, null, null, null);
INSERT INTO blog.article (id, title, crt_date, source_name, source_url, view_count, body, short_text, comment_count, cover_img) VALUES (5, '5', null, null, null, null, null, null, null, null);
INSERT INTO blog.article (id, title, crt_date, source_name, source_url, view_count, body, short_text, comment_count, cover_img) VALUES (6, '6', null, null, null, null, null, null, null, null);
INSERT INTO blog.article (id, title, crt_date, source_name, source_url, view_count, body, short_text, comment_count, cover_img) VALUES (7, '7', null, null, null, null, null, null, null, null);
INSERT INTO blog.article (id, title, crt_date, source_name, source_url, view_count, body, short_text, comment_count, cover_img) VALUES (8, '8', null, null, null, null, null, null, null, null);
INSERT INTO blog.article (id, title, crt_date, source_name, source_url, view_count, body, short_text, comment_count, cover_img) VALUES (9, '9', null, null, null, null, null, null, null, null);
INSERT INTO blog.article (id, title, crt_date, source_name, source_url, view_count, body, short_text, comment_count, cover_img) VALUES (10, '10', null, null, null, null, null, null, null, null);
INSERT INTO blog.article (id, title, crt_date, source_name, source_url, view_count, body, short_text, comment_count, cover_img) VALUES (11, '11', null, null, null, null, null, null, null, null);
INSERT INTO blog.article (id, title, crt_date, source_name, source_url, view_count, body, short_text, comment_count, cover_img) VALUES (12, '12', null, null, null, null, null, null, null, null);
INSERT INTO blog.article (id, title, crt_date, source_name, source_url, view_count, body, short_text, comment_count, cover_img) VALUES (13, '13', null, null, null, null, null, null, null, null);
INSERT INTO blog.article (id, title, crt_date, source_name, source_url, view_count, body, short_text, comment_count, cover_img) VALUES (14, '14', null, null, null, null, null, null, null, null);
INSERT INTO blog.article (id, title, crt_date, source_name, source_url, view_count, body, short_text, comment_count, cover_img) VALUES (15, '15', null, null, null, null, null, null, null, null);
create table article_comment
(
    article_id   int          null,
    author_area  varchar(100) null,
    author_name  varchar(100) null,
    content      varchar(200) null,
    comment_time datetime     null
);


create table article_label
(
    label_id   int         null,
    article_id int         null,
    label_name varchar(50) null,
    constraint article_label_article_id_fk
        foreign key (article_id) references article (id),
    constraint article_label_label_label_id_fk
        foreign key (label_id) references label (label_id)
);

INSERT INTO blog.article_label (label_id, article_id, label_name) VALUES (1, 1, '前端');
INSERT INTO blog.article_label (label_id, article_id, label_name) VALUES (2, 1, '后端');
INSERT INTO blog.article_label (label_id, article_id, label_name) VALUES (1, 2, '前端');
INSERT INTO blog.article_label (label_id, article_id, label_name) VALUES (2, 2, '后端');
create table label
(
    label_id   int auto_increment
        primary key,
    label_name varchar(50) not null
);

INSERT INTO blog.label (label_id, label_name) VALUES (1, '前端');
INSERT INTO blog.label (label_id, label_name) VALUES (2, '后端');