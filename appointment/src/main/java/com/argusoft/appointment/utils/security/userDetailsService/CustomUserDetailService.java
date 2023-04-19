package com.argusoft.appointment.utils.security.userDetailsService;


import com.argusoft.appointment.dao.user.UserDao;
import com.argusoft.appointment.entity.User;
import com.argusoft.appointment.utils.security.config.MyUserDetails;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try{
      User user = userDao.getUserByParam("contactNo",String.class,username).get(0);

        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        else{
            return MyUserDetails.build(user);
        }}catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
