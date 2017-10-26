create table PLAYERS (
	ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	USERNAME VARCHAR(256),
	UNIQUE(USERNAME)
	-- Not going to store rating in database, instead will calculate 
);

--create table CHESS_GAMES (
	--ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	--WHITE_ID INT NOT NULL,
	--WHITE_INIT_RATING INT NOT NULL,
	--BLACK_ID INT NOT NULL,
	--BLACK_INIT_RATING INT NOT NULL,
	--RESULT INT,
	-- Each move will be notated in the database as piece, from row, from col, to row, to col, 
	-- so N0122 would be knight from the first row 2nd column to 3rd row 3rd column. 
	-- This gives 10 characters per move. The longest game ever played was 269 moves, so 5K is plenty of room 
	--MOVES CLOB(5000),
	--PRIMARY_KEY(ID),
	--FOREIGN_KEY(WHITE_ID) REFERENCES PLAYERS(ID),
	--FOREIGN_KEY(BLACK_ID) REFERENCES PLAYERS(ID)
--);