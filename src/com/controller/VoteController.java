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
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import com.database.VoteQuery;
import com.voting.Candidate;
import com.voting.Result;
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

	private BarChartModel barModel;

//	@PostConstruct
//	public void init() {
//		list = getList();
//
//		createBarModel(list);
//
//	}

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

	private void createBarModel(List<Result> list) {
		barModel = initBarModel(list);

		barModel.setTitle("Man/Woman");
		barModel.setLegendPosition("ne");

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Candidates");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Votes");
		yAxis.setMin(0);
		yAxis.setMax(200);
	}

	private BarChartModel initBarModel(List<Result> list) {
		BarChartModel model = new BarChartModel();
		
		ChartSeries men = new ChartSeries();
		men.setLabel("Man");
		ChartSeries woman = new ChartSeries();
		woman.setLabel("Woman");

		
		men.set("2004", 120);
		men.set("2005", 100);
		men.set("2006", 44);
		men.set("2007", 150);
		men.set("2008", 25);

		
		woman.set("2004", 52);
		woman.set("2005", 60);
		woman.set("2006", 110);
		woman.set("2007", 135);
		woman.set("2008", 120);

		model.addSeries(men);
		model.addSeries(woman);

		return model;
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

}
