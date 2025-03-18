CREATE TABLE IF NOT EXISTS tbl_task(
    task_id BIGSERIAL PRIMARY KEY,
    title varchar(255) not null,
    completion_date date,
    is_important boolean not null default 'f',
    is_urgent boolean not null default 'f',
    user_id bigint not null,
    CONSTRAINT fk_task_user
        FOREIGN KEY (user_id)
            REFERENCES tbl_user(user_id)
                ON DELETE CASCADE
                ON UPDATE CASCADE
    
);