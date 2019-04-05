package com.dmantz.ecapp.repository;

import org.aspectj.weaver.loadtime.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmantz.ecapp.request.OptionsRO;

@Repository
public interface OptionsRepository extends JpaRepository<OptionsRO, Integer> {

	Options save(Options options);

}
