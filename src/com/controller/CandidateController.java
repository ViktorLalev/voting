package com.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.database.CandidateQuery;
import com.voting.Candidate;

@ManagedBean(name = "candidates")

public class CandidateController implements Serializable {

	CandidateQuery query = new CandidateQuery();

	private List<Candidate> list = new ArrayList<Candidate>();

	private Integer id;
	private String name;
	private String platform;

	public CandidateController() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;

	}

	public String getById(Integer id) {
		return query.getById(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public List<Candidate> getList() {

		return query.listCandidate();
	}

	public void setList(List<Candidate> list) {
		this.list = list;
	}

	public void vote(Integer id) {

		System.out.println("" + id);

		// TODO Store

		this.redirect("vote");
	}

	public void store() {

//		
		query.store(name, platform);
//
		this.redirect("settings/candidates/index");

	}

	public void delete(Integer id) {

		query.deleteCandidate(id);

	}

	private void redirect(String url) {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		String contextPath = origRequest.getContextPath();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + "/faces/" + url + ".xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
