
create table if not exists persistent_logins ( 
  username varchar(100) not null, 
  series varchar(64) primary key, 
  token varchar(64) not null, 
  last_used timestamp not null
);

delete from  user_role;
delete from  roles;
delete from  users;


INSERT INTO roles (id, name) VALUES 
(1, 'ROLE_ADMIN'),
(3, 'ROLE_USER')
;

INSERT INTO users (id, email, password, name) VALUES 
(1, 'admin@gmail.com', '$2a$10$zsfwKJWyfz1vH4zhJE74Yu2MIJr0AyKOPYiNpT/kobj26Zoxgc9Fa', 'Admin'),
(2, 'employee1@gmail.com', '$2a$10$zsfwKJWyfz1vH4zhJE74Yu2MIJr0AyKOPYiNpT/kobj26Zoxgc9Fa', 'Employee1'),
(3, 'employee2@gmail.com', '$2a$10$zsfwKJWyfz1vH4zhJE74Yu2MIJr0AyKOPYiNpT/kobj26Zoxgc9Fa', 'Employee2')
;


insert into user_role(user_id, role_id) values
(1,1),
(2,3),
(3,3)
;
