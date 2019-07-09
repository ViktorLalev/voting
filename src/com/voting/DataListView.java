package com.voting;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DataListView implements Serializable {

	private List<Candidate> candidates;
	
	private Candidate selectedCandidate;

	@ManagedProperty("#{candidateService}")
	private CandidateService service;
	


	@PostConstruct
	public void init() {
		candidates = service.createCandidates(10);
		
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setService(CandidateService service) {
		this.service = service;
	}

	public Candidate getSelectedCandidate() {
		return selectedCandidate;
	}

	public void setSelectedCandidate(Candidate selectedCandidate) {
		this.selectedCandidate = selectedCandidate;
	}
}