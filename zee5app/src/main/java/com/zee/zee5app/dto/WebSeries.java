package com.zee.zee5app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebSeries {
	private String seriesId;
	private String seriesName;
	private int noOfEpisodes;
	private int noOfSeasons;
	private String[] langauges;
	private String[] actors;
	private String[] actressess;
}