
drop database if exists Food;
create database Food;
use Food;

create table Food (
    id integer primary key auto_increment,
    food_name text not null,
    food_group text not null,
    calories integer not null
);

INSERT INTO Food (food_name, food_group, calories) VALUES 
('Chicken Breast', 'Protein', 185),
('Ground beef', 'Protein', 190),
('Boiled egg', 'Protein', 155),
('Tilapia', 'Protein', 129),
('Salmon', 'Protein', 200),
('Soybeans', 'Protein', 296),
('Potatoes', 'Carbohydrates', 90),
('White rice', 'Carbohydrates', 130),
('Pasta', 'Carbohydrates', 131),
('Boiled yam', 'Carbohydrates', 118),
('Avocado', 'Fats and Oils', 160),
('Palm oil', 'Fats and Oils', 240),
('Coconut oil', 'Fats and Oils', 234);