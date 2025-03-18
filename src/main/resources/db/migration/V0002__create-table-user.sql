CREATE TABLE IF NOT EXISTS tbl_user(
    user_id BIGSERIAL primary key,
    username varchar(255) NOT NULL UNIQUE,
    "password" varchar(255) NOT NULL,
    role_id  integer,
    CONSTRAINT fk_userid_roleid
        FOREIGN KEY (role_id)
            REFERENCES tbl_role(role_id)
                ON DELETE CASCADE
                ON UPDATE CASCADE
);