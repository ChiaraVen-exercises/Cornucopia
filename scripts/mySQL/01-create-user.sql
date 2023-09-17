-- Drop user first if they exist
DROP USER if exists 'admin'@'%' ;

-- Now create user with prop privileges
CREATE USER 'mothadmin'@'localhost' IDENTIFIED BY 'plantlover';

GRANT ALL PRIVILEGES ON * . * TO 'mothadmin'@'localhost';
