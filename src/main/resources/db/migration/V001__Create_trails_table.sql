DROP TABLE IF EXISTS trails;

CREATE TABLE trails (
  id IDENTITY PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  start_time TIME NOT NULL,
  end_time TIME NOT NULL,
  min_age TINYINT NOT NULL,
  max_age TINYINT NOT NULL,
  price DECIMAL(13, 2) NOT NULL DEFAULT 0,
  currency ENUM('EUR') NOT NULL DEFAULT 'EUR',
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE UNIQUE INDEX idx_name ON trails(name);