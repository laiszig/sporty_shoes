create table sporty_shoes.users(
                                   username varchar(50) not null primary key,
                                   password varchar(500) not null,
                                   enabled boolean not null
);

create table sporty_shoes.authorities (
                                          username varchar(50) not null,
                                          authority varchar(50) not null,
                                          constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on sporty_shoes.authorities (username,authority);

insert into sporty_shoes.users (username, password, enabled) values ('user','{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW',true);
insert into sporty_shoes.users (username, password, enabled) values ('admin','{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW',true);

insert into sporty_shoes.authorities values ('user','USER');
insert into sporty_shoes.authorities values ('admin','USER');
insert into sporty_shoes.authorities values ('admin','ADMIN');