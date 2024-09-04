package com.synectiks.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synectiks.app.entity.StudentDetailsEntity;

@Repository
public interface StudentadminRepository extends JpaRepository<StudentDetailsEntity, Long> {

}
