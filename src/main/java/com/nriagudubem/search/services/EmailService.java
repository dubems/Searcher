package com.nriagudubem.search.services;

import com.nriagudubem.search.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    SearchRepository searchRepository;
}
