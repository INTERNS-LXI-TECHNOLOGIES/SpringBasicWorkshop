CREATE TABLE QnA (
    Question TEXT,
    OptionA VARCHAR(50),
    OptionB VARCHAR(50),
    OptionC VARCHAR(50),
    CorrectAnswer VARCHAR(50)
);

INSERT INTO QnA (Question, OptionA, OptionB, OptionC, CorrectAnswer) VALUES
('What is the capital of the United States?', 'A) Washington D.C.', 'B) New York City', 'C) Los Angeles', 'A) Washington D.C.'),

('Which city is the capital of France?', 'A) Paris', 'B) Berlin', 'C) Madrid', 'A) Paris'),

('What is the capital of Japan?', 'A) Beijing', 'B) Seoul', 'C) Tokyo', 'C) Tokyo'),

('Which city serves as the capital of Australia?', 'A) Sydney', 'B) Melbourne', 'C) Canberra', 'C) Canberra'),

('What is the capital of Brazil?', 'A) Rio de Janeiro', 'B) Sao Paulo', 'C) Brasilia', 'C) Brasilia');