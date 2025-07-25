package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Policy;
import com.example.demo.service.PolicyService;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
	@Autowired
	private PolicyService policyService;

	@PostMapping
	public ResponseEntity<Policy> createPolicy(@Validated @RequestBody Policy policy) {
		return new ResponseEntity<>(policyService.savePolicy(policy), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Policy> getAllPolicies() {
		return policyService.getAllPolicies();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Policy> getPolicyById(@PathVariable Long id) {
		return ResponseEntity.ok(policyService.getPolicyById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Policy> updatePolicy(@PathVariable Long id, @Validated @RequestBody Policy policy) {
		return ResponseEntity.ok(policyService.updatePolicy(id, policy));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
		policyService.deletePolicy(id);
		return ResponseEntity.noContent().build();
	}

}
