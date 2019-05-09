package com.lanny.partition;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lanny Yao
 * @date 5/9/2019 11:23 AM
 */
@Slf4j
@RestController
@RequestMapping("/partitions")
public class PartitionsController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/{table}")
    public Object getPartitionsDetails(@PathVariable(name = "table") String tableName) {
        return jdbcTemplate.query("SELECT PARTITION_NAME,TABLE_ROWS "
                + "FROM INFORMATION_SCHEMA.PARTITIONS "
                + "WHERE TABLE_NAME = '"+ tableName + "'", (rs, rowNum) -> {
            Map<String, Integer> result = new HashMap<>();
            result.put(rs.getString(1), rs.getInt(2));
            return result;
        });
    }
}
