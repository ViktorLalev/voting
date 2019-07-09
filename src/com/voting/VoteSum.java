package com.voting;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.FlowEvent;
import org.primefaces.model.chart.PieChartModel;

import com.database.VoteQuery;
import com.voting.Candidate;
import com.voting.Vote;
import com.voting.VoteSum;

public class VoteSum implements Serializable {

	VoteQuery query = new VoteQuery();

	private Integer candidate_id;
	private Integer votes;

	private List<VoteSum> list = new ArrayList<VoteSum>();

	public VoteSum() {

	}

	public Integer getCandidate_id() {
		return candidate_id;
	}

	public void setCandidate_id(Integer candidate_id) {
		this.candidate_id = candidate_id;
	}

	public List<VoteSum> getList() {

		return query.listVoteSum();
	}

	public void setList(List<VoteSum> list) {
		this.list = list;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}
}
