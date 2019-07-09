package com.voting;


import com.controller.CandidateController;

public class Vote {

	private Integer id;
	private Integer candidate_id;
	private Integer age;
	private String sex;
	private String city;
	private String education;

	

	public Vote() {

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

	public String getCandidate() {

		CandidateController candidate = new CandidateController();

		return candidate.getById(candidate_id);
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

		return sex;// == "m" ? "Male" : "Female";
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




}
