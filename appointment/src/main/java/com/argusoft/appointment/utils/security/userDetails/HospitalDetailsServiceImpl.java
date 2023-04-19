package com.argusoft.appointment.utils.security.userDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.argusoft.appointment.dao.hospital.HospitalDao;
import com.argusoft.appointment.dao.person.PersonDao;
import com.argusoft.appointment.entity.Hospital;
import com.argusoft.appointment.entity.Person;

import jakarta.transaction.Transactional;

@Service
public class HospitalDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private HospitalDao hospitalDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            Hospital hospital = hospitalDao.getHospitalByParam("email",  username).get(0);
            if (hospital == null) {
                throw new UsernameNotFoundException("Requested User does not exists");
            }

            return new UserDetailsImpl(hospital.getHospitalId(), hospital.getHospitalAdminEmail(), hospital.getHospitalAdminPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
