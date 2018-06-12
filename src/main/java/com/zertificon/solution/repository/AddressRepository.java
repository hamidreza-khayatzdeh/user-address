package com.zertificon.solution.repository;

import com.zertificon.solution.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hamidreza on 6/12/2018.
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
}
