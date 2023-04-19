package com.argusoft.appointment.utils.security.userDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.argusoft.appointment.dao.doctor.DoctorDao;
import com.argusoft.appointment.dao.person.PersonDao;
import com.argusoft.appointment.entity.Doctor;
import com.argusoft.appointment.entity.Person;

import jakarta.transaction.Transactional;

@Service
public class DoctorDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private DoctorDao doctorDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            Doctor doctor = doctorDao.getDoctorByParam("email", username).get(0);
            if (doctor == null) {
                throw new UsernameNotFoundException("Requested User does not exists");
            }

            return new UserDetailsImpl(doctor.getDoctorId(), doctor.getEmail(), doctor.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
