# 针对如下表actor结构创建索引：
# (注:在 SQLite 中,除了重命名表和在已有的表中添加列,ALTER TABLE 命令不支持其他操作)

use nowcoder;
create unique index uniq_idx_firstname on actor(first_name);
create index idx_lastname on actor(last_name)