create table clients (
                         id bigint generated by default as identity primary key,
                         name varchar(100) not null
);

create table contacts (
                          id bigint generated by default as identity primary key,
                          type varchar(10) check(type IN ('PHONE', 'EMAIL')),
                          value varchar(100) not null
);

create table clients_contacts (
                                  id bigint generated by default as identity primary key,
                                  client_id bigint references clients(id) on delete cascade,
                                  contact_id bigint references contacts(id) on delete cascade
);