package com.demoapi.demoproj.data;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
    
    List<Guest> findByGuestId(long guestId);
    List<Guest> findByEmailAddress(String emailAddress);
    List<Guest> findByPhoneNumber(String phoneNumber);
    List<Guest> findByFirstName(String firstName);
    List<Guest> findByLastName(String lastName);

    List<Guest> findByFirstNameIgnoreCaseContainingAndLastNameIgnoreCaseContaining
    (String firstName, String lastName);

    
}
