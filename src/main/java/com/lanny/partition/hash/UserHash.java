package com.lanny.partition.hash;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lanny Yao
 * @date 5/9/2019 2:54 PM
 */
@Entity
@Table(name = "user_hash_partition")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserHash {

    @Id
    private Integer id;

    private String name;
}
