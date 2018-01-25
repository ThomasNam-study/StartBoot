package kr.purred.playground.startboot.data;

import lombok.Data;

@Data
public class PointData
{
	private String memberID;

	private int point;

	public PointData (String memberID, int point)
	{
		this.memberID = memberID;
		this.point = point;
	}
}
