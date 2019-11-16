package com.nriagudubem.search.controllers;

import com.nriagudubem.search.model.User;
import com.nriagudubem.search.requestDto.SearchQuery;
import com.nriagudubem.search.services.SearchService;
import com.nriagudubem.search.sqs.dto.SearchMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.Instant;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SearchController extends ResponseEntityExceptionHandler {

    private final SearchService searchService;

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/search")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String search(@RequestParam(value = "query") @Valid SearchQuery searchQuery,
                         RedirectAttributes redirectAttributes) {
        searchService.publishMessageToQueue(
                SearchMessageDto.builder()
                        .searchQuery(searchQuery.getQuery())
                        .now(Instant.now())
                        .user(User.builder()
                                .email("dubem@gmail.com")
                                .password("password").build())
                        .build());
        redirectAttributes.addAttribute("message", "Your search has started");
        return "index";
    }
}
