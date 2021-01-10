use ks_projects;

create table kickstarter_db.ks_projects(
  ID int primary key,
  name varchar index,
  category varchar,
  main_category varchar,
  currency varchar,
  deadline timestamp,
  goal double,
  launched timestamp,
  pledged double ,
  state varchar,
  backers int,
  country varchar,
  usd_pledged double,
  usd_pledged_real double,
  usd_goal_real double
);

CREATE INDEX name_index
ON kickstarter_db.ks_projects(name);

drop table kickstarter_db.ks_projects;

select count(*)
from ks_projects;
