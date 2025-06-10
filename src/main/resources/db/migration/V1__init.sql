-- V1__init.sql

-- Tabela de usuários
CREATE TABLE user_tb (
    user_id UUID PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    resume TEXT
);

-- Tabela de chats
CREATE TABLE chat_tb (
    chat_id UUID PRIMARY KEY,
    user_id_fk UUID NOT NULL,
    content TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user_chat FOREIGN KEY (user_id_fk) REFERENCES user_tb(user_id)
);
