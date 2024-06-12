CREATE TABLE task
(
    id          int PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
    title       varchar(100)                                 NOT NULL,
    description varchar(200)                                 NOT NULL,
    status      varchar(35)                                  NOT NULL
);

SELECT *
FROM task;

SELECT *
FROM task
WHERE ID = ?;

INSERT INTO task(title, description, status)
VALUES (?, ?, ?);

UPDATE task
SET title       = ?,
    description = ?,
    status      = ?
WHERE id = ?;

UPDATE task
SET status = ?
WHERE id = ?;