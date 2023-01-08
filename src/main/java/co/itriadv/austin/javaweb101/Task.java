package co.itriadv.austin.javaweb101;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Entity // This tells Hibernate to make a table out of this class
@Data // 這個可以讓你懶惰少打很多get/set
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 3000)
	@JsonProperty("text")
	private String taskText;

	@Column
	@JsonProperty("day")
	private String taskDay;

	@Column
	private Boolean reminder;

	@Column
	@JsonIgnore
	private String note;

	// 這是範例，你也可以格式化時間的輸出
	// @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

}
