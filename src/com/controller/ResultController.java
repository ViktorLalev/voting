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
import org.primefaces.model.charts.ChartData;

import com.database.ResultQuery;
import com.voting.Candidate;
import com.voting.Result;

@ManagedBean(name = "results")

public class ResultController implements Serializable {

	ResultQuery query = new ResultQuery();

	private List<Result> list = new ArrayList<Result>();

	private Integer candidate_id;
	private Integer votes;

	private PieChartModel pieModel;

	@PostConstruct
	public void init() {

		createPieModel();

	}

	public Integer getCandidate_id() {
		return candidate_id;
	}

	public void setCandidate_id(Integer candidate_id) {
		this.candidate_id = candidate_id;
	}

	public List<Result> getList() {

		return query.listResults();
	}

	public void setList(List<Result> list) {
		this.list = list;
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	private void createPieModel() {
		pieModel = new PieChartModel();

		pieModel.set("Brand 1", 540);
		pieModel.set("Brand 2", 325);
		pieModel.set("Brand 3", 702);
		pieModel.set("Brand 4", 421);

		pieModel.setTitle("Simple Pie");
		pieModel.setLegendPosition("w");
		pieModel.setShadow(false);
	}

}
