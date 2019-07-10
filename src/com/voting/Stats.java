package com.voting;

import com.controller.CandidateController;

public class Stats {

	private Integer candidate_id;
	private Integer votes;
	private String sex;

	public Stats() {

	}

	public Integer getCandidate_id() {
		return candidate_id;
	}

	public String getCandidate() {

		CandidateController candidate = new CandidateController();

		return candidate.getById(candidate_id);
	}

	public void setCandidate_id(Integer candidate_id) {
		this.candidate_id = candidate_id;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
