package com.scaler.splitwisejune22.repositories;

import com.scaler.splitwisejune22.models.Group;
import com.scaler.splitwisejune22.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    Optional<Group> findById(Long id);

    // Optional<Group>



//    List<Group> findAllByParticipantsContaining(List<User> users);
    // select * from groups
    // where participants in ()

}
