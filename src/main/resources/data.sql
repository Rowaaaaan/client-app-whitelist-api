INSERT INTO CLIENT VALUES (1, 'Bob');
INSERT INTO CLIENT VALUES (2, 'Jake');
INSERT INTO CLIENT VALUES (3, 'Storm Thorgerson');

INSERT INTO APP VALUES (1, 'App 1');
INSERT INTO APP VALUES (2, 'App 2');

INSERT INTO CLIENT_INET_ADDRESS VALUES ('192.168.0.25');
INSERT INTO CLIENT_INET_ADDRESS VALUES ('192.168.0.43');
INSERT INTO CLIENT_INET_ADDRESS VALUES ('192.168.0.67');

INSERT INTO WHITELIST (client_id, app_id, environment, ipv4_address) VALUES (1, 1, 'DEV', '192.168.0.25'); 
INSERT INTO WHITELIST (client_id, app_id, environment, ipv4_address) VALUES (1, 1, 'STAGE', '192.168.0.43');
INSERT INTO WHITELIST (client_id, app_id, environment, ipv4_address) VALUES (1, 1, 'PROD', '192.168.0.43');
INSERT INTO WHITELIST (client_id, app_id, environment, ipv4_address) VALUES (2, 1, 'DEV', '192.168.0.43');
INSERT INTO WHITELIST (client_id, app_id, environment, ipv4_address) VALUES (2, 2, 'PROD', '192.168.0.67');
