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

		list = getList();

		createPieModel(list);

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

	private void createPieModel(List<Result> list) {

		pieModel = new PieChartModel();

		list.forEach((l) -> pieModel.set(l.getCandidate(), l.getVotes()));

		pieModel.setTitle("Vote Current Results");
		pieModel.setLegendPosition("w");
		pieModel.setShadow(false);
	}

}
