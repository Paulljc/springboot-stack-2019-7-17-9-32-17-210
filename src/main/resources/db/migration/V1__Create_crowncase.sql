create table `crown_case`
(
   `id` long auto_increment primary key,
   `case_name` varchar(255) not null,
   `case_time` long not null,
   `crown_detail_id` long ,
   `procuratorate_id` long not null
);