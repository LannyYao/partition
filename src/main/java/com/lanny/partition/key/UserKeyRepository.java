package com.lanny.partition.key;

import com.lanny.partition.hash.UserHash;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lanny Yao
 * @date 5/9/2019 11:22 AM
 */
public interface UserKeyRepository extends JpaRepository<UserKey, Integer> {

}
