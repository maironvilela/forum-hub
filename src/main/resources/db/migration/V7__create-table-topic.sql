CREATE TABLE topics(
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    message VARCHAR(100) NOT NULL,
    author_id BIGINT NOT NULL,
    courser_id BIGINT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES users(id),
    FOREIGN KEY (courser_id) REFERENCES courses(id)
)