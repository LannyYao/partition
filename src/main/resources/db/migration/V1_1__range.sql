create table IF NOT EXISTS user_range_partition(
name varchar(10),
age int,
PRIMARY KEY (age)
)
PARTITION BY RANGE(age)(
PARTITION young values LESS THAN (30),
PARTITION middle_age values LESS THAN (60),
PARTITION old values LESS THAN MAXVALUE
);
-- 利用取值范围将数据分区, MYSQL的分区字段，必须包含在主键字段内