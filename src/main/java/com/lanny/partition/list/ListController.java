package com.lanny.partition.list;

import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lanny Yao
 * @date 5/9/2019 2:54 PM
 */
@Slf4j
@RestController
@RequestMapping("/list")
public class ListController {

    @Autowired
    private UserListRepository userListRepository;

    private static List<Integer> availableIds = Arrays.asList(1, 5, 10, 15, 20, 25);

    /**
     * GET localhost:8080/partitions/user_list_partition [ { "p0": 2 }, { "p1": 2 }, { "p2": 2 } ]
     *
     * LIST分区处理NULL值："Table has no partition for value null"
     */
    @GetMapping("/save")
    public String save() {

        log.info("Insert 6 records");
        availableIds.stream().map(i -> new UserList(i, "name" + i)).forEach(userListRepository::save);
        return "successfully saved";
    }
}
