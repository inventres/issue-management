package com.example.demo.service.implementaion;

import com.example.demo.entity.IssueHistory;
import com.example.demo.repo.IssueHistoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.example.demo.service.IssueHistoryService;

import org.springframework.data.domain.Pageable;

@Service
public class IssueHistoryServiceimpl implements IssueHistoryService {
    private final IssueHistoryRepository issueHistoryRepository;

    public IssueHistoryServiceimpl(IssueHistoryRepository issueHistoryRepository) {
        this.issueHistoryRepository = issueHistoryRepository;
    }


    @Override
    public IssueHistory save(IssueHistory issue) {
        return null;
    }

    @Override
    public IssueHistory getById(Long id) {
        return null;
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        return null;
    }
}
