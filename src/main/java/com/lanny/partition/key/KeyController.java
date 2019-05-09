package com.lanny.partition.key;

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
@RequestMapping("/key")
public class KeyController {

    @Autowired
    private UserKeyRepository userKeyRepository;

    /**
     * GET localhost:8080/partitions/user_key_partition [ { "p0": 50 }, { "p1": 50 } ]
     */
    @GetMapping("/save")
    public String save() {

        log.info("Insert 100 records");

        if (userKeyRepository.exists(99)) {
            return "Existed";
        }

        IntStream.range(0, 100).mapToObj(i -> new UserKey(i, "name" + i)).forEach(userKeyRepository::save);

        return "successfully saved";
    }
}
