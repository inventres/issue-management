package com.example.demo.service;

import com.example.demo.dto.IssueDto;
import com.example.demo.util.TPage;

import org.springframework.data.domain.Pageable;

public interface IssueService {
    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto issue);

    IssueDto update(Long id, IssueDto issueDto);
}
