-- Get all car
SELECT name FROM car WHERE name IS NOT NULL;
--Get unused body
SELECT b.type FROM body AS b LEFT OUTER JOIN car AS c ON c.id = b.id WHERE c.id IS NULL;
--Get unused engine
 SELECT e.type FROM engine AS e LEFT OUTER JOIN car AS c ON c.id = e.id WHERE c.id IS NULL;
--Get unused transmission
SELECT t.type FROM transmission AS t LEFT OUTER JOIN car AS c ON c.id = t.id WHERE c.id IS NULL;
