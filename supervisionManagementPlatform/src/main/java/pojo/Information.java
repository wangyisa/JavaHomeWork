package pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Information implements Serializable {
	private String informationId;

	private String informationItitle;

	private String informationImessage;

	private Date informationIdate;

	private String informationType;

	private Integer ishot;

	private static final long serialVersionUID = 1L;

}