public class CSProgrammingProjectI {

 
    public static void main(String[] args) {
     
        double[] x = {10, 20, 20, 10};
        double[] y = {20, 20, 10, 10};
        int i = 0;
        double area = 0;
        
       area = RecursiveAreaFinder(x, y, i, area);
       System.out.println(area);
       
    }
    
	public static double RecursiveAreaFinder (double[] x, double[] y, int i, double area){
        
         
          if (i == 2){
            
            return Math.abs(area;
        } else{
            
            area = area + (x[0]*y[i+1] + x[i+1]*y[i+2] + x[i+2]*y[0] - y[0]*x[i+1] - y[i+1]*x[i+2] - y[i+2]*x[0])/2;
            
            return RecursiveAreaFinder(x, y, i+1, area);
            
        } 
    }

}
