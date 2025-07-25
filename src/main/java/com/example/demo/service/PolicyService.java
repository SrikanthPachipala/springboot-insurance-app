package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Policy;
import com.example.demo.repository.PolicyRepository;

@Service
public class PolicyService {
	@Autowired
    private PolicyRepository policyRepository;

    public Policy savePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    public Policy getPolicyById(Long id) {
        return policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found with ID: " + id));
    }

    public Policy updatePolicy(Long id, Policy updatedPolicy) {
        Policy existingPolicy = getPolicyById(id);
        existingPolicy.setHolderName(updatedPolicy.getHolderName());
        existingPolicy.setType(updatedPolicy.getType());
        existingPolicy.setStartDate(updatedPolicy.getStartDate());
        existingPolicy.setEndDate(updatedPolicy.getEndDate());
        existingPolicy.setPremiumAmount(updatedPolicy.getPremiumAmount());
        return policyRepository.save(existingPolicy);
    }

    public void deletePolicy(Long id) {
        policyRepository.deleteById(id);
    }
}
