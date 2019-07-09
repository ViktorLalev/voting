package com.voting;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Election {

	private String name;
	private Date startDate;
	private Date endDate;

	Vote[] votes;

	public Election() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Vote[] getVotes() {
		return votes;
	}

	public void setVotes(Vote[] votes) {
		this.votes = votes;
	}

	public void update() {
		// System.out.println(this.name);

		// Update in DB
		// GO TO index

	}

}
