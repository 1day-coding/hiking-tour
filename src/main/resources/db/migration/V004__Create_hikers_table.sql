DROP TABLE IF EXISTS hikers;

CREATE TABLE hikers (
  id IDENTITY PRIMARY KEY,
  booking_id INT NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(70) NOT NULL,
  age TINYINT NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
