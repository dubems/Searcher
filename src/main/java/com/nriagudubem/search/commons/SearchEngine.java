package com.nriagudubem.search.commons;

import com.nriagudubem.search.httpClient.email.dto.GetEmailResponseDto;
import com.nriagudubem.search.sqs.dto.SearchMessageDto;

public interface SearchEngine {

    GetEmailResponseDto getEmails(SearchMessageDto searchMessageDto);
}

