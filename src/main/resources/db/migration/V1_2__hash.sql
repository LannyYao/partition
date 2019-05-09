create table IF NOT EXISTS user_hash_partition(
id int,
name varchar(10),
PRIMARY KEY (id)
)
PARTITION BY HASH(id)
PARTITIONS 2;
-- 基于给定的分区个数，将数据分配到不同分区，HASH分区只能对整数进行分区，对于非整型字段只能通过表达式转为整型