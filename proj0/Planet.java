public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double mass;
	public double yyVel;
	public String imgFileName;

	private static final double G=6.67e-11;

	public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;

	}
	public Planet(Planet p){
		xxPos=p.xxPos;
		yyPos=p.yyPos;
		xxVel=p.xxVel;
		yyVel=p.yyVel;
		mass=p.mass;
		imgFileName=p.imgFileName;


	}
	public Planet(){
        this.xxPos = 0;
        this.yyPos = 0;
        this.xxVel = 0;
        this.yyVel = 0;
        this.mass = 0;
        this.imgFileName = "";
    }
	public double calcDistance(Planet p){
		double distance;
		distance=Math.sqrt((xxPos-p.xxPos)*(xxPos-p.xxPos)+(yyPos-p.yyPos)*(yyPos-p.yyPos));

		return distance;

	}
	public double calcForceExertedBy(Planet p){
		double f;
		f=G*mass*p.mass/(calcDistance(p)*calcDistance(p));
		return f;

	}
	public double calcForceExertedByX(Planet p){
		double dx,dy,fx;
		dx = p.xxPos - xxPos;
		dy = p.yyPos - yyPos;
		fx = calcForceExertedBy(p) * dx / calcDistance(p);
		return fx;
	}
	public double calcForceExertedByY(Planet p){
		double dx,dy,fy;
		dx = p.xxPos - xxPos;
		dy = p.yyPos - yyPos;
		fy = calcForceExertedBy(p) * dy / calcDistance(p);
		return fy;
	}	
	public double calcNetForceExertedByX(Planet[] allPlanets){
		double fx = 0;
		for (Planet p : allPlanets){
			if(this.equals(p)){
				continue;
			}
			else{
				fx = fx + calcForceExertedByX(p);

			}
		}
		return fx;

	}
	public double calcNetForceExertedByY(Planet[] allPlanets){
		double fy = 0;
		for (Planet p : allPlanets){
			if(this.equals(p)){
				continue;
			}
			else{
				fy = fy + calcForceExertedByY(p);

			}
		}
		return fy;

	}
	public void update(double dt, double fx, double fy){
		double ax, ay;
	
		ax = fx / mass;
		ay = fy / mass;
		xxVel = xxVel + dt * ax;
		yyVel = yyVel + dt * ay;
		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;
	}
	public void draw(){
		StdDraw.picture(xxPos, yyPos,"images/" + imgFileName);
	}


}