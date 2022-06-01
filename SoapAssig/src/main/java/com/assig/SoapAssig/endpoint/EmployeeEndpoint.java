//package com.assig.soapassig.endpoint;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ws.server.endpoint.annotation.Endpoint;
//import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
//import org.springframework.ws.server.endpoint.annotation.RequestPayload;
//import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//
//import com.assig.soapassig.Service.EmployeeService;
//import com.assig.soapassig.entity.Employee;
//import com.assig.soapassig.interfaces.AddEmployeeRequest;
//import com.assig.soapassig.interfaces.AddEmployeeResponse;
//import com.assig.soapassig.interfaces.DeleteEmployeeRequest;
//import com.assig.soapassig.interfaces.DeleteEmployeeResponse;
//import com.assig.soapassig.interfaces.EmployeeInfo;
//import com.assig.soapassig.interfaces.GetEmployeeByIdRequest;
//import com.assig.soapassig.interfaces.GetEmployeeResponse;
//import com.assig.soapassig.interfaces.ServiceStatus;
//import com.assig.soapassig.interfaces.UpdateEmployeeRequest;
//import com.assig.soapassig.interfaces.UpdateEmployeeResponse;
//
//@Endpoint
//public class EmployeeEndpoint {
//
//	private static final String NAMESPACE_URI = "http://SoapAssig.assig.com/interfaces";
//	@Autowired
//	private EmployeeService employeeService;
//	
//	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
//	@ResponsePayload
//	public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {
//		AddEmployeeResponse response = new AddEmployeeResponse();
//		ServiceStatus serviceStatus = new ServiceStatus();
//
//		Employee employee = new Employee();
//		BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
//		employeeService.AddEmployee(employee);
//		response.setEmployeeInfo(request.getEmployeeInfo());
//		serviceStatus.setStatus("SUCCESS");
// 	    serviceStatus.setMessage("Content Added Successfully");
//		response.setServiceStatus(serviceStatus);
//		return response;
//	}
//	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIdRequest")
//	@ResponsePayload
//	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeByIdRequest request) {
//		GetEmployeeResponse response = new GetEmployeeResponse();
//		EmployeeInfo employeeInfo = new EmployeeInfo();
//		BeanUtils.copyProperties(employeeService.getEmployeeById(request.getEmpId()), employeeInfo);
//		response.setEmployeeInfo(employeeInfo);
//		return response;
//	}
//	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
//	@ResponsePayload
//	public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
//		Employee employee = new Employee();
//		BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
//		employeeService.updateEmployee(employee);
//		ServiceStatus serviceStatus = new ServiceStatus();
//		serviceStatus.setStatus("SUCCESS");
//		serviceStatus.setMessage("Content Updated Successfully");
//		UpdateEmployeeResponse response = new UpdateEmployeeResponse();
//		response.setServiceStatus(serviceStatus);
//		return response;
//	}
//
//	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
//	@ResponsePayload
//	public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request) {
//		employeeService.deleteEmployee(request.getEmpId());
//		ServiceStatus serviceStatus = new ServiceStatus();
//
//		serviceStatus.setStatus("SUCCESS");
//		serviceStatus.setMessage("Content Deleted Successfully");
//		DeleteEmployeeResponse response = new DeleteEmployeeResponse();
//		response.setServiceStatus(serviceStatus);
//		return response;
//	}
//
//}
//
