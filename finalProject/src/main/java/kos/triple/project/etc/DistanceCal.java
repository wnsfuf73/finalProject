package kos.triple.project.etc;

public class DistanceCal{

	private double distance;
	
	public DistanceCal(double x1, double y1, double x2, double y2) {
		this.distance = this.calDistance(x1,y1,x2,y2);
	}
	
	public double getDistance() {
		return this.distance;
	}
	
	
	public int calDistance(double lat1, double lon1, double lat2, double lon2){  
	    
	    double theta, dist;  
	    theta = lon1 - lon2;  
	    dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1))   
	          * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));  
	    dist = Math.acos(dist);  
	    dist = rad2deg(dist);  
	      
	    dist = dist * 60 * 1.1515;   
	    dist = dist * 1.609344;    // ���� mile ���� km ��ȯ.  
	    dist = dist * 1000.0;      // ����  km ���� m �� ��ȯ  
	    
	
	    int distance = (int)dist/1000;
	    return distance;  
	}  
	  
	    // �־��� ��(degree) ���� �������� ��ȯ  
	private double deg2rad(double deg){  
	    return (double)(deg * Math.PI / (double)180d);  
	}  
	  
	    // �־��� ����(radian) ���� ��(degree) ������ ��ȯ  
	private double rad2deg(double rad){  
	    return (double)(rad * (double)180d / Math.PI);  
	} 
	
}