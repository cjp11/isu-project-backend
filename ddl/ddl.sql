DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
                          `id`	bigint	NOT NULL,
                          `member_id`	VARCHAR(100)	NULL,
                          `name`	VARCHAR(200)	NULL,
                          `password`	VARCHAR(200)	NULL,
                          `email`	VARCHAR(200)	NULL,
                          `register_type`	VARCHAR(100)	NULL,
                          `birth_date`	DATE	NULL,
                          `gender`	char(1)	NULL,
                          `address`	VARCHAR(200)	NULL,
                          `delete_yn`	char(1)	NULL
);

DROP TABLE IF EXISTS `homepage`;

CREATE TABLE `homepage` (
                            `id`	bigint	NOT NULL,
                            `member_id`	bigint	NOT NULL,
                            `name`	varchar(200)	NULL,
                            `nickname`	varchar(200)	NULL,
                            `profile_image`	varchar(200)	NULL,
                            `introduce`	varchar(500)	NULL,
                            `theme`	varchar(50)	NULL,
                            `wheather`	char(1)	NULL
);

DROP TABLE IF EXISTS `content`;

CREATE TABLE `content` (
                           `id`	bigint	NOT NULL,
                           `category_id`	bigint	NOT NULL,
                           `member_id`	bigint	NOT NULL,
                           `title`	varchar(200)	NULL,
                           `text`	longtext	NULL,
                           `create_datetime`	datetime	NULL,
                           `update_datetime`	datetime	NULL,
                           `view_count`	bigint	NULL,
                           `delete_yn`	char(1)	NULL
);

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
                            `id`	bigint	NOT NULL,
                            `homepage_id`	bigint	NOT NULL,
                            `name`	varchar(200)	NULL,
                            `create_time`	datetime	NULL,
                            `delete_yn`	char(1)	NULL
);

DROP TABLE IF EXISTS `content_heart`;

CREATE TABLE `content_heart` (
                                 `content_id`	bigint	NOT NULL,
                                 `member_id`	bigint	NOT NULL,
                                 `create_datetime`	datetime	NULL
);

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
                         `id`	bigint	NOT NULL,
                         `board_id`	bigint	NOT NULL,
                         `member_id`	bigint	NOT NULL,
                         `reply_content`	varchar(200)	NULL,
                         `create_datetime`	datetime	NULL,
                         `update_datetime`	datetime	NULL,
                         `delete_yn`	char(1)	NULL,
                         `reply_id`	bigint	NULL,
                         `reply_order`	bigint	NULL,
                         `reply_dept`	bigint	NULL
);

DROP TABLE IF EXISTS `reply_heart`;

CREATE TABLE `reply_heart` (
                               `id`	bigint	NOT NULL,
                               `reply_id`	bigint	NOT NULL,
                               `member_id`	bigint	NOT NULL,
                               `create_datetime`	datetime	NULL
);

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
                        `id`	bigint	NOT NULL,
                        `name`	varchar(200)	NULL,
                        `path`	varchar(500)	NULL,
                        `type`	varchar(50)	NULL,
                        `org_name`	varchar(200)	NULL,
                        `create_datetime`	datetime	NULL,
                        `update_datetime`	datetime	NULL,
                        `member_id`	bigint	NULL,
                        `delete_yn`	char(1)	NULL
);

DROP TABLE IF EXISTS `content_file`;

CREATE TABLE `content_file` (
                                `content_id`	bigint	NOT NULL,
                                `file_id`	bigint	NOT NULL,
                                `thumbnail`	char(1)	NULL
);

DROP TABLE IF EXISTS `visitcount`;

CREATE TABLE `visitcount` (
                              `id`	bigint	NOT NULL,
                              `homepage_id`	bigint	NOT NULL,
                              `member_id`	bigint	NOT NULL,
                              `create_datetime`	datetime	NULL
);

DROP TABLE IF EXISTS `follow`;

CREATE TABLE `follow` (
                          `following_id`	bigint	NOT NULL,
                          `follower_id`	bigint	NOT NULL,
                          `create_datetime`	datetime	NULL
);

DROP TABLE IF EXISTS `guestbook`;

CREATE TABLE `guestbook` (
                             `id`	bigint	NOT NULL,
                             `homepage_id`	bigint	NOT NULL,
                             `member_id`	bigint	NOT NULL,
                             `text`	text	NULL,
                             `create_datetime`	datetime	NULL,
                             `delete_yn`	char(1)	NULL
);

DROP TABLE IF EXISTS `music`;

CREATE TABLE `music` (
                         `id`	bigint	NOT NULL,
                         `homepage_id`	bigint	NOT NULL,
                         `name`	varchar(200)	NULL,
                         `link`	varchar(500)	NULL,
                         `create_datetime`	datetime	NULL,
                         `delete_yn`	char(1)	NULL
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
                                                             `id`
    );

ALTER TABLE `homepage` ADD CONSTRAINT `PK_HOMEPAGE` PRIMARY KEY (
                                                                 `id`
    );

ALTER TABLE `content` ADD CONSTRAINT `PK_CONTENT` PRIMARY KEY (
                                                               `id`
    );

ALTER TABLE `category` ADD CONSTRAINT `PK_CATEGORY` PRIMARY KEY (
                                                                 `id`
    );

ALTER TABLE `content_heart` ADD CONSTRAINT `PK_CONTENT_HEART` PRIMARY KEY (
                                                                           `content_id`
    );

ALTER TABLE `reply` ADD CONSTRAINT `PK_REPLY` PRIMARY KEY (
                                                           `id`
    );

ALTER TABLE `reply_heart` ADD CONSTRAINT `PK_REPLY_HEART` PRIMARY KEY (
                                                                       `id`
    );

ALTER TABLE `file` ADD CONSTRAINT `PK_FILE` PRIMARY KEY (
                                                         `id`
    );

ALTER TABLE `visitcount` ADD CONSTRAINT `PK_VISITCOUNT` PRIMARY KEY (
                                                                     `id`
    );

ALTER TABLE `guestbook` ADD CONSTRAINT `PK_GUESTBOOK` PRIMARY KEY (
                                                                   `id`
    );

ALTER TABLE `music` ADD CONSTRAINT `PK_MUSIC` PRIMARY KEY (
                                                           `id`
    );

ALTER TABLE `homepage` ADD CONSTRAINT `FK_member_TO_homepage_1` FOREIGN KEY (
                                                                             `member_id`
    )
    REFERENCES `member` (
                         `id`
        );

ALTER TABLE `content` ADD CONSTRAINT `FK_category_TO_content_1` FOREIGN KEY (
                                                                             `category_id`
    )
    REFERENCES `category` (
                           `id`
        );

ALTER TABLE `content` ADD CONSTRAINT `FK_member_TO_content_1` FOREIGN KEY (
                                                                           `member_id`
    )
    REFERENCES `member` (
                         `id`
        );

ALTER TABLE `category` ADD CONSTRAINT `FK_homepage_TO_category_1` FOREIGN KEY (
                                                                               `homepage_id`
    )
    REFERENCES `homepage` (
                           `id`
        );

ALTER TABLE `content_heart` ADD CONSTRAINT `FK_member_TO_content_heart_1` FOREIGN KEY (
                                                                                       `member_id`
    )
    REFERENCES `member` (
                         `id`
        );

ALTER TABLE `reply` ADD CONSTRAINT `FK_content_TO_reply_1` FOREIGN KEY (
                                                                        `board_id`
    )
    REFERENCES `content` (
                          `id`
        );

ALTER TABLE `reply` ADD CONSTRAINT `FK_member_TO_reply_1` FOREIGN KEY (
                                                                       `member_id`
    )
    REFERENCES `member` (
                         `id`
        );

ALTER TABLE `reply_heart` ADD CONSTRAINT `FK_reply_TO_reply_heart_1` FOREIGN KEY (
                                                                                  `reply_id`
    )
    REFERENCES `reply` (
                        `id`
        );

ALTER TABLE `reply_heart` ADD CONSTRAINT `FK_member_TO_reply_heart_1` FOREIGN KEY (
                                                                                   `member_id`
    )
    REFERENCES `member` (
                         `id`
        );

ALTER TABLE `content_file` ADD CONSTRAINT `FK_content_TO_content_file_1` FOREIGN KEY (
                                                                                      `content_id`
    )
    REFERENCES `content` (
                          `id`
        );

ALTER TABLE `content_file` ADD CONSTRAINT `FK_file_TO_content_file_1` FOREIGN KEY (
                                                                                   `file_id`
    )
    REFERENCES `file` (
                       `id`
        );

ALTER TABLE `visitcount` ADD CONSTRAINT `FK_homepage_TO_visitcount_1` FOREIGN KEY (
                                                                                   `homepage_id`
    )
    REFERENCES `homepage` (
                           `id`
        );

ALTER TABLE `visitcount` ADD CONSTRAINT `FK_member_TO_visitcount_1` FOREIGN KEY (
                                                                                 `member_id`
    )
    REFERENCES `member` (
                         `id`
        );

ALTER TABLE `follow` ADD CONSTRAINT `FK_member_TO_follow_1` FOREIGN KEY (
                                                                         `following_id`
    )
    REFERENCES `member` (
                         `id`
        );

ALTER TABLE `follow` ADD CONSTRAINT `FK_member_TO_follow_2` FOREIGN KEY (
                                                                         `follower_id`
    )
    REFERENCES `member` (
                         `id`
        );

ALTER TABLE `guestbook` ADD CONSTRAINT `FK_homepage_TO_guestbook_1` FOREIGN KEY (
                                                                                 `homepage_id`
    )
    REFERENCES `homepage` (
                           `id`
        );

ALTER TABLE `guestbook` ADD CONSTRAINT `FK_member_TO_guestbook_1` FOREIGN KEY (
                                                                               `member_id`
    )
    REFERENCES `member` (
                         `id`
        );

ALTER TABLE `music` ADD CONSTRAINT `FK_homepage_TO_music_1` FOREIGN KEY (
                                                                         `homepage_id`
    )
    REFERENCES `homepage` (
                           `id`
        );

