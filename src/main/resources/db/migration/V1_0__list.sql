create table IF NOT EXISTS user_list_partition(
id int,
name varchar(10),
PRIMARY KEY (id)
)
PARTITION BY LIST(id)(
PARTITION p0 values in (1,5),
PARTITION p1 values in (10,15),
PARTITION p2 values in (20,25)
);
-- 建立离散值列表指定特定值属于哪一个分区,超出分区范围时，插入失败