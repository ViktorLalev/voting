package com.voting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "candidateService")
@ApplicationScoped
public class CandidateService {

	public List<Candidate> createCandidates(int size) {
		List<Candidate> list = new ArrayList<Candidate>();
		for (int i = 0; i < size; i++) {
			list.add(new Candidate(getRandomId(), getRandomName(), getRandomPlatform()));
		}

		return list;
	}

	private String getRandomId() {
		return UUID.randomUUID().toString().substring(0, 8);
	}

	private String getRandomName() {
		return UUID.randomUUID().toString().substring(0, 8);
	}

	private String getRandomPlatform() {
		return UUID.randomUUID().toString().substring(0, 8);
	}

}