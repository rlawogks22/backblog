package com.example.backblog.security;


import com.example.backblog.entitiy.Back;
import com.example.backblog.repository.BackRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BackDetailsServiceImpl implements UserDetailsService {

    private final BackRepository backRepository;

    public BackDetailsServiceImpl(BackRepository backRepository) {
        this.backRepository = backRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String Backname) throws UsernameNotFoundException {
        Back back = backRepository.findByUsername(Backname)
                .orElseThrow(() -> new UsernameNotFoundException("Not Found " + Backname));

        return new BackDetailsImpl(back);
    }

}