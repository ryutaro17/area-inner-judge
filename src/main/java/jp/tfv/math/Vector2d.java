package jp.tfv.math;

/**
 * @author ryutaro.hayashi
 *
 */
public class Vector2d {

	private double x;
	private double y;
	
	public Vector2d(Point2d p1, Point2d p2) {
		this.x = p2.getX() - p1.getX();
		this.y = p2.getY() - p1.getY();
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	/**
	 * 外積を計算
	 * @param v
	 * @return
	 */
	public double cross(Vector2d v) {
		return this.x * v.getY() - this.y * v.getX();
	}
	
	/**
	 * 内積を計算
	 * @param v
	 * @return
	 */
	public double dot(Vector2d v)	{
		return this.x * v.getX() + this.y * v.getY();
	}
}
