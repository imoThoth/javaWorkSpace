package com.titans.atlas.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.email =?1")
    Optional<Student> findStudentByEmail(String email);
}
// "msg_id": 2,
//         "company_name": "Experian",
//         "registrationDate": "1990-05-03T13:20:10",
//         "score": 0,
//         "directors_count": 2,
//         "lastUpdated": "1990-05-03T13:20:10"