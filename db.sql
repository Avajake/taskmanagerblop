--Пользователь (User):
--Поля: id, username, email, password, role.
--Связь с задачами: один ко многим (один пользователь может иметь несколько задач).

--Проект (Project):
--Поля: id, name, description, ownerId (владелец).
--Связь с задачами: один ко многим.

--Задача (Task):
--Поля: id, title, description, status, priority, deadline, projectId, assigneeId.
--Статусы: новая, в процессе, завершена.
--Приоритеты: низкий, средний, высокий.

--users и projects: один пользователь может быть владельцем нескольких проектов (связь один-ко-многим).
--projects и tasks: один проект может иметь множество задач (связь один-ко-многим).
--tasks и users: каждая задача может быть назначена одному пользователю (опционально, связь один-ко-многим).


CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL DEFAULT 'USER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE projects (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    owner_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (owner_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    status VARCHAR(20) NOT NULL DEFAULT 'new',  -- Статусы: new, in_progress, completed
    priority VARCHAR(20) NOT NULL DEFAULT 'medium',  -- Приоритеты: low, medium, high
    deadline DATE,
    project_id INT NOT NULL,
    assignee_id INT,  -- Пользователь, которому назначена задача
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE,
    FOREIGN KEY (assignee_id) REFERENCES users(id) ON DELETE SET NULL
);

CREATE INDEX idx_task_status ON tasks(status);
CREATE INDEX idx_task_priority ON tasks(priority);
CREATE INDEX idx_project_owner ON projects(owner_id);