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
import org.primefaces.model.charts.ChartData;

import com.database.StatsQuery;
import com.voting.Candidate;
import com.voting.Stats;

@ManagedBean(name = "stats")

public class StatsController implements Serializable {

	StatsQuery query = new StatsQuery();

	private List<Stats> list = new ArrayList<Stats>();

	private List<Stats> listBySex = new ArrayList<Stats>();

	private Integer candidate_id;
	private Integer votes;
	private String sex;

	private PieChartModel pieModel;
	private BarChartModel sexModel;

	@PostConstruct
	public void init() {

		list = getList();

		createPieModel(list);
		listBySex = getListBySex();
		createBarModelForSex(listBySex);

//		ArrayList<Stats> manList = new ArrayList<Stats>();
//		ArrayList<Stats> womanList = new ArrayList<Stats>();
//
//		for (Stats item : list) {
//
//			if (item.getSex() == "m") {
//
//				manList.add(item);
//			} else {
//				womanList.add(item);
//			}
//		}
//		System.out.println(manList);
//		System.out.println(womanList);
//		for (Stats item : manList) {
//			man.set(item.getCandidate(), item.getVotes());
//
//		}
//		for (Stats item : womanList) {
//			woman.set(item.getCandidate(), item.getVotes());
//
//		}
	}

	// Setters / Getters
	public Integer getCandidate_id() {
		return candidate_id;
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

	// List Queries
	public List<Stats> getList() {

		return query.listResults();
	}

	public void setList(List<Stats> list) {
		this.list = list;
	}

	public List<Stats> getListBySex() {

		return query.listStatsBySex();
	}

	public void setListBySex(List<Stats> list) {
		this.listBySex = list;
	}

	// Charts
	public PieChartModel getPieModel() {
		return pieModel;
	}

	public BarChartModel getSexModel() {
		return sexModel;
	}

	private void createPieModel(List<Stats> list) {

		pieModel = new PieChartModel();

		list.forEach((l) -> pieModel.set(l.getCandidate(), l.getVotes()));

		pieModel.setTitle("Vote Current Results");
		pieModel.setLegendPosition("w");
		pieModel.setShadow(false);
	}

	private void createBarModelForSex(List<Stats> list) {
		sexModel = initBarModel(list);

		sexModel.setTitle("By Gender");
		sexModel.setLegendPosition("ne");

//		list.forEach((l) -> pieModel.set(l.getCandidate(), l.getVotes()));
		Axis xAxis = sexModel.getAxis(AxisType.X);
		xAxis.setLabel("Gender");

		Axis yAxis = sexModel.getAxis(AxisType.Y);
		yAxis.setLabel("Votes");
		yAxis.setMin(0);
		yAxis.setMax(20);
	}

	private BarChartModel initBarModel(List<Stats> list) {
		BarChartModel model = new BarChartModel();

		ChartSeries man = new ChartSeries();
		man.setLabel("Man");
		ChartSeries woman = new ChartSeries();
		woman.setLabel("Woman");

		ArrayList<Stats> manList = new ArrayList<Stats>();
		ArrayList<Stats> womanList = new ArrayList<Stats>();

		for (Stats item : list) {

			if (item.getSex().equals("m")) {

				manList.add(item);

			} else {
				womanList.add(item);

			}
		}

		for (Stats item : manList) {
			man.set(item.getCandidate(), item.getVotes());

		}
		for (Stats item : womanList) {
			woman.set(item.getCandidate(), item.getVotes());

		}

		model.addSeries(man);
		model.addSeries(woman);

		return model;
	}

}
