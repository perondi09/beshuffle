CREATE TABLE dayalbum
(
    id           UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    artist       VARCHAR(255) NOT NULL,
    url_cover    VARCHAR(255) NOT NULL,
    resume       VARCHAR(255) NOT NULL,
    display_date date NOT NULL
);