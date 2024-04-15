-- Create the database schema
DROP DATABASE IF EXISTS Food;
CREATE DATABASE Food;
USE Food;

CREATE TABLE Food (
    id INTEGER PRIMARY KEY AUTO_INCREMENT, -- Add AUTO_INCREMENT to the id column
    food_name TEXT NOT NULL,
    food_group TEXT NOT NULL,
    calories INTEGER NOT NULL
);

-- Insert data into the Food table
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