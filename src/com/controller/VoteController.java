package com.controller;

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

@ManagedBean(name = "votes")
@ViewScoped

public class VoteController implements Serializable {

	VoteQuery query = new VoteQuery();

	private List<Vote> list = new ArrayList<Vote>();

	private Integer id;
	private Integer candidate_id;
	private Integer age;
	private String sex;
	private String city;
	private String education;

	public VoteController() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCandidate_id() {
		return candidate_id;
	}

	public void setCandidate_id(Integer candidate_id) {
		this.candidate_id = candidate_id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public List<Vote> getList() {

		return query.listVotes();
	}

	public void setList(List<Vote> list) {
		this.list = list;
	}

	public void store(Integer candidate_id) {

		query.store(candidate_id, age, sex, city, education);

		this.redirect("success");

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
