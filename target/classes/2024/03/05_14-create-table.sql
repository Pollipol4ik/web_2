
-- Создание таблицы Role
CREATE table if not exists Role (
                      roleId SERIAL PRIMARY KEY,
                      name VARCHAR(30)
);

-- Создание таблицы User
CREATE table if not exists "User" (
                        userId SERIAL PRIMARY KEY,
                        login VARCHAR(60),
                        password VARCHAR(40),
                        name VARCHAR(120),
                        roleId INT,
                        FOREIGN KEY (roleId) REFERENCES Role(roleId)
);

-- Создание таблицы Status
CREATE table if not exists Status (
                        statusId SERIAL PRIMARY KEY,
                        name VARCHAR(30)
);

-- Создание таблицы Board
CREATE table if not exists Board (
                       boardId SERIAL PRIMARY KEY,
                       title VARCHAR(30)
);

-- Создание таблицы Card
CREATE table if not exists Card (
                      cardId SERIAL PRIMARY KEY,
                      description TEXT,
                      authorId INT,
                      assigneeId INT,
                      boardId INT,
                      statusId INT,
                      FOREIGN KEY (authorId) REFERENCES "User"(userId),
                      FOREIGN KEY (assigneeId) REFERENCES "User"(userId),
                      FOREIGN KEY (boardId) REFERENCES Board(boardId),
                      FOREIGN KEY (statusId) REFERENCES Status(statusId)
);


