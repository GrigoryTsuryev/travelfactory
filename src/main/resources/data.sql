DELETE from campaign;
DELETE from contact;
Delete from registration;


insert into campaign (id, name) values (1, 'registration1');

insert into contact (id, email) values (1, 'test@test.com');
insert into contact (id, email) values (2, 'test1@test1.com');


insert into registration (id, email, phone, campaign_id) values (1, 'email@email.com', "922559291111", 1);
insert into registration (id, email, phone, campaign_id) values (2, 'email1@email.com', "922559291112", 1);

