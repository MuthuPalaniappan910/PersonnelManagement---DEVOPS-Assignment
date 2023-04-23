package com.dda.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dda.assignment.dto.ProjectFinance;
import com.dda.assignment.dto.ProjectFinanceResponse;
import com.dda.assignment.exception.InvalidProjectException;
import com.dda.assignment.exception.NoProjectFinanceFoundException;
import com.dda.assignment.model.Finance;
import com.dda.assignment.model.Project;
import com.dda.assignment.repository.FinanceRepository;
import com.dda.assignment.utils.ApplicationConstants;

@Service
public class FinanceServiceImpl implements FinanceService {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private FinanceRepository financeRepository;

	@Override
	public ProjectFinanceResponse getFinanceDetails(Long projectId) throws InvalidProjectException, NoProjectFinanceFoundException {
		
		ProjectFinanceResponse projectFinanceResponse = new ProjectFinanceResponse();
		List<ProjectFinance> projectFinanceListDto = new ArrayList<>();
		Project project = projectService.getProjectDetails(projectId);
		List<Finance> projectFinanceList = financeRepository.findAllByProject(project);
		if(projectFinanceList.isEmpty()) {
			throw new NoProjectFinanceFoundException(ApplicationConstants.NO_PROJECT_FINANCE_FOUND);
		}
		projectFinanceList.forEach(projectFinance -> {
			ProjectFinance projectFinanceDto = new ProjectFinance();
			projectFinanceDto.setAmountAllocated(projectFinance.getAmountAllocated());
			projectFinanceDto.setAmountSpent(projectFinance.getAmountSpent());
			projectFinanceDto.setFinanceId(projectFinance.getFinanceId());
			projectFinanceDto.setFinancialYear(projectFinance.getFinancialYear());
			projectFinanceListDto.add(projectFinanceDto);
		});
		projectFinanceResponse.setFinance(projectFinanceListDto);
		projectFinanceResponse.setProjectId(project.getProjectId());
		projectFinanceResponse.setProjectName(project.getProjectName());
		return projectFinanceResponse;
	}

}
