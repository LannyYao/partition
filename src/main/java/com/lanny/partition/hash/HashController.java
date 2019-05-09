package com.lanny.partition.hash;

import java.util.stream.IntStream;
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
@RequestMapping("/hash")
public class HashController {

    @Autowired
    private UserHashRepository userHashRepository;

    /**
     * GET localhost:8080/partitions/user_hash_partition [ { "p0": 50 }, { "p1": 50 } ]
     *
     * HASH分区处理NULL：当做零看待
     */
    @GetMapping("/save")
    public String save() {

        log.info("Insert 100 records");

        if (userHashRepository.exists(99)) {
            return "Existed";
        }

        IntStream.range(0, 100).mapToObj(i -> new UserHash(i, "name" + i)).forEach(userHashRepository::save);

        return "successfully saved";
    }
}
