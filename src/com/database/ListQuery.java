package com.database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.voting.Candidate;

public class ListQuery extends DBConnection implements Serializable {

	public List<Candidate> listCandidate() {
		List<Candidate> list = new ArrayList<Candidate>();

		try {
			ps = connect().prepareStatement("SELECT * FROM candidates");

			rs = ps.executeQuery();

			while (rs.next()) {
				Candidate candidate = new Candidate();
				candidate.setId(rs.getInt("id"));
				candidate.setName(rs.getString("name"));
				candidate.setPlatform(rs.getString("platform"));
				list.add(candidate);
			}
		} catch (Exception e) {

		}
		return list;

	}

}
