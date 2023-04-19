package com.argusoft.appointment.utils.security.userDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.argusoft.appointment.dao.person.PersonDao;
import com.argusoft.appointment.entity.Person;

import jakarta.transaction.Transactional;

@Service
public class PersonDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonDao personDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            Person person = personDao.getPersonByParam("email", String.class, username).get(0);
            if (person == null) {
                throw new UsernameNotFoundException("Requested User does not exists");
            }

            return new UserDetailsImpl(person.getPersonId(), person.getEmail(), person.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
