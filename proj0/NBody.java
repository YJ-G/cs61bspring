public class NBody{
	public static double readRadius(String path){
		In in = new In(path);
		in.readDouble();
		double r = in.readDouble();
		return r;

	}
	public static Planet[] readPlanets(String path){
		In in = new In(path);
		int n = in.readInt();
		in.readDouble();
		Planet[] p = new Planet[n];
	    for(int j = 0; j < n; j++){
            p[j] = new Planet();
        }
		for(int i = 0; i < n; i++){
			
			p[i].xxPos = in.readDouble();
			p[i].yyPos = in.readDouble();
			p[i].xxVel = in.readDouble();
			p[i].yyVel = in.readDouble();
			p[i].mass = in.readDouble();
			p[i].imgFileName = in.readString();
			
		}
		return p;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] all_planet = readPlanets(filename);



		StdDraw.enableDoubleBuffering();
		double time = 0;
		double[] xForces = new double[all_planet.length] ;
		double[] yForces = new double[all_planet.length] ;
		for(time = 0; time < T; time = time + dt){
			for(int i = 0; i < all_planet.length; i++ ){
			
				xForces[i] = all_planet[i].calcNetForceExertedByX(all_planet);
				yForces[i] = all_planet[i].calcNetForceExertedByY(all_planet);
			}
			for(int i = 0; i < all_planet.length; i++ ){
			
				all_planet[i].update(dt,xForces[i],yForces[i]);
			}
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0,0, "images/starfield.jpg");
		
		for(Planet p : all_planet){
			p.draw();

		}
		StdDraw.show();
		StdDraw.pause(10);
		}
		StdOut.printf("%d\n", all_planet.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < all_planet.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
              	    	all_planet[i].xxPos, all_planet[i].yyPos, all_planet[i].xxVel,
                  		all_planet[i].yyVel, all_planet[i].mass, all_planet[i].imgFileName);   
		}
		




		
	}
}