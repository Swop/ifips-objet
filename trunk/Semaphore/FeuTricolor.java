
public class FeuTricolor extends FeuBicolor {

	boolean Feu3;
	
	public FeuTricolor () {

		super.Feu1=false;
		super.Feu2=false;
		this.Feu3=true;
			
	    };

	    
	    boolean isGreen(){
	    	return super.Feu1;
	    }
	    
	    void toGreen(){
	    	super.Feu1=true;
	    	super.Feu2=false;
	    	this.Feu3=false;
	    	
	    }
	    
	    
	    void toOrange(){
	    	super.Feu1=false;
	    	super.Feu2=true;
	    	this.Feu3=false;
	    	
	    }	    
	    
	    void toRed(){
	    	super.Feu1=false;
	    	super.Feu2=false;
	    	this.Feu3=true;
	    }
	
	
}