DROP TABLE IF EXISTS TBL_CURRENCY_RATIOS;
 
CREATE TABLE Usuario (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  user_name VARCHAR(500) NOT NULL,
  encrypted_password VARCHAR(500) NOT NULL
);

CREATE TABLE Hero (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  nickname VARCHAR(500) NOT NULL,
  enabled bit NOT NULL default 0,
  creation_date datetime NOT NULL,
  created_by VARCHAR(120) NULL,
  update_date datetime NULL,
  updated_by VARCHAR(120) NULL
);
