package kr.purred.playground.startboot;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import kr.purred.playground.startboot.data.PointData;

public class SimpleTest
{
	@Test
	public void simpleTest ()
	{
		List<PointData> datas = new ArrayList<> ();

		datas.add (new PointData ("A", 5000));
		datas.add (new PointData ("A", 8000));
		datas.add (new PointData ("C", 9000));
		datas.add (new PointData ("C", 5000));
		datas.add (new PointData ("B", 15000));
		datas.add (new PointData ("B", 2000));
		datas.add (new PointData ("C", 2000));
		datas.add (new PointData ("C", 2000));
		datas.add (new PointData ("A", 2000));

		int sum = 0;

		for (PointData p : datas)
		{
			sum += p.getPoint ();
		}

		System.out.println (sum);

		Map<String, List<PointData>> collect = datas.stream ().collect (Collectors.groupingBy (PointData::getMemberID));

		collect.entrySet ().stream ().forEach ((e) -> {
			System.out.println ("Member ID : " + e.getKey ());
			System.out.println ( e.getValue ());
		});

		Map<Boolean, List<PointData>> collect1 = datas.stream ().collect (Collectors.partitioningBy ((p) -> p.getPoint () < 5000));

		collect1.entrySet ().stream ().forEach ((e) -> {
			System.out.println ("Member ID : " + e.getKey ());
			System.out.println ( e.getValue ());
		});
	}
}
