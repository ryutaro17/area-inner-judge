package jp.tfv.area_inner_judge;

import java.util.ArrayList;
import java.util.List;

import jp.tfv.math.GeometoryUtil;
import jp.tfv.math.Point2d;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		List<Point2d> points = new ArrayList<Point2d>();
		points.add(new Point2d(-1.0,  1.0));
		points.add(new Point2d(-1.0, -1.0));
		points.add(new Point2d( 0.0, -0.5));
		points.add(new Point2d( 1.0, -1.5));
		points.add(new Point2d( 1.0,  1.0));

		Point2d point = new Point2d( 0, 0);
		System.out.println(GeometoryUtil.innerJudgementCrossingNumber(point, points));
		System.out.println(GeometoryUtil.innerJudgementWindingNumber(point, points));
    }
}
