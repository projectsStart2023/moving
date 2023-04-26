package net.project.moving.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Netflix_movie {
	private String title;
	private String poster_path;
	private String poster;
	private String release_date;
	private String over_view;

}
