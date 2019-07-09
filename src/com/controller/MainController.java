package com.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.database.ListQuery;
import com.voting.Candidate;

@ManagedBean(name = "main")

public class MainController implements Serializable {

	ListQuery query = new ListQuery();

	private List<Candidate> list = new ArrayList<Candidate>();

	public List<Candidate> getList() {

		return query.listCandidate();
	}

	public void setList(List<Candidate> list) {
		this.list = list;
	}

}
