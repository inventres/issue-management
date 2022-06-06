package com.example.demo.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Project Dto")
public class ProjectDto {
    @ApiModelProperty(value = "Project ID")
    private Long id;
    @ApiModelProperty(required = true, value = "Name of Project")
    @NotNull
    private String projectName;
    @ApiModelProperty(required = true, value = "Code of Project")
    @NotNull
    private String projectCode;
}
