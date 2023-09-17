CREATE TABLE `food_items` (
    `id` int NOT NULL AUTO_INCREMENT,
    `description` varchar(100) DEFAULT NULL,
    `sent_by`varchar(45) NOT NULL,
    `status` ENUM ('awaiting_approval','available', 'reserved', 'delivered', 'removed'),
     PRIMARY KEY (`id`)
);

CREATE TABLE `ingredients` (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(50),
    PRIMARY KEY (`id`)
);

CREATE TABLE `food_items__ingredients` (
    `food_item_id` int NOT NULL,
    `ingredient_id` int NOT NULL
);