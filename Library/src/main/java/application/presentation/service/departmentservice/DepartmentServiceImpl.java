package application.presentation.service.departmentservice;

import application.business.converter.department.DepartmentParam;
import application.business.converter.department.DepartmentResult;
import application.business.processor.departmentprocessor.DepartmentProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/Department")
public class DepartmentServiceImpl extends BaseServiceImpl<DepartmentParam,DepartmentResult,Long,DepartmentProcessor> implements DepartmentService {
}
