package jp.tfv.math;

import java.util.ArrayList;
import java.util.List;

public final class GeometoryUtil {

	private static final String PI = String.format("%.10f", Math.PI);
	
	/**
	 * 2点間の距離を計算
	 * @param p1
	 * @param p2
	 * @return
	 */
	public static double distance(Point2d p1, Point2d p2)	{
		return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
	}
	
	/**
	 * Winding Number Algorithm を使った内外判定
	 * @param p
	 * @param polygon
	 * @return true:エリア内、false:エリア外
	 */
	public static boolean innerJudgementWindingNumber(Point2d p, List<Point2d> polygon)	{
		
		double totalDegree = 0.0;
		
		int j = 0;
		for(int i=0; i<polygon.size(); i++) {
			j = (i + 1) % polygon.size();
			
			Point2d p1 = polygon.get(i);
			Point2d p2 = polygon.get(j);
			
			// 点が一致した場合 内側とみなす
			if( (p.getX() == p1.getX() && p.getY() == p1.getY()) || (p.getX() == p2.getX() && p.getY() == p2.getY()) ) return true;
			
			Vector2d v1 = new Vector2d(p, p1);
			Vector2d v2 = new Vector2d(p, p2);
			
			// 距離計算
			double distance1 = GeometoryUtil.distance(p, p1);
			double distance2 = GeometoryUtil.distance(p, p2);
			// 外積
			double cross_value = v1.cross(v2);
			// 内積
			double dot_value = v1.dot(v2);
			// なす角度計算(rad)
			double radian = Math.acos(dot_value / (distance1 * distance2));

			//if( Math.abs(radian) == Math.PI ) return true;
			if( String.format("%.10f", Math.abs(radian)).equals(PI) ) return true;
			
			if(cross_value > 0)	{
				totalDegree += Math.toDegrees(radian);
			} else	{
				totalDegree -= Math.toDegrees(radian);
			}
		}
				
		return ( 359.0 < Math.abs(totalDegree) && Math.abs(totalDegree) < 361.0 );

	}
	
	/**
	 * Crossing Number Algorithm を使った内外判定
	 * @param p
	 * @param polygon
	 * @return true:エリア内、false:エリア外
	 */
	public static boolean innerJudgementCrossingNumber(Point2d p, List<Point2d> polygon)	{
		
		int cross_count = 0;
		int j = 0;
		for(int i=0; i<polygon.size(); i++) {
			j = (i + 1) % polygon.size();
			
			Point2d p1 = polygon.get(i);
			Point2d p2 = polygon.get(j);

			// 点が一致した場合 内側とみなす
			if( (p.getX() == p1.getX() && p.getY() == p1.getY()) || (p.getX() == p2.getX() && p.getY() == p2.getY()) ) return true;

			// Yの値が大きい方をp2に置き換える
			if(p1.getY() > p2.getY())	{
				Point2d _tmp = p1;
				p1 = p2;
				p2 = _tmp;
			}

			// p1, p2のX座標が同じときは、p1.y <= p.y <= p2.yの場合エリア内と判定する
			if( p1.getX() == p2.getX() && p.getX() == p1.getX())	{
				if( p.getY() >= p1.getY() && p.getY() <= p2.getY() ) return true;
			}

			// p1, p2のY座標が同じときは、p1.xとp2.xの線分の間にp.xがある場合エリア内と判定する
			if( p1.getY() == p2.getY() && p.getY() == p1.getY())	{
				if( p1.getX() <= p2.getX() )	{
					if( p.getX() >= p1.getX() && p.getX() <= p2.getX() ) return true;					
				} else	{
					if( p.getX() >= p2.getX() && p.getX() <= p1.getX() ) return true;										
				}
			}
			
			double x = ( p1.getX() * (p2.getY() - p.getY()) + p2.getX() * (p.getY() - p1.getY()) ) / (p2.getY() - p1.getY());
			double y = p.getY();
			
			// 対象の点のY座標がP1（下）とP2（上）に収まっているか
			if( p1.getY() <= y && y < p2.getY() )	{
				// 対象の点の右側方向に線ががあるか
				if( x >= p.getX() )	{
					cross_count++;
				}
			}
		}
		
		if(cross_count % 2 == 1)	{
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		List<Point2d> points = new ArrayList<Point2d>();
		points.add(new Point2d(135.7366963, 34.99512827));
		points.add(new Point2d(135.7368143, 34.99388022));
		points.add(new Point2d(135.7388528, 34.99308039));
		points.add(new Point2d(135.7388413, 34.99505845));

		Point2d point = new Point2d(135.737454, 34.994827);
		System.out.println(innerJudgementWindingNumber(point, points));
		System.out.println(innerJudgementCrossingNumber(point, points));
		
	}
}
