INSERT INTO competence (nom) VALUES ('Concentration');
INSERT INTO competence (nom) VALUES ('Technique');
INSERT INTO role (name) VALUES ('ROLE_ADMIN'); 
INSERT INTO role (name) VALUES ('ROLE_LUTIN');
INSERT INTO user (user_type, email, first_name, last_name, password, disposable, role_id) VALUES ('admin', 'admin@email.com', 'admin', 'admin', '$2a$10$jaXQuXf7DYPAs.9AE5vtDukFigkJaE4O8JYjIUtI7fyK8qoKriKt.', true, 1);
INSERT INTO user (user_type, email, first_name, last_name, password, disposable, role_id) VALUES ('lutin', 'lutin1@email.com', 'hour', 'mina', '$2a$10$jaXQuXf7DYPAs.9AE5vtDukFigkJaE4O8JYjIUtI7fyK8qoKriKt.', true, 2);
INSERT INTO user (user_type, email, first_name, last_name, password, disposable, role_id) VALUES ('lutin', 'lutin2@email.com', 'hesina', 'moh', '$2a$10$jaXQuXf7DYPAs.9AE5vtDukFigkJaE4O8JYjIUtI7fyK8qoKriKt.', true, 2);
INSERT INTO user (user_type, email, first_name, last_name, password, disposable, role_id) VALUES ('lutin', 'lutin3@email.com', 'zekri', 'fatma', '$2a$10$jaXQuXf7DYPAs.9AE5vtDukFigkJaE4O8JYjIUtI7fyK8qoKriKt.', true, 2);
INSERT INTO user (user_type, email, first_name, last_name, password, disposable, role_id) VALUES ('lutin', 'lutin4@email.com', 'goumidi', 'yeser', '$2a$10$jaXQuXf7DYPAs.9AE5vtDukFigkJaE4O8JYjIUtI7fyK8qoKriKt.', true, 2);
INSERT INTO user_lutin_competences (lutin_entity_id, lutin_competences_id) VALUES (2, 1);
INSERT INTO user_lutin_competences (lutin_entity_id, lutin_competences_id) VALUES (2, 2);
INSERT INTO jouet (nom,LUTIN_ID) VALUES ('Léon le dragon Luminou Jemini',2); 
INSERT INTO jouet (nom) VALUES ('Poupé LOL'); 
 
