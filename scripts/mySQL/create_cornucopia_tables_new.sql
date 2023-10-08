


CREATE TABLE `Cornucopia`.`FoodLot` (
                                        `id` INT NOT NULL AUTO_INCREMENT,
                                        `content_description` VARCHAR(45) NOT NULL,
                                        `status` VARCHAR(45) NOT NULL,
                                        PRIMARY KEY (`id`));


CREATE TABLE `Cornucopia`.`FoodItem` (
                                         `id` INT NOT NULL AUTO_INCREMENT,
                                         `description` VARCHAR(200) NOT NULL,
                                         `expirationDate` DATE NOT NULL,
                                         `category` VARCHAR(45) NOT NULL,
                                         `traceableCode` INT NULL,
                                         PRIMARY KEY (`id`));
