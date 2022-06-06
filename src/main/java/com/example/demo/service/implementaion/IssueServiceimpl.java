package com.example.demo.service.implementaion;

import com.example.demo.dto.IssueDto;
import com.example.demo.dto.ProjectDto;
import com.example.demo.entity.Issue;
import com.example.demo.entity.Project;
import com.example.demo.repo.IssueRepository;
import com.example.demo.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.service.IssueService;

import java.util.Arrays;
import java.util.Objects;

@Service
public class IssueServiceimpl implements IssueService {
    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;
    public IssueServiceimpl(IssueRepository issueRepository, ModelMapper modelMapper){
       this.issueRepository = issueRepository;
       this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issue) {
        if(issue.getDate() == null)
            throw new IllegalArgumentException("Issue Date cannot be null");

        Issue issueDb = modelMapper.map(issue, Issue.class);
        issueDb =  issueRepository.save(issueDb);
        return modelMapper.map(issueDb, IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        return modelMapper.map(issueRepository.getById(id), IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage page = new TPage<IssueDto>();
        IssueDto[] issueDtos = modelMapper.map(data.getContent(), IssueDto[].class);
        page.setStats(data, Arrays.asList(issueDtos));
        return page;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        return null;
    }

    public Boolean delete(Long id){
        issueRepository.deleteById(id);
        return true;
    }

    @Override
    public IssueDto update(Long id, IssueDto issueDto) {
       return  null;
    }
}
