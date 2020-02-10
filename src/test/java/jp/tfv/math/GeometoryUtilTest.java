package jp.tfv.math;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GeometoryUtilTest {
	
	@Test
	public void test凹型パターン１()	{
		//　 凹型のテスト
		List<Point2d> points = new ArrayList<Point2d>();
		points.add(new Point2d(-1.0,  1.0));
		points.add(new Point2d(-1.0, -1.0));
		points.add(new Point2d( 0.0, -0.5));
		points.add(new Point2d( 1.0, -1.5));
		points.add(new Point2d( 1.0,  1.0));

		Point2d point = new Point2d( -2.0, 0.5);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point, points), false);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point, points), false);
	}

	@Test
	public void test凹型パターン２()	{
		//　 凹型のテスト
		List<Point2d> points = new ArrayList<Point2d>();
		points.add(new Point2d(-1.0,  1.0));
		points.add(new Point2d(-1.0, -1.0));
		points.add(new Point2d( 0.0, -0.5));
		points.add(new Point2d( 1.0, -1.5));
		points.add(new Point2d( 1.0,  1.0));

		Point2d point = new Point2d( 2.0, -1.0);
		
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point, points), false);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point, points), false);
	}

	@Test
	public void test凹型パターン３()	{
		//　 凹型のテスト
		List<Point2d> points = new ArrayList<Point2d>();
		points.add(new Point2d(-1.0,  1.0));
		points.add(new Point2d(-1.0, -1.0));
		points.add(new Point2d( 0.0, -0.5));
		points.add(new Point2d( 1.0, -1.5));
		points.add(new Point2d( 1.0,  1.0));

		Point2d point = new Point2d( -0.5, -0.5);
		
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point, points), true);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point, points), true);
	}

	@Test
	public void test凹型パターン４()	{
		//　 凹型のテスト
		List<Point2d> points = new ArrayList<Point2d>();
		points.add(new Point2d(-1.0,  1.0));
		points.add(new Point2d(-1.0, -1.0));
		points.add(new Point2d( 0.0, -0.5));
		points.add(new Point2d( 1.0, -1.5));
		points.add(new Point2d( 1.0,  1.0));

		Point2d point = new Point2d( -0.5, 0.7499999);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point, points), true);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point, points), true);
	}

	@Test
	public void test凹型パターン5()	{
		//　 凹型のテスト
		List<Point2d> points = new ArrayList<Point2d>();
		points.add(new Point2d(-1.0,  1.0));
		points.add(new Point2d(-1.0, -1.0));
		points.add(new Point2d( 0.0, -0.5));
		points.add(new Point2d( 1.0, -1.0));
		points.add(new Point2d( 1.0,  1.0));

		Point2d point = new Point2d( -1.5, -1.0);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point, points), false);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point, points), false);
	}

	@Test
	public void test線上パターン1()	{
		List<Point2d> points = new ArrayList<Point2d>();
		points.add(new Point2d(-1.0,  1.0));
		points.add(new Point2d(-1.0, -1.0));
		points.add(new Point2d( 0.0, -0.5));
		points.add(new Point2d( 1.0, -1.0));
		points.add(new Point2d( 1.0,  1.0));

		Point2d point = new Point2d( -0.4999999, -0.75);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point, points), false);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point, points), false);
	}

	@Test
	public void test線上パターン2()	{
		List<Point2d> points = new ArrayList<Point2d>();
		points.add(new Point2d(-1.0,  1.0));
		points.add(new Point2d(-1.0, -1.0));
		points.add(new Point2d( 0.0, -0.5));
		points.add(new Point2d( 1.0, -1.0));
		points.add(new Point2d( 1.0,  1.0));

		Point2d point = new Point2d( -0.5, 1.00001);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point, points), false);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point, points), false);
	}

	@Test
	public void test線上パターン3()	{
		List<Point2d> points = new ArrayList<Point2d>();
		points.add(new Point2d(-1.0,  1.0));
		points.add(new Point2d(-1.0, -1.0));
		points.add(new Point2d( 0.0, -0.5));
		points.add(new Point2d( 1.0, -1.0));
		points.add(new Point2d( 1.0,  1.0));

		Point2d point = new Point2d( 1.0, 0.5);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point, points), true);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point, points), true);
	}

	@Test
	public void test下部単点パターン()	{
		//　 凹型のテスト
		List<Point2d> points = new ArrayList<Point2d>();
		points.add(new Point2d(-1.0,  1.0));
		points.add(new Point2d(-1.0, -1.0));
		points.add(new Point2d( 0.0, -2.5));
		points.add(new Point2d( 1.0, -1.5));
		points.add(new Point2d( 1.0,  1.0));

		Point2d point = new Point2d( -1.0, -2.4);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point, points), false);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point, points), false);
	}

	@Test
	public void testKRPエリア１()	{

		// KRP凸エリア
		List<Point2d> points = new ArrayList<Point2d>();
		points.add(new Point2d(135.7366963, 34.99512827));
		points.add(new Point2d(135.7368143, 34.99388022));
		points.add(new Point2d(135.7388528, 34.99308039));
		points.add(new Point2d(135.7388413, 34.99505845));

		Point2d point = new Point2d(135.737454, 34.994827);

		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point, points), true);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point, points), true);
	}

	@Test
	public void testKRP広島エリア()	{

		// 広島エリア
		List<Point2d> points = new ArrayList<Point2d>();
		points.add(new Point2d(132.464955, 34.424609));
		points.add(new Point2d(132.46063,  34.425658));
		points.add(new Point2d(132.453508, 34.42377));
		points.add(new Point2d(132.435959, 34.405519));
		points.add(new Point2d(132.422479, 34.381177));
		points.add(new Point2d(132.427692, 34.377609));
		points.add(new Point2d(132.444223, 34.372467));
		points.add(new Point2d(132.456686, 34.373411));
		points.add(new Point2d(132.464189, 34.378554));
		points.add(new Point2d(132.469783, 34.387999));
		points.add(new Point2d(132.471436, 34.395974));
		points.add(new Point2d(132.467493, 34.420312));

		// エリア外（右）
		Point2d point = new Point2d(132.50454617683351, 34.41838581120604);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point, points), false);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point, points), false);

		// エリア外（左）
		Point2d point2 = new Point2d(132.42420865241945, 34.41399581726479);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point2, points), false);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point2, points), false);

		// エリア外（上）
		Point2d point3 = new Point2d(132.4605038392666, 34.4288684442115);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point3, points), false);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point3, points), false);

		// エリア外（下）
		Point2d point4 = new Point2d(132.43477821350098, 34.36951139880402);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point4, points), false);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point4, points), false);

		// エリア内
		Point2d point5 = new Point2d(132.428464, 34.383479);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point5, points), true);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point5, points), true);

		// エリア内
		Point2d point6 = new Point2d(132.441425, 34.394617);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point6, points), true);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point6, points), true);

	}

	@Test
	public void test熊本エリア()	{

		// 熊本エリア
		List<Point2d> points = new ArrayList<Point2d>();
		points.add(new Point2d(130.727719, 32.858603));
		points.add(new Point2d(130.708646, 32.863408));
		points.add(new Point2d(130.68919,  32.863834));
		points.add(new Point2d(130.670326, 32.850923));
		points.add(new Point2d(130.657738, 32.816412));
		points.add(new Point2d(130.65367,  32.777292));
		points.add(new Point2d(130.662189, 32.764889));
		points.add(new Point2d(130.68902,  32.760827));
		points.add(new Point2d(130.708349, 32.762324));
		points.add(new Point2d(130.725642, 32.766494));
		points.add(new Point2d(130.743953, 32.778791));
		points.add(new Point2d(130.755271, 32.812568));
		points.add(new Point2d(130.757051, 32.839068));
		points.add(new Point2d(130.740141, 32.850284));

		// エリア外（右）
		Point2d point = new Point2d(130.78452513761863, 32.827991169795936);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point, points), false);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point, points), false);

		// エリア外（左）
		Point2d point2 = new Point2d(130.65234587736472, 32.870245591399815);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point2, points), false);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point2, points), false);

		// エリア外（上）
		Point2d point3 = new Point2d(130.65234587736472, 32.870245591399815);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point3, points), false);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point3, points), false);
	
		// エリア外（下）
		Point2d point4 = new Point2d(130.6901113802944, 32.73490290238267);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point4, points), false);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point4, points), false);

		// エリア内
		Point2d point5 = new Point2d(130.694517, 32.844166);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point5, points), true);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point5, points), true);

		// エリア内
		Point2d point6 = new Point2d(130.682911, 32.763089);
		assertEquals(GeometoryUtil.innerJudgementCrossingNumber(point6, points), true);
		assertEquals(GeometoryUtil.innerJudgementWindingNumber(point6, points), true);

	}

	
}
