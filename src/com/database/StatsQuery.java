package com.database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.voting.Stats;

public class StatsQuery extends DBConnection implements Serializable {

	public List<Stats> listResults() {
		List<Stats> list = new ArrayList<Stats>();

		try {
			ps = connect().prepareStatement("SELECT candidate_id,count(id) as votes FROM votes group by candidate_id");

			rs = ps.executeQuery();

			while (rs.next()) {
				Stats result = new Stats();

				result.setCandidate_id(rs.getInt("candidate_id"));
				result.setVotes(rs.getInt("votes"));

				list.add(result);
			}
		} catch (Exception e) {

		}
		return list;

	}
	
	public List<Stats> listStatsBySex() {
		List<Stats> list = new ArrayList<Stats>();

		try {
			ps = connect().prepareStatement("SELECT candidate_id,sex,count(id) as votes FROM votes group by candidate_id, sex");

			rs = ps.executeQuery();

			while (rs.next()) {
				Stats result = new Stats();

				result.setCandidate_id(rs.getInt("candidate_id"));
				result.setVotes(rs.getInt("votes"));
				result.setSex(rs.getString("sex"));

				list.add(result);
			}
		} catch (Exception e) {

		}
		return list;

	}

}
