CREATE TABLE pais (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE producto (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    precio REAL        NOT NULL,
    img TEXT,
    descripcion TEXT,
    PRIMARY KEY (id)
);

