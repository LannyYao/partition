package com.lanny.partition.range;

import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lanny Yao
 * @date 5/9/2019 11:23 AM
 */
@Slf4j
@RestController
@RequestMapping("/range")
public class RangeController {

    @Autowired
    private UserRangeRepository userRangeRepository;

    /**
     * GET localhost:8080/partitions/user_range_partition [ { "young": 30 }, { "middle_age": 30 }, { "old": 40 } ]
     *
     * RANGE分区处理NULL值：当做最小值处理，所以写入到最小分区中
     */
    @GetMapping("/save")
    public String save() {

        log.info("Insert 100 records");

        if (userRangeRepository.exists(99)) {
            return "Existed";
        }

        IntStream.range(0, 100).mapToObj(i -> new UserRange(i, "name" + i)).forEach(userRangeRepository::save);

        return "successfully saved";
    }

}
