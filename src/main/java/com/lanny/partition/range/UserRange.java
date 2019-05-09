package com.lanny.partition.range;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lanny Yao
 * @date 5/9/2019 11:19 AM
 */
@Entity
@Table(name = "user_range_partition")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRange implements Serializable {

    @Id
    private Integer age;

    private String name;
}
