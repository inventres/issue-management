package com.example.demo.api;

import com.example.demo.dto.IssueDto;
import com.example.demo.entity.Issue;
import com.example.demo.service.implementaion.IssueServiceimpl;
import com.example.demo.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api("Issue APIs")
@CrossOrigin(origins = "*", maxAge = 3600)
public class IssueController {

    private final IssueServiceimpl issueServiceimpl;

    public IssueController(IssueServiceimpl projectServiceImpl) {
        this.issueServiceimpl = projectServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value="GetById Issue Api", response = IssueDto.class)
    public ResponseEntity<IssueDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(issueServiceimpl.getById(id));
    }

    @PostMapping
    @ApiOperation(value="Create Issue Operation", response = IssueDto.class)
    public ResponseEntity<IssueDto> createIssue(@Valid @RequestBody IssueDto issueDto) {
        return ResponseEntity.ok(issueServiceimpl.save(issueDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Update Issue Operation", response = IssueDto.class)
    public ResponseEntity<IssueDto> updateIssue(@PathVariable("id") Long id, @RequestBody IssueDto issueDto) {
       return ResponseEntity.ok(issueServiceimpl.update(id, issueDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Delete Issue Operation", response = Boolean.class)
    public ResponseEntity<Boolean> DeleteIssue(@PathVariable(value = "id", required = true) Long id){
        return ResponseEntity.ok(issueServiceimpl.delete(id));
    }
}
